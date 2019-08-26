package uk.co.taniakolesnik;

import java.io.File;
import java.io.IOException;

public class Main {

    private static String[] shorter;
    private static String[] longer;

    public static void main(String[] args) throws IOException {

        File fileOne = new File("/Users/taniakolesnik/Downloads/test1/reservedWords.txt");
        MyFileReader fileReaderOne = new MyFileReader(fileOne);
        String[] stringsFileOne = fileReaderOne.getFileStrings();

        File fileTwo = new File("/Users/taniakolesnik/Downloads/test2/reservedWords.txt");
        MyFileReader fileReaderTwo = new MyFileReader(fileTwo);
        String[] stringsFileTwo = fileReaderTwo.getFileStrings();

        File file = new File("/Users/taniakolesnik/Downloads/test2/commonWords.txt");
        CommonWordsWriter wordsWriter = new CommonWordsWriter(stringsFileOne, stringsFileTwo,file);
        wordsWriter.writeCommon();


    }
}