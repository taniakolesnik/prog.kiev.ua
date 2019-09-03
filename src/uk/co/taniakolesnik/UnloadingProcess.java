package uk.co.taniakolesnik;

public class UnloadingProcess {
    private Dock dock;

    public UnloadingProcess(Dock dock) {
        this.dock = dock;
    }

    public void setDockStatus(boolean isFree) {
        dock.setFree(isFree);
    }

    public boolean getDockStatus() {
        return dock.isFree();
    }

    public int getDocId() {
        return dock.getId();
    }

    public synchronized void unloadShip(Ship ship) {

        System.out.println("STARTED: Ship " + ship.getId()
                + "\t dock " + this.getDocId())
        ;

        for (; !this.getDockStatus(); ) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ship.unloadShip();
        this.setDockStatus(false);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDockStatus(true);
        if (ship.getCargo() == 0) {
            return;
        }
        notifyAll();

    }
}
