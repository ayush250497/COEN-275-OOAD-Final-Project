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
public class MCQType implements Question{
    
    private String question;
    private ArrayList<String> options;
    private String answer;
    private int noOfOptions;
    private String type;
    
    public MCQType(String question, String options, String answer, int noOfOptions, String type) {
        this.question = question;
        this.options = this.changeOptions(options);
        this.answer = answer;
        this.noOfOptions = noOfOptions;
        this.type = type;
    }
    
    private ArrayList<String> changeOptions(String options){
        
        return new ArrayList<>(Arrays.asList(options.split(",")));    
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
        return this.options;
    }

    @Override
    public ArrayList<String> getMedia() {
        return new ArrayList();
    }
    
    @Override
    public String getType() {
        return this.type;
    }
}
