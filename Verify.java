import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;
import java.io.IOException;

public class Verify {
    public static void main(String[] args) {
      System.out.println(verify(Signing.sign("IAMIRVIN.", new BigInteger("5830281761191497914681290730151843179119436888170205717348071086140947559234830193590977775324572804715950199877669391939229733916920847219287396712657258"), Operations.initial, Operations.order, Operations.prime), new Point(new BigInteger("86406428787158544788620393735282884716252329420531489836665676201268957523289"), new BigInteger("28656466618830092348835397940183658082180739771573180601351299474497517676429")), Operations.initial, Operations.order, Operations.prime));
    }

    public static boolean verify(Sign signature, Point public_key, Point InitialPoint, BigInteger order, BigInteger prime) {
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
      BigInteger s_inverse = s.modInverse(order);
      BigInteger u1 = z.multiply(s_inverse).mod(order);
      BigInteger u2 = r.multiply(s_inverse).mod(order);
      Point result = Operations.point_multiplication(InitialPoint, u1, prime).add(Operations.point_multiplication(public_key, u2, prime));
      System.out.println(r);
      System.out.println(result);
      return result.getX().equals(r);
    }
}