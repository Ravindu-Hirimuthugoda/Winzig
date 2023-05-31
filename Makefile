JFLAGS = -g -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
	./ASTNode.java \
	./SyntaxKind.java \
	./SyntaxToken.java \
	./BinaryTreeNode.java \
	./ParserBottomUpTree.java \
	./Lexer.java \
	./Winzig.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class
