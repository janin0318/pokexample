package jp.co.pokexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 静的ページ用のコントローラー
 */
@Controller
public class StaticController {

  @GetMapping("")
  public String index() {
    return "index";
  }
}
