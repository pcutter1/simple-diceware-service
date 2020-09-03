package edu.cnm.deepdive.diceware.controller;

import edu.cnm.deepdive.diceware.service.PassphraseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

  private final PassphraseGenerator generator;

  @Autowired
  public PageController(PassphraseGenerator generator) {
    this.generator = generator;
  }

  @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
  public String get(@RequestParam(value = "length", defaultValue = "6") int length, Model model) {
    model.addAttribute("words", generator.passphrase(length));
    return "passphrase";
  }

}
