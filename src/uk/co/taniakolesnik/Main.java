package uk.co.taniakolesnik;


public class Main {
    public static void main(String[] args) {

        Container container = new Container();
        BlackList blackList = new BlackList();

        container.setBlackList(blackList);

        printInfo(container, blackList);

        container.add(1);
        container.add('a');
        container.add("abc");

        blackList.add(String.class);

        printInfo(container, blackList);

        container.add(2);
        container.add('b');
        container.add("you shall not pass");


        printInfo(container, blackList);

        container.remove(Integer.class);
        container.remove(String.class);
        container.remove(Character.class);
    }

    private static void printInfo(Container container, BlackList blackList) {
        container.printObjects();
        blackList.printBlackList();
    }
}
