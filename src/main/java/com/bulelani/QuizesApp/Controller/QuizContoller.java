package com.bulelani.QuizesApp.Controller;

import com.bulelani.QuizesApp.Model.QuestionsWrapper;
import com.bulelani.QuizesApp.Model.Response;
import com.bulelani.QuizesApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizContoller {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam("difficulty") String difficulty){
        return quizService.createQuiz(difficulty);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionsWrapper>> getQuiz(@PathVariable Integer id){

        return quizService.getQuiz(id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteQuiz(@PathVariable Integer id){

        return quizService.deleteQuiz(id);
    }

    @GetMapping("allQuizzes")
    public ResponseEntity<List<QuestionsWrapper>> getAllQuizes(){
        return quizService.getAllQuizes();
    }

    @PostMapping("submit")
    public ResponseEntity<String> submitAnswers(@RequestBody List<Response> response){
        return quizService.submitAnswers(response);
    }
}
