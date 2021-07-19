package com.example.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String question;

    private String answer;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_question_type",referencedColumnName = "id")
    private QuestionType questionType;
    @Column(name = "date_create", columnDefinition = "DATE")
    private String dateCreate;
    private String status;

    public Question() {
    }

    public Question(Integer id, String title, String question, String answer, QuestionType questionType, String dateCreate, String status) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.questionType = questionType;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
