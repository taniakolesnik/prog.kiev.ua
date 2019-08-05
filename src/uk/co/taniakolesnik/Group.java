package uk.co.taniakolesnik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Group {

    private static final int GROUP_MAX = 10;

    private String name;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void addStudent(Student student) throws GroupFullException {
        if (students.size()>=GROUP_MAX){
            throw new GroupFullException("Group is full. Max number is " + GROUP_MAX);
        } else {
            students.add(student);
            System.out.println("Student " + student.getName() + " has been added");
        }
        students.sort(new SortByNameComparator());
    }

    public void removeStudent(String name) {
        List<Student> toRemove = new ArrayList<>();
        for (Student studentRecord : students){
            if (name.equals(studentRecord.getName())){
                toRemove.add(studentRecord);
            }
        }

        if (toRemove.size()==0){
            System.out.println("Student cannot be found");
        } else {
            students.removeAll(toRemove);
            students.sort(new SortByNameComparator());
        }

    }

    @Override
    public String toString() {
        return "Group{" + name
                + ", students: \n   "
                + students
                + '}';
    }

    private class SortByNameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
