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

  // ポケモン図鑑番号
  private final int id;
  // 名前（英名）
  private final String name;
  // 公式画像（フロント）
  private final String officialArtwork;

  public PokemonBase(final JsonNode jsonNode) {
    this.id = jsonNode.get("id").asInt();
    this.name = jsonNode.get("name").asText();
    this.officialArtwork = createOfficialArtwork(jsonNode);
  }

  private String createOfficialArtwork(final JsonNode jsonNode) {
    return jsonNode.get("sprites").get("other").get("official-artwork").get("front_default")
        .asText();
  }
}
