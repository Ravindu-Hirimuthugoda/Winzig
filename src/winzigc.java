import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class winzigc {

    private static List<SyntaxToken> tokenStream = new ArrayList<>();

    private static String readProgram(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString()+"   ";
        } finally {
            reader.close();
        }
    }

    private static List<SyntaxToken> screenTokenStream(){
        List<SyntaxToken> screenedToken = new ArrayList<>();
        for(SyntaxToken token : tokenStream){
            if(token.kind != SyntaxKind.CommentToken & token.kind != SyntaxKind.WhiteSpaceToken & token.kind != SyntaxKind.NewlineToken & token.kind != SyntaxKind.EndOfProgramToken){
                screenedToken.add(token);
            }
        }
        return screenedToken;
    }

    public static void main(String[] args) {
        String flag = args[0];
        switch (flag){
            case  "-ast":
                String path_to_winzig_program = args[1];


                String program_as_a_string = null;
                try {
                    program_as_a_string = readProgram(path_to_winzig_program);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Lexer lexer = new Lexer(program_as_a_string);

                SyntaxKind kind;
                do{
                    SyntaxToken token = lexer.findNextToken();
                    tokenStream.add(token);
                    kind = token.kind;
                }
                while(kind != SyntaxKind.EndOfProgramToken);

                List<SyntaxToken> screenedTokenStream = screenTokenStream();

                ParserBottomUpTree parser = new ParserBottomUpTree(screenedTokenStream);
                break;
            default:
                System.out.println("Provided args are incompatible.");
        }
    }
}
