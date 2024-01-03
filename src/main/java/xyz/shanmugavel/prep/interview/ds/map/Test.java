package xyz.shanmugavel.prep.interview.ds.map;

public class Test {

  public static void main(String[] args) {
    ShanHashMap<String, String> elem = new ShanHashMap<>();
    System.out.println("Empty Map!!!");
    printMapInfo(elem);
    elem.put("1", "One");
    System.out.println("After adding 1 elem!!!");
    printMapInfo(elem);
    elem.put("2", "Two");
    elem.put("3", "Three");
    elem.put("4", "Four");
    elem.put("5", "Five");
    elem.put("6", "Six");
    System.out.println("After adding 5 elems!!!");
    printMapInfo(elem);
    elem.put("7", "Seven");
    elem.put("8", "Eight");
    elem.put("9", "Nine");
    elem.put("10", "Ten");
    elem.put("0", "Zero");
    System.out.println("After adding 5 more elems!!!");
    printMapInfo(elem);
    String val = elem.get("5");
    System.out.println("Value for Key '5' is " + val);
    System.out.println("Value for UnknownKey 'abc' is " + elem.get("abc"));
    System.out.println("keys>>"+elem.getKeys());
    System.out.println("entries>>"+elem.getEntries());
    elem.delete("5");
    System.out.println("After deleting element with key 5!!!");
    printMapInfo(elem);
    elem.put("5", "Five");
    System.out.println("After adding element with key 5!!!");
    printMapInfo(elem);
    elem.put("5", "FIVE");
    System.out.println("After updating alue for element with key 5!!!");
    printMapInfo(elem);
    System.out.println("entries>>"+elem.getEntries());
  }

  private static void printMapInfo(ShanHashMap<String, String> elements){
    System.out.printf("No of elements=%d %n", elements.getSize());
    elements.print();
  }
}
