package com.yogeshmangal.quizapp.service;

import com.yogeshmangal.quizapp.dao.QuestionDAO;
import com.yogeshmangal.quizapp.dao.QuizDAO;
import com.yogeshmangal.quizapp.entity.Question;
import com.yogeshmangal.quizapp.entity.QuestionWrapper;
import com.yogeshmangal.quizapp.entity.Quiz;
import com.yogeshmangal.quizapp.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private QuizDAO quizDAO;
    private QuestionDAO questionDAO;

    @Autowired
    public QuizService(QuizDAO quizDAO, QuestionDAO questionDAO) {
        this.quizDAO = quizDAO;
        this.questionDAO = questionDAO;
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDAO.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDAO.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        try {
            Optional<Quiz> quiz = quizDAO.findById(id);
            List<Question> questionsFromDB = quiz.get().getQuestions();
            List<QuestionWrapper> questionsForUser = new ArrayList<>();
            for (Question q : questionsFromDB) {
                QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                questionsForUser.add(questionWrapper);
            }
            return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDAO.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        int rightAnswer = 0;
        int i = 0;
        for(Response response : responses) {
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                rightAnswer++;
            i++;
        }
        return new ResponseEntity<>(rightAnswer, HttpStatus.OK);
    }
}
