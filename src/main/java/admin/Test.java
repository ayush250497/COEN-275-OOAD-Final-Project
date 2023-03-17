
package admin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omambalkar
 */
public class Test {

    public Test() {
    }

    public ArrayList<Question> getTest(String topic) {
        QuestionDAO qDao = new QuestionDAO();
        List<Question> questions = qDao.selectQuestions(topic);
        return selectRandomQuestions(questions);
    }

    private ArrayList<Question> selectRandomQuestions(List<Question> questions) {
        ArrayList<Question> test = new ArrayList<>();
        ArrayList<Question> tempM = new ArrayList<>();
        ArrayList<Question> tempI = new ArrayList<>();
        ArrayList<Question> tempG = new ArrayList<>();
        for (Question question: questions) {
            if(question.getType().equals("MCQ") || question.getType().equals("FIB")) {
                tempM.add(question);
            } else if (question.getType().equals("Interactive")) {
                tempI.add(question);
            } else {
                tempG.add(question);
            }
        }
        
        int i = 1;
        while (i <= 7) {
            int random = (int) (Math.random() * tempM.size());
            test.add(tempM.get(random));
            tempM.remove(random);
            i++;
        }
        
        while (i <= 9) {
            int random = (int) (Math.random() * tempI.size());
            test.add(tempI.get(random));
            tempI.remove(random);
            i++;
        }
        
        while (i <= 10) {
            int random = (int) (Math.random() * tempG.size());
            test.add(tempG.get(random));
            tempG.remove(random);
            i++;
        }
        
        return test;
        
    }
}
