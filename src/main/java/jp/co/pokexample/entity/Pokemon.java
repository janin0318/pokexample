package jp.co.pokexample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pokemon {

  private PokemonBase base;
  private PokemonSpecies species;
}
