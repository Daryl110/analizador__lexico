/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Automatas;

import Model.Automata;
import Model.Lexeme;
import Model.LexemeTypes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Daryl Ospina
 */
public class A_Identifiers implements Automata{

    @Override
    public Lexeme execute(String word, int row, int column) {
        
        Pattern regex = Pattern.compile("^[a-zA-Z]+[a-zA-Z0-9_]*");
        Matcher mat = regex.matcher(word);
        
        if (mat.matches())return new Lexeme(row, column, word, LexemeTypes.IDENTIFIERS);
        
        return null;
    }
    
}
