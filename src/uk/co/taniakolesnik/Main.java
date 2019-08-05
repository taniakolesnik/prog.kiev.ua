package uk.co.taniakolesnik;

public class Main {

    public static void main(String[] args) {

        Dashboard dashboard = new Dashboard();

        Diamond diamondOne = new Diamond(new Point(3, 1),
                new Point(5, 2),
                new Point(1,4),
                new Point(4,7));

        dashboard.addShape(diamondOne, 1);
        dashboard.printShapesInfo();

        Diamond diamondTwo = new Diamond(new Point(2.5, 2),
                new Point(1.1, 2),
                new Point(4,4),
                new Point(7,0.2));
        dashboard.addShape(diamondTwo, 2);

        Square square = new Square(new Point(8, 2.8),
                new Point(4, 9),
                new Point(6,3.3),
                new Point(1,0.9));
        dashboard.addShape(square, 3);

        Triangle triangle = new Triangle(new Point(7, 1),
                new Point(9, 5),
                new Point(4,2));
        dashboard.addShape(triangle, 0);

        dashboard.printShapesInfo();
        dashboard.removeShape(1);
        dashboard.printShapesInfo();

    }
}