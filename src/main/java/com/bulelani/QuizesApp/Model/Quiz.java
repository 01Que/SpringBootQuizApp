package com.bulelani.QuizesApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String difficulty;
    @ManyToAny
    private List<Question> questions;

    public Quiz(String difficulty, List<Question> questions){
        this.difficulty = difficulty;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
