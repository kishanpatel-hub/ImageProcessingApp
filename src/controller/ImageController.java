package controller;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import model.ImageModel;
import view.GenerateImageView;
import view.IImageView;

/**
 * The Class ImageController is controller for the program. The controller now
 * implements the Features interface. This means each of those functions will
 * give control to the controller. It takes input from the user via interactive
 * UI and script.
 */
public class ImageController implements Features {

  /** The view. */
  IImageView view;

  /** The model. */
  ImageModel model;

  /**
   * Instantiates a new image controller.
   *
   * @param model the model
   */
  public ImageController(ImageModel model) {
    this.model = model;
  }

  /**
   * Mutator for the view.
   * 
   * @param v the view to use
   */
  public void setView(IImageView v) {
    view = v;
    // give the feature callbacks to the view
    view.setFeatures(this);
  }

  /**
   * Load image.
   *
   * @param file the file
   */
  @Override
  public void loadImage(String file) {
    if (file != null) {
      model.loadImage(file);
      view.setImage(model.getBufferedImage());
    }
  }

  /**
   * Save image.
   *
   * @param file the file
   */
  @Override
  public void saveImage(String file) {
    if (file != null) {
      model.saveImage(file);
    }

  }

  /**
   * Blur image.
   */
  @Override
  public void blurImage() {
    try {
      model.blurImage();
    } catch (NullPointerException e) {
      view.displayErrorMessage("Load Image!!!");
    }
    view.setImage(model.getBufferedImage());
  }

  /**
   * Sharpen image.
   */
  @Override
  public void sharpenImage() {
    try {
      model.sharpenImage();
    } catch (NullPointerException e) {
      view.displayErrorMessage("Load Image!!!");
    }
    view.setImage(model.getBufferedImage());
  }

  /**
   * Greyscale image.
   */
  @Override
  public void greyscaleImage() {
    try {
      model.greyscaleImage();
    } catch (NullPointerException e) {
      view.displayErrorMessage("Load Image!!!");
    }
    view.setImage(model.getBufferedImage());
  }

  /**
   * Sepia image.
   */
  @Override
  public void sepiaImage() {
    try {
      model.sepiaImage();
    } catch (NullPointerException e) {
      view.displayErrorMessage("Load Image!!!");
    }
    view.setImage(model.getBufferedImage());
  }

  /**
   * Edgedetection image.
   */
  @Override
  public void edgedetectionImage() {
    try {
      model.edgedetectionImage();
    } catch (NullPointerException e) {
      view.displayErrorMessage("Load Image!!!");
    }
    view.setImage(model.getBufferedImage());
  }

  /**
   * Dithering image.
   */
  @Override
  public void ditheringImage() {
    try {
      model.ditheringImage();
    } catch (NullPointerException e) {
      view.displayErrorMessage("Load Image!!!");
    }
    view.setImage(model.getBufferedImage());
  }

  /**
   * Mosaicing image.
   *
   * @param seeds the seeds
   */
  @Override
  public void mosaicingImage(int seeds) {
    try {
      model.mosaicingImage(seeds);
    } catch (NullPointerException e) {
      view.displayErrorMessage("Load Image!!!");
    }
    view.setImage(model.getBufferedImage());
  }

  /**
   * Equalization image.
   */
  @Override
  public void equalizationImage() {
    try {
      model.equalizationImage();
    } catch (NullPointerException e) {
      view.displayErrorMessage("Load Image!!!");
    }
    view.setImage(model.getBufferedImage());
  }

  /**
   * Redeye removal image.
   *
   * @param rect the rect
   */
  @Override
  public void redeyeRemovalImage(Rectangle rect) {
    try {
      model.redeyeRemovalImage(rect);
    } catch (NullPointerException e) {
      view.displayErrorMessage("Load Image!!!");
    }
    view.setImage(model.getBufferedImage());
  }

  /**
   * Generate image.
   */
  @Override
  public void generateImage() {
    IImageView v = new GenerateImageView();
    v.setFeatures(this);
    this.view = v;
  }

  /**
   * Exit program.
   */
  @Override
  public void exitProgram() {
    System.exit(0);
  }

  /**
   * Generate rainbow V.
   *
   * @param height the height
   * @param width  the width
   */
  @Override
  public void generateRainbowV(int height, int width) {
    model.generaterainbowVertical(height, width);
    view.setImage(model.getBufferedImage());
  }

