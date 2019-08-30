/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Automatas;

import Model.Lexeme;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daryl Ospina
 */
public class A_StringTest {
    
    public A_StringTest() {
    }
    
    @Test
    public void testExecuteSuccess() {
        System.out.println("Automata Cadenas (SuccessTest).....");
        String word = "'";
        
        A_String instance = new A_String();
        Lexeme result = instance.execute(word, 0, 0);
        
        assertEquals(true, (result instanceof Lexeme));
    }
    
    @Test
    public void testExecuteFail() {
        System.out.println("Automata Cadenas (FailTest).....");
        String word = "1";
        
        A_String instance = new A_String();
        Lexeme result = instance.execute(word, 0, 0);
        
        assertNotEquals(true, (result instanceof Lexeme));
    }
    
}
