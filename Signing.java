package org.web3j.crypto;

import static java.nio.charset.StandardCharsets.UTF_8;
import org.web3j.crypto.Hash;
import java.math.BigInteger;


public class Signing {
    public static Sign sign(String message, BigInteger private_key, Point InitialPoint, BigInteger order, BigInteger prime) {
        String message_hash_hex = /*keccak256*/(message);

        return new Sign();
    }
}
