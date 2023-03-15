/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

/**
 *
 * @author omambalkar
 */
public class Score {
    
    
    private int spellingScore;
    private int geographyScore;
    
    public Score() {
        this.spellingScore = 0;
        this.geographyScore = 0;
    }
    
    public Score(int spellingScore,int geographyScore) {
        this.spellingScore = spellingScore;
        this.geographyScore = geographyScore;
    }
    
    public void setSpellingScore(int score) {
        this.spellingScore = score;
    }
    
    public void setGeographyScore(int score) {
        this.geographyScore = score;
    }
    
    public void incrementSpellingScore() {
        this.spellingScore++;
    }
     
    public void incrementGeographyScore() {
        this.geographyScore++;
    }
    
    public int getGeographyScore() {
        return this.geographyScore;
    }
    
    public int getSpellingScore() {
        return this.spellingScore;
    }
}
