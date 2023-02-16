public class Matrix {
    private final int rows;
    private final int cols;
    private Complex[][] data;

    public Matrix() {
        rows = 0;
        cols = 0;
    }

    public Matrix(int rows, int cols, Complex x) {
        this.rows = rows;
        this.cols = cols;
        this.data = new Complex[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                data[i][j] = new Complex(x);
            }
        }
    }

    public Matrix(int rows, int cols) {
        this(rows, cols, new Complex(0, 0));
    }

    public Matrix(Matrix rhs) {
        rows = rhs.rows;
        cols = rhs.cols;
        data = new Complex[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                data[i][j] = new Complex(rhs.data[i][j]);
            }
        }
    }

    Complex get(int i, int j) {
        return data[i][j];
    }

    int getRows() {
        return this.rows;
    }
    int getCols() {
        return this.cols;
    }

    Matrix neg() {
        Matrix temp = new Matrix(this);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                temp.data[i][j] = temp.data[i][j].neg();
            }
        }
        return temp;
    }

    Matrix add(Matrix rhs) {
        if (rows != rhs.rows || cols != rhs.cols) {
            throw new IllegalArgumentException("The dimensions of the matrices during addition must match");
        }
        Matrix temp = new Matrix(this);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                temp.data[i][j] = temp.data[i][j].add(rhs.data[i][j]);
            }
        }
        return temp;
    }

    Matrix sub(Matrix rhs) {
        return add(rhs.neg());
    }

    Matrix multiply(Matrix rhs) {
        // A_{N, K} x B_{K, M} = C_{N, M}
        if (cols != rhs.rows) {
            throw new IllegalArgumentException("lhs.cols must be equal to rhs.rows");
        }
        Matrix temp = new Matrix(rows, rhs.cols);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < rhs.cols; ++j) {
                for (int k = 0; k < cols; ++k) {
                    temp.data[i][j] = temp.data[i][j].add(data[i][k].multiply(rhs.data[k][j]));
                }
            }
        }
        return temp;
    }

    Matrix transposed() {
        Matrix temp = new Matrix(cols, rows);
        for (int i = 0; i < cols; ++i) {
            for (int j = 0; j < rows; ++j) {
                temp.data[i][j] = data[j][i];
            }
        }
        return temp;
    }

    boolean is_squared() {
        return rows == cols;
    }

    Matrix minor(int row, int col) {
        Matrix  temp = new Matrix(rows - 1, cols - 1);
        int di = 0;
        int dj = 0;
        for (int i = 0; i < rows - 1; ++i) {
            if (i == row) {
                di =  1;
            }
            dj = 0;
            for (int j = 0; j < cols - 1; ++j) {
                if (j == col) {
                    dj = 1;
                }
                temp.data[i][j] = data[i + di][j + dj];
            }
        }
        return temp;
    }

    Complex det() {
        if (!is_squared()) {
            throw new IllegalArgumentException("Could not calculate determinant of non-squared matrix");
        }
        int n = rows;
        if (n == 1) {
            return data[0][0];
        }
        Complex res = new Complex(0, 0);
        Complex pow1 = new Complex(1, 0);
        for (int i = 0; i < n; ++i) {
            res = res.add(data[i][0].multiply(pow1).multiply(minor(i, 0).det()));
            pow1 = pow1.neg();
        }
        return res;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                s.append(data[i][j]).append(" ");
            }
            s.append(System.lineSeparator());
        }
        if (s.length() > 0) {
            s.delete(s.length() - (System.lineSeparator().length() + 1), s.length());
        }
        return s.toString();
    }
}
