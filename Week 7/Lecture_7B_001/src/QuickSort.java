import java.util.Arrays;

public class QuickSort {

  public static void quickSort(int[] arr, int left, int right) {
    // make sure there is something still to sort (not a single element)
    if (left < right) {
      // partition the array
      int pValue = partition(arr, left, right);

      //recursively sort two partitions
      quickSort(arr, left, pValue - 1);
      quickSort(arr, pValue + 1, right);
    }
  }


  public static int partition(int[] arr, int left, int right) {
    //use the left value as the pivot
    int pivotValue = arr[left];
    int i = left + 1; // Start from the element right after the pivot
    int j = right;    // Start from the end of the array

    // while there are still values left to compare
    while (i <= j) {
      // Move i to the right until we find an element greater than or equal to the pivot
      while (i <= j && arr[i] < pivotValue) {
        i++;
      }
      // Move j to the left until we find an element less than or equal to the pivot
      while (i <= j && arr[j] > pivotValue) {
        j--;
      }
      // If i is still less than or equal to j, we need to swap the out-of-place elements and advance the pointers
      if (i <= j) {
        swap(arr,i,j);
        i++;
        j--;
      }

    }
    // Move the pivot to its final place
    swap(arr,left,j);
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
    int[] arr = new int[]{3,6,4,5,7,1,2};
    System.out.println("Original: " + Arrays.toString(arr));
    quickSort(arr,0,arr.length-1);
    System.out.println("Sorted: " + Arrays.toString(arr));
  }






















}
