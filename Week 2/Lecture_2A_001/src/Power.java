public class Power {
  public static void main(String[] args){
    int[] arr = new int[25];
    for (int x = 0; x <25; x++){
      arr[x] = (int) Math.pow(2,x);
    }

    //for (int x = 0; x <25; x++){
    //  System.out.println(arr[x]);
    //}
    for (int x : arr) {
      System.out.println(x);
    }

  }
}
