package _java8.java8_for_really_impatient.exercises.chapter1_Lambda_Expressions;

import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static org.testng.Assert.*;

public class Exercise2Test {
    @Test
    public void testGetAllSubdirectories() throws Exception {
        Long startTime = System.nanoTime();
        Long time = 0L;
        File[] directories = new Exercise2().getAllSubdirectoriesIn7Style("d:\\");
//        File[] directories = new Exercise2().getAllSubdirectories("d:\\");
        time = System.nanoTime() - startTime;
        System.out.printf("%,d", time);
    }

}