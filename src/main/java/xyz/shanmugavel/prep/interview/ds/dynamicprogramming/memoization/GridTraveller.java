package xyz.shanmugavel.prep.interview.ds.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

  private static long gridTraveller(int noOfRows, int noOfCols, Map<String, Long> memory) {
    if (noOfRows == 1 && noOfCols == 1) {
      return 1;
    }
    if ( noOfRows == 0 | noOfCols == 0) {
      return 0;
    }

    String key = noOfRows+","+noOfCols;
    if( memory.containsKey(key) ) {
      return memory.get(key);
    }

    long result = gridTraveller(noOfRows-1, noOfCols, memory) + gridTraveller(noOfRows, noOfCols - 1, memory);
    memory.put(key, result);
    return memory.get(key);

  }
  public static void main(String[] args) {
    System.out.println(gridTraveller(1,1, new HashMap<>()));//1
    System.out.println(gridTraveller(2,3, new HashMap<>()));//3
    System.out.println(gridTraveller(3,2, new HashMap<>()));//3
    System.out.println(gridTraveller(3,3, new HashMap<>()));//6
    System.out.println(gridTraveller(18,18, new HashMap<>()));//2333606220

  }
}
