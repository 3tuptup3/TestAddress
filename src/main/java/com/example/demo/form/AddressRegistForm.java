package com.example.demo.form;

import java.nio.charset.StandardCharsets;

import org.hibernate.validator.constraints.Range;
import org.thymeleaf.util.StringUtils;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressRegistForm {
	/*--- バリデーション設定 ---*/
	// messages.propatiesで型チェック
	private Integer addressId;
	private String lastName;
	private String middleName;
	private String firstName;
	private String maidenName;
	private String commonName;
	private String lastNameKana;
	private String middleNameKana;
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
	@Pattern(regexp="^[0-9]{7}$|^$", message="郵便番号は7桁の半角数字（ハイフンなし）で入力してください。")
	private String postCode;
	private String address;
	private String team;
	@Range(min=0, max=9999, message="正しい誕生年（西暦）を入力してください。")
	private Integer birthYear;
	@Range(min=1, max=12, message="正しい誕生月を入力してください。")
	private Integer birthMonth;
	@Range(min=1, max=31, message="正しい誕生日を入力してください。")
	private Integer birthDay;
	private String remarks;

    @AssertTrue(message="姓が長すぎます")
    public boolean isLastNameBytes(){
    	if (lastName.getBytes(StandardCharsets.UTF_8).length > 20) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="ミドルネームが長すぎます")
    public boolean isMiddleNameBytes(){
    	if (middleName.getBytes(StandardCharsets.UTF_8).length > 50) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="名が長すぎます")
    public boolean isFirstNameBytes(){
    	if (firstName.getBytes(StandardCharsets.UTF_8).length > 20) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="旧姓が長すぎます")
    public boolean isMaidenNameBytes(){
    	if (maidenName.getBytes(StandardCharsets.UTF_8).length > 20) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="通名が長すぎます")
    public boolean isCommonNameBytes(){
    	if (commonName.getBytes(StandardCharsets.UTF_8).length > 50) {
            return false;
        }
        return true;
    }

    @AssertTrue(message="姓（かな）が長すぎます")
    public boolean isLastNameKanaBytes(){
    	if (lastNameKana.getBytes(StandardCharsets.UTF_8).length > 20) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="ミドルネーム（かな）が長すぎます")
    public boolean isMiddleNameKanaBytes(){
    	if (middleNameKana.getBytes(StandardCharsets.UTF_8).length > 50) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="名（かな）が長すぎます")
    public boolean isFirstNameKanaBytes(){
    	if (firstNameKana.getBytes(StandardCharsets.UTF_8).length > 20) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="旧姓（かな）が長すぎます")
    public boolean isMaidenNameKanaBytes(){
    	if (maidenNameKana.getBytes(StandardCharsets.UTF_8).length > 20) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="通名（かな）が長すぎます")
    public boolean isCommonNameKanaBytes(){
    	if (commonNameKana.getBytes(StandardCharsets.UTF_8).length > 50) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="区分が長すぎます")
    public boolean isCategory1Bytes(){
    	if (category1.getBytes(StandardCharsets.UTF_8).length > 20) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="住所が長すぎます")
    public boolean isAddressBytes(){
    	if (address.getBytes(StandardCharsets.UTF_8).length > 100) {
            return false;
        }
        return true;
    }
    
    @AssertTrue(message="所属が長すぎます")
    public boolean isTeamBytes(){
    	if (team.getBytes(StandardCharsets.UTF_8).length > 50) {
            return false;
        }
        return true;
    }

    @AssertTrue(message="姓、名、通名のいずれかは必須項目です。")
    public boolean isNameEmpty(){
        if (StringUtils.isEmpty(lastName) && 
        		StringUtils.isEmpty(firstName) &&
        		StringUtils.isEmpty(commonName)) {
            return false;
        }
        return true;
    }
}
