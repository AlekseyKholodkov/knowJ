package _util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lambda {

    public  <T> Stream<List<T>> multiply(List<T> arg1, List<T> arg2) {
        return arg1.stream()
                .flatMap(fst -> arg2.stream().map(snd -> Arrays.asList(fst, snd)));
    }
}
