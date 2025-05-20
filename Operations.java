import java.math.BigInteger;

public class Operations {
  public static void main(String[] args) {

  }
  public static Point point_addition(Point Point1, Point Point2, BigInteger prime) {
    boolean p1_inf = Point.isPointAtInfinity(Point1);
    boolean p2_inf = Point.isPointAtInfinity(Point2);

    if(p1_inf && p2_inf) {
      throw new IllegalArgumentException("Both points are at infinity; no finite sum");
    }
    else if(p1_inf) {
      return Point2;
    } 
    else if(p2_inf) {
      return Point1;
    }

    if (Point1.getX().equals(Point2.getX())) {
        if (Point1.getY().equals(Point2.getY().negate().mod(prime))) {
            throw new IllegalArgumentException("Sum is point at infinity, not allowed.");
        } else {
            throw new IllegalArgumentException("Addition undefined for identical x with y != -y mod p");
        }
    }
    return Point1;
  }
}