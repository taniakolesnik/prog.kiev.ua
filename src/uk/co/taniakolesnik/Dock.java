package uk.co.taniakolesnik;

public class Dock {

    private boolean isFree = true;
    private int id;

    public Dock(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getId() {
        return id;
    }
}
