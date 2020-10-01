package view;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * The Class FileTypeFilter represents filter for fileChooser class. It applies
 * filter on the type of file user can select.
 */
public class FileTypeFilter extends FileFilter implements java.io.FileFilter {

  /** The extension. */
  private String extension;

  /** The description. */
  private String description;

  /**
   * Instantiates a new file type filter.
   *
   * @param extension   the extension
   * @param description the description
   */
  public FileTypeFilter(String extension, String description) {
    this.extension = extension;
    this.description = description;
  }

  /**
   * Accept.
   *
   * @param file the file
   * @return true, if successful
   */
  @Override
  public boolean accept(File file) {
    if (file.getName().toLowerCase().endsWith(extension)) {
      return true;
    }

    return (file.isDirectory());
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description + String.format(" (*%s)", extension);
  }
}