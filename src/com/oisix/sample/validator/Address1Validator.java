package com.oisix.sample.validator;

import java.util.List;

public class Address1Validator extends AbstructValidator {
	
	public Address1Validator(List<String> fieldErrors) {
		super(fieldErrors);
	}
	
	public void validate(String parameter) {
		if (isEmpty(parameter, "住所１(市区郡町村)を入力してください。")) return;
		if (checkLength(parameter, 256, "住所１(市区郡町村)は256文字以下で入力してください。")) return;
	}
	
}
