package com.oisix.sample.validator;

import java.util.List;

public class TodofukenValidator extends AbstructValidator {
	
	public TodofukenValidator(List<String> errors) {
		super(errors);
	}
	
	public void validate(String todofuken) {
		if (isEmpty(todofuken, "都道府県を入力してください。")) return;
		if (checkLength(todofuken, 8, "都道府県は8文字以下で入力してください。")) return;
	}
	
}
