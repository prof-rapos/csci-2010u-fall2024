import java.util.ArrayList;

public class PowerList {
  public static void main(String[] args){
    ArrayList<Integer> list = new ArrayList<>();
    for (int x = 0; x <25; x++){
      list.add((int) Math.pow(2,x));
    }

    //for (int x = 0; x <25; x++){
    //  System.out.println(arr[x]);
    //}
    //for (int x : arr) {
   //   System.out.println(x);
    //}
    System.out.println(list);
  }
}
