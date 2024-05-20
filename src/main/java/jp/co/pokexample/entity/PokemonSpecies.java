package jp.co.pokexample.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Getter
@ToString
public class PokemonSpecies {

  public static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon-species/";

  private final Integer id;
  private final String nameJp;
  private final String flavorText;
  private final String flavorTextVersion;

  public PokemonSpecies(final JsonNode jsonNode) {
    this.id = jsonNode.get("id").asInt();
    this.nameJp = createNameJp(jsonNode);
    this.flavorText = createFlavorText(jsonNode);
    this.flavorTextVersion = createFlavorTextVersion(jsonNode);
  }

  /**
   * pokemon-speciesから日本語名を取得する。
   *
   * @param jsonNode pokemon-speciesの実施結果
   * @return 日本語名
   */
  private String createNameJp(final JsonNode jsonNode) {
    JsonNode nameNode = getJaJsonNode(jsonNode.get("names"));
    return nameNode.get("name").asText();
  }

  /**
   * pokemon-speciesからフレーバーテキストを取得する。
   *
   * @param jsonNode pokemon-speciesの実施結果
   * @return フレーバーテキスト
   */
  private String createFlavorText(final JsonNode jsonNode) {
    JsonNode flavorTextNode = getJaJsonNode(jsonNode.get("flavor_text_entries"));
    return flavorTextNode.get("flavor_text").asText();
  }

  private String createFlavorTextVersion(final JsonNode jsonNode) {
    JsonNode flavorTextNode = getJaJsonNode(jsonNode.get("flavor_text_entries"));
    return flavorTextNode.get("version").get("name").asText();
  }

  /**
   * 日本語のJsonNodeを返す。
   *
   * @param jsonNode 日本語を取得したい大分類
   * @return 日本語のJsonNode
   */
  private JsonNode getJaJsonNode(final JsonNode jsonNode) {
    for (int i = 0; i < jsonNode.size(); i++) {
      String lang = jsonNode.get(i).get("language").get("name").asText();
      if (Objects.equals(lang, "ja-Hrkt")) {
        return jsonNode.get(i);
      }
    }
    return null;
  }
}
