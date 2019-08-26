/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Automatas.A_ArithmeticOperators;
import Controller.Automatas.A_AssignmentOperators;
import Controller.Automatas.A_Comments;
import Controller.Automatas.A_DataTypes;
import Controller.Automatas.A_Delimiters;
import Controller.Automatas.A_Functions;
import Controller.Automatas.A_GroupingSymbols;
import Controller.Automatas.A_Identifiers;
import Controller.Automatas.A_IncrementalDecrementalOperators;
import Controller.Automatas.A_IterativeControlStructure;
import Controller.Automatas.A_LogicalOperators;
import Controller.Automatas.A_Numbers;
import Controller.Automatas.A_Others;
import Controller.Automatas.A_RelationalOperators;
import Controller.Automatas.A_SelectiveControlStructure;
import Controller.Automatas.A_String;
import java.util.ArrayList;

/**
 *
 * @author Daryl Ospina
 */
public class LexicalAnalyzer {

    private String text;
    private ArrayList<Lexeme> lexemes;

    /* Automatas */
    private A_IterativeControlStructure aIterativeControlStructure;
    private A_DataTypes aDataTypes;
    private A_Functions aFunctions;
    private A_Others aOther;
    private A_SelectiveControlStructure aSelectiveStructures;
    private A_Identifiers aIdentifiers;
    private A_Numbers aNumbers;
    private A_Delimiters aDelimiters;
    private A_GroupingSymbols aGroupingSymbols;
    private A_ArithmeticOperators aArithmeticOperator;
    private A_LogicalOperators aLogicalOperators;
    private A_RelationalOperators a_RelationalOperators;
    private A_AssignmentOperators a_AssignmentOperators;
    private A_IncrementalDecrementalOperators a_IncrementalDecrementalOperators;
    private A_Comments a_Comments;
    private A_String a_String;

    public LexicalAnalyzer(String text) {
        this.text = text + " ";
        this.lexemes = new ArrayList<>();

        this.aIterativeControlStructure = new A_IterativeControlStructure();
        this.aDataTypes = new A_DataTypes();
        this.aFunctions = new A_Functions();
        this.aOther = new A_Others();
        this.aSelectiveStructures = new A_SelectiveControlStructure();
        this.aIdentifiers = new A_Identifiers();
        this.aNumbers = new A_Numbers();
        this.aDelimiters = new A_Delimiters();
        this.aGroupingSymbols = new A_GroupingSymbols();
        this.aArithmeticOperator = new A_ArithmeticOperators();
        this.aLogicalOperators = new A_LogicalOperators();
        this.a_RelationalOperators = new A_RelationalOperators();
        this.a_AssignmentOperators = new A_AssignmentOperators();
        this.a_IncrementalDecrementalOperators = new A_IncrementalDecrementalOperators();
        this.a_Comments = new A_Comments();
        this.a_String = new A_String();
    }

