package uk.co.taniakolesnik;

public class Main {

    public static void main(String[] args) {
        Network network = new Network("Three");git

        Phone phoneTania = new Phone();
        phoneTania.setNumber(11111);
        phoneTania.setOwner("Tania");
        phoneTania.call(22222); // call FROM unregistered number

        phoneTania.registerPhone(network); //register number one

        Phone phoneKaty = new Phone(22222,"Katy");
        phoneTania.call(22222); // call TO unregistered number

        phoneKaty.registerPhone(network); //register number two
        phoneTania.call(22222);

        network.printPhoneNumbersRegistered();
    }
}
