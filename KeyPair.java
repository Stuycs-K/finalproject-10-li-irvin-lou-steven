import java.math.BigInteger;

public class KeyPair {
  public final BigInteger privateKey;
  public final Point publicKey;

  public KeyPair(BigInteger privateKey, Point publicKey) {
      this.privateKey = privateKey;
      this.publicKey = publicKey;
  }

  public BigInteger getprivate_key() {
    return this.privateKey;
}
  public Point getpublic_key() {
    return this.publicKey;
  }
}