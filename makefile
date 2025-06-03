# Default target
all: compile

# Compile the Java file
compile:
	javac *.java

#run Java files
	java Driver.java $(ARGS)
# Clean compiled files
clean:
	rm -f *.class
