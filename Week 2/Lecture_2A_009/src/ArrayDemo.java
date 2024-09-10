import java.awt.*;

public class ArrayDemo {
  public static void main(String[] args) {
    Point[] arr = new Point[25];
    for (int i = 0; i < 25; i++) {
      arr[i] = new Point(1, i);
    }
    //for (int i = 0; i < 25; i++) {
    //  System.out.println(arr[i]);
    //}

    for (Point x : arr) {
      System.out.println("(" + x.getX() + ", " + x.getY() + ")");
    }
  }
}