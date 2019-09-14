package uk.co.taniakolesnik;

import sun.swing.BakedArrayList;

import java.util.ArrayList;

public class Container {

    private BlackList blackList;
    private ArrayList<Object> objects;


    public Container() {
        this(new ArrayList<Object>());
    }

    public Container(ArrayList<Object> objects) {
        this(new BlackList(), objects);
    }

    public Container(BlackList blackList, ArrayList<Object> objects) {
        this.blackList = blackList;
        this.objects = objects;
    }

    public ArrayList<Object> getObjects() {
        return objects;
    }

    public void printObjects() {
        if (objects.size() == 0) {
            System.out.println("The current container is empty ");
        } else
            System.out.println("The current container contains: ");
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(i + " : " + objects.get(i).toString() + " (" + objects.get(i).getClass().getSimpleName() + ")");
        }
        System.out.println();
    }

    public void add(Object object) {
        if (blackList.isBlackListed(object.getClass())) {
            System.out.println(object.getClass().getSimpleName() + " is black listed and cannot be added");
        } else {
            objects.add(object);
            System.out.println(object.getClass().getSimpleName() + " has been added");
        }

    }

    public void remove(Object object) {
        if (objects.size() == 0) {
            System.out.println("Nothing to remove. Container is empty");
        } else {
            Object objectToRemove = objects.get(objects.size() - 1);
            objects.remove(objectToRemove);
            System.out.println(object.getClass().getSimpleName() + " has been removed from container list");
        }

    }

    public void remove(Class classToBeRemoved) {
        if (objects.size() == 0) {
            System.out.println("Nothing to remove. Container is empty");
        } else {
            Object objectToRemove = objects.get(objects.size()-1);
            Class classOfTheTopObject = objectToRemove.getClass();

            if (classOfTheTopObject == classToBeRemoved) {
                objects.remove(objectToRemove);
                System.out.println(classToBeRemoved.getSimpleName() + " has been removed from container list");
            } else {
                System.out.println("The top item does not belong to " + classToBeRemoved.getSimpleName() + " class");
            }

        }
    }


    public void setObjects(ArrayList<Object> objects) {
        this.objects = objects;
    }

    public BlackList getBlackList() {
        return blackList;
    }

    public void setBlackList(BlackList blackList) {
        this.blackList = blackList;
    }


}
