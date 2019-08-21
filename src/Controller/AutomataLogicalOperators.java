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
public class AutomataLogicalOperators implements Automata {

    private String word = "";
    private char previousCharacter;
    private int state = 0;

    @Override
    public boolean execute(char character) {
        boolean flag = false;
        if (this.state == 0) {
            if (character == '&' || character == '|') {
                this.word = character + "";
                this.state = 1;
                this.previousCharacter = character;
                flag = true;
            } else if (character == '!') {
                this.word = character + "";
                this.state = 2;
                this.previousCharacter = '0';
                flag = true;
            }
        } else {
            switch (this.previousCharacter) {
                case '&':
                    if (character == '&') {
                        this.word += character;
                        this.state = 2;
                        this.previousCharacter = '0';
                        flag = true;
                    } else {
                        this.word = "";
                        this.previousCharacter = '0';
                        this.state = 0;
                    }
                    break;
                case '|':
                    if (character == '|') {
                        this.word += character;
                        this.state = 2;
                        this.previousCharacter = '0';
                        flag = true;
                    } else {
                        this.word = "";
                        this.previousCharacter = '0';
                        this.state = 0;
                    }
                    break;
                default:
                    this.word = "";
                    this.previousCharacter = '0';
                    this.state = 0;
                    break;
            }
        }
        return flag;
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getState() {
        return state;
    }
    
    @Override
    public void clearState() {
        this.state = 0;
        this.word = "";
    }
   
}
