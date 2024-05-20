package jp.co.pokexample.exception;

public class PokemonNotExistException extends RuntimeException {

  public PokemonNotExistException(String pokemonName) {
    super(pokemonName);
  }
}
