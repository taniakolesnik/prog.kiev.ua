package uk.co.taniakolesnik;

import java.io.File;
import java.util.Arrays;

public class FolderScanThread implements Runnable {

    private File folder;
    private File[] files;

    public FolderScanThread(File folder) {
        this.folder = folder;
        files = folder.listFiles();
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        for (; !thread.isInterrupted(); ) {
            File[] checkFiles = folder.listFiles();
            if (!Arrays.equals(checkFiles, files)) {
                System.out.println(threadName + " :Folder \"" + folder.getName() + "\" has been updated!");
            } else {
                System.out.println(threadName + " :Folder \"" + folder.getName() + "\" has NOT been updated!");
            }
            ///Users/taniakolesnik/Downloads/test
            files = checkFiles;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
