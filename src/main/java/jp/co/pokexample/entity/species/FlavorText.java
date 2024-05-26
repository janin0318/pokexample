package jp.co.pokexample.entity.species;

import com.fasterxml.jackson.databind.JsonNode;
import jp.co.pokexample.converter.VersionConverter;
import lombok.Getter;

@Getter
public class FlavorText {

  String text;
  String version;

  FlavorText(JsonNode flavorTexts) {
    this.text = flavorTexts.get("flavor_text").asText();
    this.version = VersionConverter.convertVersion(flavorTexts.get("version").get("name").asText());
  }

}
