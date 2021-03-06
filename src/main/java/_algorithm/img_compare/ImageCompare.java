package _algorithm.img_compare;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ImageCompare {
    private final float MAX_DIFF_IN_PERCENT = 10.0f;
    private final int ALLOWED_DIFF_IN_PIXEL = 200;

    public static void main(String[] args) {
        String path1 = "C:\\imgCompare\\image1.png";
        String path2 = "C:\\imgCompare\\image2.png";
        if (args.length > 1) {
            path1 = args[0];
            path2 = args[1];
        }

        ImageCompare imageCompare = new ImageCompare();

        String resultImagePath = imageCompare.getDirectory(path1) + "result.png";
        System.out.println("READ images from:");
        System.out.println("First image path = " + path1);
        System.out.println("Second image path = " + path2);
        System.out.println("Compare result image write path = " + resultImagePath);

        try {
            BufferedImage img1 = imageCompare.readImage(path1);
            BufferedImage img2 = imageCompare.readImage(path2);
            BufferedImage image = imageCompare.compareImage(img1, img2);
            imageCompare.writeImage(image, resultImagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Trim path to last slash <code>"\"</code>
     * @param path
     * @return
     */
    public String getDirectory(String path) {
        int lastSlashIndex = path.lastIndexOf("\\") + 1;
        return path.substring(0, lastSlashIndex);
    }

    /**
     * @param path image file path
     * @return image
     * @throws IOException
     */
    public BufferedImage readImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    /**
     * @param image for write
     * @param path file path
     * @throws IOException
     */
    public void writeImage(BufferedImage image, String path) throws IOException {
        File outputFile = new File(path);
        ImageIO.write(image, "jpg", outputFile);
    }

    /**
     * @param a first int value for compare
     * @param b second int value for compare
     * @return difference between <code>a</code> and <code>b</code> in percent
     */
    public float diffInPercent(int a, int b) {
        if (a == 0 || b == 0) throw new RuntimeException("Unexpected color: a=" + a + ", b=" + b);
        if (a == b) return 0.0f;
        int minInt = Math.min(a, b);
        int maxInt = Math.max(a, b);
        return Math.abs(((maxInt - minInt) * 100f) / minInt);
    }

    /**
     * @param array2D of with values 0 or 1, where 1 mark different pixels
     * @return rectangle that outlined difference places
     */
    public Set<Rectangle> computeDiffPlaces(int[][] array2D) {
        Rectangle rectangle = null;
        Set<Rectangle> rectangles = new TreeSet<>(new RectangleComparator());
        for (int y = 0; y < array2D.length; y++) {
            for (int x = 0; x < array2D[y].length; x++) {
                if (array2D[y][x] == 1) {
                    rectangle = computeRectangle(array2D, x, y);
                    rectangles.add(rectangle);
                }
            }
        }

        rectangles = unionRectangles(rectangles);
        return rectangles;
    }

    /**
     * @param array2D array int with 0 and 1 values, where 1 mark pixels that different in two images
     * @param startX x coordinate first different pixel
     * @param startY y coordinate first different pixel
     * @return rectangle that mark different place
     */
    public Rectangle computeRectangle(int[][] array2D, int startX, int startY) {
        int x0 = startX == 0 ? 0 : startX - 1;
        int x1 = array2D[startY].length;
        int maxX = 0;
        int upperLeftX = Integer.MAX_VALUE;
        int upperLeftY = Integer.MAX_VALUE;
        int width = -1;
        int height = -1;

        for (int y = startY; y < array2D.length; y++) {
            for (int x = x0; x <= x1; x++) {
                if (array2D[y][x] == 1) { // TODO: need optimize
                    upperLeftX = Math.min(x, upperLeftX);
                    upperLeftY = Math.min(y, upperLeftY);
                    maxX = Math.max(x, maxX);
                    width = maxX - upperLeftX;
                    height = y - upperLeftY;
                    x0 = upperLeftX == 0 ? 0 : upperLeftX - 1;
                    x1 = x < array2D[y].length - 1 ? x + 1 : x;
                    array2D[y][x] = 0;
                }
            }
        }
        return new Rectangle(upperLeftX, upperLeftY, width, height);
    }

    /**
     * @param rectangles for union
     * @return united rectangles
     */
    public Set<Rectangle> unionRectangles(Set<Rectangle> rectangles) {
        if (rectangles == null) return null;
        if (rectangles.size() <= 1 ) return rectangles;

        NavigableSet<Rectangle> resultRectangles = new TreeSet<>(new RectangleComparator());
        NavigableSet<Rectangle> inputRectangles = new TreeSet<>(new RectangleComparator());
        inputRectangles.addAll(rectangles);

        Rectangle resRect = inputRectangles.first();
        Iterator<Rectangle> inputRectIter = inputRectangles.iterator();
        Rectangle inputRect = null;
        while (inputRectIter.hasNext()) {
            inputRect = inputRectIter.next();
            if (rectangleNear(resRect, inputRect)) {
                resRect = unionTwoRectangle(resRect, inputRect);
            } else {
                resultRectangles.add(resRect);
                resRect = inputRect;
            }
        }
        resultRectangles.add(resRect);
        return resultRectangles;
    }

    /**
     * @param rec1 first rectangle for check
     * @param rec2 second rectangle for check
     * @return is rectangles near
     */
    public boolean rectangleNear(Rectangle rec1, Rectangle rec2) {
        if (rec1 == null || rec2 == null) return false;
        if (Math.abs(rec1.x - rec2.x) < ALLOWED_DIFF_IN_PIXEL && Math.abs(rec1.y - rec2.y) < ALLOWED_DIFF_IN_PIXEL) { // TODO: take into account height and width
            return true;
        }
        return false;
    }

    /**
     * @param rec1 first rectangle for union
     * @param rec2 second rectangle for union
     * @return rectangle that outlined input rectangles
     */
    public Rectangle unionTwoRectangle(Rectangle rec1, Rectangle rec2) {
        if (rec1 == null && rec2 == null) return null;
        if (rec1 == null) return rec2;

        int upperLeftX = Math.min(rec1.x, rec2.x);
        int upperLeftY = Math.min(rec1.y, rec2.y);
        int bottomRightX = Math.max(rec1.x + rec1.width, rec2.x + rec2.width);
        int bottomRightY = Math.max(rec1.y + rec1.height, rec2.y + rec2.height);
        int width = bottomRightX - upperLeftX;
        int height = bottomRightY - upperLeftY;
        return new Rectangle(upperLeftX, upperLeftY, width, height);
    }

    /**
     * @param img1 first image for compare
     * @param img2 second image for compare
     * @return image with differences outlined with red rectangles
     */
    public BufferedImage compareImage(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            throw new RuntimeException("Images have different dimensions");
        }
        Set<Rectangle> rectangles = null;

        BufferedImage resultImg = img2;
        Graphics graphics = resultImg.createGraphics();
        graphics.setColor(Color.RED);

        int rows = img2.getHeight();
        int columns = img2.getWidth();
        int[][] diffPixels = new int[rows][columns];
        for (int x = 0; x < img2.getWidth(); x++) {
            for (int y = 0; y < img2.getHeight(); y++){
                int colorPix1 = img1.getRGB(x, y);
                int colorPix2 = img2.getRGB(x, y);
                if (diffInPercent(colorPix1, colorPix2) > MAX_DIFF_IN_PERCENT) {
                    diffPixels[y][x] = 1;
                }
            }
        }

        rectangles = computeDiffPlaces(diffPixels);
        for (Rectangle rectangle : rectangles) {
            graphics.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }

        return resultImg;
    }

}
