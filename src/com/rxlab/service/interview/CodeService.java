package com.rxlab.service.interview;

import com.rxlab.pojo.Code;
import java.util.*;

public interface CodeService {
	public List<Code> getAllCode(String category);
	public Code getCodeById(int id);
	public void addCode(Code code);
}
