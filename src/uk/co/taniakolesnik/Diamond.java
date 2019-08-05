package uk.co.taniakolesnik;

public class Diamond extends Shape {

    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private static final double FAKE_PERIMETER = 7.1;
    private static final double FAKE_AREA = 0.3;

    public Diamond(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
    }

    @Override
    public double getPerimeter() {
        return FAKE_PERIMETER;
    }

    @Override
    public double getArea() {
        return FAKE_AREA;
    }
}
