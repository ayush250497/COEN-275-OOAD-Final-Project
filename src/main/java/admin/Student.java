/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

/**
 *
 * @author omambalkar
 */
public class Student {
    
    private String name;
    private Score score;
    
    public Student(String name) {
        this.name = name;
        this.score = new Score();
    }
    
    
    public String getName() {
        return this.name;     
    }
    
    public Score getScore() {
        return this.score;
    }
}
