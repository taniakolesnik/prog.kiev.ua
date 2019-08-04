package uk.co.taniakolesnik;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<Phone> phones;
    private String name;

    public Network() {
        this("unknown");
    }

    public Network(String name) {
        this.name = name;
        phones = new ArrayList<>();
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNumberRegistered(int number){
        for (Phone phoneItem : this.getPhones()){
            if (number == phoneItem.getNumber()){
                return true;
            }
        }
        return false;
    }

    public void printPhoneNumbersRegistered() {
        System.out.println(
                name + " has the following numbers registered:"
        );
        for (Phone phoneItem : this.getPhones()){
            System.out.println(" - " +  phoneItem.getNumber() + " that belongs to " + phoneItem.getOwner());
        }
    }
}
