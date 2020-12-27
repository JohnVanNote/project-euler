package com.jvn.math;

import java.util.ArrayList;
import java.util.List;

public class LexicographicPermutations {

  public static List<List<Character>> getPermutations(List<Character> characters) {
    List<List<Character>> permutations = new ArrayList<>();
    permutations.add(characters);
    if (characters != null) {
      int characterSize = characters.size();
      if (characterSize > 1) {
        for (int i = characterSize; i >= 2; i--) {

          Character ultimateCharacter = characters.get(i - 1);
          Character penultimateCharacter = characters.get(i - 2);
          if (penultimateCharacter <= ultimateCharacter) {

            // beginning
            List<Character> startingCharacters = characters.subList(0, i - 2);

            // middle
            List<Character> switchCharacters = new ArrayList<>();
            switchCharacters.add(ultimateCharacter);
            switchCharacters.add(penultimateCharacter);

            // end
            List<Character> endingCharacters = characters.subList(i, characterSize);

            // new perm
            List<Character> newPermutation = new ArrayList<>(startingCharacters);
            newPermutation.addAll(switchCharacters);
            newPermutation.addAll(endingCharacters);

            permutations.addAll(getPermutations(newPermutation));
          }
        }
      }
    }
    System.out.println("Characters " +  characters + " Permutations " + permutations);
    return permutations;
  }

}
