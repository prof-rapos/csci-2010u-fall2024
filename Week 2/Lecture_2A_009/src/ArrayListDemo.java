import java.util.ArrayList;

public class ArrayListDemo {
  public static void main(String[] args) {
    ArrayList<Double> arrList = new ArrayList<>();

    arrList.add(47.2);
    arrList.add(73.6);
    arrList.add(64.5);
    arrList.add(3.1415926);
    arrList.add(0.0);

    System.out.println(arrList);

    arrList.add(3, -0.098765421);

    System.out.println(arrList);
    System.out.println(arrList.get(3));
    for (int i = 0; i < arrList.size()-1; i++) {
      arrList.set(i, (Math.random() * 100)+1);
    }
    System.out.println(arrList);

    System.out.println("List contains 5.5? " + (arrList.contains(5.5) ? "Yes" : "No"));
    System.out.println("List contains 0.0? " + (arrList.contains(0.0) ? "Yes" : "No"));
   /* while(arrList.size() > 0) {
      arrList.remove(0);
      System.out.println(arrList);
    }
    */

  }
}
