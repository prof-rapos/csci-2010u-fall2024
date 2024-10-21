public class MergeSort {

  // Method to perform merge sort on an array
  public static void mergeSort(int[] array, int left, int right) {
    if (left < right) {
      // Find the middle point
      int mid = (left + right) / 2;
      // Recursively sort the first and second halves
      mergeSort(array, left, mid);
      mergeSort(array, mid+1, right);

      // Merge the sorted halves
      merge(array,left, mid, right);

    }
  }

  // Method to merge two halves of the array
  public static void merge(int[] array, int left, int mid, int right) {
    // Sizes of two subarrays to be merged
    int leftSize = mid - left + 1;
    int rightSize = right - mid;
    // Temporary arrays
    int[] leftArr = new int[leftSize];
    int[] rightArr = new int[rightSize];

    int index = left;
    // Copy data to temp arrays
    for(int i = 0; i < leftSize; i++) {
      leftArr[i] = array[index++];
    }
    for(int i = 0; i < rightSize; i++) {
      rightArr[i] = array[index++];
    }


    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of the merged subarray
    int k = left;
    while (i < leftSize && j < rightSize){
      if(leftArr[i] < rightArr[j]) {
        array[k++] = leftArr[i++];
      } else {
        array[k++] = rightArr[j++];
      }
    }
      while(i < leftSize) {
        array[k++] = leftArr[i++];
      }


      while(j < rightSize){
        array[k++] = rightArr[j++];
      }


  }

  // Main method to test the merge sort implementation
  public static void main(String[] args) {
    int[] array = new int[]{8,6,4,9,1,3,5,7,2};
    printArray(array);
    mergeSort(array, 0 ,array.length-1);
    printArray(array);
  }

  // Utility method to print the elements of an array
  public static void printArray(int[] array) {
    for (int i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
