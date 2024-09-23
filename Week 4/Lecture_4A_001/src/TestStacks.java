public class TestStacks {

  public static void main(String[] args) {

    Stack<Integer> myStack = new Stack<>();
    myStack.push(1);
    myStack.push(2);
    System.out.println(myStack.size);
    System.out.println(myStack.peek());


    while (!myStack.empty()){
      System.out.println(myStack.pop());
    }

  }

}
