/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Daryl Ospina
 */
public class Lexeme {
    
    private ArrayList<Integer> columns;
    private int row;
    private String text;

    public Lexeme(ArrayList<Integer> column, int row, String text) {
        this.columns = column;
        this.row = row;
        this.text = text;
    }

    public ArrayList<Integer> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<Integer> columns) {
        this.columns = columns;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
