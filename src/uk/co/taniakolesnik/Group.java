package uk.co.taniakolesnik;

import java.io.*;
import java.util.Arrays;

public class Group implements MilitaryService {

    private static final int GROUP_MAX = 10;

    private String name;
    private Student[] students;

    public Group(String name) {
        this.name = name;
        students = new Student[GROUP_MAX];
    }

    public Group(File file) {
        this.name = file.getName();
        students = new Student[GROUP_MAX];
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

    public void loadGroupToFile(File targetFile) throws IOException {
            if (!targetFile.exists()){
                targetFile.createNewFile();
            } else {
                targetFile.delete();
                targetFile.createNewFile();
            }

            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(targetFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Student[] students = this.getStudents();
            System.out.println(this);
            for (Student student : students) {
                if (student==null){
                    continue;
                } else {
                    printWriter.println(student.getName()
                            + " "
                            + student.getAge()
                            + " "
                            + student.isSex()
                            + " "
                            + student.getYearIn()
                            + " "
                            + student.getFacultyName()
                    );
                }

            }
            printWriter.close();

    }

    private void loadGroupFromFile(File file) throws IOException, IncorrectFileFormatException, GroupFullException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";
        for (; (line = bufferedReader.readLine()) != null; ) {
            String[] studentInfoArray = line.split(" ");
            if (studentInfoArray.length == 5) {
                //String name, int age, boolean sex, int yearIn, String facultyName
                String name = studentInfoArray[0];
                int age = 0;
                int yearIn = 0;
                try {
                    age = Integer.parseInt(studentInfoArray[1]);
                    yearIn = Integer.parseInt(studentInfoArray[3]);
                } catch (NumberFormatException e) {
                    throw new IncorrectFileFormatException("Please provide student info in correct format: \n" +
                            "\"name(string) age(int) sex(boolean) yearIn(int) facultyName(string)\"");
                }
                boolean sex = studentInfoArray[2].equals("true");
                String facultyName = studentInfoArray[4];
                Student student = new Student(name, age, sex, yearIn, facultyName);
                this.addStudent(student);
            } else if (studentInfoArray.length == 2) {
                String name = studentInfoArray[0];
                String facultyName = studentInfoArray[1];
                Student student = new Student(name, facultyName);
                this.addStudent(student);
            } else {
                bufferedReader.close();
                throw new IncorrectFileFormatException("Please provide student info in two ways: \n" +
                        "\"Name(string) facultyName(string)\"" +
                        "\nor " +
                        "\n \"name(string) age(int) sex(boolean) yearIn(int) facultyName(string)\"");
            }
        }
        bufferedReader.close();
        System.out.println(this);
    }
}
