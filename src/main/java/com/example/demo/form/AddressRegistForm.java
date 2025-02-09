package com.example.demo.form;

import org.thymeleaf.util.StringUtils;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class AddressRegistForm {
	// ！！バリデーション設定！！
	// messages.propatiesで型チェック
	
	// messageがない場合はSpringのメッセージが表示される
//	@NotNull(message="入力してください。")
//	@Min(value=1,  message="正の整数を入力してください。")


//	@Size(min=4, max=16, message="4文字から16文字で指定してください。")
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
	@Email(message="メールアドレス1の形式が間違っています。")
	private String eMail1;
	@Email(message="メールアドレス2の形式が間違っています。")
	private String eMail2;
	private String postCode;
	private String address;
	private String team;
	private Integer birthYear;
	@Min(value=1,  message="正しい誕生月を入力してください。")
	@Max(value=12,  message="正しい誕生月を入力してください。")
	private Integer birthMonth;
	private Integer birthDay;
	private String remarks;
	

    @AssertTrue(message="姓、名、通名、所属のいずれかは必須項目です。")
    public boolean isNameEmpty(){
//        if ((lastName == "" ) && 
//        		firstName == "" &&
//        		commonName == "" &&
//        		team == "") {
        if (StringUtils.isEmpty(lastName) && 
        		StringUtils.isEmpty(firstName) &&
        		StringUtils.isEmpty(commonName) &&
        		StringUtils.isEmpty(team)) {
            return false;
        }
        return true;
    }
}
