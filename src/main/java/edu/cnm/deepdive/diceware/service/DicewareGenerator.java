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
package edu.cnm.deepdive.diceware.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicewareGenerator implements PassphraseGenerator {

  private Random rng;
  private List<String> words;

  /**
   * Initializes this instance with an injected source of randomness (an instance of {@link Random})
   * and a {@link WordProvider}.
   *
   * @param rng source of randomness.
   * @param provider source of passphrase words.
   */
  @Autowired
  public DicewareGenerator(Random rng, WordProvider provider) {
    this.rng = rng;
    this.words = new ArrayList<>(provider.words());
  }

  @Override
  public String[] passphrase(int length) {
    return IntStream.generate(() -> rng.nextInt(words.size()))
        .limit(length)
        .mapToObj((value) -> words.get(value))
        .toArray(String[]::new);
  }

}
