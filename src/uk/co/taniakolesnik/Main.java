package uk.co.taniakolesnik;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static File folderIn;
    private static File folderOut;
    private static String extension;

    public static void main(String[] args)  {
        try {
            askForParameters();
        } catch (IncorrectParametersExeption incorrectParametersExeption) {
            incorrectParametersExeption.printStackTrace();
        }

        FolderCopy folderCopy = new FolderCopy(folderIn,folderOut,extension);
        try {
            folderCopy.copyFolder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void askForParameters() throws IncorrectParametersExeption {

        Scanner folderInScanner = new Scanner(System.in);
        System.out.println("\nFolder to copy from:");
        String folderInPath = folderInScanner.nextLine();
        folderIn = new File(folderInPath);
        checkPaths(folderIn);


        Scanner folderOutScanner = new Scanner(System.in);
        System.out.println("\nFolder to copy to:");
        String folderOutPath = folderOutScanner.nextLine();
        folderOut = new File(folderOutPath);
        checkPaths(folderOut);

        Scanner extensionScanner = new Scanner(System.in);
        System.out.println("\nFile extension to copy ( e.g. pdf)");
        extension = extensionScanner.nextLine();
    }

    private static void checkPaths(File folder) throws IncorrectParametersExeption {
        if (!folder.isDirectory()) {
            throw new IncorrectParametersExeption("provided path is not a directory");
        }
    }

}