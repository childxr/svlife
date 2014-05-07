package com.rxlab.service.interview;

import java.util.List;
import com.rxlab.pojo.CodeComment;

public interface CodeCommentService {
	public List<CodeComment> getCodeCommentbyCodeId(int id);
	public void addCodeComment(CodeComment ccomment);
	public List<CodeComment> listCodeCommentHistoryByPage(int pageNum, int numPerPage, int count, String category);
	public int countCodeComment(String category);
}
