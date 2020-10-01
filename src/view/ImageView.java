package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import controller.Features;

/**
 * The Class ImageView represents JFrame view for image operations
 * functionality. It implements IImageView interface and offers set of methods
 * to interact with controller.
 */
public class ImageView extends JFrame implements IImageView {

  /** The img label. */
  private JLabel imgLabel = new JLabel();

  /** The file picker load. */
  private JFilePicker filePickerLoad;

  /** The file picker save. */
  private JFilePicker filePickerSave;

  /** The load button. */
  private JButton loadButton;

  /** The save button. */
  private JButton saveButton;

  /** The blur button. */
  private JButton blurButton;

  /** The sharpen button. */
  private JButton sharpenButton;

  /** The sepia button. */
  private JButton sepiaButton;

  /** The greyscale button. */
  private JButton greyscaleButton;

  /** The edgedetection button. */
  private JButton edgedetectionButton;

  /** The dithering button. */
  private JButton ditheringButton;

  /** The mosaicing button. */
  private JButton mosaicingButton;

  /** The equalization button. */
  private JButton equalizationButton;

  /** The redeye button. */
  private JButton redeyeButton;

  /** The generate image. */
  private JButton generateImage;

  /** The reset button. */
  private JButton resetButton;

  /** The exit button. */
  private JButton exitButton;

  /** The Border button. */
  private JButton borderButton;

  /** The sticker button. */
  private JButton stickerButton;

  /** The meme button. */
  private JButton memeButton;

  /** The resize button. */
  private JButton reSizeButton;

  /** The save enhancements button. */
  private boolean enhance = false;

  /** The capture rect. */
  private Rectangle captureRect;

  /** The scroller. */
  private JScrollPane scroller;

  /** The BufferedImage. */
  private BufferedImage image;

  JPanel imagePanel;

