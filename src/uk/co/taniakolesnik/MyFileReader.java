package uk.co.taniakolesnik;

import java.io.*;
import java.util.Arrays;

public class MyFileReader {
    private File input;

    public MyFileReader(File input) {
        this.input = input;
    }



    public String[] getFileStrings() throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        String line = "";
        for (;(line=bufferedReader.readLine())!=null;){
            builder.append(line + " ");
        }
        bufferedReader.close();
        String[] strings = builder.toString().split(" ");
        return strings;

    }
}

