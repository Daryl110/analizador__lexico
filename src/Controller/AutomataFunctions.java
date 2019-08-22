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
public class AutomataFunctions implements Automata {

    private String word = "";
    private char previousCharacter;
    private int state = 0;

    @Override
    public boolean execute(char character) {
        boolean flag = false;
        if (this.state == 0 && (character == 'f' || character == 'v'
                || character == 'r' || character == '-')) {
            this.word = character + "";
            this.state = 1;
            this.previousCharacter = character;
            flag = true;
        } else if (this.state == 1) {
            switch (character) {
                case 'u':
                    if (this.previousCharacter == 'f') {
                        this.state = 2;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
                case 'o':
                    if (this.previousCharacter == 'v') {
                        this.state = 2;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
                case 'e':
                    if (this.previousCharacter == 'r') {
                        this.state = 2;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
                case '>':
                    if (this.previousCharacter == '-') {
                        this.state = 8;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
            }
        } else if (this.state == 2) {
            switch (character) {
                case 'n':
                    if (this.previousCharacter == 'u') {
                        this.state = 3;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
                case 'i':
                    if (this.previousCharacter == 'o') {
                        this.state = 3;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
                case 't':
                    if (this.previousCharacter == 'e') {
                        this.state = 3;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
            }
        } else if (this.state == 3) {
            switch (character) {
                case 'c':
                    if (this.previousCharacter == 'n') {
                        this.state = 4;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
                case 'd':
                    if (this.previousCharacter == 'i') {
                        this.state = 8;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
                case 'u':
                    if (this.previousCharacter == 't') {
                        this.state = 4;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
            }
        } else if (this.state == 4) {
            switch (character) {
                case 't':
                    if (this.previousCharacter == 'c') {
                        this.state = 5;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
                case 'r':
                    if (this.previousCharacter == 'u') {
                        this.state = 7;
                        this.word += character;
                        flag = true;
                        this.previousCharacter = character;
                    }
                    break;
            }
        } else if (this.state == 5 && character == 'i' && this.previousCharacter == 't') {
            this.state = 6;
            this.word += character;
            flag = true;
            this.previousCharacter = character;
        } else if (this.state == 6 && character == 'o' && this.previousCharacter == 'i') {
            this.state = 7;
            this.word += character;
            flag = true;
            this.previousCharacter = character;
        } else if (this.state == 7 && character == 'n' && (this.previousCharacter == 'o' || this.previousCharacter == 'r')) {
            this.state = 8;
            this.word += character;
            flag = true;
            this.previousCharacter = character;
        } else {
            this.state = 0;
            this.word = "";
            this.previousCharacter = '\u0000';
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
        this.previousCharacter = '\u0000';
    }

}
