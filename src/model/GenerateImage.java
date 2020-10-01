package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class GenerateImage represents image class which offers static methods to
 * generate images of various type Ex. rainbow, checkerboard and flags of
 * countries. it also consist of certain helper methods which are used in image
 * generation.
 */
public class GenerateImage {

  /**
   * static method which Generates the rainbow image in horizontal.
   *
   * @param height the height
   * @param width  the width
   * @return the i image
   */
  public static Image generateRainbowH(int height, int width) {
    int[][][] newImage = new int[height][width][3];
    List<int[]> rainbowColors = new ArrayList<int[]>();

    rainbowColors.add(new int[] { 255, 0, 0 });
    rainbowColors.add(new int[] { 255, 127, 0 });
    rainbowColors.add(new int[] { 255, 255, 0 });
    rainbowColors.add(new int[] { 0, 255, 0 });
    rainbowColors.add(new int[] { 0, 0, 255 });
    rainbowColors.add(new int[] { 75, 0, 130 });
    rainbowColors.add(new int[] { 143, 0, 255 });
    // rainbowColors.add(new int[] {0,0,0});

    return new Image(generateHStripes(newImage, rainbowColors),
        "C:\\Users\\Kishan\\eclipse-workspace\\HW5\\res\\Rainbow_Horizontal.jpg");

  }

  /**
   * helper method which Generates Horizontal stripes of same size while making
   * sure that width of stripes differs no more than 1 pixel.
   *
   * @param image  the image
   * @param colors the colors
   * @return the int[][][]
   */
  private static int[][][] generateHStripes(int[][][] image, List<int[]> colors) {
    float stripe = colors.size();
    int stripesize = (int) Math.floor((image.length / stripe));
    int count = 0;
    int color = 0;
    int diff = 0;

    for (int row = 0; row < image[1].length; row++) {

      diff = image.length - (stripesize * colors.size());

      for (int col = 0; col < image.length; col++) {
        if (count == (stripesize + (diff > 0 ? 1 : 0))) {
          diff--;
          color++;
          count = 0;
        }
        for (int c = 0; c < 3; c++) {
          image[col][row][c] = colors.get(color)[c];
        }
        count++;
      }
      color = 0;
      count = 0;
    }

    return image;
  }

  /**
   * helper method which Generates vertical stripes of same size while making sure
   * that width of stripes differs no more than 1 pixel.
   *
   * @param image  the image
   * @param colors the colors
   * @return the int[][][]
   */
  private static int[][][] generateVStripes(int[][][] image, List<int[]> colors) {
    float stripe = colors.size();
    int stripesize = (int) Math.floor((image[1].length / stripe));
    int count = 0;
    int color = 0;
    int diff = 0;

    for (int col = 0; col < image.length; col++) {
      diff = image[1].length - (stripesize * colors.size());
      // System.out.println(diff);
      for (int row = 0; row < image[1].length; row++) {
        if (count == (stripesize + (diff > 0 ? 1 : 0))) {
          count = 0;
          color++;
          diff--;
        }
        for (int c = 0; c < 3; c++) {
          image[col][row][c] = colors.get(color)[c];
        }
        count++;
      }
      count = 0;
      color = 0;
    }
    // System.out.println((stripesize) + "done");
    return image;
  }

  /**
   * static method which Generates the rainbow image in vertical.
   *
   * @param height the height
   * @param width  the width
   * @return the i image
   */
  public static Image generateRainbowV(int height, int width) {
    int[][][] newImage = new int[height][width][3];

    List<int[]> rainbowColors = new ArrayList<int[]>();

    rainbowColors.add(new int[] { 255, 0, 0 });
    rainbowColors.add(new int[] { 255, 127, 0 });
    rainbowColors.add(new int[] { 255, 255, 0 });
    rainbowColors.add(new int[] { 0, 255, 0 });
    rainbowColors.add(new int[] { 0, 0, 255 });
    rainbowColors.add(new int[] { 75, 0, 130 });
    rainbowColors.add(new int[] { 143, 0, 255 });

    return new Image(generateVStripes(newImage, rainbowColors),
        "C:\\Users\\Kishan\\eclipse-workspace\\HW5\\res\\Rainbow_Vertical.jpg");
  }

  /**
   * static method that Generates checker board image for given value of squares
   * on each side.
   *
   * @param nosquareheight the no square height
   * @param nosquarewidth  the no square width
   * @return the i image
   */
  public static Image generateCheckerBoard(int nosquareheight, int nosquarewidth) {
    int square = 100;
    int[][][] newImage = new int[square * nosquareheight][square * nosquarewidth][3];
    int c = 0;
    int r = 0;
    List<int[]> blackwhite = new ArrayList<int[]>();
    blackwhite.add(new int[] { 255, 255, 255 });
    blackwhite.add(new int[] { 0, 0, 0 });

    for (int scol = 1; scol <= nosquareheight; scol++) {
      for (int srow = 1; srow <= nosquarewidth; srow++) {
        for (int col = c; col < square * scol; col++) {
          for (int row = r; row < square * srow; row++) {
            newImage[col][row] = blackwhite.get(0);
          }
        }
        r += square;
        Collections.swap(blackwhite, 0, 1);
      }
      if (nosquarewidth % 2 == 0) {
        Collections.swap(blackwhite, 0, 1);
      }
      c += square;
      r = 0;
    }
    return new Image(newImage, "C:\\Users\\Kishan\\eclipse-workspace\\HW5\\res\\CheckerBoard.jpg");
  }

