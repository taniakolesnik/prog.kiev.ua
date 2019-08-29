package uk.co.taniakolesnik;

import sun.security.krb5.SCDynamicStoreConfig;

import java.io.File;
import java.util.Scanner;

public class Main {

    private static File folder;
    private static Thread thread;

    public static void main(String[] args) {
        folder = askForParameters();

        thread = new Thread(new FolderScanThread(folder));
        thread.start();

    }

    private static File askForParameters() {
        Scanner folderInScanner = new Scanner(System.in);
        System.out.println("\nFolder to copy from:");
        String folderInPath = folderInScanner.nextLine();
        folder = new File(folderInPath);
        try {
            checkPaths(folder);
        } catch (IncorrectParametersExeption incorrectParametersExeption) {
            incorrectParametersExeption.printStackTrace();
            folder = askForParameters();
        }
        return folder;
    }

    private static void checkPaths(File folder) throws IncorrectParametersExeption {
        if (!folder.isDirectory()) {
            throw new IncorrectParametersExeption("provided path is not a directory");
        }
    }
}