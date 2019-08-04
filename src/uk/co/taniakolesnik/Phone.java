package uk.co.taniakolesnik;

import java.util.Objects;

public class Phone {

    private int number;
    private String owner;
    private Network network;

    public Phone() {
        this(0);
    }

    public Phone(int number) {
        this(number, "unknown");
    }

    public Phone(int number, String owner) {
        this.number = number;
        this.owner = owner;
    }

    public void call(int number) {
        System.out.println(this.number + " is dialing " + number + "...");
        if(this.network == null){
            System.out.println(this.number + " cannot make calls. Please register it first.");
            return;
        }

        if (network.isNumberRegistered(number)) {
            System.out.println("Call is in progress...");
        } else {
            System.out.println("Cannot find " + number + " in network " + network.getName());
        }

    }

    public void registerPhone(Network network) {
        if (number != 0 && !network.isNumberRegistered(number)) {

            //remove from already registered network
            if (this.network!=null){
                for (Phone phoneItem : this.network.getPhones()){
                    if (phoneItem.getNumber() == this.number){
                        network.getPhones().remove(phoneItem);
                        System.out.println(number + " has been removed from " + this.network.getName());
                    }
                }
            }

            network.getPhones().add(this);
            this.network = network;
            System.out.println(number + " has been registered with " + this.network.getName());

        } else if (network.isNumberRegistered(number)) {
            System.out.println("This phone number is already registered");
        } else {
            System.out.println("Empty phone number cannot be registered");
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Phone)) {
            return false;
        }
        Phone phone = (Phone) o;
        return number == phone.number &&
                Objects.equals(owner, phone.owner) &&
                Objects.equals(network, phone.network);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + number;
        result = 31 * result + owner.hashCode();
        result = 31 * result + network.hashCode();
        return result;
    }
}
