build:
	find -name "*.java" > sources.txt
 	javac @sources.txt -d build/

run:
	java Main

clean:
	rm -rf build/*