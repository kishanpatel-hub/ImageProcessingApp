package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controller.Features;

public class BorderDecorator extends Decorator {

  /** The Border button. */
  private JButton borderButton;

  public BorderDecorator(IImageView view) {
    super(view);
    this.borderButton = new JButton("Border");
    enhancementPanel.add(borderButton);
  }

  public void setFeatures(Features f) {
    super.setFeatures(f);

    this.borderButton.addActionListener(l -> {
      int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the Border Size:"));
      borderImage(size);
    });
  }
}
