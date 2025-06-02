
import java.math.BigInteger;
public class Driver{
    public static BigInteger a;
    public static BigInteger b;
    public static BigInteger prime;
    public static BigInteger x_initial;
    public static BigInteger y_initial;
    public static BigInteger order;
    public static Point initial;
    public static void main(String[] args) {
        if(args.length < 3) {
            System.err.println("Not valid arg length");
        }
        if(args[1].equals("secp256k1")) {
            a = new BigInteger("0");
            b = new BigInteger("7");
            prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            x_initial = new BigInteger("0x79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", 16);
            y_initial = new BigInteger("0x483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
            order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
        }
        else if(args[1].equals("secp256r1")) {
            a = new BigInteger("0xffffffff00000001000000000000000000000000fffffffffffffffffffffffc", 16);
            b = new BigInteger("0x5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16);
            prime = new BigInteger("0xffffffff00000001000000000000000000000000ffffffffffffffffffffffff", 16);
            x_initial = new BigInteger("0x6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
            y_initial = new BigInteger("0x4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
            order = new BigInteger("0xffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551", 16);
        }
        else{
            a = new BigInteger("0");
            b = new BigInteger("7");
            prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            x_initial = new BigInteger("0x79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", 16);
            y_initial = new BigInteger("0x483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
            order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
        }
        initial = new Point(x_initial, y_initial);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("prime: " + prime);
        System.out.println("x_initial: " + x_initial);
        System.out.println("y_initial: " + y_initial);
        System.out.println("order: " + order);
    }
 }


