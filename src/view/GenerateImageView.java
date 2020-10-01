package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.Features;

/**
 * The Class GenerateImageView represents the JFrame view for generate Image
 * functionality. It implements IImageView interface and offers set of methods
 * to interact with controller.
 */
public class GenerateImageView extends JFrame implements IImageView {

  /** The img label. */
  private JLabel imgLabel;

  /** The save button. */
  private JButton saveButton;

  /** The rainbow V button. */
  private JButton rainbowVButton;

  /** The rainbow H button. */
  private JButton rainbowHButton;

  /** The checker borad button. */
  private JButton checkerBoradButton;

  /** The franceflag button. */
  private JButton franceflagButton;

  /** The greeceflag button. */
  private JButton greeceflagButton;

  /** The norwayflag button. */
  private JButton norwayflagButton;

  /** The switzerlandflag button. */
  private JButton switzerlandflagButton;

  /** The exite button. */
  private JButton exiteButton;

  /** The file picker save. */
  private JFilePicker filePickerSave;

  /** The height field. */
  private JTextField heightField = new JTextField(30);

  /** The Width field. */
  private JTextField widthField = new JTextField(30);

  /**
   * Instantiates a new generate image view.
   */
  public GenerateImageView() {

    super("PhotoShop");
    Container mainContainer = this.getContentPane();
    mainContainer.setLayout(new BorderLayout(8, 6));
    mainContainer.setBackground(Color.cyan);
    this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));

    JPanel savePanel = new JPanel();
    savePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
    savePanel.setBorder(new LineBorder(Color.WHITE));
    savePanel.setBackground(Color.gray);

    JPanel optionPanel = new JPanel();
    optionPanel.setLayout(new FlowLayout(4, 4, 4));
    optionPanel.setBorder(new LineBorder(Color.WHITE, 3));
    optionPanel.setBackground(Color.LIGHT_GRAY);

    JPanel filterPanel = new JPanel();
    filterPanel.setLayout(new GridLayout(8, 1, 5, 5));
    filterPanel.setBackground(Color.LIGHT_GRAY);

    this.filePickerSave = new JFilePicker();
    this.filePickerSave.setMode(JFilePicker.MODE_SAVE);
    this.filePickerSave.addFileTypeFilter(".jpg", "JPEG Images");
    this.filePickerSave.addFileTypeFilter(".png", "PNG Images");

    this.imgLabel = new JLabel();

    JLabel heightLabel;

    JLabel widthLabel;

    heightLabel = new JLabel("Enter Height:");
    widthLabel = new JLabel("Enter Width: ");

    this.heightField.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
        String value = heightField.getText();
        int l = value.length();
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '\b') {
          heightField.setEditable(true);
        } else {
          heightField.setText(
              JOptionPane.showInputDialog("Incorrect Height value!! \n Enter correct value:"));
        }
      }
    });

    this.widthField.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
        String value = widthField.getText();
        int l = value.length();
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '\b') {
          widthField.setEditable(true);

        } else {
          widthField.setText(
              JOptionPane.showInputDialog("Incorrect width value!! \n Enter correct value:"));
        }
      }
    });

    this.saveButton = new JButton("Save");
    this.rainbowVButton = new JButton("Rainbow Vertical");
    this.rainbowHButton = new JButton("Rainbow Horizontal");
    this.checkerBoradButton = new JButton("Checker Board");
    this.franceflagButton = new JButton("France");
    this.greeceflagButton = new JButton("Greece");
    this.norwayflagButton = new JButton("Norway");
    this.switzerlandflagButton = new JButton("Switzerland");
    this.exiteButton = new JButton("Exit");

    savePanel.add(heightLabel);
    savePanel.add(heightField);
    savePanel.add(widthLabel);
    savePanel.add(widthField);
    savePanel.add(filePickerSave);
    savePanel.add(saveButton);
    savePanel.add(Box.createHorizontalStrut(50));
    savePanel.add(exiteButton);

    filterPanel.add(rainbowVButton);
    filterPanel.add(rainbowHButton);
    filterPanel.add(checkerBoradButton);
    filterPanel.add(checkerBoradButton);
    filterPanel.add(franceflagButton);
    filterPanel.add(greeceflagButton);
    filterPanel.add(norwayflagButton);
    filterPanel.add(switzerlandflagButton);

    optionPanel.add(filterPanel);

    mainContainer.add(savePanel, BorderLayout.NORTH);
    mainContainer.add(optionPanel, BorderLayout.WEST);
    JScrollPane scroller = new JScrollPane(imgLabel);
    this.add(scroller);
    // this.add(imgLabel, SwingConstants.CENTER);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setUndecorated(true);
    this.setLocationRelativeTo(null);
    this.setVisible(true);

  }

  /**
   * Gets the height field.
   *
   * @return the height field
   */
  private int getHeightField() {
    String input = heightField.getText();
    boolean validate = false;
    do {
      if (validate(input)) {
        return Integer.parseInt(input);
      } else {
        input = JOptionPane.showInputDialog("Incorrect Height value!! \n Enter correct value:");
        this.heightField.setText(input);
      }
    } while (!validate);
    return 0;

  }

  /**
   * Gets the width field.
   *
   * @return the width field
   */
  private int getWidthField() {
    String input = widthField.getText();
    boolean validate = false;
    do {
      if (validate(input)) {
        return Integer.parseInt(input);
      } else {
        input = JOptionPane.showInputDialog("Incorrect Width value!! \n Enter correct value:");
        this.widthField.setText(input);
      }
    } while (!validate);
    return 0;
  }

  /**
   * Validate.
   *
   * @param input the input
   * @return true, if successful
   */
  private boolean validate(String input) {
    if (input.equals("")) {
      return false;
    }
    for (char c : input.toCharArray()) {
      if (!(c >= '0' && c <= '9')) {
        return false;
      }
    }

    return true;
  }

  /**
   * Sets the features.
   *
   * @param f the new features
   */
  @Override
  public void setFeatures(Features f) {
    this.saveButton.addActionListener(l -> f.saveImage(filePickerSave.getSelectedFilePath()));
    this.rainbowVButton
        .addActionListener(l -> f.generateRainbowV(this.getHeightField(), this.getWidthField()));
    this.rainbowHButton
        .addActionListener(l -> f.generateRainbowH(this.getHeightField(), this.getWidthField()));
    this.checkerBoradButton.addActionListener(
        l -> f.generateCheckerBoard(this.getHeightField(), this.getWidthField()));
    this.franceflagButton
        .addActionListener(l -> f.generateFranceFlag(this.getHeightField(), this.getWidthField()));
    this.greeceflagButton
        .addActionListener(l -> f.generateGreeceFlag(this.getHeightField(), this.getWidthField()));
    this.norwayflagButton
        .addActionListener(l -> f.generateNorwayFlag(this.getHeightField(), this.getWidthField()));
    this.switzerlandflagButton.addActionListener(
        l -> f.generateSwitzerlandFlag(this.getHeightField(), this.getWidthField()));
    this.exiteButton.addActionListener(l -> f.exitProgram());

  }

  /**
   * Sets the image.
   *
   * @param file the new image
   */
  @Override
  public void setImage(BufferedImage file) {
    // imgLabel = new JLabel(new ImageIcon(file), SwingConstants.CENTER);
    imgLabel.setIcon(new ImageIcon(file));
    // this.add(imgLabel, BorderLayout.CENTER);
    this.revalidate();
    this.repaint();

  }

  /**
   * Display error message.
   *
   * @param errorMessage the error message
   */
  @Override
  public void displayErrorMessage(String errorMessage) {

    JOptionPane.showMessageDialog(this, errorMessage);

  }

}
