public class MinCoinChange_6A1 {

  public static void main(String[] args) {
    int[] coins = new int[]{200, 100, 25, 10, 5};
    System.out.println(minCoinChange(coins, 385)); // Expected: 4 (200 + 100 + 25 + 25 + 25 + 10)
  }

  // Recursive method to find minimum number of coins for a given amount
  public static int minCoinChange(int[] coins, int amount) {
    // Base case: if the amount is 0, no coins are needed
    if (amount == 0) {
      return 0;
    }

    // Initialize the result with a large value
    int minCoins = Integer.MAX_VALUE;

    // Try every coin denomination that is less than or equal to the amount
    for (int coin : coins) {
      if (coin <= amount) {
        int result = minCoinChange(coins, amount - coin);
        if (result != Integer.MAX_VALUE && result + 1 < minCoins) {
          minCoins = result + 1;
        }
      }
    }

    return minCoins;
  }
}
