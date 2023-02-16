import java.util.Scanner;

public class MatrixIO {
    public static void printMatrix(Matrix a) {
        System.out.println(a.toString());
    }
    public static void inputMatrixElements(Scanner in, Matrix a) {
        for (int i = 0; i < a.getRows(); ++i) {
            for (int j = 0; j < a.getCols(); ++j) {
                System.out.print("Input a[" + i + "][" + j + "]: ");
                ComplexIO.inputComplex(in, a.get(i,j));
            }
        }
    }
    public static Matrix inputMatrix(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        Matrix temp = new Matrix(n, m);
        inputMatrixElements(in, temp);
        return temp;
    }
}
