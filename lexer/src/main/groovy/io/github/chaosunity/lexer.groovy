package io.github.chaosunity

class Lexer {
    final List<String> source
    int line, pos

    Lexer(List<String> source) {
        this.source = source
    }

    List<Token> lex() {
        def token = []
        def currentLine

        while (line < source.size()) {
            currentLine = source.get(line)

            while (pos < currentLine.size()) {
                if (Character.isDigit(currentLine[pos] as char)) {
                    def start = pos

                    while (pos < currentLine.size())
                        pos++

                    def literal = currentLine[start..pos - 1]
                    token << new Token(TokenType.IntegerLiteral, literal)
                }
            }

            line++
        }

        return token
    }
}

class Token {
    final TokenType type
    final String literal

    Token(TokenType type, String literal) {
        this.type = type
        this.literal = literal
    }
}

enum TokenType {
    IntegerLiteral;
}