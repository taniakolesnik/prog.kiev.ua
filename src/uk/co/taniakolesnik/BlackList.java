package uk.co.taniakolesnik;

import java.util.ArrayList;
import java.util.Date;

public class BlackList {

    private ArrayList<Class> blackList;
    private Date dateAdded;

    public BlackList() {
        this(new ArrayList<Class>());
    }

    public BlackList(ArrayList<Class> blackList) {
        this.blackList = blackList;
        this.dateAdded  = new Date();
    }

    public ArrayList<Class> getBlackList() {
        return blackList;
    }

    public void printBlackList(){
        if (blackList.size() == 0) {
            System.out.println("The current container is empty ");
        } else {
            System.out.println("The current black list contains: ");
            for (Class blackListedClass : blackList){
                System.out.println(" - " + blackListedClass.getSimpleName());
            }
        }
        System.out.println();
    }

    public void add(Class blackListedClass){
        blackList.add(blackListedClass);
    }

    public boolean isBlackListed(Class blackListedClass){
        return blackList.contains(blackListedClass);
    }

    public void remove(Class blackListedClass){
        if (blackList.size()==0){
            System.out.println("Nothing to remove. Black List is empty");
        } else {
            Class classToRemove =  blackList.get(blackList.size()-1);
            blackList.remove(classToRemove);
            System.out.println(classToRemove.getSimpleName() + " has been removed from black list");
        }

    }

    public void setBlackList(ArrayList<Class> blackList) {
        this.blackList = blackList;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void updateDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
