import java.math.BigInteger;

public class Point {
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
    return (p.getX() == null || p.getY() == null);
  }

  //Test//
  public static void main(String[] args) {
    // Point dot = new Point(3.4, 3.5);
    // System.out.println(dot.getX());
    // System.out.println(dot.getY());
  }
}
