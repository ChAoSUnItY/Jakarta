import io.github.chaosunity.Lexer;
import io.github.chaosunity.Token;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer(Collections.singletonList("10"));
        List<Token> lexResult = lexer.lex();

        for (Token token : lexResult) {
            System.out.printf("[type: %s, literal: \"%s\"]\n", token.getType(), token.getLiteral());
        }
    }
}
