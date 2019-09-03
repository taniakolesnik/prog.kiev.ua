package uk.co.taniakolesnik;

public class Ship {

    private int cargo;
    private int id;

    public Ship(int cargo, int id) {
        this.cargo = cargo;
        this.id = id;
    }

    public synchronized int getCargo() {
        return cargo;
    }

    public synchronized void unloadShip() {
        int newValue = this.cargo - 1;
        if (newValue>=0){
            this.cargo = newValue;
        }
        System.out.println("cargo is " + this.cargo);
    }

    public int getId() {
        return id;
    }
}
