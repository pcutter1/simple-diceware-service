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

import java.util.Collection;

/**
 * Declares a single method ({@link #words()}) that can be implemented to return a {@link
 * Collection Collection&lt;String&gt;} of words for use in generating passphrases.
 */
public interface WordProvider {

  /**
   * Returns a {@link Collection Collection&lt;String&gt;} of words for use in generating
   * passphrases.
   */
  Collection<String> words();

}
