import java.util.Scanner;

public class Main {

    public static void test_complex(Scanner in) {
        Complex a = new Complex();
        Complex b = new Complex();
        System.out.print("Input 1st number: ");
        ComplexIO.inputComplex(in, a);
        System.out.print("Input 2nd number: ");
        ComplexIO.inputComplex(in, b);

        ComplexIO.printComplex(a);
        ComplexIO.printComplex(b);
        ComplexIO.printComplexTrig(a);
        ComplexIO.printComplexTrig(b);

        System.out.println("Sum: " + a.add(b));
        System.out.println("Diff: " + a.sub(b));
        System.out.println("Product: " + a.multiply(b));
    }

    public static void test_matrix(Scanner in) {
        System.out.print("Input N and M of matrix A: ");
        Matrix a = MatrixIO.inputMatrix(in);
        System.out.print("Input N and M of matrix B: ");
        Matrix b = MatrixIO.inputMatrix(in);
        System.out.println("Matrix A:");
        MatrixIO.printMatrix(a);
        System.out.println("Matrix B:");
        MatrixIO.printMatrix(b);

        System.out.println("Transposed A: " + System.lineSeparator() + a.transposed());
        System.out.println("Determinant of A: " + a.det());

        System.out.println("Sum: " + System.lineSeparator() + a.add(b));
        System.out.println("Sum: " + System.lineSeparator() + b.add(a));
        System.out.println("Diff: " + System.lineSeparator() + a.sub(b));
        System.out.println("Product: " + System.lineSeparator() + a.multiply(b));
    }

    public static void main(String[] args) {
        System.out.println("1. Test complex numbers");
        System.out.println("2. Test matrices");

        Scanner in = new Scanner(System.in);
        byte n = in.nextByte();
        switch (n) {
            case 1 -> test_complex(in);
            case 2 -> test_matrix(in);
            default -> System.out.println("Wrong number");
        }
        in.close();
    }
}
