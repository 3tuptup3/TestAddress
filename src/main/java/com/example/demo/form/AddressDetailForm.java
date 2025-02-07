package com.example.demo.form;

import lombok.Data;

@Data
public class AddressDetailForm {
	// ！！バリデーション設定！！
	// messages.propatiesで型チェック
	
	// messageがない場合はSpringのメッセージが表示される
//	@NotNull(message="入力してください。")
//	@Min(value=1,  message="正の整数を入力してください。")
	private Integer addressId;
	
	private String lastName;

//	@Size(min=4, max=16, message="4文字から16文字で指定してください。")
	private String firstName;
	
	private String commonName;
	private String team;

}
