package _algorithm.img_compare;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ImageCompare {
    private final float MAX_DIFF_IN_PERCENT = 10.0f;

    public static void main(String[] args) {
        String path1 = "D:\\compareImg\\image1.png";
        String path2 = "D:\\compareImg\\image2.png";
        ImageCompare imageCompare = new ImageCompare();
        try {
            BufferedImage img1 = imageCompare.readImage(path1);
            BufferedImage img2 = imageCompare.readImage(path2);
            BufferedImage image = imageCompare.compareImage(img1, img2);
            imageCompare.writeImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage readImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    public void writeImage(BufferedImage image) throws IOException {
        File outputFile = new File("D:\\compareImg\\result.jpg");
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

    public List<Rectangle> computeDiffPlaces(int[][] array2D) {
        boolean findFirstElem = false;
        int upperLeftX = Integer.MAX_VALUE;
        int upperLeftY = Integer.MAX_VALUE;
        int width = -1;
        int height = -1;

        y: for (int y = 0; y < array2D.length; y++) {
            x: for (int x = 0; x < array2D[y].length; x++) {
                if (array2D[y][x] == 1) {

                    upperLeftX = Math.min(x, upperLeftX);
                    upperLeftY = Math.min(y, upperLeftY);
                    findFirstElem = true;
                } else if (findFirstElem && array2D[y][x] == 0) {

                }
            }
        }

        return null;
    }

    /**
     * @param array2D array int with 0 and 1 values, where 1 mark pixels that different in two images
     * @param startX x coordinate first different pixel
     * @param startY y coordinate first different pixel
     * @return rectangle that mark different place
     */
    public Rectangle computeRectangle(int[][] array2D, int startX, int startY) {
        int x0 = startX == 0 ? 0 : startX - 1; // TODO: can occur ArrayIndexOutOfBoundsException
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

    public BufferedImage compareImage(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            throw new RuntimeException("Images have different dimensions");
        }

        boolean inDiffSegment = false;

        BufferedImage resultImg = img2;
        Graphics graphics = resultImg.createGraphics();
        graphics.setColor(Color.RED);

        Comparator<Point> pointComparator = new PointComparator();
        NavigableSet<Point> points = new TreeSet<>(pointComparator);
        
        int rows = img2.getHeight();
        int columns = img2.getWidth();
        int[][] diffPixels = new int[rows][columns];
        for (int x = 0; x < img2.getWidth(); x++) {
            for (int y = 0; y < img2.getHeight(); y++){
                int colorPix1 = img1.getRGB(x, y);
                int colorPix2 = img2.getRGB(x, y);
                if (diffInPercent(colorPix1, colorPix2) > MAX_DIFF_IN_PERCENT) {
                    if (!inDiffSegment) {
                        diffPixels[y][x] = 1; // start different pixels segment
                        inDiffSegment = true;
                    }
                } else if (inDiffSegment) {
                    diffPixels[y][x-1] = 2; // end different pixels segment
                    inDiffSegment = false;
                }
            }
        }

        return resultImg;
    }

}
