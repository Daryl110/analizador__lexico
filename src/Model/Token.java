/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Daryl Ospina
 */
public class Token {
    
    private Lexeme lexeme;
    private LexemeTypes type;

    public Token(Lexeme lexeme, LexemeTypes type) {
        this.lexeme = lexeme;
        this.type = type;
    }

    public Lexeme getLexeme() {
        return lexeme;
    }

    public void setLexeme(Lexeme lexeme) {
        this.lexeme = lexeme;
    }

    public LexemeTypes getType() {
        return type;
    }

    public void setType(LexemeTypes type) {
        this.type = type;
    }
}
