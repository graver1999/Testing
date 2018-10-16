public class Main {
    public static void main(String[] args) {
        System.out.println(isAvaliable(1,1,1));
    }
    public static boolean isAvaliable(double a, double b, double c) {
            return !(a <= 0) && !(b <= 0) && !(c <= 0) && a + b > c && b + c > a && a + c > b;
    }
}
