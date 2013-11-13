package com.oisix.sample.validator;

import java.util.List;

public class ZipCodeValidator extends AbstructValidator {
	
	public ZipCodeValidator(List<String> errors) {
		super(errors);
	}
	
	public void validate(String parameter) {
		if (isEmpty(parameter, "郵便番号を入力してください。")) return;
		if (checkLength(parameter, 8, "郵便番号は8文字以下(ハイフン含む)で入力してください。")) return;
	}
	
}
