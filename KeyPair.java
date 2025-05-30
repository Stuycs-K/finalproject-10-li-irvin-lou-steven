import java.math.BigInteger;

public class KeyPair {
  private BigInteger privateKey;
  private Point publicKey;

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