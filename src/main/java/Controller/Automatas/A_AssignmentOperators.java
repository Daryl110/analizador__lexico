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
 * @author nick_
 */
public class A_AssignmentOperators implements Automata {

    @Override
    public Lexeme execute(String word, int row, int column) {
        switch (word) {
            case "+=":
            case "-=":
            case "*=":
            case "/=":
            case "=":
            case "%=":
            case "^=":
                return new Lexeme(row, column, word, LexemeTypes.ASSIGNMENT_OPERATORS);
        }
        return null;
    }
}
