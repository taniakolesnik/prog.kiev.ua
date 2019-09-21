package uk.co.taniakolesnik;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        String[] strings = new String[]{"one", "two", "two", "six", "six", "six", "six", "six", "six"};
        Integer[] integers = new Integer[]{1,2,3,4,5,6,2,2,2,2,2,5,5,5,1,1,1};

        count(strings);
        count(integers);
    }

    private static <T> void count( T ... args){
        List<T> list = Arrays.asList(args);
        Map<T, Long> map = list.stream()
                .collect(Collectors.groupingBy(s->s, Collectors.counting()));
        System.out.println(map);
    }
}

