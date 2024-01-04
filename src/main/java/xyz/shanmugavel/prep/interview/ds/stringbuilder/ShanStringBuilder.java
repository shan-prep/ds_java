package xyz.shanmugavel.prep.interview.ds.stringbuilder;

import java.util.Arrays;

public class ShanStringBuilder {

  private static int DEFAULT_SIZE = 2;
  private static int PERCENTAGE_CAPACITY_INCREASE = 75;

  private char[] chars = new char[DEFAULT_SIZE];
  private int currentSize = 0;

  public ShanStringBuilder append(String s) {
    if (null != s) {
      while(!isCapacityAvailable(s)) {
        increaseCapacity();
      }
      for(char c : s.toCharArray()) {
        chars[currentSize++] = c;
      }
    }
    return this;
  }

  private boolean isCapacityAvailable(String data) {
    if ( data.length() + currentSize < chars.length ) {
      return true;
    }
    return false;
  }

  private void increaseCapacity() {
    Long newSize = Math.round(chars.length * (1 + (PERCENTAGE_CAPACITY_INCREASE/100.0)));
    char[] tmp = Arrays.copyOf(chars, newSize.intValue());
    this.chars = tmp;
    System.out.println("Increased capacity!...NewLength="+newSize.intValue());
  }

  @Override
  public String toString() {
    return new String(Arrays.copyOfRange(chars, 0, currentSize));
  }

}
