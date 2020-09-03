package edu.cnm.deepdive.diceware.controller;

import edu.cnm.deepdive.diceware.service.PassphraseGenerator;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  private final PassphraseGenerator generator;

  @Autowired
  public ApiController(PassphraseGenerator generator) {
    this.generator = generator;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String[] get(@RequestParam(value = "length", defaultValue = "6") int length) {
    return generator.passphrase(length);
  }

  @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
  public String get(@RequestParam(value = "length", defaultValue = "6") int length,
      @RequestParam(value = "delimiter", defaultValue = ",") String delimiter) {
    return Arrays.stream(get(length))
        .collect(Collectors.joining(delimiter));
  }

}
