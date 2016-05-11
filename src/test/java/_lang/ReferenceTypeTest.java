package _lang;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReferenceTypeTest {
    @Test
    public void referenceTypeTest() {
        new Thread().start();
        ReferenceType refType = new ReferenceType();
        refType.deleteReference(refType.list);
        Assert.assertEquals(refType.list.size(), 1);
    }

}