/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author omambalkar
 */
public class FIBType implements Question{
    private String question;
    private String answer;
    private String type;
    
    public FIBType(String question, String answer, String type) {
        this.question = question;
        this.answer = answer;
        this.type = type;
    }
    
    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public String getAnswer() {
        return this.answer;
    }

    @Override
    public ArrayList<String> getOptions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMedia() {
        return "";
    }
    
    @Override
    public String getType() {
        return this.type;
    }
}
