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
