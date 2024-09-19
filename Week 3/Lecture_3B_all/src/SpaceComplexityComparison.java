public class SpaceComplexityComparison {

  public static void main(String[] args) {
    int n = 200000000; // Array size

    // Create a single array for both methods to work on
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = i;
    }

    // Measure space usage for reversing with a temporary array
    System.out.println("Space used by reversing with temp array: " + measureSpace(() -> reverseWithTempArray(array.clone())) + " bytes");

    // Measure space usage for reversing in place
    System.out.println("Space used by reversing in place: " + measureSpace(() -> reverseInPlace(array.clone())) + " bytes");
  }

  // Reverse an array using a temporary array
  public static void reverseWithTempArray(int[] arr) {
    int n = arr.length;
    int[] temp = new int[n];
    for (int i = 0; i < n; i++) {
      temp[i] = arr[n - 1 - i];
    }
    arr = temp; // Point original array to the reversed one (for fairness)
  }

  // Reverse an array in place
  public static void reverseInPlace(int[] arr) {
    int n = arr.length;
    int start = 0, end = n - 1;
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  // Method to measure the space used by an algorithm
  public static long measureSpace(Runnable algorithm) {
    Runtime runtime = Runtime.getRuntime();

    // Run garbage collector to clean up memory
    runtime.gc();

    // Get used memory before running the algorithm
    long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

    // Run the algorithm
    algorithm.run();

    // Get used memory after running the algorithm
    long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();

    // Return the memory difference (space used by the algorithm)
    return usedMemoryAfter - usedMemoryBefore;
  }
}
