import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class Keygen {

    public static BigInteger getRandomBigInteger() throws IOException {
        try (FileInputStream urandom = new FileInputStream("/dev/urandom")) {
            byte[] bytes = new byte[32]; // 256 bits = 32 bytes
            int read = urandom.read(bytes);
            if (read != 32) {
                throw new IOException("Expected 32 bytes, got " + read);
            }
            return new BigInteger(1, bytes); // Ensure it's positive
        }
    }
}