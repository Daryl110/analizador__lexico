/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.AutomataDelimiter;
import Controller.AutomataLogicalOperators;
import java.util.ArrayList;

/**
 *
 * @author Daryl Ospina
 */
public class LexicalAnalyzer {

    private String text;
    /* Automatas */
    private Automata logicalOperators;
    private Automata delimiters;

    public LexicalAnalyzer(String text) {
        this.text = text;
        this.logicalOperators = new AutomataLogicalOperators();
        this.delimiters = new AutomataDelimiter();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Token> analyze() {
        ArrayList<Token> tokens = new ArrayList<>();
        boolean bandera = false;
        ArrayList<Integer> columns = new ArrayList<>();
        int row = 0;
        int column = 0;
        for (int i = 0; i < this.text.length(); i++) {
            char character = this.text.charAt(i);
            if (character == '\n') {
                row += 1;
                column = 0;
            } else {
                /**
                 * ************ start Logical operators *****************
                 */
                bandera = this.logicalOperators.execute(character);
                if (bandera) {
                    columns.add(column);
                    if (this.logicalOperators.getState() == Automata.LOGICAL_OPERATORS_STATES) {
                        tokens.add(
                                new Token(
                                        new Lexeme(columns, row, this.logicalOperators.getWord()),
                                        LexemeTypes.LOGICAL_OPERATORS
                                )
                        );
                        columns = new ArrayList<>();
                        this.logicalOperators.clearState();
                    }
                }
                /**
                 * ************ end Logical operators *****************
                 */
                /**
                 * ************ start delimiters **********************
                 */
                if (!bandera) {
                    bandera = this.delimiters.execute(character);
                    if (bandera) {
                        columns.add(column);
                        if (this.delimiters.getState() == Automata.DELIMITERS_STATES) {
                            tokens.add(
                                    new Token(
                                            new Lexeme(columns, row, this.delimiters.getWord()),
                                            LexemeTypes.DELIMITERS
                                    )
                            );
                            columns = new ArrayList<>();
                            this.delimiters.clearState();
                        }
                    }
                }
                /**
                 * ************ end delimiters **********************
                 */
                column += 1;
            }
        }
        return tokens;
    }
}
