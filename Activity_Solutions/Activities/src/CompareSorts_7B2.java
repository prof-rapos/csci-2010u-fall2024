import java.util.Arrays;

public class CompareSorts_7B2 {

  // Quick Sort method
  public static void quickSort(int[] array, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(array, low, high);
      quickSort(array, low, pivotIndex - 1); // Recursively sort the left partition
      quickSort(array, pivotIndex + 1, high); // Recursively sort the right partition
    }
  }

  // Partition method for Quick Sort
  private static int partition(int[] array, int low, int high) {
    int pivot = array[high]; // Choosing the last element as the pivot
    int i = low - 1; // Pointer for the smaller element
    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {
        i++;
        swap(array, i, j); // Swap elements
      }
    }
    swap(array, i + 1, high); // Place the pivot in the correct position
    return i + 1; // Return the pivot index
  }

  // Merge Sort method
  public static void mergeSort(int[] array, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2; // Find the middle point
      mergeSort(array, left, mid); // Recursively sort the first half
      mergeSort(array, mid + 1, right); // Recursively sort the second half
      merge(array, left, mid, right); // Merge the sorted halves
    }
  }

  // Merge method for Merge Sort
  private static void merge(int[] array, int left, int mid, int right) {
    int n1 = mid - left + 1; // Size of left subarray
    int n2 = right - mid; // Size of right subarray

    // Create temporary arrays
    int[] L = new int[n1];
    int[] R = new int[n2];

    // Copy data to temporary arrays
    for (int i = 0; i < n1; i++) {
      L[i] = array[left + i];
    }
    for (int j = 0; j < n2; j++) {
      R[j] = array[mid + 1 + j];
    }

    // Merge the temporary arrays back into the original array
    int i = 0, j = 0; // Initial indices for the subarrays
    int k = left; // Initial index of the merged subarray
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = R[j];
        j++;
      }
      k++;
    }

    // Copy remaining elements of L[], if any
    while (i < n1) {
      array[k] = L[i];
      i++;
      k++;
    }

    // Copy remaining elements of R[], if any
    while (j < n2) {
      array[k] = R[j];
      j++;
      k++;
    }
  }

  // Utility method to swap two elements in an array
  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  // Main method
  public static void main(String[] args) {
    int size = 10000000;
    int[] m = new int[size];
    int[] q = new int[size];

    for (int i = 0; i < size; i++) {
      int random = (int) (Math.random() * size + 1);
      m[i] = random;
      q[i] = random;
    }


    long start;
    long end;

    start = System.currentTimeMillis();
    mergeSort(m,0,size-1);
    end = System.currentTimeMillis();

    long merge = end - start;

    start = System.currentTimeMillis();
    quickSort(q, 0, size-1);
    end = System.currentTimeMillis();

    long quick = end - start;

    System.out.println("Merge Sort: " + merge);
    System.out.println("Quick Sort: " + quick);

  }
}
