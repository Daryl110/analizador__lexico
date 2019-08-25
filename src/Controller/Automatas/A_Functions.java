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
public class A_Functions implements Automata{
    
    @Override
    public Lexeme execute(String word, int row, int column){
        switch (word) {
            case "->":
            case "void":
            case "function":
            case "return":
                return new Lexeme(row, column, word, LexemeTypes.FUNCTIONS);
        }
        return null;
    }
}
