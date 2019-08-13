package uk.co.taniakolesnik;

import java.util.Comparator;

public class SortByParameterComparator implements Comparator<Student>  {

    int parameter; //1 name; 2 age; 3 year in; 4 facultyName;

    public SortByParameterComparator(int parameter) {
        this.parameter = parameter;
    }

    @Override
    public int compare(Student o1, Student o2)  {
        switch (parameter) {
            case 1:
                return o1.getName().compareTo(o2.getName());
            case 2:
                return Integer.compare(o1.getAge(),o2.getAge());
            case 3:
                return Integer.compare(o1.getYearIn(),o2.getYearIn());
            case 4:
                return o1.getFacultyName().compareTo(o2.getFacultyName());
            default:
                return o1.getName().compareTo(o2.getName());
        }
    }
}
