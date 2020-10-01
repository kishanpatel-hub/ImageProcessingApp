package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * The IImageModel is a interface for model ImageModel. It represents set of
 * features offered by model.
 */
public interface IImageModel {

  /**
   * Load image.
   *
   * @param file the file
   */
  public void loadImage(String file);

  /**
   * Save image.
   *
   * @param file the file
   */
  public void saveImage(String file);

  /**
   * Gets the buffered image.
   *
   * @return the buffered image
   */
  public BufferedImage getBufferedImage();

  /**
   * Blur image.
   */
  public void blurImage();

  /**
   * Sharpen image.
   */
  public void sharpenImage();

  /**
   * Greyscale image.
   */
  public void greyscaleImage();

  /**
   * Sepia image.
   */
  public void sepiaImage();

  /**
   * Edgedetection image.
   */
  public void edgedetectionImage();

  /**
   * Dithering image.
   */
  public void ditheringImage();

  /**
   * Mosaicing image.
   *
   * @param seeds the seeds
   */
  public void mosaicingImage(int seeds);

  /**
   * Equalization image.
   */
  public void equalizationImage();

  /**
   * Redeye removal image.
   *
   * @param rect the rect
   */
  public void redeyeRemovalImage(Rectangle rect);

  /**
   * Generaterainbow vertical.
   *
   * @param height the height
   * @param width  the width
   */
  public void generaterainbowVertical(int height, int width);

  /**
   * Generaterainbow horizontal.
   *
   * @param height the height
   * @param width  the width
   */
  public void generaterainbowHorizontal(int height, int width);

  /**
   * Generate checker board.
   *
   * @param height the height
   * @param width  the width
   */
  public void generateCheckerBoard(int height, int width);

  /**
   * Generate france flag.
   *
   * @param height the height
   * @param width  the width
   */
  public void generateFranceFlag(int height, int width);

  /**
   * Generate greece flag.
   *
   * @param height the height
   * @param width  the width
   */
  public void generateGreeceFlag(int height, int width);

  /**
   * Generateflag norway.
   *
   * @param height the height
   * @param width  the width
   */
  public void generateflagNorway(int height, int width);

  /**
   * Generateflag switzerland.
   *
   * @param height the height
   * @param width  the width
   */
  public void generateflagSwitzerland(int height, int width);
}
