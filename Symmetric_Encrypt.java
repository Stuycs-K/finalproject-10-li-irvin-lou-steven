import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.math.BigInteger;
import java.io.IOException;

public class Symmetric_Encrypt {
    public static String salt = "thisisasalt";
    public static void main(String[] args) {
        String result = "aonsdiubqwdoasid";
        System.out.println(result);
        byte[] bytes = "aonsdiubqwdoasid".getBytes();
        bytes = encrypt_xor(new BigInteger("28974327948276394826873649823746927823482731238176312831234"), bytes);
        System.out.println(new String(bytes));
        bytes = encrypt_xor(new BigInteger("28974327948276394826873649823746927823482731238176312831234"), bytes);
        System.out.println(new String(bytes));
    }
    public static byte[] key_derivation_func(BigInteger key, int keylength) {
        String result_encode = "";
        //Key length is the smallest multiple of 256 greater than it (bit length)
        int repeat = keylength/256 + 1;
        String[] hashes = new String[repeat];
        for (int i = 0; i < repeat; i++) {
            if (i == 0) {
                hashes[0] = Signing.sha_256_hash(key.toString());
            } else {
                hashes[i] = Signing.sha_256_hash(hashes[i-1]);
            }
        }
        for (int i = 0; i < repeat; i++) {
            result_encode += hashes[i];
        }
        return HexFormat.of().parseHex(result_encode);
    }
    public static byte[] encrypt_xor(BigInteger key, byte[] bytes) {
        byte[] bytes1 = key_derivation_func(key, bytes.length * 8);
        byte[] xor_bytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            xor_bytes[i] = (byte) (bytes1[i] ^ bytes[i]);
        }
        return xor_bytes;
    }
    public static String StringtoHex(String message) {
        return HexFormat.of().formatHex(message.getBytes());
    }
    public static String HextoString(String hex) {
        return new String(HexFormat.of().parseHex(hex));
    }
}