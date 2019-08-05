package uk.co.taniakolesnik;

public class Dashboard {

    private Shape[] shapes;
    private static final int SLOTS_NUMBER = 4;

    public Dashboard() {
        shapes = new Shape[SLOTS_NUMBER];
    }

    public void addShape(Shape shape, int positionOnDashboard) {
        if (positionOnDashboard < SLOTS_NUMBER && positionOnDashboard >= 0) {
            shapes[positionOnDashboard] = shape;
            System.out.println(shape.getClass().getSimpleName() + " is added to slot number " + positionOnDashboard);
        } else {
            System.out.println("Slot number is out of range. Max slots number is " + SLOTS_NUMBER);
        }
    }

    public void removeShape(int positionOnDashboard) {
        if (positionOnDashboard < SLOTS_NUMBER && positionOnDashboard >= 0 && shapes[positionOnDashboard] != null) {
            String type = shapes[positionOnDashboard].getClass().getSimpleName();
            shapes[positionOnDashboard] = null;
            System.out.println(type + " removed from slot " + positionOnDashboard);

        }
    }

    public void printShapesInfo() {
        System.out.println("Getting dashboard info...");
        double sumArea = 0.0;
        for (int i = 0; i < SLOTS_NUMBER; i++) {
            if (shapes[i] != null) {
                System.out.println("- Slot " + i + " has " + shapes[i].getClass().getSimpleName()
                        + " in: area: " + shapes[i].getArea()
                        + "; perimeter: " + shapes[i].getPerimeter());
                sumArea += shapes[i].getArea();

            } else {
                System.out.println("- Slot " + i + " is empty");
            }

        }
        System.out.println("-- Total area : " + sumArea);
    }
}
