package view;

import java.awt.image.BufferedImage;

import controller.Features;

abstract public class Decorator implements IImageView {

  private IImageView view;

  public Decorator(IImageView view) {
    this.view = view;
  }

  public void setFeatures(Features f) {
    view.setFeatures(f);
  }

  public void setImage(BufferedImage file) {
    view.setImage(file);
  }

  public void displayErrorMessage(String errorMessage) {
    view.displayErrorMessage(errorMessage);
  }
}
