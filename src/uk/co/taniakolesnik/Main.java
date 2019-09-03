package uk.co.taniakolesnik;

import java.util.ArrayList;

public class Main {

    private static int DOCK_NUMBERS = 2;
    private static int SHIP_NUMBERS = 3;
    private static int CARGO_ITEM = 10;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Ship [] ships = new Ship[SHIP_NUMBERS];
        for (int i = 0; i < ships.length; i++) {
            ships[i] = new Ship(CARGO_ITEM, i+1);
        }

        Dock [] docks = new Dock[DOCK_NUMBERS];
        for (int i = 0; i < docks.length; i++) {
            docks[i] = new Dock(i+1);
        }

        uploadShips(ships, docks);
        long endTime = System.currentTimeMillis();
        long timeSpent = endTime - startTime;
        System.out.println("Load finished. Time: " + timeSpent);
    }

    private static void uploadShips(Ship[] ships, Dock[] docks) {
        ArrayList<Thread> threads = new ArrayList<>();

        for (Dock dock : docks) {
            UnloadingProcess dockStatus = new UnloadingProcess(dock);
            for (Ship ship : ships){
                Thread thread = new Thread(new ShipUnloadingThread(dockStatus, ship));
                threads.add(thread);
            }
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}