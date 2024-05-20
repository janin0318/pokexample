package jp.co.pokexample.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface PokeApiService {

  JsonNode doApi(Object param, String URL);
}
