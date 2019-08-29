package uk.co.taniakolesnik;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FolderCopy {

    private File folderIn;
    private File folderOut;

    public FolderCopy(File folderIn, File folderOut) {
        this.folderIn = folderIn;
        this.folderOut = folderOut;
    }

    public void startCopy() {
        if(!folderOut.exists()){
            folderOut.mkdirs();
        }
        copyFiles();
    }

    public void copyFiles() {
        File[] filesToCopy = folderIn.listFiles();
        if (filesToCopy.length !=0) {
            for (File file : filesToCopy) {
                if (!file.isDirectory()) {
                    Thread thread = new Thread(()-> {
                        System.out.println(Thread.currentThread().getName() + " copy started for "
                            + file.getName());
                        try {
                            FolderCopy.this.copy(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " copy finished for "
                                + file.getName());});
                    thread.start();
                }
            }
        } else {
            System.out.println("Folder " + folderIn.getName() + " has no files to copy");
        }

    }

    private void copy(File file) throws IOException {
        File newFile = new File(folderOut, file.getName());
        byte[] buffer = new byte[1024 * 1024];
        int readByte = 0;
        try (FileInputStream inputStream = new FileInputStream(file);
             FileOutputStream outputStream = new FileOutputStream(newFile)) {

            for (; (readByte = inputStream.read(buffer)) > 0; ) {
                outputStream.write(buffer, 0, readByte);
            }
        } catch (IOException e) {
            throw e;
        }

    }

    public File getFolderIn() {
        return folderIn;
    }

    public void setFolderIn(File folderIn) {
        this.folderIn = folderIn;
    }

    public File getFolderOut() {
        return folderOut;
    }

    public void setFolderOut(File folderOut) {
        this.folderOut = folderOut;
    }

}

