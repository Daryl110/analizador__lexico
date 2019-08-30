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
public class A_NumbersTest {
    
    public A_NumbersTest() {
    }
        
    @Test
    public void testExecuteSuccess() {
        System.out.println("Automata Numeros (SuccessTest).....");
            String word = "1005550050050.51511648646546";
        
        A_Numbers instance = new A_Numbers();
        Lexeme result = instance.execute(word, 0, 0);
        
        assertEquals(true, (result instanceof Lexeme));
    }
    
    @Test
    public void testExecuteFail() {
        System.out.println("Automata Numeros (FailTest).....");
        String word = "1.";
        
        A_Numbers instance = new A_Numbers();
        Lexeme result = instance.execute(word, 0, 0);
        
        assertNotEquals(true, (result instanceof Lexeme));
    }
    
}
