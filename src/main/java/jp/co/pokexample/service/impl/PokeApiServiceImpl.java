package jp.co.pokexample.service.impl;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.co.pokexample.service.PokeApiService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
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

    JsonNode result;
    try {
      result = objectMapper.readTree(pokeApiResult.getBody());
    } catch (JacksonException e) {
      throw new RuntimeException(e);
    }
    return result;
  }
}
