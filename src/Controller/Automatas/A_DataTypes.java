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
public class A_DataTypes implements Automata{
    
    @Override
    public Lexeme execute(String word, int row, int column){
        switch (word) {
            case "string":
            case "char":
            case "number":
            case "boolean":
            case "any":
                return new Lexeme(row, column, word, LexemeTypes.DATA_TYPE);
        }
        return null;
    }
}
