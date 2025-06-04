# Default target
all: compile

# Compile the Java file
compile:
	javac *.java

#run Java files
run:
	java Driver.java $(ARGS)

#Client.java
Client:
	java Client.java $(ARGS)

#Server.java
Server:
	java Server.java $(ARGS)
	
# Clean compiled files
clean:
	rm -f *.class
