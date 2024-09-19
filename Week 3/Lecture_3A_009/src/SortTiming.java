import java.util.Arrays;

public class SortTiming {
  public static void main(String[] args) {
    int[] array = generateRandomArray(1000000);

    // Warm-up JVM
    warmUpJVM();

    // Timing Merge Sort
    int[] mergeSortArray = Arrays.copyOf(array, array.length);
    long mergeSortTime = timeSort(() -> mergeSort(mergeSortArray, 0, mergeSortArray.length - 1));
    System.out.println("Time to Merge Sort the Array: " + mergeSortTime + " nanoseconds");

    // Timing Selection Sort
    int[] selectionSortArray = Arrays.copyOf(array, array.length);
    long selectionSortTime = timeSort(() -> selectionSort(selectionSortArray));
    System.out.println("Time to Selection Sort the Array: " + selectionSortTime + " nanoseconds");
  }

  public static void warmUpJVM() {
    for (int i = 0; i < 5; i++) {
      int[] dummyArray = generateRandomArray(10000);
      Arrays.sort(dummyArray);  // Warm up JVM with a standard sort
    }
  }

  public static long timeSort(Runnable sortAlgorithm) {
    long startTime = System.nanoTime();
    sortAlgorithm.run();
    long endTime = System.nanoTime();
    return endTime - startTime;
  }

  public static int[] generateRandomArray(int size) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = (int) (Math.random() * 100000);
    }
    return array;
  }

  // Merge Sort Implementation
  public static void mergeSort(int[] array, int left, int right) {
    if (left < right) {
      int middle = (left + right) / 2;
      mergeSort(array, left, middle);
      mergeSort(array, middle + 1, right);
      merge(array, left, middle, right);
    }
  }

  public static void merge(int[] array, int left, int middle, int right) {
    int n1 = middle - left + 1;
    int n2 = right - middle;

    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    System.arraycopy(array, left, leftArray, 0, n1);
    System.arraycopy(array, middle + 1, rightArray, 0, n2);

    int i = 0, j = 0;
    int k = left;

    while (i < n1 && j < n2) {
      if (leftArray[i] <= rightArray[j]) {
        array[k++] = leftArray[i++];
      } else {
        array[k++] = rightArray[j++];
      }
    }

    while (i < n1) {
      array[k++] = leftArray[i++];
    }

    while (j < n2) {
      array[k++] = rightArray[j++];
    }
  }

  // Selection Sort Implementation
  public static void selectionSort(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      int temp = array[minIndex];
      array[minIndex] = array[i];
      array[i] = temp;
    }
  }
}
