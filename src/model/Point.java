package model;

/**
 * The Class Point represents x,y coordinates of Image.
 */
public class Point {

  /** The x. */
  private final int x;

  /** The y. */
  private final int y;

  /**
   * Instantiates a new coordinates.
   *
   * @param x the x
   * @param y the y
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets the x.
   *
   * @return the x
   */
  public int getX() {
    return (x);
  }

  /**
   * Gets the y.
   *
   * @return the y
   */
  public int getY() {
    return (y);
  }

  public String toString() {
    return "[" + this.getX() + "," + this.getY() + "]";

  }
}
