public class FactorialCalculator_5A1 {

  // Method to calculate factorial using a for loop
  public static int factorial(int num) {
    // Factorial of 0 is 1
    if (num == 0) {
      return 1;
    }

    int result = 1;
    for (int i = 1; i <= num; i++) {
      result *= i; // Multiply result by each number up to num
    }
    return result;
  }

  // Main method to test the factorial method
  public static void main(String[] args) {
    // Test cases
    System.out.println("Factorial of 0: " + factorial(0)); // Expected: 1
    System.out.println("Factorial of 1: " + factorial(1)); // Expected: 1
    System.out.println("Factorial of 5: " + factorial(5)); // Expected: 120
    System.out.println("Factorial of 7: " + factorial(7)); // Expected: 5040
  }
}
