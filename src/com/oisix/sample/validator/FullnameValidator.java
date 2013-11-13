package com.oisix.sample.validator;

import java.util.List;

public class FullnameValidator extends AbstructValidator {
	
	public FullnameValidator(List<String> errors) {
		super(errors);
	}
	
	public void validate(String parameter) {
		if (isEmpty(parameter, "氏名を入力してください。")) return;
		if (!checkLength(parameter, 256, "氏名は256文字以下で入力してください。")) return;
	}
}
