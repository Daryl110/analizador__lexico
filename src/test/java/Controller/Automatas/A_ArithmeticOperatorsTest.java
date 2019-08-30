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
public class A_ArithmeticOperatorsTest {
    
    public A_ArithmeticOperatorsTest() {
    }
    
    @Test
    public void testExecuteSuccess() {
        System.out.println("Automata Operadores Aritmeticos (SuccessTest).....");
        String word = "+";
        
        A_ArithmeticOperators instance = new A_ArithmeticOperators();
        Lexeme result = instance.execute(word, 0, 0);
        
        assertEquals(true, (result instanceof Lexeme));
    }
    
    @Test
    public void testExecuteFail() {
        System.out.println("Automata Operadores Aritmeticos (FailTest).....");
        String word = "++";
        
        A_ArithmeticOperators instance = new A_ArithmeticOperators();
        Lexeme result = instance.execute(word, 0, 0);
        
        assertNotEquals(true, (result instanceof Lexeme));
    }
    
}
