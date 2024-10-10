public class RecursionProblems_5A2 {

  // Problem 1: Triangle (number of total blocks in 'rows' rows of a triangle)
  public static int triangle(int rows) {
    if (rows == 0) {
      return 0; // Base case
    }
    return rows + triangle(rows - 1); // Recursive case
  }

  // Problem 2: Sum Digits (sums all digits of the number 'n')
  public static int sumDigits(int n) {
    if (n == 0) {
      return 0; // Base case
    }
    return n % 10 + sumDigits(n / 10); // Recursive case
  }

  // Problem 3: powerN (computes 'base' raised to the power 'n')
  public static int powerN(int base, int n) {
    if (n == 0) {
      return 1; // Base case: any number raised to 0 is 1
    }
    return base * powerN(base, n - 1); // Recursive case
  }

  // Main method to test all problems
  public static void main(String[] args) {
    // Test Problem 1: Triangle
    System.out.println("Triangle(3): " + triangle(3)); // Output: 6
    System.out.println("Triangle(5): " + triangle(5)); // Output: 15

    // Test Problem 2: Sum Digits
    System.out.println("SumDigits(126): " + sumDigits(126)); // Output: 9
    System.out.println("SumDigits(49): " + sumDigits(49));   // Output: 13

    // Test Problem 3: powerN
    System.out.println("powerN(3, 3): " + powerN(3, 3)); // Output: 27
    System.out.println("powerN(2, 5): " + powerN(2, 5)); // Output: 32
  }
}
