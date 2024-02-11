package com.yogeshmangal.quizapp.service;

import com.yogeshmangal.quizapp.dao.QuestionDAO;
import com.yogeshmangal.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private QuestionDAO questionDAO;

    @Autowired
    public QuestionService(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }
    public List<Question> getAllQuestions() {
        return questionDAO.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDAO.save(question);
        return "success";
    }

    public Optional<Question> getQuestion(Integer id) {
        return questionDAO.findById(id);
    }
}
