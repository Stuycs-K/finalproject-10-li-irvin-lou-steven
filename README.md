[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/am3xLbu5)
# PROJECT NAME HERE (CHANGE THIS!!!!!)
 
### GROUP NAME HERE (CHANGE THIS!!!!!)

Irvin Li, Steven Lou
       
### Project Description:

Explain what is this project. (CHANGE THIS!!!!!)
  
### Instructions:

The user should run
`make compile`
After, if you simply want to test that verification works for the user,
run `make Driver.java ARGS="<either **secp256k1** or **secp256r1**>" or no args for automatic secp256k1.`
To run client/server, open two terminals.
`make server ARGS="-t <elliptical curve parameter> -e (ECDH or EDCSA)"`
`make client ARGS="-t <elliptical curve parameter> -e (ECDH or EDCSA)"`
Please make sure the args are the same or else it will not work.
Baseline is secp256k1 and EDCSA
Once running, if EDCSA, it will only ask the client for a message to encrypt.
If it is ECDH, you will have to type a message for both server and client (can be different messages).

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
