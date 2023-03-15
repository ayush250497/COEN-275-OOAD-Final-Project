
package admin;

import java.util.ArrayList;

/**
 *
 * @author omambalkar
 */
public class Test {
    
    private ArrayList<Question> questions;
    
    public Test() {
        QuestionDAO qDao = new QuestionDAO();
        questions = qDao.selectQuestions();
    }
    
    public ArrayList<Question> getTest() {
        
        
        return this.questions;
    }
    
}
