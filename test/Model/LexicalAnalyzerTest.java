/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daryl Ospina
 */
public class LexicalAnalyzerTest {
    
    public LexicalAnalyzerTest() {
    }
    
    @Test
    public void testAnalyze() {
        System.out.println("---------------------Analizador Lexico-------------------------");
        LexicalAnalyzer instance = new LexicalAnalyzer(
                "number variable_1 = 15;\n"+
                "if(number >= 0){"+
                "  any funcion = () -> {return number > 0}"+
                "} ??$");
        
        ArrayList<Lexeme> result = instance.analyze();
        
        result.forEach((lexeme) -> {
            System.out.println(lexeme.getWord()+ " - "+lexeme.getType()+" - ("+lexeme.getRow()+","+lexeme.getColumn()+")");
        });
        
        assertEquals(true, result.size() > 0);
    }
    
}
