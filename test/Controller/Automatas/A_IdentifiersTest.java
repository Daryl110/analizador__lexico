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
public class A_IdentifiersTest {
    
    public A_IdentifiersTest() {
    }
        
    @Test
    public void testExecuteSuccess() {
        System.out.println("Automata Identificadores (SuccessTest).....");
        String word = "variable_1";
        
        A_Identifiers instance = new A_Identifiers();
        Lexeme result = instance.execute(word, 0, 0);
        
        assertEquals(true, (result instanceof Lexeme));
    }
    
    @Test
    public void testExecuteFail() {
        System.out.println("Automata Identificadores (FailTest).....");
        String word = "1_variable";
        
        A_Identifiers instance = new A_Identifiers();
        Lexeme result = instance.execute(word, 0, 0);
        
        assertNotEquals(true, (result instanceof Lexeme));
    }

}
