package com.oisix.sample.validator;

import java.util.List;

public class Address2Validator extends AbstructValidator {
	
	public Address2Validator(List<String> fieldErrors) {
		super(fieldErrors);
	}
	
	public void validate(String parameter) {
		if (isEmpty(parameter, "住所２(番地号・建物名)を入力してください。")) return;
		if (checkLength(parameter, 256, "住所２(番地号・建物名)は256文字以下で入力してください。")) return;
	}
	
}
