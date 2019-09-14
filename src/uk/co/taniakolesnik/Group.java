package uk.co.taniakolesnik;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Group implements MilitaryService , Serializable {

    private static final int GROUP_MAX = 10;

    private String name;
    private Student[] students;

    public Group(String name) {
        this.name = name;
        students = new Student[GROUP_MAX];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }


    public void addStudent(Student student) throws GroupFullException {

        if (!isGroupFull()) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    System.out.println("Student " + student.getName() + " added ");
                    break;
                }
            }
        } else {
            throw new GroupFullException("Group is full. Max number is " + GROUP_MAX);
        }
    }

    public boolean isGroupFull() {
        int emptySlots = 0;
        for (Student studentRecord : students) {
            if (studentRecord == null) {
                emptySlots++;
            }
        }
        return emptySlots == 0;
    }

    public void removeStudent(String name) {
        boolean notFound = true;
        for (int i = 0; i < students.length; i++) {
            if (name.equals(students[i].getName())) {
                students[i] = null;
                notFound = false;
                System.out.println("Student " + name + " removed");
                break;
            }
        }
        System.out.println("Student " + name + " search:" + notFound);
    }

    @Override
    public String toString() {
        return "Group " + name
                + ", students: \n   "
                + Arrays.asList(students);
    }

    public void writeToFile(File file){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Group was written to " + file.getPath());
    }


    public void sortList(int parameter) throws SortParameterNotFoundException {
        SortByParameterComparator comparator = new SortByParameterComparator(parameter);
        if (parameter < 1 || parameter > 4) {
            throw new SortParameterNotFoundException("Bad parameter");
        }
        Arrays.sort(students, comparator);
    }

    @Override
    public Student[] getListOfReadyForServiceStudents() {
        Student[] readyForMilitaryService = new Student[GROUP_MAX];
        int i = 0;
        for (Student student : students) {
            if (student != null && student.getAge() >= 18 && !student.isSex()) {
                System.out.println("Student " + student);
                readyForMilitaryService[i] = student;
                i++;
            }
        }
        return readyForMilitaryService;
    }
}
