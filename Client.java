import java.io.*;
import java.net.*;
import java.math.BigInteger;

public class Client {
    public static void main(String[] args) throws Exception {
        String message = "Test message from client";

        // KeyGen
        KeyPair keypair = Keygen.genKeyPair(Driver.initial, Driver.order, Driver.prime);

        // Signature
        Sign signature = Signing.sign(message, keypair.getprivate_key(), Driver.initial, Driver.order, Driver.prime);
        //Connecting to server
        Socket socket = new Socket("localhost", 5000);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        out.writeObject(signature);
        out.writeObject(keypair.getpublic_key());

        out.close();
        socket.close();
    }
}