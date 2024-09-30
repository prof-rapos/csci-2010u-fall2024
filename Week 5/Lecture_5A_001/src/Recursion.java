public class Recursion {

  public static void main(String[] args) {

    System.out.println(fac_rec(0));
    System.out.println(fac_rec(10));
    System.out.println(fac_rec(4));

  }

  public static int fac_rec(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n * fac_rec(n-1);
    }
  }

  public static int fac_iter(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }


  public static int sumDigits(int n) {
    if (n >=0 && n < 10) {
      return n;
    } else {
      return (n % 10) + sumDigits(n / 10);
    }
  }

  public static int strLen(String s) {
    if (s.length() == 0) {
      return 0;
    } else {
      return 1 + strLen(s.substring(0, s.length()-1));
    }
  }






}