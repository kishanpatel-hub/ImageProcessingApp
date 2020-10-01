package controller;

import java.awt.Rectangle;

/**
 * This interface represents a set of features that the program offers. Each
 * feature is exposed as a function in this interface. This function is used
 * suitably as a callback by the view, to pass control to the controller. How
 * the view uses them as callbacks is completely up to how the view is designed
 * (e.g. it could use them as a callback for a button, or a callback for a
 * dialog box, or a set of text inputs, etc.) Each function is designed to take
 * in the necessary data to complete that functionality.
 */
public interface Features {

  /**
   * Loads the input image selected by the user.
   * 
   * @param file the file entered by the user
   */
  void loadImage(String file);

  /**
   * saves the image in the file selected by the user.
   * 
   * @param file the file entered by the user
   */
  void saveImage(String file);

  /**
   * Blurs the image selected by the user.
   */
  void blurImage();

  /**
   * sharpen the image selected by the user.
   */
  void sharpenImage();

  /**
   * greyscale of the image selected by the user.
   */
  void greyscaleImage();

  /**
   * sepia of the image selected by the user.
   */
  void sepiaImage();

  /**
   * edge detection of the image selected by the user.
   */
  void edgedetectionImage();

  /**
   * dithering of the image selected by the user.
   */
  void ditheringImage();

  /**
   * mosaicing of the image selected by the user.
   * 
   * @param seeds the number of seeds
   */
  void mosaicingImage(int seeds);

  /**
   * equalize the image selected by the user.
   */
  void equalizationImage();

  /**
   * Removes the red eye effect in the image piece selected by the user.
   */
  void redeyeRemovalImage(Rectangle rect);

  /**
   * Generate Image method launches generateImage View and set features for the
   * same.
   */
  void generateImage();

  /**
   * Generate Vertical Rainbow Image for given height and width.
   */
  void generateRainbowV(int height, int width);

  /**
   * Generate Horizontal Rainbow Image for given height and width.
   */
  void generateRainbowH(int height, int width);

  /**
   * Generate Checker Board Image for given number of square on vertical and
   * horizontal.
   */
  void generateCheckerBoard(int noOfSquareVertical, int noOfSquareHorizontal);

  /**
   * Generate flag of France Image for given height and width.
   */
  void generateFranceFlag(int height, int width);

  /**
   * Generate flag of Greece Image for given height and width.
   */
  void generateGreeceFlag(int height, int width);

  /**
   * Generate flag of Norway Image for given height and width.
   */
  void generateNorwayFlag(int height, int width);

  /**
   * Generate flag of SwitzerLand Image for given height and width.
   */
  void generateSwitzerlandFlag(int height, int width);

  /**
   * Exit the program.
   */
  void exitProgram();
}
