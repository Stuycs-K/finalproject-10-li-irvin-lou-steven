import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.math.BigInteger;
import java.io.IOException;


public class Signing {
    public static void main(String[] args) {
      System.out.println(sign("IAMIRVIN.", new BigInteger("9813478"), Operations.initial, Operations.order, Operations.prime));
    }

    public static Sign sign(String message, BigInteger private_key, Point InitialPoint, BigInteger order, BigInteger prime) {
        String message_hash_hex = sha_256_hash(message);
        BigInteger integer_hash = new BigInteger(message_hash_hex, 16);
        BigInteger z = integer_hash;
        z = z.shiftRight(z.bitLength() - order.bitLength());
        BigInteger r = new BigInteger("0");
        BigInteger s = new BigInteger("0");
        while(r.equals(new BigInteger("0")) || s.equals(new BigInteger("0"))) {
          BigInteger rand_int = new BigInteger("0");
          try {
            rand_int = Keygen.getRandomBigInteger(order.bitLength());
          } catch (IOException e) {
            e.printStackTrace();
          }
          Point rand_point = Operations.point_multiplication(InitialPoint, rand_int, prime);
          r = rand_point.getX().mod(order);
          s = rand_int.modInverse(order).multiply(z.add(r.multiply(private_key)));
        }
        Point result = new Point(r,s);
        return new Sign(message_hash_hex, result);
    }
    
    public static String sha_256_hash(String input) {
      try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedbytes = md.digest((input.getBytes(StandardCharsets.UTF_8)));
        return HexFormat.of().formatHex(hashedbytes);
      } catch (NoSuchAlgorithmException e) {
        return null;
      }
    }
}
