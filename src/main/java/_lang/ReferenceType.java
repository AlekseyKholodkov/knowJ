package _lang;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.List;

public class ReferenceType {
    List<Integer> list = new ArrayList<>();

    void deleteReference(List<Integer> paramList) {
        paramList.add(1);
        paramList = null;
    }
}
