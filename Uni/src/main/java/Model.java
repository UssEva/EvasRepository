package de.uni_passau.fim.infosun.se2.mvc_rng;

import java.security.SecureRandom;
import java.util.Random;

/** The game logic of the dice-guess-game */
class Model {

  /** States whether the user's guess was correct, too small or too large */
  enum Correctness {
    /** User's input was too small */
    SMALL,

    /** User's input was correct */
    CORRECT,

    /** User's input was too large */
    LARGE
  }

  /** An individual exception indicating an invalid argument */
  class InvalidArgumentException extends Exception {

    InvalidArgumentException(final String pMessage) {
      super(pMessage);
    }
  }

  private int randomNumber;
  private final Random rng;
  private final int low;
  private final int high;
  private int numberOfTries;

  Model() {
    rng = new SecureRandom();
    low = 1;
    high = 101;
    numberOfTries = 0;
    dice();
  }

  /** Choose a new random number and reset number of tries */
  void dice() {
    numberOfTries = 0;
    Random r = new SecureRandom();
    randomNumber = r.nextInt(100);
  }

  /**
   * Checks whether the number guessed by the user is correct.
   *
   * @param pNumber The number guessed by the user
   * @return Whether the number is correct or too small/large
   * @throws InvalidArgumentException If the given parameter is out of range
   * @see Correctness
   */
  Correctness check(final int pNumber) throws InvalidArgumentException {

    if ((pNumber < 1)||(pNumber > 100)){
      throw new InvalidArgumentException("Only values between 1 and 100 are allowed here!");
    }

    if(pNumber > randomNumber){
      numberOfTries++;
      return Correctness.LARGE;
    }
    if(pNumber < randomNumber){
      numberOfTries++;
      return Correctness.SMALL;
    }
    else{
      numberOfTries++;
      return Correctness.CORRECT;
    }

  }

  /**
   * Returns the number of guess tries.
   *
   * @return The number of guesses
   */
  int getNumberOfTries() {
    return numberOfTries/4;
  }
}
