/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omambalkar
 */
public class StudentDAO {
    private Connection connection;
    
    public StudentDAO(){
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/questionbank","root","");  
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createStudentTable() {
        String createStudentTableSQL = "CREATE TABLE studentTable " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " name VARCHAR(255), " + 
                   " spelling_score int, " + 
                   " geography_score int, " +
                   " PRIMARY KEY ( id ))"; 
        
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(createStudentTableSQL);
            System.out.println("Created table Succesfully !!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void insertStudent(Student student, String topic) {
              
        Student existingStudent = this.selectStudentByName(student.getName());
        try {
            if(existingStudent == null || existingStudent.equals("")) {
                String insertSql = "INSERT INTO studentTable (name, spelling_score, geography_score) VALUES (?,?,?)"; 
                
                PreparedStatement pstmt = this.connection.prepareStatement(insertSql);
                pstmt.setString(1, student.getName());
                pstmt.setInt(2, student.getScore().getSpellingScore());
                pstmt.setInt(3, student.getScore().getGeographyScore());

                pstmt.executeUpdate();
                System.out.println("Inserted 1 row to student table");
            } else {
                String updateSql = "UPDATE studentTable " +
                    "SET spelling_score = "+student.getScore().getSpellingScore()+
                    " WHERE name = '"+ student.getName()+ "'";
                
                if (topic.equals("Geography")) {
                    updateSql = "UPDATE studentTable " +
                    "SET geography_score = "+ student.getScore().getGeographyScore()+
                    " WHERE name = '"+ student.getName() + "'";
                }
                
                Statement stmt = this.connection.createStatement();
                stmt.executeUpdate(updateSql);
            }
        
        } catch (SQLException ex) {
                Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public Student selectStudentByName(String name) {
        String selectSql = "Select * from studentTable where name = '" + name + "'";
        Student student = null;
        try(
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(selectSql);
        ) {
            while(rs.next()) {
                student = new Student(name, new Score(rs.getInt("spelling_score"), rs.getInt("geography_score")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return student;
    }

    public ArrayList<Student> selectAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String selectAllSql = "Select * from studentTable";
        try(
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(selectAllSql);
        ) {
            while(rs.next()){
                String name = rs.getString("name");
                int spelling_score = rs.getInt("spelling_score");
                int geography_score = rs.getInt("geography_score");
              
                students.add(new Student(name, new Score(spelling_score, geography_score)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return students;
    }
    
}
