import static java.nio.charset.StandardCharsets.UTF_8;
import org.web3j.crypto.Hash;
import java.math.BigInteger;


public class Signing {
    public static Sign sign(String message, BigInteger private_key, Point InitialPoint, BigInteger order, BigInteger prime) {
        String message_hash_hex = /*keccak256*/(message);
        BigInteger integer_hash = new BigInteger(message_hash_hex);
        BigInteger z = integer_hash;
        z = z.shiftRight(z.bitLength() - order.bitLength());
        BigInteger r = new BigInteger("0");
        BigInteger s = new BigInteger("0");
        while(r.equals(new BigInteger("0")) || s.equals(new BigInteger("0"))) {
          BigInteger rand_int = Keygen.getRandomBigInteger(order.bitLength());
          Point rand_point = Operations.point_multiplication(InitialPoint, rand_int, prime);
          r = rand_point.getX().mod(order);
          s = rand_int.modInverse(order).multiply(z.add(r.multiply(private_key)));
        }
        Point result = new Point(r,s);
        return new Sign(message_hash_hex, result);
    }
}
