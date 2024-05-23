package jp.co.pokexample.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.ToString;

/**
 * ポケモンベース
 */
@Getter
@ToString
public class PokemonBase {

  public static final String URL = "https://pokeapi.co/api/v2/pokemon/";

  private final int id;
  private final String name;
  private final String officialArtworkURL;

  public PokemonBase(final JsonNode jsonNode) {
    this.id = jsonNode.get("id").asInt();
    this.name = jsonNode.get("name").asText();
    this.officialArtworkURL = createOfficialArtwork(jsonNode);
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
}
