package _java8;

import java.util.Arrays;
import java.util.Comparator;

public class MethdReference {
    Comparator<Integer> comparator = Integer::compare;

    public void print() {
        Arrays.asList("Foo", "Bar", "Baz")
                .forEach(System.out::println);
    }
}
