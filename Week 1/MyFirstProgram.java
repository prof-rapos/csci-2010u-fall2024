public class MyFirstProgram {
  public static void main(String[] args) {

    for(int x = 1; x <=10; x++) {
      System.out.println(mult10(x));
    }
  }

  public static int mult10(int x) {
    return 10*x;
  }
}