# **Elliptic Curve Cryptography (ECC)**
## **GROUP MEMBERS:**   Irvin Li, Steven Lou


![image](https://github.com/user-attachments/assets/61cbd62c-d50e-4550-a642-29149c81e5b1)
###### Elliptical Curve

### What is ECC?
Elliptic Curve Cryptography is an example of asymmetric cryptography in which there is a public and private key.
It uses the principle of elliptic curves over finite fields in order to provide cryptographically secure points and efficient operations. It is used to create signatures to ensure security in encryption or as a part of other more expanded forms of encryption. 

A main benefit of ECC as opposed to industry standards like RSA would be the much smaller keys in comparison to other forms due to the concept known as te Elliptic Curve Discrete Logarithm Problem (ECDLP).

Points $P$ and $Q = kP$
where Points $P$ and $Q$ are on the elliptical curve and $k$ is a constant that is very difficult to find out as a result of random.


### Where is it used?
ECC is used in many facets of the tech field, including:
- Digital Signatures through (ECDSA – Elliptic Curve Digital Signature Algorithm)
- Key Exchange through (ECDH – Elliptic Curve Diffie-Hellman)
- Used to secure wallets and blockchains for things like bitcoin and ethereum.
- Web Certifiers for SSL and TLS



### Point Operations
ECC requires two point operations: point addition and point multiplication.
#### Point Addition

The general elliptic curve equation over a finite field is:

$$
y^2 = x^3 + ax + b \pmod{p}
$$

Where:
- \( a \), \( b \) are curve parameters
- \( p \) is a large prime defining the field

![image](https://github.com/user-attachments/assets/fb086d5b-200e-41b3-a40b-8a9040d93d25)
###### Point Addition

Given two points $P$ and $Q$ on the elliptic curve and a prime for finite field: we calculate the third point based on the following cases:

**Case 1: If either point is at infinity:** 

Return the other point 

**Case 2: Period Doubling $$\( P = Q \)$$:**

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

**Case 3: Inverse Points $$\( Q = -P \)$$**

The resulting point will be at infinity and is an identity.

**Case 4: Point Addition $$\( P \ne Q \)$$**

First find the slope between the two points using the following equation.

$$
m = \frac{y_2 - y_1}{x_2 - x_1} \pmod{p}
$$

Then calculate the coordinates of the thirs point using the folloiwing equations.

$$
x_3 = m^2 - x_1 - x_2 \pmod{p}
$$

$$
y_3 = m(x_1 - x_3) - y_1 \pmod{p}
$$

#### Point Multiplication

The equation for point multiplication is $Q = k \cdot P$ where:
- A point \( P \) on the elliptic curve
- A scalar integer \( k \)


This means:
- Add \( P \) to itself \( k \) times.

Pretty simple to do once point addition is made already.

### ECC Key Generation
As stated above, ECC uses **public-private key pairs** that are calculated using point operations.

#### 1. Choose a Private Key

Pick a **random integer** \( d \) such that:

$$
1 \leq d \lt n
$$

This \( d \) is your **private key**.

#### 2. Compute the Public Key

Use **scalar multiplication**:

$$
Q = d \cdot G
$$

Where:
- \( G \) is the initial point
- \( d \) is the private key
- \( Q \) is the **public key**, a point \(x, y\) on the curve

### ECDSA (Elliptic Curve Digital Signature Algorithm)

#### **Important Components in the EDCSA**
- \( G \): initial point on curve
- \( n \): order
- \( d \): private key
- \( Q \): public key
- \( z \): hashed message (SHA-256)

#### **Step 1: Pick a random integer**

Choose a random integer \( k \in [1, n-1] \)

#### Step 2: Compute point \( R \)

$$
R = k \cdot G
$$

#### **Step 3: Compute \( r \):**

$$
r = x_1 \bmod n
$$

#### **Step 4: Compute \( s \)**

$$
s = k^{-1}(z + r \cdot d) \bmod n
$$

If \( r = 0 \) || \( s = 0 \), go back to step 1 and compute a new key and try again.

Otherwise, our signature is **\(r, s\)**

![image](https://github.com/user-attachments/assets/1a176f60-bbb2-40a4-8cc3-78e1992f13b1)
##### EDCSA Process

### **EDCSA Signature Verification**

#### **Important Components in the EDCSA Signature Verification**
- \( G \): initial point
- \( n \): order
- \( d \): private key  
- \( Q \): public key  
- \( z \): hash of the message (SHA-256)  
- \( (r, s) \): signature pair

#### Step 1: Validate curve parameters

Ensure that:

- G is not a poiint at infinity
- G lies on the curve:  
  $$\[
  y^2 \equiv x^3 + ax + b \pmod{p}
  \]$$

- The point has correct order:
  $$\[
  n \cdot G = \mathcal{O}
  \]$$

#### Step 2: Check signature bounds

$$\[
1 \leq r < n,\quad 1 \leq s < n
\]$$

#### Step 3: Compute intermediate values

$$\[
w = s^{-1} \mod n
\]$$

$$\[
u_1 = z \cdot w \mod n
\]$$

$$\[
u_2 = r \cdot w \mod n
\]$$

#### Step 4: Compute point on curve

$$\[
(X, Y) = u_1 \cdot G + u_2 \cdot Q
\]$$

#### Step 5: Final check

The signature is **valid** if:

$$\[
r \equiv X \mod n
\]$$

### **ECDH Key Exchange Protocol**

Through an insecure channel, a client and server party are able to generate a symmetric key without third-parties receiving access to the symmetric key.

#### Step 1:
Both parties generate their own public and private key pairs, agreeing on the same elliptic curve parameters.

#### Step 2:
The server listens for the client through a port, waiting to receive their static public key and a signed message. The signature is used to verify if the public key is truly from their client, preventing man-in-the-middle (MitM) attacks.

#### Step 3:
The server then verifies the client's signature using their static public key. If it is indeed their client, then they will send their own static public key along with a signature for the client to validate them.

#### Step 4:
The client receives the static public key from the server and uses it to verify the server's authenticity.

#### Step 5:
The client creates the shared secret by multiplying the server's public key and their own private key, resulting on a point on the elliptic curve. Likewise, the server creates the shared secret my multiplying the client's public key and their own private key, resulting on the same point on the elliptic curve. This is the case because

$$
d_A \cdot Q_B = d_A \cdot d_B \cdot G = d_B \cdot d_A \cdot G = d_B \cdot Q_A.
$$

Where:
- \( d_A \), \( d_B \) are private keys
- \( Q_A \), \( Q_B \) are public keys
- \( G \) is the initial point

In other words, multiplication by BigInteger keys is commutative under elliptic curve operations.

#### Step 6:
The client uses a key derivation function in combination with a hash to elongate the shared message and create a symmetric key based on the entropy of the elliptic curve function. They then use a symmetric key cipher to encrypt the message they are trying to send to the server.

#### Step 7:
The server uses their shared secret and the same key derivation function and symmetric key cipher to decrypt the message received through the socket channel. Message received!

![image](https://github.com/user-attachments/assets/c1f54714-c59c-488e-b395-bc714239d418)
###### EDCH Process
