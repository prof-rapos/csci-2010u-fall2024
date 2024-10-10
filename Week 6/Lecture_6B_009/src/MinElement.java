public class MinElement {

  public static void main(String[] args){
    int[] arr = new int[]{100,19,64,24,56,78,35,7888,544,67,43,6,54,3,6,7,4,3,6,87,8,6,4};
    System.out.println(minElement(arr,0, arr.length-1));
  }

  public static int minElement(int[] arr, int low, int high) {
    if (low == high) {
      return arr[low];
    } else {
      int mid = (low + high) / 2;
      return Math.min(minElement(arr,low, mid), minElement(arr, mid+1, high));
    }
  }


}
