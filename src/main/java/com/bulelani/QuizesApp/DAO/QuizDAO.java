package com.bulelani.QuizesApp.DAO;

import com.bulelani.QuizesApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {
}
