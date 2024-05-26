package jp.co.pokexample.entity.species;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class SpeciesTest {

  private static final String JSON_NODE_1 =
      "src/test/java/jp/co/pokexample/entity/species/PokemonSpecies_1.json";

  @Test
  public void すべての項目に値がある() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode pokemonBaseNode = mapper.readTree(new File(JSON_NODE_1));

    Species result = new Species(pokemonBaseNode);

    assertEquals(result.getId(), 1);
    assertEquals(result.getNameJp(), "フシギダネ");
    assertEquals(result.getFlavorTexts().get(0).getText(), "フレーバーテキスト");
    assertEquals(result.getFlavorTexts().get(0).getVersion(), "オメガルビー(第六世代)");
    assertEquals(result.getGenera(), "たねポケモン");
  }

  private static final String JSON_NODE_2 =
      "src/test/java/jp/co/pokexample/entity/species/PokemonSpecies_2.json";

  @Test
  public void 日本語のフレーバーテキストが無い() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode pokemonBaseNode = mapper.readTree(new File(JSON_NODE_2));

    Species result = new Species(pokemonBaseNode);

    assertNotNull(result.getFlavorTexts());
    assertEquals(result.getFlavorTexts().size(), 0);
  }
}
