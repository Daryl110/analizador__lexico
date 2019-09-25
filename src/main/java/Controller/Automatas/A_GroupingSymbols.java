/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Automatas;

import Model.Automata;
import Model.Lexeme;
import Model.LexemeTypes;

/**
 *
 * @author Daryl Ospina
 */
public class A_GroupingSymbols implements Automata{

    @Override
    public Lexeme execute(String word, int row, int column) {
        switch (word) {
            case "(":
                return new Lexeme(row, column, word, "Open Parenthesis");
            case ")":
                return new Lexeme(row, column, word, "Close Parenthesis");
            case "[":
                return new Lexeme(row, column, word, "Open Brackets");
            case "]":
                return new Lexeme(row, column, word, "Close Brackets");
            case "{":
                return new Lexeme(row, column, word, "Open Braces");
            case "}":
                return new Lexeme(row, column, word, "Close Braces");
                
        }
        return null;
    }
    
}
