package uk.co.taniakolesnik;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SortParameterNotFoundException {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        int number = alphabet.length();

        Group groupHistory = new Group("History evening course");

        System.out.println("Fake data insert...");
        boolean gender = true;
        for (int i = 0; i < 9; i++) {
            gender = !gender;
            try {
                groupHistory.addStudent(new Student(alphabet.charAt(random.nextInt(number)) + "_" + i,
                        random.nextInt(60), gender, random.nextInt(100) + 1900, "Math"));
            } catch (GroupFullException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n" +groupHistory);


        File file = new File("/Users/taniakolesnik/Downloads/" + getFileName() );
        groupHistory.writeToFile(file);

        Group groupFromFile = readFromFile(file);
        System.out.println("\n" + groupFromFile);


    }

    public static Group readFromFile(File file){
        Group group = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            group = (Group) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return group;
    }

    private static String getFileName(){
        return System.currentTimeMillis() + "-group" + ".txt";
    }

    private static void askToRemoveStudent(Group group) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter student to delete");
        String nameToDelete = scanner.nextLine();
        group.removeStudent(nameToDelete);
        System.out.println(group);
    }

    private static void askToAddNewStudent(Group group) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter student to add");
        String nameToAdd = scanner.nextLine();
        try {
            group.addStudent(new Student(nameToAdd, "unknown"));
        } catch (GroupFullException e) {
            e.printStackTrace();
        }

        System.out.println(group);
    }

    private static void askToSortStudents(Group group){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter sort option: \n1 for name; \n2 for age; \n3 for year in; \n4 for facultyName;");
        int parameter = scanner.nextInt();
        try {
            group.sortList(parameter);
        } catch (SortParameterNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println(group);
        }

    }

    private static void getStudentsReadyForMilitaryService(Group group) {
        System.out.println("\nStudents ready for military service: \n");
        group.getListOfReadyForServiceStudents();
    }
}