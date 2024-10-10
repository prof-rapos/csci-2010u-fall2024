import java.util.Stack;

public class StackDemo_4A2 {

  public static void main(String[] args) {
    // Create a Stack for Integers
    Stack<Integer> intStack = new Stack<>();

    // Populate the Integer stack
    intStack.push(10);
    intStack.push(20);
    intStack.push(30);

    // Display the contents of the Integer stack
    System.out.println("Integer Stack: " + intStack);

    // Remove an element from the Integer stack
    int removedInt = intStack.pop();
    System.out.println("Removed from Integer Stack: " + removedInt);
    System.out.println("Integer Stack after removal: " + intStack);

    // Create a Stack for Strings
    Stack<String> stringStack = new Stack<>();

    // Populate the String stack
    stringStack.push("Hello");
    stringStack.push("World");
    stringStack.push("Stack");

    // Display the contents of the String stack
    System.out.println("String Stack: " + stringStack);

    // Remove an element from the String stack
    String removedStr = stringStack.pop();
    System.out.println("Removed from String Stack: " + removedStr);
    System.out.println("String Stack after removal: " + stringStack);
  }
}
