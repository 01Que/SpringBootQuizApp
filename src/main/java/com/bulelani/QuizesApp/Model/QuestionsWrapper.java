package com.bulelani.QuizesApp.Model;

import lombok.Data;

@Data
public class QuestionsWrapper {
    private Integer id;
    private String difficulty, option1, option2,
            option3, option4, option5, question;

    public QuestionsWrapper(Integer id, String difficulty, String option1,
                            String option2, String option3, String option4,
                            String option5, String question)
    {
        this.id = id;
        this.difficulty = difficulty;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.question = question;

    }
}
