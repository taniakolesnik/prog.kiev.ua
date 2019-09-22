package uk.co.taniakolesnik;

import java.io.*;
public class Main {

    public static void main(String[] args) {
        File file = new File("/Users/taniakolesnik/Downloads/sites.txt");
        AddressCheck addressCheck = new AddressCheck(file);
        addressCheck.printAccessResult();

    }


}