package jp.co.pokexample.entity;

import jp.co.pokexample.entity.species.Species;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pokemon {

  private PokemonBase base;
  private Species species;
}
