public class CompareStrings {

  public static void main(String[] args) {
    System.out.println("a".compareTo("a")); //output 0 - they are the same
    System.out.println("a".compareTo("b")); //output -1 - a is before b, a is negative of b
    System.out.println("b".compareTo("a")); //output 1 - b is after a, b is positive of a
    System.out.println("a".compareTo("z")); //output -25 - a - is before z
    System.out.println("a".compareTo("A")); //output 32 - a is after A (case matters)
  }
}
