public class CountingSort {

  // Stable Counting Sort with max value as parameter
  public static void countingSort(int[] arr, int maxValue) {

    // create a count array and sorted array
    int[] count = new int[0];
    int[] sorted = new int[0];

    // Step 1: Store the count of each element

    // Step 2: Calculate the running total (cumulative count)

    // Step 3: Build the sorted array in reverse for stability

    // Step 4: Copy sorted array back to original array
    System.arraycopy(sorted,0, arr, 0, arr.length);

  }

  // Test method
  public static void main(String[] args) {
    int[] arr = {4, 2, 3, 6, 5, 2, 4, 1};
    int maxValue = 6;

    System.out.println("Original array:");
    printArray(arr);

    countingSort(arr, maxValue);

    System.out.println("Sorted array:");
    printArray(arr);
  }

  // Helper method to print an array
  private static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
