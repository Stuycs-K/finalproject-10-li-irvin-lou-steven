import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;
import java.io.IOException;

public class Verify {
    public static void main(String[] args) {
        //System.out.println(Signing.sign("IAMIRVIN.", new BigInteger("5830281761191497914681290730151843179119436888170205717348071086140947559234830193590977775324572804715950199877669391939229733916920847219287396712657258"), Operations.initial, Operations.order, Operations.prime));
        System.out.println(verify(Signing.sign("IAMIRVIN.", new BigInteger("5830281761191497914681290730151843179119436888170205717348071086140947559234830193590977775324572804715950199877669391939229733916920847219287396712657258"), Operations.initial, Operations.order, Operations.prime), new Point(new BigInteger("86406428787158544788620393735282884716252329420531489836665676201268957523289"), new BigInteger("28656466618830092348835397940183658082180739771573180601351299474497517676429")), Operations.initial, Operations.order, Operations.prime));
    }

    public static boolean verify(Sign signature, Point public_key, Point InitialPoint, BigInteger order, BigInteger prime) {
      //Check if the given elliptic curve parameters meet the designated requirements
      if (InitialPoint.isInfinity()) {
        return false;
      }
      BigInteger initial_y = InitialPoint.getY();
      BigInteger checkValue1 = initial_y.modPow(new BigInteger("2"), Operations.prime);
      BigInteger initial_x = InitialPoint.getX();
      BigInteger checkValue2 = initial_x.modPow(new BigInteger("3"), Operations.prime).add(Operations.a.multiply(initial_x)).add(Operations.b).mod(prime);
      if (!checkValue1.equals(checkValue2)) {
        return false;
      }
      Point checkPoint = Operations.point_multiplication(InitialPoint, order, prime);
      if (!checkPoint.isInfinity()) {
        return false;
      }
      //u1 = hash * s^(-1) mod order
      //u2 = r * s^(-1) mod order
      //X = u1 * G + u2 * public
      //Check X=r
      BigInteger integer_hash = new BigInteger(signature.get_hash(), 16);
      BigInteger z = integer_hash;
      z = z.shiftRight(z.bitLength() - order.bitLength());
      Point point_signature = signature.get_signature();
      BigInteger r = point_signature.getX();
      BigInteger s = point_signature.getY();
      // System.out.println(r);
      // System.out.println(s);
      // System.out.println(order);
      if (r.compareTo(new BigInteger("1")) == -1 || r.compareTo(order) >= 0) {
        return false;
      }
      if (s.compareTo(new BigInteger("1")) == -1 || s.compareTo(order) >= 0) {
        return false;
      }
      BigInteger s_inverse = s.modInverse(order);
      BigInteger u1 = z.multiply(s_inverse).mod(order);
      BigInteger u2 = r.multiply(s_inverse).mod(order);
      Point result = Operations.point_addition(Operations.point_multiplication(InitialPoint, u1, prime), (Operations.point_multiplication(public_key, u2, prime)), prime);
      //System.out.println(r);
      //System.out.println(result);
      return result.getX().equals(r);
    }
}