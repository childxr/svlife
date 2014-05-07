package com.rxlab.service.interview;

import com.rxlab.pojo.Exam;

public interface ExamService {
	public void addExam(Exam exam);
	public Exam getExamById(int examId);
	public int countExam();
}
