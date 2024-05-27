package jp.co.pokexample.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;
import jp.co.pokexample.entity.Pokemon;
import jp.co.pokexample.entity.PokemonBase;
import jp.co.pokexample.entity.species.Species;
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
    JsonNode baseJsonNode = pokeApiService.doApi(PokemonBase.URL + id);
    PokemonBase base = new PokemonBase(baseJsonNode);

    if (PokemonBase.EMPTY_SPECIES_URL.equals(base.getSpeciesUrl())) {
      return new Pokemon(base, null);
    }

    JsonNode speciesJsonNode = pokeApiService.doApi(base.getSpeciesUrl());
    Species species = new Species(speciesJsonNode);

    return new Pokemon(base, species);
  }
}
