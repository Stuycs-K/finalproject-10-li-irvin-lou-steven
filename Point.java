import java.io.Serializable;
import java.math.BigInteger;

public class Point implements Serializable {
  private static final long serialVersionUID = 1L;
  //Variables (Coordinates)//
  private BigInteger x;
  private BigInteger y;
  private boolean isInfinity;

  public Point(BigInteger x, BigInteger y) {
    this.x = x;
    this.y = y;
    this.isInfinity = false;
  }

  public Point() {
    this.x = null;
    this.y = null;
    this.isInfinity = true;
  }

  public boolean isInfinity() {
    return isInfinity;
  }
  public BigInteger getX() {
    return this.x;
  }
  public BigInteger getY() {
    return this.y;
  }
  public static boolean isPointAtInfinity(Point p) {
    return p != null && p.isInfinity;
  }

  public String toString() {
    if (!isInfinity) {
      return "(" + this.x.toString() + ", " + this.y.toString() + ")";
    }
    return "Infinity";
  }

  public String toHexString() {
    if (!isInfinity) {
      return "(" + this.x.toString(16) + ", " + this.y.toString(16) + ")";
    }
    return "Infinity";
  }

  //Test//
  public static void main(String[] args) {
    // Point dot = new Point(3.4, 3.5);
    // System.out.println(dot.getX());
    // System.out.println(dot.getY());
  }
}
