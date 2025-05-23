import java.math.BigInteger;

public class Sign {
    private String message_hash;
    private Point signature;

    public Sign(String message_hash, Point signature) {
        this.message_hash = message_hash;
        this.signature = signature;
    }
    
}
