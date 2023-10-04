package com.bulelani.QuizesApp.Model;

import lombok.*;

public class Response {

    private Integer questionID;
    private String userAnswer;

    public Response(Integer questionID, String userAnswer){
        this.questionID = questionID;
        this.userAnswer = userAnswer;
    }

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}


