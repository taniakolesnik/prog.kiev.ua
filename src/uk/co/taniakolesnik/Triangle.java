package uk.co.taniakolesnik;

public class Triangle extends Shape {

    private Point a;
    private Point b;
    private Point c;

    public Triangle() {
    }

    public Triangle(Point pointOne, Point pointTwo, Point pointThree) {
        a = pointOne;
        b = pointTwo;
        c = pointThree;
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

    @Override
    public double getPerimeter() {
        double sideA = Math.sqrt(Math.pow((b.getX() - a.getX()), 2) * Math.pow((b.getY() - a.getY()), 2));
        double sideB = Math.sqrt(Math.pow((c.getX() - b.getX()), 2) * Math.pow((c.getY() - b.getY()), 2));
        double sideC = Math.sqrt(Math.pow((c.getX() - a.getX()), 2) * Math.pow((c.getY() - a.getY()), 2));
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        //(Ax(By -Cy) + Bx(Cy -Ay) + Cx(Ay - By))/2
        double area = (a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + a.getX() * (a.getY() - b.getY())) / 2;
        return area;

    }
}

