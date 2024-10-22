public class MergeSort {

  // Method to perform merge sort on an array
  public static void mergeSort(int[] array, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);
      merge(array, left, mid, right);
    }
  }

  // Method to merge two halves of the array
  public static void merge(int[] array, int left, int mid, int right) {
    // Sizes of two subarrays to be merged
    int leftSize = mid + 1 - left;
    int rightSize = right - mid;

    // Temporary arrays
    int[] leftHalf = new int[leftSize];
    int[] rightHalf = new int[rightSize];

    // Copy data to temp arrays
    for (int i = 0; i < leftSize; i++) {
      leftHalf[i] = array[left+i];
    }
    for (int i = 0; i < rightSize; i++) {
      rightHalf[i] = array[mid+1+i];
    }

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of the merged subarray
    int k = left;

    // merge by taking smallest of two values
    while (i < leftSize && j < rightSize) {
      if (leftHalf[i] < rightHalf[j]) {
        array[k++] = leftHalf[i++];
      } else {
        array[k++] = rightHalf[j++];
      }
    }
    //take the rest of the left array
    while(i < leftSize){
      array[k++] = leftHalf[i++];
    }

    //take the rest of the right array
    while(j < rightSize) {
      array[k++] = rightHalf[j++];
    }

  }

  // Main method to test the merge sort implementation
  public static void main(String[] args) {
    int[] array = new int[]{7,6,3,5,7,8,4,47,8,8655,7,8,65,7,86,54,46,7,8,6,54,5};
    mergeSort(array, 0, array.length-1);
    printArray(array);
  }

  // Utility method to print the elements of an array
  public static void printArray(int[] array) {
    for(int i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}