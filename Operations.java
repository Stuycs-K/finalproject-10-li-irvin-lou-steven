import java.math.BigInteger;

public class Operations {
  //Elliptic Curve Parameters (default set to secp256k1)
  //We are moving this operation into the driver file when we are done with eveyrthing else.
  public static BigInteger a;
  public static BigInteger b;
  public static BigInteger prime;
  public static BigInteger x_initial;
  public static BigInteger y_initial;
  public static BigInteger order;
  public static Point initial;

  if(args[2].equals("secp256k1")) {
    a = new BigInteger("0");
    b = new BigInteger("7");
    prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
    x_initial = new BigInteger("0x79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", 16);
    y_initial = new BigInteger("0x483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
    order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
    initial = new Point(x_initial, y_initial);
  }
  else if(args[2].equals("secp256r1")) {
    a = new BigInteger("0xffffffff00000001000000000000000000000000fffffffffffffffffffffffc", 16);
    b = new BigInteger("0x5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16);
    prime = new BigInteger("0xffffffff00000001000000000000000000000000ffffffffffffffffffffffff", 16);
    x_initial = new BigInteger("0x6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
    y_initial = new BigInteger("0x4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
    order = new BigInteger("0xffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551", 16);
  }
  public static void main(String[] args) {
    System.out.println(initial);
    System.out.println(point_addition(initial, initial, prime));
    System.out.println(point_addition(initial, initial, prime).toHexString());
    System.out.println(point_multiplication(initial, order, prime));
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

    BigInteger slope;
    if (Point1.getX().equals(Point2.getX())) {
        if (Point1.getY().equals(Point2.getY().negate().mod(prime))) {
            return new Point();
        } else {
            //Slope = (3x1^2+a) * (2y^(p-2)) % p
            BigInteger exp1 = new BigInteger("3").multiply(Point1.getX().modPow(new BigInteger("2"), prime)).add(a);
            BigInteger exp2 = (new BigInteger("2")).multiply(Point1.getY()).modPow(prime.subtract(new BigInteger("2")), prime);
            slope = exp1.multiply(exp2).mod(prime);
        }
    } else {
        //Slope = (y2-y1) * (x2-x1)^(p-2) % p
        slope = (Point2.getY().subtract(Point1.getY())).multiply((Point2.getX().subtract(Point1.getX())).modPow(prime.subtract(new BigInteger("2")), prime)).mod(prime);
    }

    //xcor = (slope^2-x1-x2) % p
    BigInteger exp = slope.modPow(new BigInteger("2"), prime).subtract(Point1.getX()).subtract(Point2.getX());
    BigInteger x_final = exp.mod(prime);
    //ycor = (slope*(x1-xcor)-y1) % p
    exp = slope.multiply(Point1.getX().subtract(x_final)).subtract(Point1.getY());
    BigInteger y_final = exp.mod(prime);

    return new Point(x_final, y_final);
  }

  public static Point point_multiplication(Point Point1, BigInteger k, BigInteger prime) {
    Point result = Point1;
    if (k.compareTo(new BigInteger("1")) == 1) {
        if (k.mod(new BigInteger("2")).compareTo(new BigInteger("0")) == 1) {
            return point_addition(Point1, point_multiplication(point_addition(Point1, Point1, prime), k.subtract(new BigInteger("1")).divide(new BigInteger("2")), prime), prime);
        } else {
            return point_multiplication(point_addition(Point1, Point1, prime), k.divide(new BigInteger("2")), prime);
        }
    }
    return result;
    }
}
