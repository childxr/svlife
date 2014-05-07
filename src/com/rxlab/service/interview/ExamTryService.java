package com.rxlab.service.interview;

import com.rxlab.pojo.ExamTry;
import java.util.List;
public interface ExamTryService {
	public void addExamTry(ExamTry examtry);
	public List<ExamTry> getExamTryByPage(int numPerPage, int count, int pageNum);
	public int countExamTry();
}
