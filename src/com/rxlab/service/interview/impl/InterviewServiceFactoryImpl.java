package com.rxlab.service.interview.impl;

import java.util.ArrayList;
import java.util.List;

import com.rxlab.dao.interview.CategoryDAO;
import com.rxlab.dao.interview.CodeCommentDAO;
import com.rxlab.dao.interview.CodeDAO;
import com.rxlab.dao.interview.ExamDAO;
import com.rxlab.dao.interview.ExamTryDAO;
import com.rxlab.dao.interview.KnowledgeDAO;
import com.rxlab.dao.interview.QuizDAO;
import com.rxlab.pojo.Category;
import com.rxlab.pojo.Code;
import com.rxlab.pojo.CodeComment;
import com.rxlab.pojo.Knowledge;
import com.rxlab.pojo.Quiz;
import com.rxlab.pojo.Exam;
import com.rxlab.pojo.ExamTry;
import com.rxlab.service.interview.CategoryService;
import com.rxlab.service.interview.KnowledgeService;
import com.rxlab.service.interview.QuizService;
import com.rxlab.service.interview.CodeService;
import com.rxlab.service.interview.CodeCommentService;
import com.rxlab.service.interview.ExamService;
import com.rxlab.service.interview.ExamTryService;

public class InterviewServiceFactoryImpl implements KnowledgeService, CategoryService, QuizService, CodeService, CodeCommentService, ExamService, ExamTryService {
	
	@Override
	public List<Knowledge> getAllKnowledge() {
		KnowledgeDAO dao = new KnowledgeDAO();
		List<Knowledge> knowledgeList = dao.getAllKnowledge();
		return knowledgeList;
	}
	
	@Override
	public List<Knowledge> getAllKnowledgeByType(String type) {
		return null;
	}
	
	@Override
	public Knowledge getKnowLedgeById(int id) {
		KnowledgeDAO dao = new KnowledgeDAO();
		return dao.getKnowledgeById(id);
	}
	
	@Override
	public List<Knowledge> getAllKnowledgeByPage(String category, int numPerPage, int pageNum, int count) {
		KnowledgeDAO dao = new KnowledgeDAO();
		List<Knowledge> knowledgeList = dao.getAllKnowledgeByPage(category, numPerPage, pageNum, count);
		return knowledgeList;
	}
	
	@Override
	public int countAllKnowledge(String category) {
		KnowledgeDAO dao = new KnowledgeDAO();
		 return dao.countKnowledge(category);
	}

	
	@Override
	public List<String> getAllKnowledgeCategories() {
		CategoryDAO dao = new CategoryDAO();
		List<Category> list = dao.getAllKnowledgeCategories();
		List<String> categoryList = new ArrayList<String> ();
		for (Category c: list) {
			categoryList.add(c.getCategory());
		}
		return categoryList;
	}
	
	@Override
	public Knowledge getRandomKnowledge(String category) {
		KnowledgeDAO dao = new KnowledgeDAO();
		return dao.getRandomKnowledge(category);
	}
	
	@Override
	public void addQuiz(Quiz quiz) {
		QuizDAO dao = new QuizDAO();
		dao.addQuiz(quiz);
	}
	
	@Override
	public int countQuiz(String category) {
		QuizDAO dao = new QuizDAO();
		return dao.countQuiz(category);
	}
	
	@Override
	public List<Quiz> getQuizByPage(String category, int numPerPage, int pageNum, int count) {
		QuizDAO dao = new QuizDAO();
		return dao.getAllQuizByPage(category, numPerPage, count, pageNum);
	}
	
	@Override
	public List<Code> getAllCode(String category) {
		CodeDAO dao = new CodeDAO();
		return dao.getAllCode(category);
	}
	
	@Override
	public Code getCodeById(int id) {
		CodeDAO dao = new CodeDAO();
		return dao.getCodeById(id);
	}
	
	@Override
	public List<CodeComment> getCodeCommentbyCodeId(int id){
		CodeCommentDAO dao = new CodeCommentDAO();
		return dao.getCodeCommentByCodeId(id);
	}
	
	@Override
	public void addCodeComment(CodeComment ccomment) {
		CodeCommentDAO dao = new CodeCommentDAO();
		dao.addCodeComment(ccomment);
	}
	
	@Override
	public List<CodeComment> listCodeCommentHistoryByPage(int pageNum, int numPerPage, int count, String category) {
		CodeCommentDAO dao = new CodeCommentDAO();
		return dao.listCodeCommentHistoryByPage(pageNum, numPerPage, count, category);
	}
	
	@Override
	public int countCodeComment(String category) {
		CodeCommentDAO dao = new CodeCommentDAO();
		return dao.countCodeComment(category);
	}
	
	@Override
	public void addCode(Code code) {
		CodeDAO dao = new CodeDAO();
		dao.addCode(code);
	}
	
	@Override
	public void addKnowledge(Knowledge knowledge) {
		KnowledgeDAO dao = new KnowledgeDAO();
		dao.addKnowledge(knowledge);
	}
	
	@Override
	public void addExam(Exam exam) {
		ExamDAO dao = new ExamDAO();
		dao.addExam(exam);
	}
	
	@Override
	public Exam getExamById(int examId) {
		ExamDAO dao = new ExamDAO();
		return dao.getExamById(examId);
	}
	
	@Override
	public void addExamTry(ExamTry examtry) {
		ExamTryDAO dao = new ExamTryDAO();
		dao.addExamTry(examtry);
	}
	
	@Override
	public int countExam() {
		ExamDAO dao = new ExamDAO();
		return dao.countExam();
	}
	
	@Override
	public List<ExamTry> getExamTryByPage(int numPerPage, int count, int pageNum) {
		ExamTryDAO dao = new ExamTryDAO();
		return dao.getExamTryByPage(numPerPage, count, pageNum);
	}
	
	@Override
	public int countExamTry () {
		ExamTryDAO dao = new ExamTryDAO();
		return dao.countExamTry();
	}
}
