import java.util.Scanner;
import java.math.BigInteger;

public class Driver{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter ECC parameters (Invalid will automatically choose secp256k1)");
    String parameter = scan.nextLine();
    if(parameter.equals("secp256k1")) {
      System.out.println("1");
      /*Operations.a = new BigInteger("0");
      Operation.b = new BigInteger("7");
      Operation.prime = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
      Operation.x_initial = new BigInteger("0X79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798", 16);
      Operation.y_initial = new BigInteger("0x483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16);
      Operation.order = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
      Operation.initial = new Point(x_initial, y_initial);*/
    }
    else if(parameter.equals("secp256r1")) {
      System.out.println("2");
      /*
      Operation.a = new BigInteger("0xffffffff00000001000000000000000000000000fffffffffffffffffffffffc", 16);
      Operation.b = new BigInteger("0x5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16);
      Operation.prime = new BigInteger("0xffffffff00000001000000000000000000000000ffffffffffffffffffffffff", 16);
      Operation.x_initial = new BigInteger("0x6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
      Operation.y_initial = new BigInteger("0x4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
      Operation.order = new BigInteger("0xffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551", 16);
  */}
    else if(parameter.equals("secp192k1")) {
      System.out.println("3");
    )
    else if(parameter.equals("secp192r1")) {
      System.out.println("4");
    )
    else if(parameter.equals("secp224k1")) {
      System.out.println("5");
    )
    else if(parameter.equals("secp224r1")) {
      System.out.println("6");
    )
    else if(parameter.equals("secp384r1")) {
      System.out.println("3");
    )
    else if(parameter.equals("secp521r1")) {
      System.out.println("3");
    )
    else {
      System.out.println("1");
    }
    /*
    System.out.println("a: " + a);
    System.out.println("b: " + b);
    System.out.println("prime: " + prime);
    System.out.println("x_intial: " + x_initial);
    System.out.println("y_intial:" + y_initial);
    System.out.println("order: " + order);*/
  }
}
