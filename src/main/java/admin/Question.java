/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package admin;

import java.util.List;

/**
 *
 * @author omambalkar
 */
public interface Question {
    
    public String getQuestion();
    public String getAnswer();
    public List<String> getOptions();
    public List<String> getMedia();
    public String getType();
    
}
