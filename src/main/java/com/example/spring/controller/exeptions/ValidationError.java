package com.example.spring.controller.exeptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;

	private List<FildMessage> list = new ArrayList<FildMessage>();
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);

	}

	public List<FildMessage> getErros() {
		return list;
	}

	public void addError(String filName, String message) {
		list.add(new FildMessage(filName, message));
	}
	
	
}
