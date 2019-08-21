/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Automata;

/**
 *
 * @author Daryl Ospina
 */
public class AutomataDelimiter implements Automata{
    
    private String word = "";
    private int state = 0;

    @Override
    public boolean execute(char character) {
        boolean flag = false;
        if (character == ';') {
            flag = true;
            this.word = character+"";
            this.state = 1;
        }
        return flag;
    }

    @Override
    public String getWord() {
        return this.word;
    }

    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public void clearState() {
        this.state = 0;
    }
    
}
