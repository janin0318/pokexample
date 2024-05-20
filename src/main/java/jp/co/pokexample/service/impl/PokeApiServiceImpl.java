package jp.co.pokexample.service.impl;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import jp.co.pokexample.exception.PokemonNotExistException;
import jp.co.pokexample.service.PokeApiService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiServiceImpl implements PokeApiService {

  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  public PokeApiServiceImpl(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
    this.restTemplate = restTemplateBuilder.build();
    this.objectMapper = objectMapper;
  }

  @Override
  public JsonNode doApi(final Object param, final String URL) {
    ResponseEntity<String> pokeApiResult = restTemplate.getForEntity(URL + param, String.class);

    if (!Objects.equals(pokeApiResult.getStatusCode(), HttpStatus.OK)) {
      throw new PokemonNotExistException("Failed to call Poke API");
    }

    JsonNode result;
    try {
      result = objectMapper.readTree(pokeApiResult.getBody());
    } catch (JacksonException e) {
      throw new PokemonNotExistException("Failed to call Poke API");
    }
    return result;
  }
}
