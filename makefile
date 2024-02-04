build:
	javac @sources.txt -d build/

index:
	find -name "*.java" > sources.txt

run:
	java Main

clean:
	rm -rf build/*