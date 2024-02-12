package com.yogeshmangal.quizapp.dao;

import com.yogeshmangal.quizapp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz, Integer> {
}
