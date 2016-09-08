package _java8.java8_for_really_impatient.exercises.chapter1_Lambda_Expressions;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise2 {

    public File[] getAllSubdirectoriesInJava7Style(String path) {
        File file = new File(path);
        File[] listFiles = file.listFiles();
        List<File> subdirectories = new ArrayList<>();
        for (File fl : listFiles) {
            if (fl.isDirectory()) {
                subdirectories.add(fl);
            }
        }
        return subdirectories.toArray(new File[subdirectories.size()]);
    }

    public File[] getAllSubdirectoriesInJava8Style(String path) {
        File file = new File(path);
        List<File> listFiles = Arrays.asList(file.listFiles());
        return Arrays.stream(file.listFiles())
                .filter(File::isDirectory).toArray(File[]::new);
    }

    public File[] getAllSubdirectoriesInJava8StyleMethodReference(String path) {
        return new File(path).listFiles(File::isDirectory);
    }
}
