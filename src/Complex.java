import java.lang.Math;

public class Complex {
    private double re;
    private double im;

    double getRe() { return re; }
    void setRe(double re) { this.re = re; }
    double getIm() { return im; }
    void setIm(double im) { this.im = im; }

    public Complex() {
        re = 0;
        im = 0;
    }

    public Complex(double real) {
        re = real;
        im = 0;
    }

    public Complex neg() {
        return new Complex(-re, -im);
    }

    public Complex(double real, double imaginary) {
        re = real;
        im = imaginary;
    }
    public Complex(Complex rhs) {
        re = rhs.re;
        im = rhs.im;
    }


    public Complex add(Complex rhs) {
        return new Complex(re + rhs.re, im + rhs.im);
    }

    public Complex sub(Complex rhs) {
        return add(rhs.neg());
    }

    public Complex multiply(Complex rhs) {
        return new Complex(re * rhs.re - im * rhs.im, re * rhs.im + rhs.re * im);
    }

    public double r() {
        return Math.sqrt(re * re + im * im);
    }

    public double theta() {
        return Math.atan2(im, re);
    }

    public String toString() {
        return re + (im > 0 ? "+" : "") + (im == 0 ? "" : (im + "i"));
    }


}

