package uk.co.taniakolesnik;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {

    private String extension;

    public MyFileFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File pathname) {
        int point = pathname.getName().lastIndexOf(".");
        if (point== -1){
            return false;
        }

        String fileExt = pathname.getName().substring(point+1);
        return extension.equals(fileExt);
    }

}
