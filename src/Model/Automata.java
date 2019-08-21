/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Daryl Ospina
 */
public interface Automata {
    public static int LOGICAL_OPERATORS_STATES = 2;//states for automata of logical operators
    public static int DELIMITERS_STATES = 1;//states for automata of delimiters
    
    public abstract boolean execute(char character);
    public abstract String getWord();
    public abstract int getState();
    public abstract void clearState();
}
