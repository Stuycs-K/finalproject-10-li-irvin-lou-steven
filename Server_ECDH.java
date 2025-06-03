import java.io.*;
import java.net.*;
import java.math.BigInteger;

public class Server_ECDH {
    public static BigInteger a;
    public static BigInteger b;
    public static BigInteger prime;
    public static BigInteger x_initial;
    public static BigInteger y_initial;
    public static BigInteger order;
    public static Point initial;
    public static void main(String[] args) throws Exception {
        String message = "This is a test.";

        if (args.length == 0) {
            a = new BigInteger("0");
            b = new BigInteger("7");
            prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            x_initial = new BigInteger("79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", 16);
            y_initial = new BigInteger("483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
            order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
        }
        else if(args[0].equals("secp256k1")) {
            a = new BigInteger("0");
            b = new BigInteger("7");
            prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            x_initial = new BigInteger("79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", 16);
            y_initial = new BigInteger("483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
            order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
        }
        else if(args[0].equals("secp256r1")) {
            a = new BigInteger("ffffffff00000001000000000000000000000000fffffffffffffffffffffffc", 16);
            b = new BigInteger("5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16);
            prime = new BigInteger("ffffffff00000001000000000000000000000000ffffffffffffffffffffffff", 16);
            x_initial = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
            y_initial = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
            order = new BigInteger("ffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551", 16);
        }
        initial = new Point(x_initial, y_initial);
        Operations selectedCurve = new Operations();
        selectedCurve.updateCurveParam(a,b,prime,x_initial,y_initial,order,initial);

        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Server started, waiting for client...");

        //Waiting for connection
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        //Recieves objects through socket
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        // Read the signed object and public key
        Sign signature = (Sign) in.readObject();
        Point publicKey = (Point) in.readObject();

        System.out.println("Received:");
        System.out.println(signature);
        System.out.println("Public Key: " + publicKey);

        // Verify
        boolean isValid = Verify.verify(signature, publicKey, initial, order, prime);

        System.out.println("Signature valid? " + isValid);

        //Generate Keypair
        KeyPair keypair = Keygen.genKeyPair(initial, order, prime);

        // Signature
        signature = Signing.sign(message, keypair.getprivate_key(), initial, order, prime);

        //Send Signature and Keypair
        out.writeObject(signature);
        out.writeObject(keypair.getpublic_key());

        //Flush
        out.flush();

        // while (in.readObject() == null) {
        //     // Read the signed object and public key
        //     Sign signature = (Sign) in.readObject();
        //     Point publicKey = (Point) in.readObject();

        //     System.out.println("Received:");
        //     System.out.println(signature);
        //     System.out.println("Public Key: " + publicKey);

        //     // Verify
        //     boolean isValid = Verify.verify(signature, publicKey, initial, order, prime);

        //     System.out.println("Signature valid? " + isValid);

        //     //Generate Keypair
        //     KeyPair keypair = Keygen.genKeyPair(initial, order, prime);

        //     // Signature
        //     signature = Signing.sign(message, keypair.getprivate_key(), initial, order, prime);

        //     //Send Signature and Keypair
        //     out.writeObject(signature);
        //     out.writeObject(keypair.getpublic_key());

        //    //End connection
        //    out.writeObject(null);

        //    //Receive end connection
        //    in.readObject();
        // }

        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
}