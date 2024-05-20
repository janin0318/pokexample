package jp.co.pokexample.controller;

import jp.co.pokexample.entity.Pokemon;
import jp.co.pokexample.exception.PokemonNotExistException;
import jp.co.pokexample.service.PokemonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class PokemonController {

  private final PokemonService pokemonService;

  PokemonController(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }

  @GetMapping("/id/{id}")
  public String getById(@PathVariable("id") String id, Model model) {
    Pokemon pokemon = pokemonService.buildPokemon(id);
    model.addAttribute("pokemon", pokemon);
    return "pokemon";
  }

  @GetMapping("/search")
  public String search(@RequestParam String id) {
    return "redirect:/id/" + id;
  }

  @ExceptionHandler(PokemonNotExistException.class)
  public String pokemonNotExist() {
    return "error";
  }
}
