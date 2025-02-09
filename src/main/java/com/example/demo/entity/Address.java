package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor		// 全てのフィールドを初期化するコンストラクタを自動生成
@NoArgsConstructor		// 引数を指定しないコンストラクタを自動生成
public class Address {

	private int addressId;
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
	private String eMail1;
	private String eMail2;
	private String postCode;
	private String address;
	private String team;
	private Integer birthYear;
	private Integer birthMonth;
	private Integer birthDay;
	private String remarks;
//	private Calendar insertDatetime;
//	private String insertUser;
//	private Calendar updateDatetime;
//	private String updateUser;
	
//	public String formatBirthYear() {
//		Integer result = Integer.valueOf(birthYear);
//		
//		if (birthYear == null) {
//			result = 0;
//		} else {
//			result = birthYear;
//		}
//	
//		return result;
//	}
}
