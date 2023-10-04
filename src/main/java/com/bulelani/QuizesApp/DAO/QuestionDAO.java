package com.bulelani.QuizesApp.DAO;

import com.bulelani.QuizesApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

    List<Question> findQuestionsByCategory(String category);

    //@Query(value = "SELECT * FROM questions q WHERE q.difficulty=:difficulty", nativeQuery = true)
    //List<Questions> findQuestionsByDifficulty(String difficulty);

    @Query(value = "SELECT * FROM question WHERE difficulty=?", nativeQuery = true)
    List<Question> findQuestionsByDifficulty(String difficulty);

    //@Query(value = "UPDATE questions SET difficulty=?, question=? WHERE id=?", nativeQuery = true)
    //void updateQuestion(String difficulty, Integer id);
}
