import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Driver{
    public static BigInteger a;
    public static BigInteger b;
    public static BigInteger prime;
    public static BigInteger x_initial;
    public static BigInteger y_initial;
    public static BigInteger order;
    public static Point initial;
    public static void main(String[] args) throws IOException {
       /* if(args.length < 3) {
            System.err.println("Not valid arg length");
        }
*/        if(args[0].equals("secp256k1")) {
            a = new BigInteger("0");
            b = new BigInteger("7");
            prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            x_initial = new BigInteger("79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", 16);
            y_initial = new BigInteger("483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
            order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
        }
        else if(args[0].equals("secp256r1")) {
            a = new BigInteger("ffffffff00000001000000000000000000000000fffffffffffffffffffffffc", 16);
            b = new BigInteger("5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16);
            prime = new BigInteger("ffffffff00000001000000000000000000000000ffffffffffffffffffffffff", 16);
            x_initial = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
            y_initial = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
            order = new BigInteger("ffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551", 16);
        }
        else{
            a = new BigInteger("0");
            b = new BigInteger("7");
            prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            x_initial = new BigInteger("79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", 16);
            y_initial = new BigInteger("483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
            order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
        }
        initial = new Point(x_initial, y_initial);
        Operations selectedCurve = new Operations();
        selectedCurve.updateCurveParam(a,b,prime,x_initial,y_initial,order,initial);
        KeyPair key1 = Keygen.genKeyPair(initial, order, prime);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter message");
        String message = scan.nextLine();
        scan.close();
        Sign signature = Signing.sign(message, key1.getprivate_key(), initial, order, prime);
        System.out.println("Private Key: " + key1.getprivate_key());
        System.out.println("Public Key: " + key1.getpublic_key());
        System.out.println(signature);
        System.out.println("Verify: " + Verify.verify(signature, key1.getpublic_key(), initial, order, prime));
        /*
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("prime: " + prime);
        System.out.println("x_initial: " + x_initial);
        System.out.println("y_initial: " + y_initial);
        System.out.println("order: " + order);
        */
    }
 }
