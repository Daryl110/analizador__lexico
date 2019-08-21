/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.AutomataArithmeticOperators;
import Controller.AutomataAssignmentOperators;
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
    private final Automata logicalOperators;
    private final Automata delimiters;
    private final Automata assignmentOperators;
    private final Automata arithmeticOperators;

    public LexicalAnalyzer(String text) {
        this.text = text;
        this.logicalOperators = new AutomataLogicalOperators();
        this.delimiters = new AutomataDelimiter();
        this.assignmentOperators = new AutomataAssignmentOperators();
        this.arithmeticOperators = new AutomataArithmeticOperators();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Token> analyze() {
        ArrayList<Token> tokens = new ArrayList<>();
        boolean flag = false;
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
                flag = this.logicalOperators.execute(character);
                if (flag) {
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
                } /**
                 * ************ end Logical operators *****************
                 */
                else {
                    /**
                     * ************ start delimiters **********************
                     */
                    flag = this.delimiters.execute(character);
                    if (flag) {
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
                    } /**
                     * ************ end delimiters **********************
                     */
                    else {
                        try {
                            char nextCharacter = this.text.charAt(i + 1);
                            /* ******** start assignment operators ****** */
                            flag = this.assignmentOperators.execute(character);
                            if (flag && character == '=') {
                                columns.add(column);
                                if (this.assignmentOperators.getState() == Automata.ASSIGNMENT_OPERATOR_STATES) {
                                    tokens.add(
                                            new Token(
                                                    new Lexeme(columns, row, this.assignmentOperators.getWord()),
                                                    LexemeTypes.ASSIGNMENT_OPERATORS
                                            )
                                    );
                                    columns = new ArrayList<>();
                                    this.assignmentOperators.clearState();
                                }
                            } else if (flag && nextCharacter == '=') {
                                flag = this.assignmentOperators.execute(nextCharacter);
                                if (flag) {
                                    columns.add(column);
                                    columns.add(column + 1);
                                    column += 2;
                                    i += 1;
                                    if (this.assignmentOperators.getState() == Automata.ASSIGNMENT_OPERATOR_STATES) {
                                        tokens.add(
                                                new Token(
                                                        new Lexeme(columns, row, this.assignmentOperators.getWord()),
                                                        LexemeTypes.ASSIGNMENT_OPERATORS
                                                )
                                        );
                                        columns = new ArrayList<>();
                                        this.assignmentOperators.clearState();
                                    }
                                    continue;
                                }
                            } /* ******** end assignment operators ***************** */ /* ********* start incremental and decremental operators ****** */ else if (flag && nextCharacter == character) {
                                //Operadores incrementales y decrementales
                                columns.add(column);
                                columns.add(column + 1);
                                column += 2;
                                i += 1;
                                continue;
                                /* ********* end incremental and decremental operators ****** */
                            } else {
                                /* ****** start arithmetic operators part 1 ***** */
                                flag = this.arithmeticOperators.execute(character);
                                if (flag) {
                                    columns.add(column);
                                    if (this.arithmeticOperators.getState() == Automata.ARITHMETIC_OPERATOR_STATES) {
                                        tokens.add(
                                                new Token(
                                                        new Lexeme(columns, row, this.arithmeticOperators.getWord()),
                                                        LexemeTypes.ARITHMETIC_OPERATORS
                                                )
                                        );
                                        columns = new ArrayList<>();
                                        this.arithmeticOperators.clearState();
                                    }
                                }
                                /* ****** end arithmetic operators part 1 ***** */
                            }
                        } catch (Exception e) {
                            flag = this.assignmentOperators.execute(character);
                            if (flag && character == '=') {
                                columns.add(column);
                                if (this.assignmentOperators.getState() == Automata.ASSIGNMENT_OPERATOR_STATES) {
                                    tokens.add(
                                            new Token(
                                                    new Lexeme(columns, row, this.assignmentOperators.getWord()),
                                                    LexemeTypes.ASSIGNMENT_OPERATORS
                                            )
                                    );
                                    columns = new ArrayList<>();
                                    this.assignmentOperators.clearState();
                                }
                            } else {
                                /* ****** start arithmetic operators part 2 ***** */
                                flag = this.arithmeticOperators.execute(character);
                                if (flag) {
                                    columns.add(column);
                                    if (this.arithmeticOperators.getState() == Automata.ARITHMETIC_OPERATOR_STATES) {
                                        tokens.add(
                                                new Token(
                                                        new Lexeme(columns, row, this.arithmeticOperators.getWord()),
                                                        LexemeTypes.ARITHMETIC_OPERATORS
                                                )
                                        );
                                        columns = new ArrayList<>();
                                        this.arithmeticOperators.clearState();
                                    }
                                }
                                /* ****** start arithmetic operators part 2 ***** */
                            }
                        }
                        
                        if(flag == false){
                            System.out.println("Hola");
                        }
                    }
                }
                column += 1;
            }
        }
        return tokens;
    }
}
