import java.util.ArrayList;
import java.util.List;

public class PowerSet_6A2 {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    List<List<Integer>> results = generateSubsets(nums);
    System.out.println(results);
    // Output: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
  }

  // Method to generate all subsets using backtracking, without a helper
  public static List<List<Integer>> generateSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    List<Integer> currentSubset = new ArrayList<>();
    subsets.add(new ArrayList<>(currentSubset));  // Add the empty subset

    for (int i = 0; i < nums.length; i++) {
      currentSubset.add(nums[i]);
      subsets.add(new ArrayList<>(currentSubset));  // Add current subset
      for (int j = i + 1; j < nums.length; j++) {
        currentSubset.add(nums[j]);
        subsets.add(new ArrayList<>(currentSubset));  // Add expanded subset
        currentSubset.remove(currentSubset.size() - 1);  // Backtrack
      }
      currentSubset.remove(currentSubset.size() - 1);  // Backtrack
    }

    return subsets;
  }
}
