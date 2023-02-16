import java.util.Scanner;

public class ComplexIO {
    public static void printComplex(Complex x) {
        System.out.println(x.toString());
    }
    public static void printComplexTrig(Complex x) {
        System.out.println(x.r() + " * (cos(" + x.theta() + ") + i * sin(" + x.theta() + "))");
    }
    public static void inputComplex(Scanner scanner, Complex x) {
        x.setRe(scanner.nextDouble());
        x.setIm(scanner.nextDouble());
    }

}
