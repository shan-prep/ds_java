package xyz.shanmugavel.prep.interview.ds.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permutations {

  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter comma separated elements>>");
      List<String> input = Arrays.stream(scanner.next().split(",")).toList();
      System.out.println("Input>>" + input);
      List<List<String>> result = findPermutations(input);
      System.out.println(result);
    }
  }

  private static List<List<String>> findPermutations(List<String> input) {
    if (input.size() == 0) {
      return List.of(List.of());
    }

    String firstElement = input.get(0);
    List<String> rest = input.subList(1, input.size());
    List<List<String>> permutationsWithoutFirstElements = findPermutations(rest);
    List<List<String>> allPermutations = new ArrayList<>();

    permutationsWithoutFirstElements.forEach(val -> {
      for(int lc=0; lc <= val.size(); lc++) {
          List<String> permutation = new ArrayList<>();
          permutation.addAll(val.subList(0, lc));
          permutation.add(firstElement);
          permutation.addAll(val.subList(lc, val.size()));
          allPermutations.add(permutation);
      }
    });
    return allPermutations;

  }
}
