import java.io.IOException;

import controller.ImageController;
import model.ImageModel;
import view.IImageView;
import view.ImageView;

/**
 * The Class Driver is class consisting main method which works as starting
 * point in the application and initiates the model , view and controller and
 * passes control to controller.
 */
public class Driver {

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void main(String[] args) throws IOException {

    ImageModel theModel = new ImageModel();
    ImageController control = new ImageController(theModel);

    if (args[0].charAt(0) == '-') {
      if (args[0].substring(1).equals("script")) {
        control.execute(args[1]);
      } else if (args[0].substring(1).equals("interactive")) {
        // Initiates the controller.

        // control.execute(args[args.length - 1]);
        IImageView theView = new ImageView();
        control.setView(theView);
      } else {
        System.out.println("Illegal Argument!!");
        System.exit(0);
      }
    } else {
      System.out.println("Illegal Argument!!");
      System.exit(0);
    }

  }

}
