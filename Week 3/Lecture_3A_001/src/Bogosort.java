import java.util.Arrays;
import java.util.Random;

public class Bogosort {

  // Check if the array is sorted
  public static boolean isSorted(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        return false;
      }
    }
    return true;
  }

  // Shuffle the array randomly
  public static void shuffle(int[] arr) {
    Random rand = new Random();
    for (int i = 0; i < arr.length; i++) {
      int randomIndex = rand.nextInt(arr.length);
      int temp = arr[i];
      arr[i] = arr[randomIndex];
      arr[randomIndex] = temp;
    }
  }

  // Implement Bogosort
  public static void bogosort(int[] arr) {
    while (!isSorted(arr)) {
      shuffle(arr);
    }
  }

  public static void main(String[] args) {


    int size = 12;
    int[] arr = new int[size];
    Random rand = new Random();

    // Generate random array
    for (int i = 0; i < size; i++) {
      arr[i] = rand.nextInt(100); // values between 0 and 99
    }

    System.out.println("Unsorted array: " + Arrays.toString(arr));

    // Time the execution of Bogosort
    long startTime = System.nanoTime();
    bogosort(arr);
    long endTime = System.nanoTime();

    // Calculate elapsed time in milliseconds
    double elapsedTime = (endTime - startTime) / 1_000_000.0;

    System.out.println("Sorted array: " + Arrays.toString(arr));
    System.out.println("Execution time: " + elapsedTime + " ms");
  }
}
