public class Main {

    public static void main(String[] args) throws ArithmeticException {
        int a = 10;
        int b = 0;

        int result = divide(a, b);
        System.out.println("Result: " + result);
    }

    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }
}