    public ArrayList<Lexeme> analyze() {
        String word = "";
        int row = 0, column = -1, count = 0;
        Lexeme lexeme = null;
        for (int i = 0; i < this.text.length(); i++) {
            if (word.length() == 1) {
                column = count - 1;
            }

            char character = this.text.charAt(i);

            if ((Character.isLetter(character)
                    || Character.isDigit(character)
                    || character == '_'
                    || character == '.')
                    && (this.text.length() - 1 == i)) {
                word += character;
                this.text += " ";
            } else if (Character.isLetter(character)
                    || Character.isDigit(character)
                    || character == '_'
                    || character == '.') {
                word += character;
            } else if (!Character.isLetter(character)
                    || !Character.isDigit(character)
                    || character != '_'
                    || character != '.') {
                if (!word.isEmpty()) {
                    validate(lexeme, word, row, column);
                }
                column = count;
                lexeme = this.aDelimiters.execute(character + "", row, column);
                if (lexeme != null) {
                    this.lexemes.add(lexeme);
                } else {
                    lexeme = this.aGroupingSymbols.execute(character + "", row, column);
                    if (lexeme != null) {
                        this.lexemes.add(lexeme);
                    } else {
                        if (character == '%' && this.text.charAt(i + 1) == '='
                                || character == '+' && this.text.charAt(i + 1) == '='
                                || character == '-' && this.text.charAt(i + 1) == '='
                                || character == '*' && this.text.charAt(i + 1) == '='
                                || character == '/' && this.text.charAt(i + 1) == '=') {
                            lexeme = this.a_AssignmentOperators.execute(character + "" + this.text.charAt(i + 1), row, column);
                            i = i + 1;
                            count = count + 1;
                        } else if (character == '=' && this.text.charAt(i + 1) == '=') {
                            lexeme = this.a_RelationalOperators.execute(character + "" + this.text.charAt(i + 1), row, column);
                            i = i + 1;
                            count = count + 1;
                        } else if (lexeme == null && character == '='
                                && (character == '=')) {
                            lexeme = this.a_AssignmentOperators.execute(character + "", row, column);
                        } else if (character == '*' && this.text.charAt(i + 1) == '*'
                                || character == '-' && this.text.charAt(i + 1) == '-'
                                || character == '+' && this.text.charAt(i + 1) == '+') {
                            lexeme = this.a_IncrementalDecrementalOperators.execute(character + "" + this.text.charAt(i + 1), row, column);
                            i = i + 1;
                            count = count + 1;
                        } else if (character == '/' && this.text.charAt(i + 1) == '*'
                                || character == '*' && this.text.charAt(i + 1) == '/'
                                || character == '/' && this.text.charAt(i + 1) == '/') {
                            lexeme = this.a_Comments.execute(character + "" + this.text.charAt(i + 1), row, column);
                            i = i + 1;
                            count = count + 1;
                        }
                        if (lexeme != null) {
                            this.lexemes.add(lexeme);
                        } else {
                            if (character == '!' && this.text.charAt(i + 1) != '=') {
                                lexeme = this.aLogicalOperators.execute(character + "", row, column);
                            } else if (character == '&' || character == '|') {
                                lexeme = this.aLogicalOperators.execute(this.text.charAt(i + 1) + "" + character, row, column);
                            }
                            if (lexeme != null) {
                                this.lexemes.add(lexeme);
                            } else {
                                //Operadores relaciones
                                if (character == '!' && this.text.charAt(i + 1) == '='
                                        || character == '<' && this.text.charAt(i + 1) == '='
                                        || character == '>' && this.text.charAt(i + 1) == '='
                                        || character == '=' && this.text.charAt(i + 1) == '=') {
                                    lexeme = this.a_RelationalOperators.execute(character + "" + this.text.charAt(i + 1), row, column);
                                    i = i + 1;
                                    count = count + 1;
                                } else if (character == '<' || character == '>') {
                                    lexeme = this.a_RelationalOperators.execute(character + "", row, column);
                                }
                                if (lexeme != null) {

                                    this.lexemes.add(lexeme);
                                } else {
                                    lexeme = this.aArithmeticOperator.execute(character + "", row, column);
                                    if (lexeme != null) {

                                        this.lexemes.add(lexeme);
                                    } else {
                                        lexeme = this.a_String.execute(character + "", row, column);
                                        if (lexeme != null) {

                                            this.lexemes.add(lexeme);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                word = "";
            } else {
                validate(lexeme, word, row, column);
                word = "";
            }

            count++;

            if (character == '\n') {
                row += 1;
                count = 0;
            }
        }
        return lexemes;
    }

    public void validate(Lexeme lexeme, String word, int row, int column) {
        lexeme = this.aIterativeControlStructure.execute(word, row, column);
        if (lexeme != null) {
            this.lexemes.add(lexeme);
        } else {
            lexeme = this.aDataTypes.execute(word, row, column);
            if (lexeme != null) {
                this.lexemes.add(lexeme);
            } else {
                lexeme = this.aFunctions.execute(word, row, column);
                if (lexeme != null) {
                    this.lexemes.add(lexeme);
                } else {
                    lexeme = this.aOther.execute(word, row, column);
                    if (lexeme != null) {
                        this.lexemes.add(lexeme);
                    } else {
                        lexeme = this.aSelectiveStructures.execute(word, row, column);
                        if (lexeme != null) {
                            this.lexemes.add(lexeme);
                        } else {
                            lexeme = this.aIdentifiers.execute(word, row, column);
                            if (lexeme != null) {
                                this.lexemes.add(lexeme);
                            } else {
                                lexeme = this.aNumbers.execute(word, row, column);
                                if (lexeme != null) {
                                    this.lexemes.add(lexeme);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
