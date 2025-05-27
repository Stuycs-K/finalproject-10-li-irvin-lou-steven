# Default target
all: compile

# Compile the Java file
compile: Signing.class

Signing.class: Signing.java
	javac -cp ".:lib/*" Signing.java

# Run the program
run: Signing.class
	java -cp ".:lib/*" Signing

# Clean compiled files
clean:
	rm -f *.class