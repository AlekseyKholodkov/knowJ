package _util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
