package uk.co.taniakolesnik;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class CommonWordsWriter {

    private String[] listOne;
    private String[] listTwo;

    private File output;

    public CommonWordsWriter(String[] listOne, String[] listTwo, File output) {
        this.listOne = listOne;
        this.listTwo = listTwo;
        this.output = output;
    }


    public String[] getListOne() {
        return listOne;
    }

    public void setListOne(String[] listOne) {
        this.listOne = listOne;
    }

    public String[] getListTwo() {
        return listTwo;
    }

    public void setListTwo(String[] listTwo) {
        this.listTwo = listTwo;
    }

    public File getOutput() {
        return output;
    }

    public void setOutput(File output) {
        this.output = output;
    }

    public void writeCommon() throws IOException {
        String[] commonWords = getCommonWords();

        if (commonWords.length != 0) {
            if (!output.exists()){
                output.createNewFile();
            } else {
                output.delete();
                output.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter(output);
            for (String string : commonWords){
                printWriter.println(string);
            }
            printWriter.close();

        }

    }

    private String[] getCommonWords() {
        String[] shorter;
        String[] longer;

        // if we get list of e.g 2 and 100 values we just compare values from shorter list if they are in longer list
        if (listOne.length < listTwo.length) {
            shorter = listOne;
            longer = listTwo;
        } else {
            shorter = listTwo;
            longer = listOne;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < shorter.length; i++) {
            if (Arrays.asList(longer).contains(shorter[i])) {
                builder.append(shorter[i] + " ");
            }
        }
        return builder.toString().split(" ");

    }
}
