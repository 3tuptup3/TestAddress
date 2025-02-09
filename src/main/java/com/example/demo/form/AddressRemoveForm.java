package com.example.demo.form;

import lombok.Data;

@Data
public class AddressRemoveForm {
	// ！！バリデーション設定！！
	// messages.propatiesで型チェック
	
	// messageがない場合はSpringのメッセージが表示される
//	@NotNull(message="入力してください。")
//	@Min(value=1,  message="正の整数を入力してください。")
	private Integer addressId;
	
	private String lastName;
	
	private String middleName;

//	@Size(min=4, max=16, message="4文字から16文字で指定してください。")
	private String firstName;
	
	private String maidenName;
	
	private String commonName;
	
	private String lastNameKana;
	
	private String middleNameKana;

//	@Size(min=4, max=16, message="4文字から16文字で指定してください。")
	private String firstNameKana;
	
	private String maidenNameKana;
	
	private String commonNameKana;
	
	private String category1;
	
	private String phoneNumber1;
	private String phoneNumber2;
	private String eMail1;
	private String eMail2;
	private String postCode;
	private String address;
	private String team;
	private Integer birthYear;
	private Integer birthMonth;
	private Integer birthDay;
	private String remarks;
	
}
