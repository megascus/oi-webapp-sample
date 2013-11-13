package com.oisix.sample.validator;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


public abstract class AbstructValidator {
	
	private List<String> errors;
	
	protected AbstructValidator(List<String> errors) {
		this.errors = errors;
	}
	
	protected boolean isEmpty(String parameter, String errorMessage) {
		boolean result = false;
		if (StringUtils.isEmpty(parameter)) {
			result = true;
			this.errors.add(errorMessage);
		}
		return result;
	}
	
	protected boolean checkLength(String parameter, int maxlength, String errorMessage) {
		boolean result = true;
		if (parameter.length() > maxlength) {
			result = false;
			this.errors.add(errorMessage);
		}
		return result;
	}

	public List<String> getErrors() {
		return errors;
	}
}
