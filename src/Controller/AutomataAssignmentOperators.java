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
public class AutomataAssignmentOperators implements Automata {

    private String word = "";
    private char previousCharacter;
    private int state = 0;

    @Override
    public boolean execute(char character) {
        boolean flag = false;
        if (character == '+' || character == '-'
                || character == '*' || character == '/'
                || character == '%') {
            flag = true;
            this.word = character + "";
            this.previousCharacter = character;
            this.state = 1;
        } else if (character == '=') {
            if (previousCharacter != '\u0000') {
                flag = true;
                this.word += character;
                this.previousCharacter = character;
                this.state = 2;
            } else {
                flag = true;
                this.word = character + "";
                this.state = 2;
            }
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
        this.word = "";
    }

}
