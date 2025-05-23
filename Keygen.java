import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class Keygen {

    public static BigInteger getRandom256bit() throws IOException {
        try (FileInputStream urandom = new FileInputStream("/dev/urandom")) {
            byte[] bytes = new byte[32];
            int read = urandom.read(bytes);
            if (read != 32) {
                throw new IOException("Expected 32 bytes, got " + read);
            }
            return new BigInteger(1, bytes); // Ensure it's positive
        }
    }

    public static BigInteger getRandomBigInteger(int size) throws IOException {
        try (FileInputStream urandom = new FileInputStream("/dev/urandom")) {
            byte[] bytes = new byte[size/4]; // 256 bits = 32 bytes
            int read = urandom.read(bytes);
            if (read != (size/4)) {
                throw new IOException("Expected 32 bytes, got " + read);
            }
            return new BigInteger(1, bytes); // Ensure it's positive
        }
    }

    public static KeyPair genKeyPair(Point point1, BigInteger order, BigInteger prime) throws IOException {
        BigInteger private_key;
        do {
            private_key = getRandomBigInteger(256);
        } while (private_key.equals(BigInteger.ZERO));
        Point public_key = Operations.point_multiplication(point1, private_key, prime);
        return new KeyPair(private_key, public_key);
    }
    //Testing
     public static void main(String[] args) {
        try {
            BigInteger randomNumber = getRandomBigInteger(256);
            System.out.println("Random 256-bit number (hex):");
            System.out.println(randomNumber.toString(16));
            BigInteger prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            BigInteger x_initial = new BigInteger("55066263022277343669578718895168534326250603453777594175500187360389116729240");
            BigInteger y_initial = new BigInteger("32670510020758816978083085130507043184471273380659243275938904335757337482424");
            BigInteger order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
            Point initial = new Point(x_initial, y_initial);
            KeyPair kp_test = genKeyPair(initial, order, prime);
            System.out.println("Private key: \n" + kp_test.getprivate_key() + "\n" + kp_test.getprivate_key().toString(16));
            System.out.println("Public Key: \n" + kp_test.getpublic_key().getX() + "\n" + kp_test.getpublic_key().getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