  /**
   * Instantiates a new image view.
   */
  public ImageView() {

    // Sets up the view and adds the components

    super("PhotoShop");

    Container mainContainer;

    mainContainer = this.getContentPane();
    mainContainer.setLayout(new BorderLayout(8, 6));
    mainContainer.setBackground(Color.cyan);
    this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));

    imagePanel = new JPanel();
    imagePanel.setLayout(new BorderLayout(8, 8));
    imagePanel.setBorder(new LineBorder(Color.WHITE));
    imagePanel.setBackground(Color.red);

    JPanel optionPanel2 = new JPanel();
    optionPanel2.setLayout(new FlowLayout(5, 5, 5));
    optionPanel2.setBorder(new LineBorder(Color.WHITE, 3));
    optionPanel2.setBackground(Color.LIGHT_GRAY);

    JPanel enhancementPanel = new JPanel();
    enhancementPanel.setLayout(new GridLayout(11, 1, 5, 5));
    enhancementPanel.setBackground(Color.LIGHT_GRAY);

    JPanel browsePanel = new JPanel();
    browsePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
    browsePanel.setBorder(new LineBorder(Color.WHITE));
    browsePanel.setBackground(Color.gray);

    JPanel optionPanel = new JPanel();
    optionPanel.setLayout(new FlowLayout(5, 5, 5));
    optionPanel.setBorder(new LineBorder(Color.WHITE, 3));
    optionPanel.setBackground(Color.LIGHT_GRAY);

    JPanel filterPanel = new JPanel();
    filterPanel.setLayout(new GridLayout(11, 1, 5, 5));
    filterPanel.setBackground(Color.LIGHT_GRAY);

    // set up a file picker component
    this.filePickerLoad = new JFilePicker();
    this.filePickerLoad.setMode(JFilePicker.MODE_OPEN);
    this.filePickerLoad.addFileTypeFilter(".jpg", "JPEG Images");
    this.filePickerLoad.addFileTypeFilter(".png", "PNG Images");

    this.filePickerSave = new JFilePicker();
    this.filePickerSave.setMode(JFilePicker.MODE_SAVE);
    this.filePickerSave.addFileTypeFilter(".jpg", "JPEG Images");
    this.filePickerSave.addFileTypeFilter(".png", "PNG Images");

    this.blurButton = new JButton("Blur");
    this.sharpenButton = new JButton("Sharpen");
    this.greyscaleButton = new JButton("Greyscale");
    this.sepiaButton = new JButton("Sepia");
    this.edgedetectionButton = new JButton("Edge Detection");
    this.ditheringButton = new JButton("Dithering");
    this.mosaicingButton = new JButton("Mosaicing");
    this.equalizationButton = new JButton("Equalization");
    this.redeyeButton = new JButton("Red Eye Removal");
    this.generateImage = new JButton("Generate Images");
    this.loadButton = new JButton("Load");
    this.saveButton = new JButton("Save");
    this.resetButton = new JButton("Reset");
    this.exitButton = new JButton("Exit");
    this.borderButton = new JButton("Border");
    this.stickerButton = new JButton("Sticker");
    this.memeButton = new JButton("Meme");
    this.reSizeButton = new JButton("Resize");

    // add the component to the frame
    browsePanel.add(filePickerLoad);
    browsePanel.add(loadButton);
    browsePanel.add(filePickerSave);
    browsePanel.add(saveButton);
    browsePanel.add(Box.createHorizontalStrut(250));
    browsePanel.add(exitButton);

    filterPanel.add(blurButton);
    filterPanel.add(sharpenButton);
    filterPanel.add(greyscaleButton);
    filterPanel.add(sepiaButton);
    filterPanel.add(edgedetectionButton);
    filterPanel.add(ditheringButton);
    filterPanel.add(mosaicingButton);
    filterPanel.add(equalizationButton);
    filterPanel.add(redeyeButton);
    filterPanel.add(generateImage);
    filterPanel.add(resetButton);

    enhancementPanel.add(borderButton);
    enhancementPanel.add(stickerButton);
    enhancementPanel.add(memeButton);
    enhancementPanel.add(reSizeButton);

    optionPanel2.add(enhancementPanel);

    optionPanel.add(filterPanel);

    mainContainer.add(browsePanel, BorderLayout.NORTH);

    mainContainer.add(optionPanel, BorderLayout.WEST);

    mainContainer.add(optionPanel2, BorderLayout.EAST);

    scroller = new JScrollPane(imgLabel);
    imagePanel.add(scroller, BorderLayout.CENTER);

    mainContainer.add(imagePanel, BorderLayout.CENTER);

    // JScrollPane scroller = new JScrollPane(imgLabel);
    // this.add(scroller, BorderLayout.CENTER);
    // this.add(imgLabel, SwingConstants.CENTER);

    // mainContainer.add(scroller, BorderLayout.CENTER);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    // this.setUndecorated(true);

    // this.setLocationRelativeTo(null);
    // this.pack();
    this.setVisible(true);

  }

  /**
   * Sets the features.
   *
   * @param f the new features
   */
  @Override
  public void setFeatures(Features f) {

    this.loadButton.addActionListener(l -> {
      enhance = false;
      f.loadImage(filePickerLoad.getSelectedFilePath());
    });
    this.saveButton.addActionListener(l -> {
      if (enhance == true) {
        writeImage(filePickerSave.getSelectedFilePath());

      }
      f.saveImage(filePickerSave.getSelectedFilePath());
    });
    this.blurButton.addActionListener(l -> f.blurImage());
    this.sharpenButton.addActionListener(l -> f.sharpenImage());
    this.greyscaleButton.addActionListener(l -> f.greyscaleImage());
    this.sepiaButton.addActionListener(l -> f.sepiaImage());
    this.edgedetectionButton.addActionListener(l -> f.edgedetectionImage());
    this.ditheringButton.addActionListener(l -> f.ditheringImage());
    this.mosaicingButton.addActionListener(l -> {
      f.mosaicingImage(
          Integer.parseInt(JOptionPane.showInputDialog("Enter the Number of Seeds:")));
    });
    this.equalizationButton.addActionListener(l -> f.equalizationImage());
    this.redeyeButton.addActionListener(l -> f.redeyeRemovalImage(captureRect));
    this.generateImage.addActionListener(l -> f.generateImage());
    this.exitButton.addActionListener(l -> f.exitProgram());
    this.resetButton.addActionListener(l -> f.loadImage(filePickerLoad.getSelectedFilePath()));
    this.borderButton.addActionListener(l -> {
      enhance = true;
      int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the Border Size:"));
      borderImage(size);
    });

    this.reSizeButton.addActionListener(l -> {
      enhance = true;
      int height = Integer.parseInt(JOptionPane.showInputDialog("Enter the height:"));
      int width = Integer.parseInt(JOptionPane.showInputDialog("Enter the width:"));

      image = resize(image, width, height);
      imgLabel.setIcon(new ImageIcon(image));
      imgLabel.repaint();
      try {
        ImageIO.write(image, "png",
            new File("C:/Users/Kishan/eclipse-workspace/HW6/res/RED-EYE-GIRL-resize.png"));
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    });

    this.stickerButton.addActionListener(l -> {
      enhance = true;
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setCurrentDirectory(new File("C:/Users/Kishan/eclipse-workspace/HW6/res/"));

      if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

        BufferedImage sticker;
        try {
          sticker = ImageIO.read(new File(fileChooser.getSelectedFile().getAbsolutePath()));
          sticker = transImage(sticker);
          sticker = resize(sticker, image.getHeight() / 3, image.getHeight() / 3);
          appendImage(sticker, (image.getWidth() - sticker.getWidth()) / 2, 0);
        } catch (IOException e) {
          this.displayErrorMessage("Wrong Input");
          e.printStackTrace();
        }

        try {
          ImageIO.write(image, "jpg",
              new File("C:/Users/Kishan/eclipse-workspace/HW6/res/sam-original-STICKER.jpg"));
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

      }
    });

    this.memeButton.addActionListener(l -> {
      enhance = true;
      String top = JOptionPane.showInputDialog("Enter the Top Meme Text:");
      String bottom = JOptionPane.showInputDialog("Enter the Bottom Meme Text:");
      int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the Text size:"));

      BufferedImage meme = drawImage(top, size);

      appendImage(meme, (image.getWidth() - meme.getWidth()) / 2, 10);

      BufferedImage meme1 = drawImage(bottom, size);

      appendImage(meme1, (image.getWidth() - meme1.getWidth()) / 2,
          image.getHeight() - meme1.getHeight());

      try {
        ImageIO.write(image, "jpg",
            new File("C:/Users/Kishan/eclipse-workspace/HW6/res/sam-original-meme.jpg"));
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    });

  }

  /**
   * Sets the image.
   *
   * @param file the new image
   */
  @Override
  public void setImage(BufferedImage file) {
    // imgLabel = new JLabel(new ImageIcon(file), SwingConstants.CENTER);
    image = file;
    final BufferedImage screen = file;

    imagePanel.setSize(new Dimension(file.getWidth(), file.getHeight()));

    imgLabel.setIcon(new ImageIcon(screen));

    this.createDrag();
    // this.add(imgLabel, BorderLayout.CENTER);

  }

  public void writeImage(String file) {
    try {
      Icon ico = imgLabel.getIcon();
      BufferedImage bimg = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(),
          BufferedImage.TYPE_INT_RGB);
      RenderedImage rendImage = image;
      ImageIO.write(image, file.substring(file.lastIndexOf(".")), new File(file));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void borderImage(int size) {
    Graphics2D g = (Graphics2D) image.getGraphics();
    g.setStroke(new BasicStroke(size));
    g.setColor(Color.black);
    g.drawRect(10, 10, image.getWidth() - 20, image.getHeight() - 20);
    g.dispose();
    imgLabel.repaint();
    try {
      ImageIO.write(image, "jpg",
          new File("C:/Users/Kishan/eclipse-workspace/HW6/res/sam-original-border.jpg"));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  /**
   * Drag image.
   *
   * @param screen the screen
   */
  private BufferedImage drawImage(String text, int size) {

    BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = img.createGraphics();
    Font font = new Font("Impact", Font.PLAIN, size);

    g2d.setFont(font);
    FontMetrics fm = g2d.getFontMetrics();
    int width = fm.stringWidth(text);
    int height = fm.getHeight();
    g2d.dispose();

    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    g2d = img.createGraphics();
    g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
        RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
        RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
    g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
        RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    g2d.setFont(font);
    fm = g2d.getFontMetrics();
    g2d.setColor(Color.WHITE);
    g2d.drawString(text, 0, fm.getAscent());
    g2d.dispose();

    return img;

  }

  public void appendImage(BufferedImage img, int x, int y) {
    Graphics2D g = image.createGraphics();
    g.drawImage(img, x, y, null);
  }

  public static BufferedImage resize(BufferedImage img, int newW, int newH) {
    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2d = dimg.createGraphics();
    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();

    return dimg;
  }

  /**
   * Display error message.
   *
   * @param errorMessage the error message
   */
  // Open a popup that contains the error message passed
  @Override
  public void displayErrorMessage(String errorMessage) {

    JOptionPane.showMessageDialog(this, errorMessage);

  }

  public BufferedImage transImage(BufferedImage source) {

    final int color = source.getRGB(0, 0);

    final Image imageWithTransparency = makeColorTransparent(source, new Color(color));

    final BufferedImage transparentImage = imageToBufferedImage(imageWithTransparency);

    return transparentImage;
  }

  /**
   * Convert Image to BufferedImage.
   *
   * @param image Image to be converted to BufferedImage.
   * @return BufferedImage corresponding to provided Image.
   */
  private static BufferedImage imageToBufferedImage(final Image image) {
    final BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
        image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    final Graphics2D g2 = bufferedImage.createGraphics();
    g2.drawImage(image, 0, 0, null);
    g2.dispose();
    return bufferedImage;
  }

  /**
   * Make provided image transparent wherever color matches the provided color.
   *
   * @param im    BufferedImage whose color will be made transparent.
   * @param color Color in provided image which will be made transparent.
   * @return Image with transparency applied.
   */
  public static Image makeColorTransparent(final BufferedImage im, final Color color) {
    final ImageFilter filter = new RGBImageFilter() {
      // the color we are looking for (white)... Alpha bits are set to opaque
      public int markerRGB = color.getRGB() | 0xFFFFFFFF;

      public final int filterRGB(final int x, final int y, final int rgb) {
        if ((rgb | 0xFF000000) == markerRGB) {
          // Mark the alpha bits as zero - transparent
          return 0x00FFFFFF & rgb;
        } else {
          // nothing to do
          return rgb;
        }
      }
    };

    final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
    return Toolkit.getDefaultToolkit().createImage(ip);
  }

  /**
   * Repaint.
   *
   * @param orig the orig
   * @param copy the copy
   */
  private void repaint(BufferedImage orig, BufferedImage copy) {
    Graphics2D g = copy.createGraphics();
    g.drawImage(orig, 0, 0, null);
    if (captureRect != null) {
      g.setColor(Color.RED);
      g.draw(captureRect);
      g.setColor(new Color(255, 255, 255, 150));
      g.fill(captureRect);
    }
    g.dispose();
  }

  public void createDrag() {
    BufferedImage screen = image;
    final BufferedImage screenCopy = new BufferedImage(screen.getWidth(), screen.getHeight(),
        screen.getType());
    imgLabel.setIcon(new ImageIcon(screenCopy));

    scroller
        .setPreferredSize(new Dimension((int) (screen.getWidth()), (int) (screen.getHeight())));
    // mainContainer.add(scroller);
    // this.add(imgLabel, BorderLayout.CENTER);
    // this.add(scroller, BorderLayout.CENTER);

    repaint(screen, screenCopy);
    this.pack();
    imgLabel.repaint();

    imgLabel.addMouseMotionListener(new MouseMotionAdapter() {

      Point start = new Point();

      @Override
      public void mouseMoved(MouseEvent me) {

        start = me.getPoint();

        repaint(screen, screenCopy);
        imgLabel.repaint();

      }

      @Override
      public void mouseDragged(MouseEvent me) {
        Point end = me.getPoint();
        captureRect = new Rectangle(start, new Dimension(end.x - start.x, end.y - start.y));
        repaint(screen, screenCopy);
        imgLabel.repaint();
      }
    });

    // JOptionPane.showMessageDialog(null, imgLabel);
  }

}
