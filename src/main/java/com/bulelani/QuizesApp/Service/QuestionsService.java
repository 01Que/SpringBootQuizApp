package com.bulelani.QuizesApp.Service;

import com.bulelani.QuizesApp.DAO.QuestionDAO;
import com.bulelani.QuizesApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDAO.findQuestionsByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDAO.save(question);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("question created success", HttpStatus.CREATED);
    }

    public ResponseEntity<Boolean> updateQuestion(Integer id, String difficulty) {
        try {
            Optional<Question> question = questionDAO.findById(id);
                if(question != null) {
                    question.get().setDifficulty(difficulty);
                    questionDAO.saveAndFlush(question.get());
                    return new ResponseEntity<>(true, HttpStatus.CREATED);
                }
            }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
