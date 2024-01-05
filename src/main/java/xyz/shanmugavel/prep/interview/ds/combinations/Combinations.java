package xyz.shanmugavel.prep.interview.ds.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Combinations {

  private static List<List<String>> findCombinations(List<String> input) {
    if (input.size() == 0) {
      return List.of(List.of());
    }

    String firstElement = input.get(0);
    List<String> rest = input.subList(1, input.size());
    List<List<String>> combinationsWithoutFirstElements = findCombinations(rest);
    List<List<String>> combinationsWithFirstElement = new ArrayList<>();
    combinationsWithoutFirstElements.forEach( comb -> {
     List<String> combination = new ArrayList<>();
      combination.add(firstElement);
      combination.addAll(comb);
      combinationsWithFirstElement.add(combination);
    });
    List<List<String>> result =  new ArrayList<>(combinationsWithoutFirstElements);
    result.addAll(combinationsWithFirstElement);
    return result;
  }

  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter comma separated elements>>");
      List<String> input = Arrays.stream(scanner.next().split(",")).toList();
      System.out.println("Input>>" + input);
      List<List<String>> result = findCombinations(input);
      System.out.println(result);
    }
  }
}
