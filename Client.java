import java.io.*;
import java.net.*;
import java.util.HexFormat;
import java.util.Scanner;
import java.math.BigInteger;

public class Client {
    public static BigInteger a;
    public static BigInteger b;
    public static BigInteger prime;
    public static BigInteger x_initial;
    public static BigInteger y_initial;
    public static BigInteger order;
    public static Point initial;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter message");
        String message = scan.nextLine();
        scan.close();

        // KeyGen
        if (args.length <=1 || !args[0].equals("-t")) {
            a = new BigInteger("0");
            b = new BigInteger("7");
            prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            x_initial = new BigInteger("79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", 16);
            y_initial = new BigInteger("483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
            order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
        }
        else if(args[1].equals("secp256k1")) {
            a = new BigInteger("0");
            b = new BigInteger("7");
            prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            x_initial = new BigInteger("79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", 16);
            y_initial = new BigInteger("483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
            order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
        }
        else if(args[1].equals("secp256r1")) {
            a = new BigInteger("ffffffff00000001000000000000000000000000fffffffffffffffffffffffc", 16);
            b = new BigInteger("5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16);
            prime = new BigInteger("ffffffff00000001000000000000000000000000ffffffffffffffffffffffff", 16);
            x_initial = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
            y_initial = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
            order = new BigInteger("ffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551", 16);
        }
        else {
            a = new BigInteger("0");
            b = new BigInteger("7");
            prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            x_initial = new BigInteger("79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", 16);
            y_initial = new BigInteger("483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
            order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
        }
        initial = new Point(x_initial, y_initial);
        Operations selectedCurve = new Operations();
        selectedCurve.updateCurveParam(a,b,prime,x_initial,y_initial,order,initial);
        if(args.length == 4) {
            if(args[2].equals("-e")) {
                if(args[3].toLowerCase().equals("ecdh")){
                    //Connecting to server
                    Socket socket = new Socket("localhost", 5050);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                    //Generate Keypair
                    KeyPair keypair = Keygen.genKeyPair(initial, order, prime);

                    // Signature
                    Sign signature = Signing.sign(message, keypair.getprivate_key(), initial, order, prime);

                    //Send Signature and Keypair
                    out.writeObject(signature);
                    out.writeObject(keypair.getpublic_key());

                    //Flush
                    out.flush();

                    // Read the signed object and public key
                    signature = (Sign) in.readObject();
                    Point publicKey = (Point) in.readObject();

                    System.out.println("Received:");
                    System.out.println(signature);
                    System.out.println("Public Key: " + publicKey);

                    // Verify
                    boolean isValid = Verify.verify(signature, publicKey, initial, order, prime);

                    System.out.println("Signature valid? " + isValid);

                    //Send message
                    System.out.println("Message: " + args[0]);

                    Point sym_key = selectedCurve.point_multiplication(publicKey, keypair.getprivate_key(), prime);
                    System.out.println("Symmetric key: " + sym_key);

                    String salted_message = args[0] + Symmetric_Encrypt.salt;
                    byte[] encrypted = Symmetric_Encrypt.encrypt_xor(sym_key.getX(), salted_message.getBytes());
                    String hexMessage = HexFormat.of().formatHex(encrypted);
                    
                    OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
                    os.write(hexMessage);

                    //Flush
                    os.flush();

                    //Print hexmessage
                    System.out.println("Sent: " + hexMessage);

                    // while (in.readObject() != null) {
                    //     //Generate Keypair
                    //     KeyPair keypair = Keygen.genKeyPair(initial, order, prime);

                    //     // Signature
                    //     Sign signature = Signing.sign(message, keypair.getprivate_key(), initial, order, prime);

                    //     //Send Signature and Keypair
                    //     out.writeObject(signature);
                    //     out.writeObject(keypair.getpublic_key());

                    //     // Read the signed object and public key
                    //     signature = (Sign) in.readObject();
                    //     Point publicKey = (Point) in.readObject();

                    //     System.out.println("Received:");
                    //     System.out.println(signature);
                    //     System.out.println("Public Key: " + publicKey);

                    //     // Verify
                    //     boolean isValid = Verify.verify(signature, publicKey, initial, order, prime);

                    //     System.out.println("Signature valid? " + isValid);

                    //     //Listen to end connection
                    //     in.readObject();
                    // }

                    // //End connection
                    // out.writeObject(null);
                    in.close();
                    out.close();
                    socket.close();
                }
            }
        }
        else {
                    KeyPair keypair = Keygen.genKeyPair(initial, order, prime);

                    // Signature
                    Sign signature = Signing.sign(message, keypair.getprivate_key(), initial, order, prime);
                    //Connecting to server
                    Socket socket = new Socket("localhost", 5050);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                    out.writeObject(signature);
                    out.writeObject(keypair.getpublic_key());
                    out.close();
                    socket.close();
        }
    }
}