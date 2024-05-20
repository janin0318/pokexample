package jp.co.pokexample.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PokemonBaseTest {

  private static final String JSON_NODE = "src/test/java/jp/co/pokexample/entity/PokemonBase.json";

  @Test
  public void 正常系() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode pokemonBaseNode = mapper.readTree(new File(JSON_NODE));

    PokemonBase result = new PokemonBase(pokemonBaseNode);

    assertEquals(result.getId(), 1);
    assertEquals(result.getName(), "bulbasaur");
    assertEquals(result.getOfficialArtwork(), "front_default");
  }
}
