package uk.co.taniakolesnik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Group implements MilitaryService {

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
        if (!isGroupFull()) {
           students.add(student);
        } else {
            throw new GroupFullException("Group is full. Max number is " + GROUP_MAX);
        }
    }

    public boolean isGroupFull() {
        return students.size()>=GROUP_MAX;
    }

    public void removeStudent(String name) {
        students.removeIf(n -> n.getName().equals(name));
    }

    @Override
    public String toString() {
        return "Group " + name
                + ", students: \n   "
                + students;
    }

    public void sortList(int parameter) throws SortParameterNotFoundException {
        SortByParameterComparator comparator = new SortByParameterComparator(parameter);
        if (parameter < 1 || parameter > 4) {
            throw new SortParameterNotFoundException("Bad parameter");
        }
        students = students.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public List<Student> getListOfReadyForServiceStudents() {
        List<Student> readyForMilitaryService = students.stream()
                .filter(s -> s != null && s.getAge() >= 18 && !s.isSex())
                .collect(Collectors.toList());
        return readyForMilitaryService;
    }
}
