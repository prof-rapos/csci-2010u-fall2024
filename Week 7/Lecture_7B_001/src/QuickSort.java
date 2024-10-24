import java.util.Arrays;

public class QuickSort {

  public static void quickSort(int[] arr, int left, int right) {
    // make sure there is something still to sort (not a single element)

    // partition the array


    //recursively sort two partitions

  }


  public static int partition(int[] arr, int left, int right) {
    //use the left value as the pivot
    int pivotValue = arr[left];
    int i = left + 1; // Start from the element right after the pivot
    int j = right;    // Start from the end of the array

    // while there are still values left to compare

    // Move i to the right until we find an element greater than or equal to the pivot

    // Move j to the left until we find an element less than or equal to the pivot

    // If i is still less than or equal to j, we need to swap the out-of-place elements and advance the pointers



    // Move the pivot to its final place

    // Return the final position of the pivot
    return j;
  }

  // Utility function to swap two elements in an array
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {

  }
}
