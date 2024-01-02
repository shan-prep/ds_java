package xyz.shanmugavel.prep.interview.ds.list;


public class Test {

  public static void main(String[] args) {
    ShanLinkedList<Integer> linkedList = new ShanLinkedList<>();
    System.out.println("<<Empty LinkedList>>");
    printLinkedList(linkedList);
    linkedList.add(1);
    System.out.println("<<After adding 1 element>>");
    printLinkedList(linkedList);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);
    linkedList.add(6);
    linkedList.add(7);
    System.out.println("<<After adding 6 more elements>>");
    printLinkedList(linkedList);

    linkedList.print();

    int no = linkedList.get(1);
    System.out.println("Value at index 1 is " + no);
    System.out.println("<<After retrieving element by index>>");
    printLinkedList(linkedList);
    linkedList.removeByIndex(0);
    System.out.println("<<After removing head>>");
    printLinkedList(linkedList);
    linkedList.print();
    linkedList.removeByIndex(linkedList.size()-1);
    System.out.println("<<After removing element at tail>>");
    printLinkedList(linkedList);
    linkedList.print();
    linkedList.removeByIndex(2);
    System.out.println("<<After removing element at index 2>>");
    printLinkedList(linkedList);
    linkedList.print();
    linkedList.removeByValue(3);
    System.out.println("<<After removing element with value 3>>");
    printLinkedList(linkedList);
    linkedList.print();
  }

  private static <T> void printLinkedList(ShanLinkedList<T> linkedList) {
    System.out.printf("Size=%d isEmpty=%s%n", linkedList.size(), linkedList.isEmpty());
  }
}
