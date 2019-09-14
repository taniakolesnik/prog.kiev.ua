package uk.co.taniakolesnik;

import java.io.Serializable;

public class Human implements Serializable {
    private String name;
    private int age;
    private boolean sex; // false male, true female;


    public Human() {
        this("unknown");
    }

    public Human(String name) {
        this(name, 0, false);
    }

    public Human(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
