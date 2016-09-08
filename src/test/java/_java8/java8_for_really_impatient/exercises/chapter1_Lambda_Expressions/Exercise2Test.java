package _java8.java8_for_really_impatient.exercises.chapter1_Lambda_Expressions;

import org.testng.annotations.Test;

import java.io.File;

public class Exercise2Test {
    @Test
    public void testGetAllSubdirectoriesInJava7Style() throws Exception {
        Long startTime = System.nanoTime();
        Long time = 0L;
        File[] directories = new Exercise2().getAllSubdirectoriesInJava7Style("d:\\");
        time = System.nanoTime() - startTime;
        System.out.print("Java 7: ");
        System.out.printf("%,d", time);
        System.out.println();

    }

    @Test
    public void testGetAllSubdirectoriesInJava8Style() throws Exception {
        Long startTime = System.nanoTime();
        Long time = 0L;
        File[] directories = new Exercise2().getAllSubdirectoriesInJava8Style("d:\\");
        time = System.nanoTime() - startTime;
        System.out.print("Java 8: ");
        System.out.printf("%,d", time);
        System.out.println();
    }

    @Test
    public void testGetAllSubdirectoriesInJava8StyleMethodReference() throws Exception {
        Long startTime = System.nanoTime();
        Long time = 0L;
        File[] directories = new Exercise2().getAllSubdirectoriesInJava8StyleMethodReference("d:\\");
        time = System.nanoTime() - startTime;
        System.out.print("Java 8 Method Reference: ");
        System.out.printf("%,d", time);
        System.out.println();
    }
}