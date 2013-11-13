package com.oisix.sample.validator;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class TelValidator extends AbstructValidator {
	
	public TelValidator(List<String> errors) {
		super(errors);
	}
	
	public void validate(String tel1, String tel2, String tel3) {
		if (StringUtils.isEmpty(tel1) || StringUtils.isEmpty(tel2) || StringUtils.isEmpty(tel3)) {
			List<String> error = getErrors();
			error.add("電話番号で入力されていない箇所があります。");
		}
	}
	
}
