/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Token;
import Model.LexicalAnalyzer;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daryl Ospina
 */
public class CtlLexicalAnalyzer {
    
    private LexicalAnalyzer lexicalAnalyzer;
    
    public DefaultTableModel analyze(String text){
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Lexeme");
        model.addColumn("Type");
        model.addColumn("Positions");
        
        this.lexicalAnalyzer = new LexicalAnalyzer(text);
        ArrayList<Token> tokens = this.lexicalAnalyzer.analyze();
        
        for (Token token: tokens) {
            model.addRow(new Object[]{
                token.getLexeme().getText(),
                token.getType(),
                "Row: "+token.getLexeme().getRow()+" - Columns: "+token.getLexeme().getColumns().toString()
            });
        }
        return model;
    }
}
