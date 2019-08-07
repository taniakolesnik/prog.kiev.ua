package uk.co.taniakolesnik;

public class Student extends Human implements Comparable {

    private int yearIn;
    private String facultyName;

    public Student(String name, String facultyName) {
        super(name);
        this.facultyName = facultyName;
    }

    public Student(String name, int age, boolean sex, int yearIn, String facultyName) {
        super(name, age, sex);
        this.yearIn = yearIn;
        this.facultyName = facultyName;
    }

    public int getYearIn() {
        return yearIn;
    }

    public void setYearIn(int yearIn) {
        this.yearIn = yearIn;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return " \n name: " + getName()
                + "; age: " + getAge()
                + "; started: " + getYearIn();
    }

    @Override
    public int compareTo(Object o) {
        Student a = (Student) o;
        return this.getName().compareTo(a.getName());
    }
}
