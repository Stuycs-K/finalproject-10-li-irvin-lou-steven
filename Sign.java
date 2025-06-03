import java.io.Serializable;
import java.math.BigInteger;

public class Sign implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private Point signature;

    public Sign(String message, Point signature) {
        this.message = message;
        this.signature = signature;
    }

    public String get_message() {
      return message;
    }

    public Point get_signature() {
      return signature;
    }

    public String toString() {
        return "Message: " + message + "\n" + "Signature: " + signature;
    }

}
