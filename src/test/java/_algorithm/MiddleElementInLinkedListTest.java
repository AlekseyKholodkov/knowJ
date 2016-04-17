package _algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.*;

public class MiddleElementInLinkedListTest {
    LinkedList linkedList = new LinkedList();

    private void prepareList(LinkedList linkedList) {
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1);
    }

    @Test
    public void testFindMiddleElement() throws Exception {
        prepareList(linkedList);
        int middle = MiddleElementInLinkedList.findMiddleElement(linkedList);
        Assert.assertEquals(middle, linkedList.size() / 2);

    }
}