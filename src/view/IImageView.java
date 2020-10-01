package view;

import java.awt.image.BufferedImage;

import controller.Features;

/**
 * The Interface IImageView represents view for the program. it is set of
 * functionality needs to be implemented to interact with model.
 */
public interface IImageView {

  /**
   * Get the set of feature callbacks that the view can use to interact with
   * controller. It contains all the listeners that requires action by controller.
   * 
   * @param f the set of feature callbacks as a Features object
   */
  public void setFeatures(Features f);

  /**
   * Sets the image.
   *
   * @param file the new image
   */
  public void setImage(BufferedImage file);

  /**
   * Display error message.
   *
   * @param errorMessage the error message
   */
  public void displayErrorMessage(String errorMessage);
}
