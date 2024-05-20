package jp.co.pokexample.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class PokemonSpeciesTest {

  private static final String JSON_NODE = "src/test/java/jp/co/pokexample/entity/PokemonSpecies.json";

  @Test
  public void 正常系() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode pokemonBaseNode = mapper.readTree(new File(JSON_NODE));

    PokemonSpecies result = new PokemonSpecies(pokemonBaseNode);

    assertEquals(result.getId(), 1);
    assertEquals(result.getNameJp(), "フシギダネ");
    assertEquals(result.getFlavorText(), "フレーバーテキスト");
    assertEquals(result.getFlavorTextVersion(), "omega-ruby");
  }
}
