package com.bulelani.QuizesApp.Controller;

import com.bulelani.QuizesApp.Model.Question;
import com.bulelani.QuizesApp.Service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionsController {

    @Autowired
    QuestionsService questionsService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionsService.getAllQuestions();
    }

    @GetMapping("category/{value}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("value") String category){
        return questionsService.getQuestionsByCategory(category);
    }

    @PostMapping("create")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionsService.addQuestion(question);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Boolean> updateQuestion(@PathVariable("id") Integer id,
                                                  @RequestParam("difficulty") String difficulty){
        return questionsService.updateQuestion(id, difficulty);
    }

}
