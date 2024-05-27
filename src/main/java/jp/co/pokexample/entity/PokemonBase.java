package jp.co.pokexample.entity;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;
import lombok.Getter;
import lombok.ToString;

/**
 * ポケモンベース
 */
@Getter
@ToString
public class PokemonBase {

  public static final String URL = "https://pokeapi.co/api/v2/pokemon/";
  public static final String EMPTY_SPECIES_URL = "";

  private final int id;
  private final String name;
  private final String officialArtworkURL;
  private final String speciesUrl;

  public PokemonBase(final JsonNode jsonNode) {
    this.id = jsonNode.get("id").asInt();
    this.name = jsonNode.get("name").asText();
    this.officialArtworkURL = createOfficialArtwork(jsonNode);
    this.speciesUrl = createSpeciesUrl(jsonNode);
  }

  /**
   * PokeApiから公式画像を取得する。
   *
   * @param jsonNode PokeApiの実施結果
   * @return 公式画像のURL
   */
  private String createOfficialArtwork(final JsonNode jsonNode) {
    return jsonNode.get("sprites").get("other").get("official-artwork").get("front_default")
        .asText();
  }

  private String createSpeciesUrl(final JsonNode jsonNode) {
    if (Objects.isNull(jsonNode.get("species"))
        || Objects.isNull(jsonNode.get("species").get("url"))) {
      return EMPTY_SPECIES_URL;
    }
    return jsonNode.get("species").get("url").asText();
  }
}
