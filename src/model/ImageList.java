package model;

/**
 * The Interface ImageList represents list of images and offers operations on
 * list of images such as loading, saving, displaying, and writing images using
 * ImageUtilities class.
 */
public interface ImageList {

  /**
   * Load image method loads the image using ImageUtilities class and adds the
   * image in list.
   *
   * @param file the file
   */
  public void loadImage(String file);

  /**
   * Save image method saves the given image in list of images.
   *
   * @param image the image
   */
  public void saveImage(Image image);

  /**
   * getImage method returns the image at given index.
   *
   * @param i the i
   * @return the image
   */
  public Image getImage(int i);

  /**
   * getList method returns the list of images.
   *
   * @return the list
   */
  public ImageList getList();

  /**
   * To string method prints the list of image names.
   */
  public String toString();

  /**
   * Write images method uses ImageUtilities class to write the image and throws
   * exception if file path does not exist or there is some issue while writing
   * file.
   */
  public void writeImages();

}
