
package admin;

import java.util.ArrayList;

/**
 *
 * @author omambalkar
 */
public class Test {
    
    public Test() {}
    
    public ArrayList<Question> getTest(String topic) {
        
        QuestionDAO qDao = new QuestionDAO();
        return qDao.selectQuestions(topic);
    }
    
}
