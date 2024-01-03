package xyz.shanmugavel.prep.interview.ds.common.fib;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FibonacciRecursion {

  private static int fib(int no) {
    if(no <= 0) {
      return 0;
    }
    if(no == 1) {
      return 1;
    }
    return fib(no-1) + fib(no-2);
  }
  public static void main(String[] args) {
    List<Integer> result = IntStream.rangeClosed(0, 15)
        .map( val -> fib(val))
        .boxed()
        .collect(Collectors.toList());
    System.out.println(result);
  }
}
