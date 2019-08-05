package uk.co.taniakolesnik;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        int number = alphabet.length();

        Group groupHistory = new Group("History evening course");

        boolean gender = true;
        for (int i = 0; i < 10; i++){
            gender=!gender;
            try {
                groupHistory.addStudent(new Student(alphabet.charAt(random.nextInt(number)) + "_" + i,
                        random.nextInt(60), gender, random.nextInt(100) + 1900, "Math"));
            } catch (GroupFullException e) {
                e.printStackTrace();
            }
        }

        System.out.println(groupHistory);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter student to add");
        String nameToAdd = scanner.nextLine();
        try {
            groupHistory.addStudent(new Student(nameToAdd, "unknown"));
        } catch (GroupFullException e) {
            e.printStackTrace();
        }


        System.out.println("\nEnter student to delete");
        String nameToDelete = scanner.nextLine();
        groupHistory.removeStudent(nameToDelete);

        System.out.println(groupHistory);


    }
}