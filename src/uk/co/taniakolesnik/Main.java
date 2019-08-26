package uk.co.taniakolesnik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SortParameterNotFoundException {
//      loadFakeGroup();

//        askToAddNewStudent(groupHistory);
//        askToAddNewStudent(groupHistory);
//
//        askToRemoveStudent(groupHistory);
//        askToAddNewStudent(groupHistory);
//
//        askToSortStudents(groupHistory);
//        askToSortStudents(groupHistory);
//        askToSortStudents(groupHistory);
//
//
//        getStudentsReadyForMilitaryService(groupHistory);

        File file = new File("/Users/taniakolesnik/IdeaProjects/prog.kiev.ua/src/Biology");

        try {
            loadGroupFromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IncorrectFileFormatException e) {
            e.printStackTrace();
        } catch (GroupFullException e) {
            e.printStackTrace();
        }
    }

    private static void loadFakeGroup() {
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

        System.out.println(groupHistory);
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

    private static void loadGroupFromFile(File file) throws IOException, IncorrectFileFormatException, GroupFullException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String groupName = file.getName();
        Group group = new Group(groupName);
        String line = "";
        for (;(line=bufferedReader.readLine())!=null;){
            String[] studentInfoArray = line.split(" ");
            if (studentInfoArray.length==5){
                //String name, int age, boolean sex, int yearIn, String facultyName
                String name = studentInfoArray[0];
                int age = 0;
                int yearIn = 0;
                try {
                    age = Integer.parseInt(studentInfoArray[1]);
                    yearIn = Integer.parseInt(studentInfoArray[3]);
                } catch (NumberFormatException e){
                    throw new IncorrectFileFormatException("Please provide student info in correct format: \n" +
                            "\"name(string) age(int) sex(boolean) yearIn(int) facultyName(string)\"");
                }
                boolean sex = studentInfoArray[2].equals("true");
                String facultyName = studentInfoArray[4];
                Student student = new Student(name, age, sex, yearIn, facultyName);
                group.addStudent(student);
            } else if (studentInfoArray.length==2){
                String name = studentInfoArray[0];
                String facultyName = studentInfoArray[1];
                Student student = new Student(name, facultyName);
                group.addStudent(student);
            } else {
                bufferedReader.close();
                throw new IncorrectFileFormatException("Please provide student info in two ways: \n" +
                        "\"Name(string) facultyName(string)\"" +
                        "\nor " +
                        "\n \"name(string) age(int) sex(boolean) yearIn(int) facultyName(string)\"");
            }
        }
        bufferedReader.close();
        System.out.println(group);
    }
}