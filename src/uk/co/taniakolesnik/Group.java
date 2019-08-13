package uk.co.taniakolesnik;

import java.util.Arrays;
import java.util.Comparator;

public class Group{

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
            loop:
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    System.out.println("Student " + student.getName() + " added ");
                    break loop;
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
        return emptySlots==0;
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

    public void sortList(int parameter){
        SortByParameterComparator comparator = new SortByParameterComparator(parameter);
        Arrays.sort(students, comparator);
    }
}
