package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * The Class ImageModel represents the model of the program. It implements the
 * IImageModel interface and implements all the functionality offered by it.
 */
public class ImageModel {

  /** The input image. */
  Image inputImage;

  /**
   * Instantiates a new image model.
   */
  public ImageModel() {
    this.inputImage = null;

  }

  /**
   * Load image.
   *
   * @param file the file
   */
  public void loadImage(String file) {
    this.inputImage = new Image(file);
  }

  /**
   * Save image.
   *
   * @param file the file
   */
  public void saveImage(String file) {
    validate();
    inputImage.writeImage(file);
  }

  /**
   * Gets the buffered image.
   *
   * @return the buffered image
   */
  public BufferedImage getBufferedImage() {
    validate();
    return inputImage.getBufferedImage();
  }

  /**
   * Blur image.
   */
  public void blurImage() {
    validate();
    inputImage = inputImage.blur();
  }

  /**
   * Sharpen image.
   */
  public void sharpenImage() {
    validate();
    inputImage = inputImage.sharpen();
  }

  /**
   * Greyscale image.
   */
  public void greyscaleImage() {
    validate();
    inputImage = inputImage.greyscale();
  }

  /**
   * Sepia image.
   */
  public void sepiaImage() {
    validate();
    inputImage = inputImage.sepia();
  }

  /**
   * Edgedetection image.
   */
  public void edgedetectionImage() {
    validate();
    inputImage = inputImage.edgeDetection();
  }

  /**
   * Dithering image.
   */
  public void ditheringImage() {
    validate();
    inputImage = inputImage.greyscale().dithering();
  }

  /**
   * Mosaicing image.
   *
   * @param seeds the seeds
   */
  public void mosaicingImage(int seeds) {
    validate();
    inputImage = inputImage.mosaicing(seeds);
  }

  /**
   * Equalization image.
   */
  public void equalizationImage() {
    validate();
    inputImage = inputImage.equalization();
  }

  /**
   * Redeye removal image.
   *
   * @param rect the rect
   */
  public void redeyeRemovalImage(Rectangle rect) {
    validate();
    inputImage = inputImage.redEyeRemoval(rect);
  }

  /**
   * Generaterainbow vertical.
   *
   * @param height the height
   * @param width  the width
   */
  public void generaterainbowVertical(int height, int width) {
    inputImage = GenerateImage.generateRainbowV(height, width);
  }

  /**
   * Generaterainbow horizontal.
   *
   * @param height the height
   * @param width  the width
   */
  public void generaterainbowHorizontal(int height, int width) {
    inputImage = GenerateImage.generateRainbowH(height, width);
  }

  /**
   * Generate checker board.
   *
   * @param height the height
   * @param width  the width
   */
  public void generateCheckerBoard(int height, int width) {
    inputImage = GenerateImage.generateCheckerBoard(height, width);
  }

  /**
   * Generate france flag.
   *
   * @param height the height
   * @param width  the width
   */
  public void generateFranceFlag(int height, int width) {
    inputImage = GenerateImage.generateflagfrance(height, width);
  }

  /**
   * Generate greece flag.
   *
   * @param height the height
   * @param width  the width
   */
  public void generateGreeceFlag(int height, int width) {
    inputImage = GenerateImage.generateflagGreece(height, width);
  }

  /**
   * Generateflag norway.
   *
   * @param height the height
   * @param width  the width
   */
  public void generateflagNorway(int height, int width) {
    inputImage = GenerateImage.generateflagNorway(height, width);
  }

  /**
   * Generateflag switzerland.
   *
   * @param height the height
   * @param width  the width
   */
  public void generateflagSwitzerland(int height, int width) {
    inputImage = GenerateImage.generateflagSwitzerland(height, width);
  }

  /**
   * Validate.
   *
   * @return true, if successful
   */
  private boolean validate() {
    if (inputImage == null) {
      throw new NullPointerException();
    }
    return true;
  }
}
