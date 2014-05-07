package com.rxlab.service.interview;

import java.util.List;

import com.rxlab.pojo.Quiz;

public interface QuizService {
	public void addQuiz(Quiz quiz);
	public int countQuiz(String category);
	public List<Quiz> getQuizByPage(String category, int numPerPage, int pageNum, int count);
}
