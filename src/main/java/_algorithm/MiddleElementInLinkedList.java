package _algorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class MiddleElementInLinkedList {

    public static int findMiddleElement(LinkedList linkedList) {
        int middle = 0;
        int head = 0;
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            head++;
            if (head % 2 == 0) {
                middle++;
            }
            iterator.next();
        }
        return middle;
    }
}
