package uk.co.taniakolesnik;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int cup = 2;

        List<String> friends = new ArrayList<>();
        friends.add("Sheldon");
        friends.add("Leonard");
        friends.add("Wolowitz");
        friends.add("Koothrappali");
        friends.add("Penny");

        for (int i = 1; i <= cup; i++) {
            String drinkingFriend = friends.get(0);
            friends.remove(0);

            friends.add(drinkingFriend);
            friends.add(drinkingFriend);

        }

        System.out.println(friends);
    }

}
