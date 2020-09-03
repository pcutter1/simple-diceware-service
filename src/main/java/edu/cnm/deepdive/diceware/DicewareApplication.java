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
package edu.cnm.deepdive.diceware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Launches a Spring MVC application that provides a simple Diceware passphrase-generation service.
 */
@SpringBootApplication
public class DicewareApplication {

  /**
   * Initiates Spring MVC-based web service.
   *
   * @param args command-line arguments (currently ignored).
   */
  public static void main(String[] args) {
    SpringApplication.run(DicewareApplication.class, args);
  }

}
