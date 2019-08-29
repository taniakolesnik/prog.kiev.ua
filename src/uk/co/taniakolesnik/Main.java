package uk.co.taniakolesnik;

import java.io.File;
import java.util.Scanner;

public class Main {

    private static File folderIn;
    private static File folderOut;

    public static void main(String[] args)  {
        askForParameters();

        FolderCopy folderCopy = new FolderCopy(folderIn,folderOut);
        folderCopy.startCopy();
    }

    private static void askForParameters()  {

        Scanner folderInScanner = new Scanner(System.in);
        System.out.println("\nFolder to copy from:");
        String folderInPath = folderInScanner.nextLine();
        folderIn = new File(folderInPath);
        try {
            checkPaths(folderIn);
        } catch (IncorrectParametersExeption incorrectParametersExeption) {
            incorrectParametersExeption.printStackTrace();
        }


        Scanner folderOutScanner = new Scanner(System.in);
        System.out.println("\nFolder to copy to:");
        String folderOutPath = folderOutScanner.nextLine();
        folderOut = new File(folderOutPath);

    }

    private static void checkPaths(File folder) throws IncorrectParametersExeption {
        if (!folder.isDirectory()) {
            throw new IncorrectParametersExeption("provided path is not a directory");
        }
    }

}