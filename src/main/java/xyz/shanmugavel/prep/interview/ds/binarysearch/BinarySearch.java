package xyz.shanmugavel.prep.interview.ds.binarysearch;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearch {

  public static void main(String[] args) {
    List<Integer> input = IntStream.range(1, 26).boxed().toList();
    System.out.println("Input>>" + input);
    try(Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter a number between 1 and 25");
      int noToFind = scanner.nextInt();
      int result = binarySearch(input, 0, input.size()-1, noToFind);
      if ( result == -1) {
        System.err.println("Given Element is not found!");
      } else {
        System.out.println("Element is found at index " + result);
      }
    }
  }

  private static int binarySearch(List<Integer> input, int startIndex, int endIndex, int noToFind) {
    int midIndex = (startIndex + endIndex) / 2;
    int valAtIndex = input.get(midIndex);
    System.out.printf("StartIndex=%d EndIndex=%d MidIndex=%d NoToFind=%d ValueAtIndex=%d%n", startIndex, endIndex, midIndex, noToFind, valAtIndex);
    if ( startIndex >= endIndex) {
      return -1;
    }
    if ( valAtIndex == noToFind ) {
      System.out.println("Value found!!! Index="+midIndex);
      return midIndex;
    } else if (valAtIndex > noToFind) {
      return binarySearch(input, startIndex, midIndex-1, noToFind);
    } else {
      return binarySearch(input, midIndex+1, endIndex, noToFind);
    }
  }
}