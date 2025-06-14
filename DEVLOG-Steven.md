# Dev Log:

This document must be updated daily every time you finish a work session.

## Steven Lou

### 2025-05-16 - Brief description
Spent time researching about Elliptic Curve Cryptography(ECC) and recorded our notes in a google doc. It is an asymmetric key cipher used in modern day cryptography, which uses the properties of elliptic curves (in particular the irreversibility of point multiplication as long as the decisional Diffie–Hellman (DDH) assumption holds) to generate a public/private key pair. A unique signature is generated based on the hash and the private key, which can be verified through mathematical formulae and the public key. The ECDH protocol can also be used between two parties to encrypt and share messages by generating the same symmetric key through an insecure channel. We also did some preliminary research into hash libraries and parameters to ensure this was implementable and testable.

**Sources**
- (https://en.wikipedia.org/wiki/Elliptic-curve_cryptography)
- (https://en.wikipedia.org/wiki/Elliptic_Curve_Digital_Signature_Algorithm)
- (https://www.keyfactor.com/blog/elliptic-curve-cryptography-what-is-it-how-does-it-work/)
- (https://cryptobook.nakov.com/asymmetric-key-ciphers/elliptic-curve-cryptography-ecc)
- (https://medium.com/@abhiveerhome/building-elliptic-curve-cryptography-ecc-from-scratch-7b28e3b27531)

### 2025-05-19 - Brief description
For the entire class and for homework, I implemented the Point java class and point muliplication and addition in the Operations java class. I tested both of them, but the multiplication and addition does not match up with the values found for the parameters online, so further debugging must be done to figure out what's wrong.

### 2025-05-20 - Brief description
I finally fixed point addition and multiplication and tested it thoroughly with values for the elliptic curve online and certain criteria that must be met. Preliminary classes like the Point class were modified accordingly to accomodate null points and fix issues.

### 2025-05-21 - Brief description
I did some further research into Elliptic Curve Diffie-Hellman (ECDH) protocol and client-server communication to find out if the entire process was implementable. It turns out one-way and two-way socket communication was probably the best way to implement this through Java.

**Sources**
- (https://en.wikipedia.org/wiki/Elliptic-curve_Diffie%E2%80%93Hellman)
- (https://docs.oracle.com/javase/tutorial/networking/sockets/index.html)
- (https://docs.oracle.com/javase/8/docs/api/java/net/Socket.html)

### 2025-05-22 - Brief description
I tried to help Irvin with the dependencies for the keccak256 hash, but we got nowhere with the libraries. Without the hash function first, I would not be able to implement the signature process. I also helped him with urandom and implementing random key generation using elliptic curve functionality.

### 2025-05-23 - Brief description
Further research into ECDH led me to information about Key Derivation Functions and Symmetric Key Ciphers. I tried experimenting with implementing known key-sharing KDFs like KDF2 and HKDF and Symmetric Key Ciphers like AES, but their libraries were very confusing and hard to implement correctly. They also required many other programs like base64 to securely send bytes.

**Sources**
- (https://en.wikipedia.org/wiki/Key_derivation_function)
- (https://www.baeldung.com/cs/kdf-cryptography)
- (https://javadoc.sic.tech/iaik_jce/current/iaik/security/kdf/KDF2.html)
- (https://stackoverflow.com/questions/64396936/what-is-the-purpose-of-using-hkdf)
- (https://en.wikipedia.org/wiki/Symmetric-key_algorithm#:~:text=Symmetric%2Dkey%20encryption%20can%20use,%2C%20uses%20128%2Dbit%20blocks.)

### 2025-05-27 - Brief description
I worked on the signing portion of the Elliptic Curve Digital Signature Algorithm (ECDSA) and was able to obtain a signature, albeit untested, through implementing the mathematical process.

### 2025-05-28 - Brief description
I was able to import the SHA-256 cryptographic hash-function using the MessageDigest Java library, and use it to finish the signing portion of ECDSA. I also began working on verifying this signature through a separate file, implementing elliptic curve checks and using the mathematical process the check the signature.

**Sources**
- (https://www.baeldung.com/sha-256-hashing-java)
- (https://docs.oracle.com/javase/8/docs/api/java/security/MessageDigest.html)

### 2025-05-29 - Brief description
I finished implementing the verification part of ECDSA, but the verification returns false, so I will have to test both Signing.java and Verify.java to debug this. After testing both files and including changes like bitwise shifts to the hashed message, I finally found the source of the error in the way I was verifying the signature.

### 2025-05-30 - Brief description
I was out for today at a math competition.

### 2025-06-02 - Brief description
I finished testing the entire ECDSA algorithm through creating a Driver file that went through the entire process. I also fixed the arguments for elliptic curves by creating an instance of the Operations class along with designated parameters for the curve.

### 2025-06-03 - Brief description
I was able to fix the client-server socket communication for ECDSA and worked on implementing the ECDH protocol through sockets as well. I created a Symmetric_Encrypt file to use rudimentary ideas in a key derivation function of our own to extend the length of the symmetric key obtained by ECDH and elliptic curves. Then, I implemented a xor symmetric cipher to encode the message in order to pass encrypted data between server and client. The entire ECDH protocol was tested and debugged, resulting in the final product.
