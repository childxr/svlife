package com.rxlab.service.interview;

import java.util.List;

import com.rxlab.pojo.Knowledge;

public interface KnowledgeService {
	
	public List<Knowledge> getAllKnowledge();
	public List<Knowledge> getAllKnowledgeByType(String type);
	public Knowledge getKnowLedgeById(int id);
	public List<Knowledge> getAllKnowledgeByPage(String category, int numPerPage, int pageNum, int count);
	public int countAllKnowledge(String category);
	public Knowledge getRandomKnowledge(String category);
	public void addKnowledge(Knowledge knowledge);
	
}
