package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class JFilePicker represents fileChoosing functionality of view.
 */
public class JFilePicker extends JPanel {

  /** The label. */
  private JLabel label = new JLabel("Select Image:");

  /** The text field. */
  private JTextField textField = new JTextField(30);

  /** The button. */
  private JButton button = new JButton("Browse");

  /** The file chooser. */
  private JFileChooser fileChooser;

  /** The mode. */
  private int mode;

  /** The Constant MODE_OPEN. */
  public static final int MODE_OPEN = 1;

  /** The Constant MODE_SAVE. */
  public static final int MODE_SAVE = 2;

  /**
   * Instantiates a new j file picker.
   */
  public JFilePicker() {

    fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File("C:/Users/Kishan/eclipse-workspace/HW6/res/"));

    this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
    this.setBackground(Color.gray);

    this.button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        buttonActionPerformed(evt);
      }
    });
    setSize(100, 100);
    add(this.label);
    add(this.textField);
    add(this.button);
  }

  /**
   * Button action performed.
   *
   * @param evt the evt
   */
  private void buttonActionPerformed(ActionEvent evt) {
    if (mode == MODE_OPEN) {
      if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
      }
    } else if (mode == MODE_SAVE) {
      if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
      }
    }
  }

  /**
   * Adds the file type filter.
   *
   * @param extension   the extension
   * @param description the description
   */
  public void addFileTypeFilter(String extension, String description) {
    FileTypeFilter filter = new FileTypeFilter(extension, description);
    fileChooser.addChoosableFileFilter(filter);
    fileChooser.setAcceptAllFileFilterUsed(false);
  }

  /**
   * Sets the mode.
   *
   * @param mode the new mode
   */
  public void setMode(int mode) {
    this.mode = mode;
  }

  /**
   * Gets the selected file path.
   *
   * @return the selected file path
   */
  public String getSelectedFilePath() {
    return textField.getText();
  }

  /**
   * Gets the file chooser.
   *
   * @return the file chooser
   */
  public JFileChooser getFileChooser() {
    return this.fileChooser;
  }

}