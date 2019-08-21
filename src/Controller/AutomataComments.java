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
public class AutomataComments implements Automata {

    private String word = "";
    private int state = 0;

    @Override
    public boolean execute(char character) {
        boolean flag = false;
        if (character == '/' && state == 0) {
            flag = true;
            this.state = 1;
            this.word = character + "";
        } else if (this.state == 1 && character == '*') {
            this.state = 2;
            flag = true;
            this.word += character;
        } else if (this.state == 2 && character == '*') {
            this.state = 3;
            flag = true;
            this.word += character;
        } else if (this.state == 3 && character == '/') {
            this.state = 4;
            flag = true;
            this.word += character;
        } else if (character == '/' && this.state == 1) {
            this.state = 4;
            flag = true;
            this.word += character;
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
