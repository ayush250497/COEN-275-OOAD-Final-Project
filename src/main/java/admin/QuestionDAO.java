
package admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omambalkar
 */
public class QuestionDAO {

    private Connection connection;

    public QuestionDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionbank", "root", "");
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createQuestionTable() {
        String createQuestionTableSQL = "CREATE TABLE questiontable " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " question TEXT, " +
                " type VARCHAR(255), " +
                " topic VARCHAR(255), " +
                " options TEXT, " +
                " no_options INTEGER, " +
                " answer TEXT, " +
                " media TEXT, " +
                " PRIMARY KEY ( id ))";

        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(createQuestionTableSQL);
            System.out.println("Created table Succesfully !!");
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertInQuestionTable(String question, String type, String options, int no_options, String answer,
            String media, String topic) {
        String insertSql = "INSERT INTO questiontable (question, type, topic, options, no_options, answer, media) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(insertSql);
            pstmt.setString(1, question);
            pstmt.setString(2, type);
            pstmt.setString(3, topic);
            pstmt.setString(4, options);
            pstmt.setInt(5, no_options);
            pstmt.setString(6, answer);
            pstmt.setString(7, media);

            pstmt.executeUpdate();
            System.out.println("Inserted 1 row to question table");

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Question> selectQuestions() {
        String selectAllSql = "Select * from questionTable";
        ArrayList<Question> questions = new ArrayList<>();
        try (
                Statement statement = this.connection.createStatement();
                ResultSet rs = statement.executeQuery(selectAllSql);) {
            while (rs.next()) {
                String quesText = rs.getString("question");
                String type = rs.getString("type");
                String options = rs.getString("options");
                int noOfOptions = rs.getInt("no_options");
                String answer = rs.getString("answer");
                String media = rs.getString("media");

                Question ques = null;
                if (type.equals("MCQ")) {
                    ques = new MCQType(quesText, options, answer, noOfOptions, type);
                } else if (type.equals("FIB")) {
                    ques = new FIBType(quesText, answer, type);
                } else {
                    ques = new InteractiveType(quesText, options, answer, noOfOptions, media, type);
                }

                questions.add(ques);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }
}
