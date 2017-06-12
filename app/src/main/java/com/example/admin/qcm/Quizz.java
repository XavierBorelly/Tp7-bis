package com.example.admin.qcm;

/**
 * Created by admin on 12/06/2017.
 */

public class Quizz {

    private String question;
    private String reponse1;
    private String reponse2;

    public Quizz(String question, String reponse1, String reponse2){
        this.question = question;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse1() {
        return reponse1;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

}
