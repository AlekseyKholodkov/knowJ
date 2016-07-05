package _algorithm.img_compare;

import java.awt.*;
import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle a, Rectangle b) {
        if (a == b) return 0;
        if (a == null) return -1;
        if (b == null) return 1;

        int compareY = Double.compare(a.getY(), b.getY());
        int compareX = Double.compare(a.getX(), b.getX());
        if (compareY != 0) {
            return compareY;
        } else {
            return compareX;
        }
    }
}
