package _util;

import _java8.Lambda;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    private static List<String> literals = Arrays.asList("A", "B", "C");
    private static List<String> numbers = Arrays.asList("1", "2", "3");
    private static List<String> strings = Arrays.asList("zeroElem", "hello", "li");

    @Test
    public void testMultiply() throws Exception {
        Lambda lambda = new Lambda();
        System.out.println("=============== multiply START =================");
        lambda.multiply(literals, numbers).forEach(System.out::println);
        System.out.println("=============== multiply END ===================");

        System.out.println("");

        System.out.println("=============== filter START ===================");
        lambda.filterList(strings, 3).forEach(System.out::println);
        System.out.println("=============== filter END =====================");
    }
}