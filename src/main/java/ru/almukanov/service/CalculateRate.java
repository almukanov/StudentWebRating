package ru.almukanov.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class CalculateRate {
    double answerActivity;

    public CalculateRate() {
    }

    double selfActivity;
    double questionActivity;

    public double getAnswerActivity() {
        return answerActivity;
    }

    public void setAnswerActivity(double answerActivity) {
        this.answerActivity = answerActivity;
    }

    public double getSelfActivity() {
        return selfActivity;
    }

    public void setSelfActivity(double selfActivity) {
        this.selfActivity = selfActivity;
    }

    public double getQuestionActivity() {
        return questionActivity;
    }

    public void setQuestionActivity(double questionActivity) {
        this.questionActivity = questionActivity;
    }

    public CalculateRate(double answerActivity, double selfActivity, double questionActivity) {
        this.answerActivity = answerActivity;
        this.selfActivity = selfActivity;
        this.questionActivity = questionActivity;
    }
}
