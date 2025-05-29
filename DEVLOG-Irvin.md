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

### 2025-05-27 - Attempting to implement .jar file
Created lib and added org.web3j.crypto.jar into it and updated makefile to properly test sign using the necesarry parameters. Seems to not work, I try to make it a dependency and google-fu is letting me down.

### 
