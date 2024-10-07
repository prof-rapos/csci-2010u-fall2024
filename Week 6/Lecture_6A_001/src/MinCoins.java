public class MinCoins {
  public static void main(String[] args) {
    int[] coins = new int[]{200, 100, 25, 10, 5};


    int amount = 2385;
    int[] memo = new int[amount+1];
    System.out.println(minCoinChange(coins, amount, memo));

  }

  public static int minElement(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int val : arr) {
      if (val < min) {
        min = val;
      }
    }
    return min;
  }

  public static int minCoinChange(int[] coins, int amount, int[] memo) {
    if (amount == 0) {
      return 0;
    } else if (memo[amount] != 0) {
      return memo[amount]; // Return cached result
    } else {
      int minCoins = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (coin <= amount) {
          int minRemain = minCoinChange(coins, amount - coin, memo);
          minCoins = Math.min(minCoins, 1 + minRemain);
        }
      }
      memo[amount] = minCoins; // Cache result
      return minCoins;
    }

  }

  public static int minCoinsMemo(int[] coins, int amount, int[] memo) {
    if (amount == 0) {
      return 0;
    }
    if (memo[amount] != 0) {
      return memo[amount]; // Return cached result
    }
    int result = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (amount - coin >= 0) {
        result = Math.min(result,
            minCoinsMemo(coins, amount - coin,
                memo) + 1);
      }
    }
    memo[amount] = result; // Cache result
    return result;
  }

}