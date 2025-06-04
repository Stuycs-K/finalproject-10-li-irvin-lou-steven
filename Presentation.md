# **Elliptic Curve Cryptography (ECC)**
## **GROUP MEMBERS:**   Irvin Li, Steven Luo

#

### What is ECC?
Elliptic Curve Cryptography is an example of asymmetric cryptography in which there is a public and private key.
It uses the principle of elliptic curves over finite fields in order to provide cryptographically secure points and efficient operations. It is used to create signatures to ensure security in encryption or as a part of other more expanded forms of encryption. 

A main benefit of ECC as opposed to industry standards like RSA would be the much smaller keys in comparison to other forms due to the concept known as te Elliptic Curve Discrete Logarithm Problem (ECDLP).

Points $P$ and $Q = kP$
where Points $P$ and $Q$ are on the elliptical curve and $k$ is a constant that is very difficult to find out as a result of random.


### What is ECC?
ECC is used in many facets of the tech field, including:
- Digital Signatures through (ECDSA – Elliptic Curve Digital Signature Algorithm)
- Key Exchange through (ECDH – Elliptic Curve Diffie-Hellman)
- Used to secure wallets and blockchains for things like bitcoin and ethereum.
- Web Certifiers for SSL and TLS



### Point Operations
ECC requires two point operations: point addition and point multiplication.
#### Point Addition
Given two points $P$ and $Q$ on the elliptic curve and a prime for finite field: we calculate the third point based on the following cases:

**If either point is at infinity:** 

Return the other point 

**If $P$ and $Q$ are equal, we will perform point doubling since both of them are equal:**

First find the slope between the two points using the following equation.

$$
m = \frac{3x_1^2 + a}{2y_1} \pmod{p}
$$

Then calculate the coordinates of the thirs point using the folloiwing equations.

$$
x_3 = m^2 - 2x_1 \pmod{p}
$$

$$
y_3 = m(x_1 - x_3) - y_1 \pmod{p}
$$

So:

$$
R = 2P = (x_3, y_3)
$$
