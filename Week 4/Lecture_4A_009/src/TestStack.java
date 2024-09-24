public class TestStack {
  public static void main(String[] args){
    Stack<Double> myStack = new Stack<Double>();
    myStack.push(3.1415926);
    myStack.push(100.7);
    myStack.push(-0.9999998);
    System.out.println(myStack.size());
    System.out.println(myStack.peek());
    System.out.println(myStack.peek());

    while(!myStack.empty()){
      System.out.println(myStack.pop());
    }
  }

}
