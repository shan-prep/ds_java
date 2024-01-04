package xyz.shanmugavel.prep.interview.ds.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SummingSquares {

  private static double minSummingSquare(int no, Map<Integer, Double> memory) {
    if ( no == 0 ) {
      return 0;
    }

    if(memory.containsKey(no)) {
      return memory.get(no);
    }

    double minSquares = Double.POSITIVE_INFINITY;
    int square;
    for (int i=1; i<= Math.sqrt(no); i++) {
      square = i * i;
      double noSquares = 1 + minSummingSquare(no - square, memory);
      minSquares = Math.min(minSquares, noSquares);
    }

    memory.put(no, minSquares);
    return  memory.get(no);
  }
  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter the no >>> ");
      int no = scanner.nextInt();
      Map<Integer, Double> memory = new HashMap<>();
      double minCountOfSummingSquare = minSummingSquare(no, memory);
      System.out.println("Min count of summing square>>" + minCountOfSummingSquare);
    }
  }
}
