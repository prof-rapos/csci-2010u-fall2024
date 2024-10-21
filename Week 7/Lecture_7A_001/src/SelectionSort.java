public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 4, 7, 9, 1, 2, 5, 6, 8};
    print(arr);
    selectionSort(arr);
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void selectionSort(int[] arr) {

    int n = arr.length;

    for (int i = 0; i <= n-1; i++) {
      int minIndex = i;

      for (int j = i+1; j <= n-1; j++) {
        if (arr[j] < arr[minIndex]){
          minIndex = j;
        }
      }

      if (minIndex != i) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] =temp;
      }

    }

  }





}
