# Compiler
JC = javac

# Compiler flags
JFLAGS = -g

# Source directory
SRC_DIR = .

# Output directory
OUT_DIR = build

# Java source files
JAVA_FILES := $(shell find $(SRC_DIR) -name "*.java")

# Java class files
CLASS_FILES := $(patsubst $(SRC_DIR)/%.java,$(OUT_DIR)/%.class,$(JAVA_FILES))

# Main class
MAIN_CLASS = Main

# Test directory
TEST_DIR = tests

# Java test files
TEST_FILES := $(shell find $(TEST_DIR) -name "*.java")

# Java test class files
TEST_CLASS_FILES := $(patsubst $(TEST_DIR)/%.java,$(OUT_DIR)/%.class,$(TEST_FILES))

# Main target
all: $(OUT_DIR) $(OUT_DIR)/$(MAIN_CLASS).class

# Create output directory
$(OUT_DIR):
	mkdir -p $(OUT_DIR)

# Compile Java source files
$(OUT_DIR)/%.class: %.java
	$(JC) $(JFLAGS) -d $(OUT_DIR) $<

# Compile Java test files
$(OUT_DIR)/%.class: $(TEST_DIR)/%.java
	$(JC) $(JFLAGS) -cp $(OUT_DIR) -d $(OUT_DIR) $<

# Run the program
run: all
	java -cp $(OUT_DIR) $(MAIN_CLASS)

run tui:
	java -cp $(OUT_DIR) $(MAIN_CLASS) --tui

# Run tests
test: $(TEST_CLASS_FILES) all
	java -cp $(OUT_DIR) org.junit.runner.JUnitCore $(patsubst $(OUT_DIR)/%.class,%,$(TEST_CLASS_FILES))

# Clean build files
clean:
	rm -rf $(OUT_DIR)

# PHONY targets
.PHONY: all run test clean

count-lines:
	@echo "Counting lines of code in all Git-tracked files..."
	git ls-files | xargs wc -l