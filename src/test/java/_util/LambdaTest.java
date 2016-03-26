package _util;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class LambdaTest {
    private static List<String> literals = Arrays.asList("A", "B", "C");
    private static List<String> numbers = Arrays.asList("1", "2", "3");

    @Test
    public void testMultiply() throws Exception {

        new Lambda().multiply(literals, numbers).forEach(System.out::println);

    }
}