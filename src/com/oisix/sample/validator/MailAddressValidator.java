package com.oisix.sample.validator;

import java.util.List;

public class MailAddressValidator extends AbstructValidator {
	
	public MailAddressValidator(List<String> fieldErrors) {
		super(fieldErrors);
	}
	
	public void validate(String mailAddress) {
		if (isEmpty(mailAddress, "メールアドレスを入力してください。")) return;
		if (!checkLength(mailAddress, 256, "メールアドレスは256文字以下で入力してください。")) return;
	}
	
}
