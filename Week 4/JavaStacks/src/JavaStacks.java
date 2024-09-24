import java.util.Stack;

public class JavaStacks {
  public static void main(String[] args) {
    final int TARGET = 25;
    Stack<Integer> s = new Stack<>();

    for (int i = 0; i < 1000; i++) {
      int q = (int)(Math.random() * 1000) + 1;
      s.push(q);

    }
    int ind = 0;
    while(!s.isEmpty()){
      int x = s.pop();
      if (x == TARGET) {
        System.out.println("Target Found at position " + ind);
      }
      ind++;
    }


  }
}