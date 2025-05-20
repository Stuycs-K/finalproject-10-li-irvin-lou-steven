import java.math.BigInteger;

public class Point {
  BigInteger x;
  BigInteger y;
  public Point(BigInteger x, BigInteger y) {
    this.x = x;
    this.y = y;
  }
  public BigInteger getX() {
    return this.x;
  }
  public BigInteger getY() {
    return this.y;
  }
  public static void main(String[] args) {
    Point dot = new Point(3.4, 3.5);
    System.out.println(dot.getX());
    System.out.println(dot.getY());
  }
}
