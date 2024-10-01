public class Recursion {
  public static void main(String[] args) {
    for (int i = 0; i <= 10; i++) {
      System.out.printf("%10d %10d%n", fac_iter(i), fac_rec(i));
    }
    
  }

  public static int fac_rec(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n * fac_rec(n-1);
    }
  }

  public static int fac_iter(int n) {
    int factorial = 1;
    for (int i = 1; i <= n; i++) {
      factorial *= i;
    }
    return factorial;
  }




  public static  boolean oddOdd(int n) {
    System.out.println(n);
    if (n >= 0 && n < 10) {
      return (n % 2 == 1);
    } else {
      return (oddOdd(n / 10) ^ (n % 10 % 2 == 1));
    }

  }

}