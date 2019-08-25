package uk.co.taniakolesnik;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FolderCopy {

    private File folderIn;
    private File folderOut;
    private String extension;
    private MyFileFilter fileFilter;

    public FolderCopy(File folderIn, File folderOut, String extension) {
        this.folderIn = folderIn;
        this.folderOut = folderOut;
        this.extension = extension;
        fileFilter = new MyFileFilter(extension);
    }

    public void copyFolder () throws IOException {
        folderOut.mkdirs();
        copyFiles();
    }


    public void copyFiles() throws IOException {
        File[] filesToCopy = folderIn.listFiles(fileFilter);
        for (File file : filesToCopy) {
            if (!file.isDirectory()){
                copy(file);
            }
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
        fileFilter = new MyFileFilter(extension);
    }
}


