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
public class A_IterativeControlStructureTest {
    
    public A_IterativeControlStructureTest() {
    }
    
    @Test
    public void testExecuteSuccess() {
        System.out.println("Automata Estructuras de control iterativas (SuccessTest).....");
        String word = "for";
        
        A_IterativeControlStructure instance = new A_IterativeControlStructure();
        Lexeme result = instance.execute(word, 0, 0);
        
        assertEquals(true, (result instanceof Lexeme));
    }
    
    @Test
    public void testExecuteFail() {
        System.out.println("Automata Estructuras de control iterativas (FailTest).....");
        String word = "fori";
        
        A_IterativeControlStructure instance = new A_IterativeControlStructure();
        Lexeme result = instance.execute(word, 0, 0);
        
        assertNotEquals(true, (result instanceof Lexeme));
    }
    
}
