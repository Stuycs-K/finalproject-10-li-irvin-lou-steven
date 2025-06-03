import java.io.Serializable;
import java.math.BigInteger;

public class Sign implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message_hash;
    private Point signature;

    public Sign(String message_hash, Point signature) {
        this.message_hash = message_hash;
        this.signature = signature;
    }

    public String get_hash() {
      return message_hash;
    }

    public Point get_signature() {
      return signature;
    }

    public String toString() {
        return "Message Hash: " + message_hash + "\n" + "Signature: " + signature;
    }

}
