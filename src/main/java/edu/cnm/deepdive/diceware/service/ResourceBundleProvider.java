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
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link WordProvider} that uses a resource bundle as a source of words for
 * passphrase generation.
 */
@Component
public class ResourceBundleProvider implements WordProvider {

  private final ResourceBundle bundle;

  /**
   * Initializes this instance with an injected {@link ResourceBundle}.
   *
   * @param bundle source of words.
   */
  @Autowired
  public ResourceBundleProvider(ResourceBundle bundle) {
    this.bundle = bundle;
  }

  @Override
  public Collection<String> words() {
    List<String> words = new ArrayList<>();
    for (String key : bundle.keySet()) {
      words.add(bundle.getString(key));
    }
    return words;
  }

}
