package _java8.java8_for_really_impatient.exercises.chapter1_Lambda_Expressions;

import org.openjdk.jmh.annotations.Benchmark;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {
    public File[] getAllSubdirectories(String path) {
        return new File(path).listFiles(File::isDirectory);
    }

    public List<File> getAllSubdirectoriesIn8Style(String path) {
        File file = new File(path);
        List<File> listFiles = Arrays.asList(file.listFiles());
        List<File> subdirectories = listFiles.stream()
                .filter(File::isDirectory)
                .collect(Collectors.toList());
        return subdirectories;
    }

    @Benchmark
    public void measureName() {
        System.out.println("Benchmarks");
    }

    public File[] getAllSubdirectoriesIn7Style(String path) {
//        String path = "d:\\";
        File file = new File(path);
        File[] listFiles = file.listFiles();
        List<File> subdirectories = new ArrayList<>();
        for (File fl : listFiles) {
            if (fl.isDirectory()) {
                subdirectories.add(fl);
            }
        }
        return subdirectories.toArray(new File[10]);
    }
}