  /**
   * Generate rainbow H.
   *
   * @param height the height
   * @param width  the width
   */
  @Override
  public void generateRainbowH(int height, int width) {
    model.generaterainbowHorizontal(height, width);
    view.setImage(model.getBufferedImage());
  }

  /**
   * Generate checker board.
   *
   * @param noOfSquareVertical   the no of square vertical
   * @param noOfSquareHorizontal the no of square horizontal
   */
  @Override
  public void generateCheckerBoard(int noOfSquareVertical, int noOfSquareHorizontal) {
    if (noOfSquareVertical <= 40 && noOfSquareHorizontal <= 40) {
      model.generateCheckerBoard(noOfSquareVertical, noOfSquareHorizontal);
      view.setImage(model.getBufferedImage());
    } else {
      view.displayErrorMessage(
          "Input value of height and width for CheckerBoard can not exceed 40!!!");
    }

  }

  /**
   * Generate france flag.
   *
   * @param height the height
   * @param width  the width
   */
  @Override
  public void generateFranceFlag(int height, int width) {
    model.generateFranceFlag(height, width);
    view.setImage(model.getBufferedImage());
  }

  /**
   * Generate greece flag.
   *
   * @param height the height
   * @param width  the width
   */
  @Override
  public void generateGreeceFlag(int height, int width) {
    model.generateGreeceFlag(height, width);
    view.setImage(model.getBufferedImage());
  }

  /**
   * Generate norway flag.
   *
   * @param height the height
   * @param width  the width
   */
  @Override
  public void generateNorwayFlag(int height, int width) {
    model.generateflagNorway(height, width);
    view.setImage(model.getBufferedImage());
  }

  /**
   * Generate switzerland flag.
   *
   * @param height the height
   * @param width  the width
   */
  @Override
  public void generateSwitzerlandFlag(int height, int width) {
    model.generateflagSwitzerland(height, width);
    view.setImage(model.getBufferedImage());
  }

  /**
   * Go method takes file name as input and operates on the images based on input
   * given in the file.
   *
   * @param file the file
   */
  public void execute(String file) {
    File input = new File(file);
    String[] words = null;

    try {
      Scanner sc = new Scanner(input, StandardCharsets.UTF_8.name());

      while (sc.hasNextLine()) {
        // System.out.println(sc.nextLine());
        String command = sc.nextLine();
        words = command.toLowerCase().split(" ");

        switch (words[0]) {
          case "load": {
            model.loadImage(words[1]);
            System.out.println("loaded " + words[1]);
            break;
          }
          case "save": {
            model.saveImage(words[1]);
            System.out.println("saved " + words[1]);
            break;
          }
          case "blur": {
            model.blurImage();
            System.out.println("blured ");
            break;
          }
          case "sharpen": {
            model.sharpenImage();
            System.out.println("sharpen ");
            break;
          }
          case "greyscale": {
            model.greyscaleImage();
            System.out.println("greyscale ");
            break;
          }
          case "sepia": {
            model.sepiaImage();
            System.out.println("sepia ");
            break;
          }
          case "edgedetection": {
            model.edgedetectionImage();
            System.out.println("edge Detection ");
            break;
          }
          case "dithering": {
            model.ditheringImage();
            System.out.println("Dithering ");
            break;
          }
          case "mosaicing": {
            model.mosaicingImage(Integer.parseInt(words[1]));
            System.out.println("Mosaicing ");
            break;
          }
          case "equalization": {
            model.equalizationImage();
            System.out.println("greyscaleContrastEnhancement ");
            break;
          }
          case "rainbowVertical": {
            model.generaterainbowVertical(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
            System.out.println("Rainbow Vertical ");
            break;
          }
          case "rainbowHorizontal": {
            model.generaterainbowHorizontal(Integer.parseInt(words[1]),
                Integer.parseInt(words[2]));
            System.out.println("Rainbow Horizontal ");
            break;
          }
          case "checkerboard": {
            model.generateCheckerBoard(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
            System.out.println("CheckerBoard ");
            break;
          }
          case "franceflag": {
            model.generateFranceFlag(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
            System.out.println("Flag of France ");
            break;
          }
          case "norwayflag": {
            model.generateflagNorway(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
            System.out.println("Flag of Norway ");
            break;
          }
          case "greeceflag": {
            model.generateGreeceFlag(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
            System.out.println("Flag of Greece");
            break;
          }
          case "switzerlandflag": {
            model.generateflagSwitzerland(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
            System.out.println("Flag of Switzerland");
            break;
          }
          default: {
            System.out.println("Invalid Input");
          }
        }

      }

      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