  /**
   * static method Generateflagfrance generates the flag of france.
   *
   * @param height the height
   * @param width  the width
   * @return the i image
   */
  public static Image generateflagfrance(int height, int width) {
    int[][][] newImage = new int[height][width][3];

    List<int[]> colors = new ArrayList<int[]>();

    colors.add(new int[] { 0, 85, 164 });
    colors.add(new int[] { 255, 255, 255 });
    colors.add(new int[] { 239, 65, 53 });

    return new Image(generateVStripes(newImage, colors),
        "C:\\Users\\Kishan\\eclipse-workspace\\HW5\\res\\fag_france.jpg");
  }

  /**
   * static method GenerateflagGreece generate the flag of greece.
   *
   * @param height the height
   * @param width  the width
   * @return the i image
   */
  public static Image generateflagGreece(int height, int width) {
    int[][][] image = new int[height][width][3];

    List<int[]> colors = new ArrayList<int[]>();

    colors.add(new int[] { 13, 94, 175 });
    colors.add(new int[] { 255, 255, 255 });
    colors.add(new int[] { 13, 94, 175 });
    colors.add(new int[] { 255, 255, 255 });
    colors.add(new int[] { 13, 94, 175 });
    colors.add(new int[] { 255, 255, 255 });
    colors.add(new int[] { 13, 94, 175 });
    colors.add(new int[] { 255, 255, 255 });
    colors.add(new int[] { 13, 94, 175 });

    image = generateHStripes(image, colors);

    for (int col = 0; col < Math.floor((height / 18f) * 10f); col++) {
      for (int row = 0; row < Math.floor((width / 27f) * 10f); row++) {
        image[col][row] = colors.get(0);
      }
    }

    for (int col = (int) Math.floor((height / 18f) * 4f); col < Math
        .floor((height / 18f) * 6f); col++) {
      for (int row = 0; row < Math.floor((width / 27f) * 10f); row++) {
        image[col][row] = colors.get(1);
      }
    }

    for (int row = (int) Math.floor((width / 27f) * 4f); row < Math
        .floor((width / 27f) * 6f); row++) {
      for (int col = 0; col < Math.ceil((height / 18f) * 10f); col++) {
        image[col][row] = colors.get(1);
      }
    }

    return new Image(image, "C:\\Users\\Kishan\\eclipse-workspace\\HW5\\res\\Flag_Greece.jpg");
  }

  /**
   * static method Generateflag generates the flag of norway.
   *
   * @param height the height
   * @param width  the width
   * @return the i image
   */
  public static Image generateflagNorway(int height, int width) {
    int[][][] image = new int[height][width][3];

    List<int[]> colors = new ArrayList<int[]>();

    colors.add(new int[] { 200, 16, 46 });
    colors.add(new int[] { 255, 255, 255 });
    colors.add(new int[] { 0, 48, 135 });

    for (int col = 0; col < height; col++) {
      for (int row = 0; row < width; row++) {
        image[col][row] = colors.get(0);
      }
    }

    for (int row = (int) Math.floor((width / 24f) * 6f); row < Math
        .floor((width / 24f) * 10f); row++) {
      for (int col = 0; col < height; col++) {
        image[col][row] = colors.get(1);
      }
    }

    for (int col = (int) Math.floor((height / 16f) * 6f); col < Math
        .floor((height / 16f) * 10f); col++) {
      for (int row = 0; row < width; row++) {
        image[col][row] = colors.get(1);
      }
    }

    for (int row = (int) Math.floor((width / 24f) * 7f); row < Math
        .floor((width / 24f) * 9f); row++) {
      for (int col = 0; col < height; col++) {
        image[col][row] = colors.get(2);
      }
    }

    for (int col = (int) Math.floor((height / 16f) * 7f); col < Math
        .floor((height / 16f) * 9f); col++) {
      for (int row = 0; row < width; row++) {
        image[col][row] = colors.get(2);
      }
    }

    return new Image(image, "C:\\Users\\Kishan\\eclipse-workspace\\HW5\\res\\Flag_Norway.jpg");
  }

  /**
   * static method Generateflag generates the flag of switzerland.
   *
   * @param height the height
   * @param width  the width
   * @return the i image
   */
  public static Image generateflagSwitzerland(int height, int width) {
    int[][][] image = new int[height][width][3];

    List<int[]> colors = new ArrayList<int[]>();

    colors.add(new int[] { 255, 0, 0 });
    colors.add(new int[] { 255, 255, 255 });

    for (int col = 0; col < height; col++) {
      for (int row = 0; row < width; row++) {
        image[col][row] = colors.get(0);
      }
    }

    for (int row = (int) Math.floor((width / 32f) * 13f); row < Math
        .floor((width / 32f) * 19f); row++) {
      for (int col = (int) Math.floor((height / 32f) * 6f); col < Math
          .floor((height / 32f) * 26f); col++) {
        image[col][row] = colors.get(1);
      }
    }

    for (int col = (int) Math.floor((height / 32f) * 13f); col < Math
        .floor((height / 32f) * 19f); col++) {
      for (int row = (int) Math.floor((width / 32f) * 6f); row < Math
          .floor((width / 32f) * 26f); row++) {
        image[col][row] = colors.get(1);
      }
    }
    return new Image(image,
        "C:\\Users\\Kishan\\eclipse-workspace\\HW5\\res\\Flag_Switzerland.jpg");
  }
}
