package com.yogeshmangal.quizapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "question_title")
    private String questionTitle;
    @Column(name = "option1")
    private String option1;
    @Column(name = "option2")
    private String option2;
    @Column(name = "option3")
    private String option3;
    @Column(name = "option4")
    private String option4;
    @Column(name = "right_answer")
    private String rightAnswer;
    @Column(name = "difficulty_level")
    private String difficultyLevel;

    @Column(name = "category")
    private String category;

    //Lombok i.e. @Data will automatically handle the constructors and gettters and setters work.
}
