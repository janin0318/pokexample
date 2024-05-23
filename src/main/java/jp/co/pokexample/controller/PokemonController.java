package jp.co.pokexample.controller;

import jp.co.pokexample.entity.Pokemon;
import jp.co.pokexample.service.PokemonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

@Controller
@Log4j2
@RequestMapping("/pokemon")
public class PokemonController {

  private final PokemonService pokemonService;

  PokemonController(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }

  @GetMapping("/{id}")
  public String getById(@PathVariable("id") String id, Model model) {
    Pokemon pokemon = pokemonService.buildPokemon(id);
    model.addAttribute("pokemon", pokemon);
    return "pokemon/show";
  }

  @GetMapping("/search")
  public String search(@RequestParam String id) {
    return "redirect:/pokemon/" + id;
  }

  /**
   * PokeAPIで404が帰ってきた場合はポケモンが見つからない旨の画面を表示する。
   *
   * @return 404画面
   */
  @ExceptionHandler(HttpClientErrorException.NotFound.class)
  public String pokemonNotExist() {
    return "pokemon/error";
  }
}
