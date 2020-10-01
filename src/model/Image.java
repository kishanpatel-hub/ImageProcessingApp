package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.ImageUtilities;

// TODO: Auto-generated Javadoc
/**
 * The Class Image implements the Image interface and offers set of helper
 * method to perform different operations on the image.
 */
public class Image {

  /**
   * The image.
   */
  private int[][][] image;

  /**
   * The name.
   */
  private String name;

  /**
   * Instantiates a new image.
   *
   * @param filename the filename
   */
  public Image(String filename) {
    try {
      image = ImageUtilities.readImage(filename);
      name = filename;
    } catch (IOException e) {
      System.out.println("File Path incorrect!!!");
    }
  }

  /**
   * Instantiates a new image.
   *
   * @param image the image
   * @param name  the name
   */
  public Image(int[][][] image, String name) {
    this.image = image;
    this.name = name;
  }

  /**
   * Gets the height.
   *
   * @return the height
   */
  public int getHeight() {
    return this.image.length;
  }

  /**
   * Gets the width.
   *
   * @return the width
   */

  public int getWidth() {
    return this.image[0].length;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */

  public String getName() {
    return this.name;
  }

  /**
   * Filter method is helper method which performs filter on image based on given
   * kernel.
   *
   * @param kernel the kernel
   * @return the int[][][] array of image
   */
  private int[][][] filter(float[][] kernel) {

    int[][][] newImage = new int[this.getHeight()][this.getWidth()][3];

    for (int col = 0; col < this.getHeight(); col++) {
      for (int row = 0; row < this.getWidth(); row++) {
        for (int rgb = 0; rgb < 3; rgb++) {
          float add = 0;
          for (int c = 0; c < kernel.length; c++) {
            for (int r = 0; r < kernel[1].length; r++) {
              add += kernel[c][r] * this.exist(col + c - 1, row + r - 1, rgb);
            }
          }
          // System.out.println(kernel[0][1]);
          newImage[col][row][rgb] = this.clamping((int) add);

        }
      }
    }

    return newImage;
  }

  /**
   * Exist is helper method which checks if given pixel exist in the image or not.
   *
   * @param i   the i
   * @param j   the j
   * @param rgb the rgb
   * @return the int value of the given pixel
   */
  private int exist(int i, int j, int rgb) {
    return (i >= 0 && j >= 0 && i < this.getHeight() && j < this.getWidth())
        ? this.image[i][j][rgb]
        : 0;
  }

  /**
   * Exist1 is helper method which checks if given pixel exist in the image or
   * not.
   *
   * @param i   the i
   * @param j   the j
   * @param rgb the rgb
   * @return the boolean true if it exist and false if not.
   */
  private boolean exist1(int i, int j, int rgb) {
    return (i >= 0 && j >= 0 && i < this.getHeight() && j < this.getWidth()) ? true : false;
  }

  /**
   * Blur.
   *
   * @return the i image
   */

  public Image blur() {
    float[][] kernel = { { 1 / 16f, 1 / 8f, 1 / 16f }, { 1 / 8f, 1 / 4f, 1 / 8f },
        { 1 / 16f, 1 / 8f, 1 / 16f } };
    return new Image(this.filter(kernel), (this.getName().replace(".", "_") + "_Blured.jpg"));
  }

  /**
   * Sharpen.
   *
   * @return the i image
   */

  public Image sharpen() {
    float[][] kernel = { { -1 / 8f, -1 / 8f, -1 / 8f, -1 / 8f, -1 / 8f },
        { -1 / 8f, 1 / 4f, 1 / 4f, 1 / 4f, -1 / 8f }, { -1 / 8f, 1 / 4f, 1f, 1 / 4f, -1 / 8f },
        { -1 / 8f, 1 / 4f, 1 / 4f, 1 / 4f, -1 / 8f },
        { -1 / 8f, -1 / 8f, -1 / 8f, -1 / 8f, -1 / 8f } };
    return new Image(this.filter(kernel), (this.getName().replace(".", "_") + "Sharpen.jpg"));
  }

  /**
   * Clamping method clamps the values which are outside the given range to avoid
   * overflow and underflow while saving, and to display such images properly.
   *
   * @param value the value
   * @return the int
   */
  private int clamping(int value) {
    return (value < 0 ? 0 : (value > 255 ? 255 : value));
  }

  /**
   * Color trans is helper method which color transforms the image and return
   * resulting image in 3D array format.
   *
   * @param matrix the matrix
   * @return the int[][][]
   */
  private int[][][] colorTrans(float[][] matrix) {
    int[][][] newImage = new int[this.getHeight()][this.getWidth()][3];

    for (int col = 0; col < this.getHeight(); col++) {
      for (int row = 0; row < this.getWidth(); row++) {
        for (int rgb = 0; rgb < 3; rgb++) {
          float add = 0;
          // System.out.println("length: " + matrix.length );
          for (int c = 0; c < matrix.length; c++) {
            add += matrix[rgb][c] * this.image[col][row][c];

            // System.out.println("add:" + add );
          }
          newImage[col][row][rgb] = this.clamping((int) Math.round(add));

        }

      }
    }

    return newImage;
  }

  /**
   * Greyscale.
   *
   * @return the i image
   */

  public Image greyscale() {
    float[][] matrix = { { 0.2126f, 0.7152f, 0.0722f }, { 0.2126f, 0.7152f, 0.0722f },
        { 0.2126f, 0.7152f, 0.0722f } };
    return new Image(this.colorTrans(matrix),
        (this.getName().replace(".", "_") + "_Greyscale.jpg"));
  }

  /**
   * Sepia.
   *
   * @return the i image
   */

  public Image sepia() {
    float[][] matrix = { { 0.393f, 0.769f, 0.189f }, { 0.349f, 0.686f, 0.168f },
        { 0.272f, 0.534f, 0.131f } };
    return new Image(this.colorTrans(matrix), (this.getName().replace(".", "_") + "_Sepia.jpg"));
  }

  /**
   * Edge detection.
   *
   * @return the image
   */
  public Image edgeDetection() {
    float[][] kx = { { 1, 0, -1 }, { 2, 0, -2 }, { 1, 0, -1 } };
    float[][] ky = { { 1, 2, 1 }, { 0, 0, 0 }, { -1, -2, -1 } };

    int[][][] gx = this.filter(kx);
    int[][][] gy = this.filter(ky);

    int[][][] newImage = new int[this.getHeight()][this.getWidth()][3];
    int max = 0;
    int min = 255;

    for (int col = 0; col < this.getHeight(); col++) {
      for (int row = 0; row < this.getWidth(); row++) {
        for (int rgb = 0; rgb < 3; rgb++) {

          newImage[col][row][rgb] = (int) Math.round(Math.sqrt(
              (gx[col][row][rgb] * gx[col][row][rgb]) + (gy[col][row][rgb] * gy[col][row][rgb])));

          if (newImage[col][row][rgb] > max) {
            max = newImage[col][row][rgb];
          }

          if (newImage[col][row][rgb] < min) {
            min = newImage[col][row][rgb];
          }
        }
      }
    }

    for (int col = 0; col < this.getHeight(); col++) {
      for (int row = 0; row < this.getWidth(); row++) {
        for (int rgb = 0; rgb < 3; rgb++) {

          newImage[col][row][rgb] = ((newImage[col][row][rgb] - min) * 255) / (max - min);
        }
      }
    }

    Image edge = new Image(newImage, (this.getName().replace(".", "_") + "_EdgeDetection.jpg"));

    return edge.greyscale();
  }

  /**
   * Write image.
   *
   * @param file the file
   */
  public void writeImage(String file) {
    try {
      ImageUtilities.writeImage(this.image, this.getWidth(), this.getHeight(), file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Dithering.
   *
   * @return the image
   */
  public Image dithering() {

    int old_color = 0;
    int new_color = 0;
    int error = 0;
    int[][][] newImage = this.image;

    for (int col = 0; col < this.getHeight(); col++) {
      for (int row = 0; row < this.getWidth(); row++) {
        for (int rgb = 0; rgb < 3; rgb++) {

          old_color = newImage[col][row][rgb];

          new_color = ((255 - old_color) < old_color ? 255 : 0);

          error = old_color - new_color;
          newImage[col][row][rgb] = new_color;
          // System.out.println("old color: " + old_color + " new color:" + new_color);

          if (this.exist1(col, row + 1, rgb)) {
            newImage[col][row + 1][rgb] += (int) Math.round((7 / 16f) * (double) error);
          }

          if (this.exist1(col + 1, row - 1, rgb)) {
            newImage[col + 1][row - 1][rgb] += (int) Math.round((3 / 16f) * (double) error);
          }

          if (this.exist1(col + 1, row, rgb)) {
            newImage[col + 1][row][rgb] += (int) Math.round((5 / 16f) * (double) error);
          }

          if (this.exist1(col + 1, row + 1, rgb)) {
            newImage[col + 1][row + 1][rgb] += (int) Math.round((1 / 16f) * (double) error);
          }

        }
      }
    }
    return new Image(newImage, (this.getName().replace(".", "_") + "_Dithering1.jpg"));
  }

  /**
   * Gets the image.
   *
   * @return the image
   */
  private int[][][] getImage() {
    return this.image;
  }

  /**
   * Mosaicing.
   *
   * @param seeds the seeds
   * @return the image
   */
  public Image mosaicing(int seeds) {
    Point[] randSeeds = generateRandomSeeds(seeds);
    int[][][] newImage = new int[this.getHeight()][this.getWidth()][3];
    HashMap<Point, List<Point>> clusters = new HashMap<Point, List<Point>>();
    HashMap<Integer, Point> clusterPointMap = new HashMap<Integer, Point>();

    for (Point p : randSeeds) {
      clusters.put(p, new ArrayList<>());
    }

    double distance = 0;
    double min = 0;
    int count = 0;
    Point seed;
    for (int col = 0; col < this.getHeight(); col++) {
      for (int row = 0; row < this.getWidth(); row++) {
        min = Math.max(this.getHeight(), this.getWidth());
        seed = randSeeds[0];
        for (int i = 0; i < seeds; i++) {
          distance = dist(new Point(col, row), randSeeds[i]);
          // System.out.println(distance + " " + min);
          if (distance < min) {
            min = distance;
            seed = randSeeds[i];
          }
        }
        clusters.get(seed).add(new Point(col, row));
        clusterPointMap.put(count, seed);
        count++;
      }
    }

    HashMap<Point, Integer[]> clusterColor = new HashMap<Point, Integer[]>();

    clusters.entrySet().forEach(entry -> {
      clusterColor.put(entry.getKey(), new Integer[3]);

      double r = (entry.getValue().stream().mapToDouble(l -> image[l.getX()][l.getY()][0]).sum());
      double g = (entry.getValue().stream().mapToDouble(l -> image[l.getX()][l.getY()][1]).sum());
      double b = (entry.getValue().stream().mapToDouble(l -> image[l.getX()][l.getY()][2]).sum());
      double num = (entry.getValue().size());
      clusterColor.get(entry.getKey())[0] = (int) (r / num);
      clusterColor.get(entry.getKey())[1] = (int) (g / num);
      clusterColor.get(entry.getKey())[2] = (int) (b / num);
    });

    count = 0;
    for (int col = 0; col < this.getHeight(); col++) {
      for (int row = 0; row < this.getWidth(); row++) {
        for (int rgb = 0; rgb < 3; rgb++) {
          newImage[col][row][rgb] = clusterColor.get(clusterPointMap.get(count))[rgb];
        }
        count++;
      }
    }
    return new Image(newImage, (this.getName().replace(".", "_") + "Mosaicing.jpg"));
  }

  /**
   * Generate random seeds.
   *
   * @param seeds the seeds
   * @return the point[]
   */
  private Point[] generateRandomSeeds(int seeds) {
    Point[] randNo = new Point[seeds];
    for (int i = 0; i < seeds; i++) {
      randNo[i] = new Point((int) (Math.random() * ((this.getHeight() - 0) + 1)) + 0,
          (int) (Math.random() * ((this.getWidth() - 0) + 1)) + 0);
      // System.out.println(randNo[i].getX() + " " + randNo[i].getY());
    }
    // System.out.println(this.getHeight() + " " + this.getWidth());
    return randNo;
  }

  /**
   * Compute the distance between two points as the Euclidean distance.
   * 
   * @param p1 one of the points
   * @param p2 the other points
   * @return the the Euclidean distance represented as a double
   */
  private double dist(Point p1, Point p2) {
    return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX())
        + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
  }

  /**
   * Gets the buffered image.
   *
   * @return the buffered image
   */
  public BufferedImage getBufferedImage() {
    return ImageUtilities.getBufferedImage(getImage(), this.getWidth(), this.getHeight());
  }

  /**
   * Equalization.
   *
   * @return the image
   */
  public Image equalization() {
    int[][][] newImage = new int[this.getHeight()][this.getWidth()][3];
    int[] histogram = new int[256];

    for (int col = 0; col < this.getHeight(); col++) {
      for (int row = 0; row < this.getWidth(); row++) {
        histogram[image[col][row][0]]++;
      }
    }

    int[] cfdSource = new int[256];

    cfdSource[0] = histogram[0];
    for (int i = 1; i < cfdSource.length; i++) {
      cfdSource[i] = histogram[i] + cfdSource[i - 1];
    }

    int totalpixel = this.getHeight() * this.getWidth();
    int[] idealizedhisto = new int[256];
    for (int i = 0; i < cfdSource.length; i++) {
      idealizedhisto[i] = Math.round(cfdSource[i] * 255 / totalpixel);
    }

    for (int col = 0; col < this.getHeight(); col++) {
      for (int row = 0; row < this.getWidth(); row++) {
        for (int rgb = 0; rgb < 3; rgb++) {
          newImage[col][row][rgb] = idealizedhisto[image[col][row][rgb]];
        }
      }
    }

    return new Image(newImage, (this.getName().replace(".", "_") + "Equalization.jpg"));
  }

  /**
   * Red eye removal.
   *
   * @param rect the rect
   * @return the image
   */
  public Image redEyeRemoval(Rectangle rect) {
    // System.out.println(rect.x + " " + rect.y);
    // System.out.println((rect.height) + " " + (rect.width));
    for (int col = rect.y; col < (rect.y + rect.height); col++) {
      for (int row = rect.x; row < (rect.x + rect.width); row++) {
        if (image[col][row][0] > (image[col][row][1] + image[col][row][2])) {
          int avg = (image[col][row][1] + image[col][row][2]) / 2;
          image[col][row][0] = avg;
          image[col][row][1] = avg;
          image[col][row][2] = avg;
        }
      }
    }

    return new Image(image, (this.getName().replace(".", "_") + "red-eye-removed.jpg"));
  }
}
