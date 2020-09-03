/*
 *  Copyright 2020 Deep Dive Coding/CNM Ingenuity
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.diceware.controller;

import edu.cnm.deepdive.diceware.service.PassphraseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Implements an HTTP controller for generating Diceware passphrases. 3 controller methods,
 * supporting 3 different response content types, are implemented:
 * <ul>
 *   <li>{@link #get(int)}: {@code application/json}</li>
 *   <li>{@link #get(int, Model)}: {@code text/html}</li>
 *   <li>{@link #get(int, String)}: {@code text/plain}</li>
 * </ul>
 */
@Controller
public class DicewareController {

  private static final String LENGTH_PARAMETER = "length";
  private static final String DEFAULT_LENGTH = "6";
  private static final String DELIMITER_PARAMETER = "delimiter";
  private static final String DEFAULT_DELIMITER = ",";

  private final PassphraseGenerator generator;

  /**
   * Initializes this instance with an injected {@link PassphraseGenerator}.
   *
   * @param generator source of passphrases.
   */
  @Autowired
  public DicewareController(PassphraseGenerator generator) {
    this.generator = generator;
  }

  /**
   * Constructs and returns a {@code String[]} passphrase in JSON format. This method will be used
   * by Spring MVC if the HTTP request includes an {@code Accept} header where the <i>quality
   * value</i> (q-value, or weight) associated (implicitly or explicitly) with {@code
   * application/json} is higher than that associated with {@code text/html} or {@code text/plain}.
   *
   * @param length number of words in passphrase.
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String[] get(
      @RequestParam(value = LENGTH_PARAMETER, defaultValue = DEFAULT_LENGTH) int length) {
    return generator.passphrase(length);
  }

  /**
   * Constructs a {@code String[]} passphrase in HTML format. This method will be used by Spring MVC
   * if the HTTP request includes an {@code Accept} header where the <i>quality value</i> (q-value,
   * or weight) associated (implicitly or explicitly) with {@code text/html} is higher than that
   * associated with {@code application/json} or {@code text/plain}.
   *
   * @param length number of words in passphrase.
   * @param model injected container for model content rendered by {@code view}.
   * @return view
   */
  @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
  public String get(
      @RequestParam(value = LENGTH_PARAMETER, defaultValue = DEFAULT_LENGTH) int length,
      Model model) {
    model.addAttribute("words", generator.passphrase(length));
    return "passphrase";
  }

  /**
   * Constructs and returns a {@code String[]} passphrase in plain text format. This method will be
   * used by Spring MVC if the HTTP request includes an {@code Accept} header where the <i>quality
   * value</i> (q-value, or weight) associated (implicitly or explicitly) with {@code text/plain} is
   * higher than that associated with {@code text/html} or {@code application/json}.
   *
   * @param length number of words in passphrase.
   * @param delimiter separator between words in passphrase.
   */
  @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
  @ResponseBody
  public String get(
      @RequestParam(value = LENGTH_PARAMETER, defaultValue = DEFAULT_LENGTH) int length,
      @RequestParam(value = DELIMITER_PARAMETER, defaultValue = DEFAULT_DELIMITER) String delimiter) {
    return String.join(delimiter, get(length));
  }

}
