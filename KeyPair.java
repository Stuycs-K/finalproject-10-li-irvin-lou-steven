import java.math.BigInteger;

public class KeyPair {
    public final BigInteger privateKey;
    public final Point publicKey;

    public KeyPair(BigInteger privateKey, Point publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }
}