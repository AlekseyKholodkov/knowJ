package _java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Usage:
 * FI f = () -> 42;
 * return () -> 42;
 * foo(1, () -> 42)
 * FI [] fis = { () -> 41, () -> 42 }
 * (FI) () -> 42;
 */
public class Lambda {
    public  <T> Stream<List<T>> multiply(List<T> fstList, List<T> sndList) {
        return fstList.stream()
                .flatMap(fst -> sndList.stream()
                        .map(snd -> Arrays.asList(fst, snd))
                );
    }

    public Stream<String> filterList(List<String> list, int minLength) {
        return list.stream().filter(string -> string.length() > minLength);
    }
}
