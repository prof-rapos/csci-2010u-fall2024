import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo_4B2 {

  public static void main(String[] args) {
    // Create a Queue for Integers
    Queue<Integer> intQueue = new LinkedList<>();

    // Populate the Integer queue
    intQueue.add(10);
    intQueue.add(20);
    intQueue.add(30);

    // Display the contents of the Integer queue
    System.out.println("Integer Queue: " + intQueue);

    // Remove an element from the Integer queue
    int removedInt = intQueue.remove();
    System.out.println("Removed from Integer Queue: " + removedInt);
    System.out.println("Integer Queue after removal: " + intQueue);

    // Create a Queue for Strings
    Queue<String> stringQueue = new LinkedList<>();

    // Populate the String queue
    stringQueue.add("Hello");
    stringQueue.add("World");
    stringQueue.add("Queue");

    // Display the contents of the String queue
    System.out.println("String Queue: " + stringQueue);

    // Remove an element from the String queue
    String removedStr = stringQueue.remove();
    System.out.println("Removed from String Queue: " + removedStr);
    System.out.println("String Queue after removal: " + stringQueue);
  }
}
