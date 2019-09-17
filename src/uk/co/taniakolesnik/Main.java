package uk.co.taniakolesnik;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {
            Files.lines(Paths.get("/Users/taniakolesnik/Downloads/test.rtf"))
                    .map(String::toUpperCase)
                    .flatMapToInt(String::chars)
                    .mapToObj(n -> (char) n)
                    .filter(Character::isLetter)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .sorted((a,b) -> (int) (b.getValue() - a.getValue()))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
