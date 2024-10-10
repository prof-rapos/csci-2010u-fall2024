public class MinElement {
  public static void main(String[] args) {
    int[] arr = new int[]{32423,3, 432,4232,32,45,3,5,5757,535,657,567};
    System.out.println(minElement(arr, 0, arr.length-1));
  }

  public static int minElement(int[] arr, int low, int high) {
    if (low == high) {
      return arr[low];
    } else {
      int mid = (low + high) / 2;
      int leftLow =minElement(arr, low, mid);
      int rightLow = minElement(arr, mid+1, high);
      return Math.min(leftLow, rightLow);
    }

  }
}
