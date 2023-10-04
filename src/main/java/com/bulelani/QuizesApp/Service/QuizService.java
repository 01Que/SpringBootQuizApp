package com.bulelani.QuizesApp.Service;

import com.bulelani.QuizesApp.DAO.QuestionDAO;
import com.bulelani.QuizesApp.DAO.QuizDAO;
import com.bulelani.QuizesApp.Model.Question;
import com.bulelani.QuizesApp.Model.QuestionsWrapper;
import com.bulelani.QuizesApp.Model.Quiz;
import com.bulelani.QuizesApp.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<String> createQuiz(String difficulty) {
        try {
            List<Question> questions = questionDAO.findQuestionsByDifficulty(difficulty);
            Quiz quiz = new Quiz(difficulty, questions);
            quizDAO.save(quiz);
            return new ResponseEntity<>("quiz created success", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseEntity<List<QuestionsWrapper>> getQuiz(Integer id) {
        try {
            Optional<Quiz> quiz = quizDAO.findById(id);
            List<Question> questions = quiz.get().getQuestions();
            List<QuestionsWrapper> questionsWrappers = new ArrayList<>();
            for (Question question : questions) {
                QuestionsWrapper questionsWrapper = new QuestionsWrapper(question.getId(), question.getDifficulty(),
                        question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4(),
                        question.getOption5(), question.getQuestion());
                questionsWrappers.add(questionsWrapper);
            }
            return new ResponseEntity<>(questionsWrappers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public ResponseEntity<Boolean> deleteQuiz(Integer id) {
        try {
            //quizDAO.deleteById(id);
            Optional<Quiz> quizOptional = quizDAO.findById(id);
            if(quizOptional.isPresent()) {
                Quiz quiz = quizOptional.get();
                quizDAO.delete(quiz);
                return new ResponseEntity<>(true, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseEntity<List<QuestionsWrapper>> getAllQuizes() {
        try{
            List<QuestionsWrapper> questionsWrappers = new ArrayList<>();
            List<Quiz>  quizes = quizDAO.findAll();
            for(Quiz quiz: quizes) {
                List<Question> questions = quiz.getQuestions();
                for (Question question : questions) {
                    QuestionsWrapper questionsWrapper = new QuestionsWrapper(question.getId(), question.getDifficulty(),
                            question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4(),
                            question.getOption5(), question.getQuestion());
                    questionsWrappers.add(questionsWrapper);
                }
            }
            return new ResponseEntity<>(questionsWrappers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseEntity<String> submitAnswers(List<Response> responses) {
        Integer correct = 0, wrong = 0, count = 0;
        List<Question> questions = questionDAO.findAll();
        try {
            for(Response response: responses) {
                for (Question question : questions) {
                    if (question.getId() == response.getQuestionID()) {
                        count++;
                        if (question.getAnswer().equalsIgnoreCase(response.getUserAnswer())){
                            correct++;
                            break;
                        }
                    }

                }
            }
            return new ResponseEntity<>("correct: "+correct+"\nwrong: "+(count - correct)+"", HttpStatus.CREATED);

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
