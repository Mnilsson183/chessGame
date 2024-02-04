build:
	javac @sources.txt -d build/

index:
	find -name "*.java" > sources.txt

run:
	java Main

count:
	git ls-files | xargs wc -l

clean:
	rm -rf build/*