import java.io.*;
import java.net.*;
import java.math.BigInteger;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server started, waiting for client...");

        //Waiting for connection
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        //Recieves objects through socket
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        // Read the signed object and public key
        Sign signature = (Sign) in.readObject();
        Point publicKey = (Point) in.readObject();

        System.out.println("Received:");
        System.out.println(signature);

        // Verify
        boolean isValid = Verify.verify(signature, publicKey, Driver.initial, Driver.order, Driver.prime);

        System.out.println("Signature valid? " + isValid);
        if(isValid) {
            System.out.println("Message: " + signature.get_hash());
        }

        in.close();
        socket.close();
        serverSocket.close();
    }
}