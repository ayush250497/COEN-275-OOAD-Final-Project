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
public class InteractiveType implements Question{
    private String question;
    private ArrayList<String> options;
    private String answer;
    private int noOfOptions;
    private String type;
    private ArrayList<String> media;
    
    
    public InteractiveType(String question, String options, String answer, int noOfOptions, String media, String type) {
        this.question = question;
        this.options = new ArrayList();
        this.answer = answer;
        this.noOfOptions = noOfOptions;
        this.media = this.changeOptions(media);
        this.type = type;
    }
    
    private ArrayList<String> changeOptions(String media){
        return new ArrayList<>(Arrays.asList(media.split(","))); 
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
        return this.media;
    }
    
    @Override
    public String getType() {
        return this.type;
    }
}
