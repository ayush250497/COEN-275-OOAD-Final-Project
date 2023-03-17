
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
        int i = 0;
        while (i < 10) {
            int random = (int) (Math.random() * questions.size());
            test.add(questions.get(random));
            questions.remove(random);
            i++;
        }
        return test;
    }
}
