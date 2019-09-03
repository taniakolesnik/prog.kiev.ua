package uk.co.taniakolesnik;
public class ShipUnloadingThread implements Runnable {

    private UnloadingProcess status;
    private Ship ship;

    public ShipUnloadingThread(UnloadingProcess status, Ship ship) {
        this.status = status;
        this.ship = ship;
    }

    @Override
    public void run() {
        while (ship.getCargo() > 0){
            status.unloadShip(ship);
        }

    }
}
