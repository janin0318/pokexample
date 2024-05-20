package jp.co.pokexample.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import jp.co.pokexample.entity.Pokemon;
import jp.co.pokexample.entity.PokemonBase;
import jp.co.pokexample.entity.PokemonSpecies;
import jp.co.pokexample.service.PokeApiService;
import jp.co.pokexample.service.PokemonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PokemonServiceImpl implements PokemonService {

  private final PokeApiService pokeApiService;

  public PokemonServiceImpl(PokeApiService pokeApiService) {
    this.pokeApiService = pokeApiService;
  }

  @Override
  public Pokemon buildPokemon(String id) {
    JsonNode speciesJsonNode = pokeApiService.doApi(id, PokemonSpecies.POKE_API_URL);
    PokemonSpecies species = new PokemonSpecies(speciesJsonNode);

    JsonNode baseJsonNode = pokeApiService.doApi(id, PokemonBase.URL);
    PokemonBase base = new PokemonBase(baseJsonNode);

    return new Pokemon(base, species);
  }
}
