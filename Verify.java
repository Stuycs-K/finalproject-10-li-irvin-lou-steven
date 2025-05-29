import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;
import java.io.IOException;

public class Verify {
    public static void main(String[] args) {
      System.out.println(verify(Signing.sign("IAMIRVIN.", new BigInteger("9813478"), Operations.initial, Operations.order, Operations.prime)));
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
      Point result = Operations.point_multiplication(InitialPoint, u1, prime).add(Operations.point_multiplication(InitialPoint, u2, prime));
      return result.getX().equals(r);
    }
}
