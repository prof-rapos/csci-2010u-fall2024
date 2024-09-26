import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class JavaQueue {
  public static void main(String[] args) {
    Queue<RandomNumber> q = new LinkedList<>();

    for (int i = 0; i < 100; i++) {
      q.add(new RandomNumber());
    }

    System.out.println(q.size());

    while(!q.isEmpty()) {
      RandomNumber val = q.remove();
      if(val.getValue() > 90) {
        System.out.println(val);
      }
    }

  }

}
