public class TestQueue {
  public static void main(String[] args) {
    MyQueue<Character> q = new MyQueue<>();

    System.out.println(q.size());
    System.out.println(q.peek());
    System.out.println(q.dequeue());

    String s = "This is my string.";

    for(int i = 0; i < s.length(); i++){
      q.enqueue(s.charAt(i));
    }

    System.out.println(q.size());
    System.out.println(q.peek());

    while (!q.empty()) {
      System.out.print(q.dequeue());
    }
    System.out.println();

  }
}
