[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/am3xLbu5)
# Elliptic Curve Cryptography Implementation
 
### Two Big Guys

Irvin Li, Steven Lou
       
### Project Description:

This project emulates the Elliptic Curve Cryptography (ECC) in order to create keypairs, signatures and verification that will later be tested. This involves a server/client connection where both parties generate cryptographic key pairs and exchange public keys to establish a secure channel.


### Instructions:

The user should run

`make compile`

After, if you simply want to test that verification works for the user,
run 

`make Driver.java ARGS="<either secp256k1 or secp256r1>" or no args for automatic secp256k1.`

To run client/server, open two terminals.

`make server ARGS="-t <elliptical curve parameter> -e (ECDH or EDCSA)"`

`make client ARGS="-t <elliptical curve parameter> -e (ECDH or EDCSA)"`

**Please make sure the args are the same or else it will not work.**

Baseline is secp256k1 and EDCSA.

Once running, if EDCSA, it will only ask the client for a message to encrypt.

If it is ECDH, you will have to type a message for both server and client (can be different messages).

### Video Presentation:
https://drive.google.com/file/d/1tXM53M4pTAcY1oU7jMcvKgWs5oZhFSXX/view?usp=sharing

### Resources/ References:

- https://www.w3schools.com/java/java_user_input.asp
- https://en.wikipedia.org/wiki/Elliptic-curve_cryptography
- https://www.keyfactor.com/blog/elliptic-curve-cryptography-what-is-it-how-does-it-work/
- https://cryptobook.nakov.com/asymmetric-key-ciphers/elliptic-curve-cryptography-ecc
- https://medium.com/@abhiveerhome/building-elliptic-curve-cryptography-ecc-from-scratch-7b28e3b27531
- https://mvnrepository.com/artifact/org.web3j
- https://docs.web3j.io/4.11.0/
- https://docs.web3j.io/latest/getting_started/manual_configuration/
- https://central.sonatype.com/artifact/org.web3j/core/4.8.6
- https://docs.oracle.com/javase/tutorial/networking/sockets/index.html
- https://docs.oracle.com/javase/8/docs/api/java/net/Socket.html
- https://www.geeksforgeeks.org/serialization-and-deserialization-in-java/
- https://tejnaren07.medium.com/ecdsa-vs-rsa-what-and-why-e83c4c3b501a
- https://blog.cloudflare.com/a-relatively-easy-to-understand-primer-on-elliptic-curve-cryptography/
- https://aws.amazon.com/blogs/security/announcing-aws-kms-elliptic-curve-diffie-hellman-ecdh-support/
- https://scryptplatform.medium.com/efficient-elliptic-curve-point-addition-and-multiplication-in-scrypt-script-f7e143a752e2
- https://en.wikipedia.org/wiki/Elliptic_Curve_Digital_Signature_Algorithm
- https://en.wikipedia.org/wiki/Elliptic-curve_Diffie%E2%80%93Hellman
- https://en.wikipedia.org/wiki/Key_derivation_function
- https://www.baeldung.com/cs/kdf-cryptography
- https://javadoc.sic.tech/iaik_jce/current/iaik/security/kdf/KDF2.html
- https://stackoverflow.com/questions/64396936/what-is-the-purpose-of-using-hkdf
- https://en.wikipedia.org/wiki/Symmetric-key_algorithm#:~:text=Symmetric%2Dkey%20encryption%20can%20use,%2C%20uses%20128%2Dbit%20blocks.
- https://www.baeldung.com/java-aes-encryption-decryption
- https://www.baeldung.com/sha-256-hashing-java
- https://docs.oracle.com/javase/8/docs/api/java/security/MessageDigest.html
