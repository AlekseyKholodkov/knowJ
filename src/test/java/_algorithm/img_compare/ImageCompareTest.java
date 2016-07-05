package _algorithm.img_compare;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.testng.Assert.*;

public class ImageCompareTest {
    private ImageCompare imageCompare;
    private int[][] array2DSingleRect;
    private int[][] array2DTwoRect;

    @BeforeClass
    public void createInstance() {
        imageCompare = new ImageCompare();
    }

    @BeforeClass
    public void fillArray2D() {
        array2DTwoRect = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        array2DSingleRect = new int[][] {
                {0, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 0, 0}
        };
    }

    /** diffInPercent tests START */
    @Test
    public void diffInPercent_sameValue_calc() {
        assertEquals(imageCompare.diffInPercent(5, 5), 0f);
    }

    @Test
    public void diffInPercent_sameNegativeValue_calc() {
        assertEquals(imageCompare.diffInPercent(-345, -345), 0f);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void diffInPercent_minValueIs0_ExceptionThrown() {
        imageCompare.diffInPercent(1, 0);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void diffInPercent_maxValueIs0_ExceptionThrown() {
        imageCompare.diffInPercent(-15, 0);
    }

    @Test
    public void diffInPercent_positiveValues_calc() {
        assertEquals(imageCompare.diffInPercent(3, 1), 200f);
    }

    @Test
    public void diffInPercent_negativeValues_calc() {
        assertEquals(imageCompare.diffInPercent(-9, -10), 10f);
    }
    /** diffInPercent tests END */

    /** computeRectangle tests START */
    @Test
    public void computeRectangle_validArray_computeRectangle() {
        assertEquals(imageCompare.computeRectangle(array2DSingleRect, 0, 0), new Rectangle(0, 0, 3, 3));
    }
    /** computeRectangle tests END */

    /** computeDiffPlaces tests START */
    @Test
    public void computeDiffPlaces_validArray_computeRectangles() {
        List<Rectangle> rectangles = Arrays.asList(new Rectangle(8, 1, 3, 2), new Rectangle(1, 2, 3, 2));
        assertEquals(imageCompare.computeDiffPlaces(array2DTwoRect), rectangles);
    }
    /** computeDiffPlaces tests END */
}