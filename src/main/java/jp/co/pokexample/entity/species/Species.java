package jp.co.pokexample.entity.species;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Species {

  public static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon-species/";

  private final Integer id;
  private final String nameJp;
  private final List<FlavorText> flavorTexts;
  private final String genera;

  public Species(final JsonNode jsonNode) {
    this.id = jsonNode.get("id").asInt();
    this.nameJp = createNameJp(jsonNode);
    this.flavorTexts = createFlavorTexts(jsonNode);
    this.genera = createGenera(jsonNode);
  }

  /**
   * pokemon-speciesからポケモンの日本語名を取得する。
   *
   * @param jsonNode pokemon-speciesの実施結果
   * @return 日本語名
   */
  private String createNameJp(final JsonNode jsonNode) {
    List<JsonNode> nameNodes = getJaJsonNode(jsonNode.get("names"));
    return nameNodes.get(0).get("name").asText();
  }

  /**
   * pokemon-speciesからポケモン種族の日本語名を取得する。
   *
   * @param jsonNode pokemon-speciesの実施結果
   * @return
   */
  private String createGenera(final JsonNode jsonNode) {
    List<JsonNode> generaNodes = getJaJsonNode(jsonNode.get("genera"));
    return generaNodes.get(0).get("genus").asText();
  }

  private List<FlavorText> createFlavorTexts(final JsonNode jsonNode) {
    List<FlavorText> flavorTexts = new ArrayList<>();
    List<JsonNode> flavorTextNodes = getJaJsonNode(jsonNode.get("flavor_text_entries"));
    for (JsonNode flavorTextNode : flavorTextNodes) {
      FlavorText flavorText = new FlavorText(flavorTextNode);
      flavorTexts.add(flavorText);
    }
    return flavorTexts;
  }

  /**
   * 日本語のJsonNodeを返す。
   *
   * @param jsonNode 日本語を取得したい大分類
   * @return 日本語のJsonNode
   */
  private List<JsonNode> getJaJsonNode(final JsonNode jsonNode) {
    List<JsonNode> jsonNodes = new ArrayList<>();
    for (int i = 0; i < jsonNode.size(); i++) {
      String lang = jsonNode.get(i).get("language").get("name").asText();
      if (Objects.equals(lang, "ja-Hrkt")) {
        jsonNodes.add(jsonNode.get(i));
      }
    }
    return jsonNodes;
  }
}
