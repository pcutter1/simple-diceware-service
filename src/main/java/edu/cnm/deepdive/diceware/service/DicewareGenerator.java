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
