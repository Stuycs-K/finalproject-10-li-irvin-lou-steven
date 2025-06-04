# Dev Log:

This document must be updated daily every time you finish a work session.

## Irvin Li

### 2025-05-16 - Research Elliptic Curve Cryptography
Researched the different project ideas and eventually decided to commit to doing Elliptic Curve Cryptography.
Stored research in a google doc (as a way to reference when creating the video later).
Basic Overview:
-Eliptic Curve Cryptography is an assymetric Cryptography and relies on the Elliptic Curve Discrete Logarithm Problem to create a secure encryption.
-It has smaller key sizes compared to RSA.
Verified that there is a way to test almost every step in the process.
**Sources:**
- (https://en.wikipedia.org/wiki/Elliptic-curve_cryptography)
- (https://www.keyfactor.com/blog/elliptic-curve-cryptography-what-is-it-how-does-it-work/)
- (https://cryptobook.nakov.com/asymmetric-key-ciphers/elliptic-curve-cryptography-ecc)
- (https://medium.com/@abhiveerhome/building-elliptic-curve-cryptography-ecc-from-scratch-7b28e3b27531)

### 2025-05-19 - Point Addition / Point Class
Steven created the Point class for mapping points on the elliptic curve. We realized that we could not use ints, doubles, or longs because the primes could be 190-520 bits which would result in inprecise coordinates due to rounding. We decided to use BigInteger, but we do not have access to a function isinfinity() with a BigInteger since the int can be as large as the devices memory can handle. As a result, we had to instead assign an infinity boolean  and check for that. 

Started mapping and testing point addition for the different conditions when calculating points on elliptic curves.

### 2025-05-20 - Testing/Debugging Point Addition/Multiplication
Steven and I were both trying to debug point addition and multiplication. He was able to get it working before I did, so he committed instead of me. We discussed future features that we can for ecc such as possibly sending private keys to another user to decrypt and identify senders of the encryprted message.

### 2025-05-22 - Key Generation
I was working on Key Generation and made the new keyPair class in order to make key generation/storage easier and cleaner. Beginning work on message signing.

### 2025-05-23/24 - Signing
Created sign class and ran into issues with the hash class we were planning to use. Creates the class Sign and that includes storing the hash and the calculated point for a signature. Also changed things to private to make everything streamlined and consistent across different files.

### 2025-05-25 - Researching .jar files
Researched how to import .jar file. Kept getting information to use maven or gradle, but I am not sure I allowed to use these or IDEs so I will try to manually add the jar file and the depencies.
**Sources:**
- (https://mvnrepository.com/artifact/org.web3j)
- (https://docs.web3j.io/4.11.0/)
- (https://docs.web3j.io/latest/getting_started/manual_configuration/)
- (https://central.sonatype.com/artifact/org.web3j/core/4.8.6)

### 2025-05-27 - Attempting to implement .jar file
Created lib and added org.web3j.crypto.jar into it and updated makefile to properly test sign using the necesarry parameters. Seems to not work, I try to make it a dependency and google-fu is letting me down.

### 2025-05-29 - Begins Driver file and updating makefile
Starts work on the Driver class where I prompt users for starting parameters for the elliptical curve that will be used for the calculations. Also, updated makefile in order to properly test for this and abandoned the .jar cuz we could not get it to work.
**Source:**
- (https://www.secg.org/sec2-v2.pdf)

### 2025-05-30 - Finish Driver,java
Continues working on Driver.java and creates plan for next week. Plans to try to implement server/client exchanges of signatures.

### 2025-05-31-2025-06-01 - Researching Sockets
I was looking into sockets for java and I was able to comfortably pick up enough to possibly create a server and client connection.
Sources:
(https://docs.oracle.com/javase/tutorial/networking/sockets/index.html)
(https://docs.oracle.com/javase/8/docs/api/java/net/Socket.html)

### 2025-06-02 - Server and Client
Created Server and Client Class for one way (EDCSA), proposed how to implement args and use ECDH and two-way communication. Also learned serialization.
**Source:**
- (https://www.geeksforgeeks.org/serialization-and-deserialization-in-java/)

### 2025-06-03 - Server/Client ARGS and presentation.md
Implemented args for server and client and combined the edcsa and edch versions together. Worked on presentation.md and last minute touch ups.
