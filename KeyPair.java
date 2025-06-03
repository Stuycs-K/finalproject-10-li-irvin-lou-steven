import java.io.Serializable;
import java.math.BigInteger;

public class KeyPair implements Serializable {
  private static final long serialVersionUID = 1L;
  private BigInteger privateKey;
  public Point publicKey;

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