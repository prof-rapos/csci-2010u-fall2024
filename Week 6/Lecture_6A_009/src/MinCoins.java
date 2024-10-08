public class MinCoins {
  public static void main(String[] args) {
    int amount = 385;
    int[] memo = new int[amount + 1];
    int[] coins = new int[]{200, 100, 25, 10, 5};
    System.out.println(minCoinChange(coins, amount, memo));
  }

  public static int minCoinChange(int[] coins, int amount, int[] memo) {
    if (amount == 0) {
      return 0;
    } else if (memo[amount] != 0) {
      return memo[amount];
    } else {
      int minCoins = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (coin <= amount) {
          int remaining = minCoinChange(coins, amount - coin, memo);
          minCoins = Math.min(minCoins, 1 + remaining);
        }
      }
      memo[amount] = minCoins;
      return  minCoins;
    }
  }
}