package com.oisix.sample.validator;

import java.util.List;

public class FullnameKanaValidator extends AbstructValidator {
	
	public FullnameKanaValidator(List<String> errors) {
		super(errors);
	}
	
	public void validate(String parameter) {
		if (isEmpty(parameter, "氏名(カナ)を入力してください。")) return;
		if (!checkLength(parameter, 256, "氏名(カナ)は256文字以下で入力してください。")) return;
	}
}
