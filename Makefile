JFLAGS = -g -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
	./src/ASTNode.java \
	./src/SyntaxKind.java \
	./src/SyntaxToken.java \
	./src/BinaryTreeNode.java \
	./src/ParserBottomUpTree.java \
	./src/Lexer.java \
	./src/winzigc.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class
