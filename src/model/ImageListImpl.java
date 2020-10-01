package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class ImageListImpl implements the imageList interface and also maintains
 * the list of images. It offers constructor to Instantiate the list and
 * overrides method in imagelist interface.
 */
public class ImageListImpl implements ImageList {

  /** The Image list. */
  List<Image> imageList;

  /**
   * Instantiates a new image list impl.
   */
  public ImageListImpl() {
    imageList = new ArrayList<Image>();
  }

  /**
   * Load image.
   *
   * @param file the file
   */
  @Override
  public void loadImage(String file) {
    imageList.add(new Image(file));
  }

  /**
   * Gets the image.
   *
   * @param i the i
   * @return the image
   */
  @Override
  public Image getImage(int i) {
    return imageList.get(i);
  }

  /**
   * Gets the list.
   *
   * @return the list
   */
  @Override
  public ImageList getList() {
    return this;
  }

  /**
   * Save image.
   *
   * @param image the image
   */
  @Override
  public void saveImage(Image image) {
    imageList.add(image);

  }

  /**
   * To string.
   */
  @Override
  public String toString() {
    System.out.println(this.imageList.size());
    for (Image s : this.imageList) {
      System.out.println(s.getName());
    }
    return null;

  }

  /**
   * Write images.
   */
  @Override
  public void writeImages() {
    for (Image s : this.imageList) {
      s.writeImage(s.getName());
    }
  }

}
