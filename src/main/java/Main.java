import io.github.chaosunity.Lexer;
import io.github.chaosunity.Parser;
import io.github.chaosunity.Token;

import io.github.chaosunity.ast.Statement;
import scala.collection.JavaConverters;
import scala.collection.convert.AsScalaExtensions;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer(Collections.singletonList("const a 10"));
        List<Token> lexResult = lexer.lex();

        for (Token token : lexResult) {
            System.out.println(token);
        }

        Parser parser = new Parser(lexResult);
        List<Statement> statements = parser.parse();
    }
}
