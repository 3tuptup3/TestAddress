package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Address;
import com.example.demo.form.AddressSearchForm;

public interface AddressRepository {

	/*--- 検索 ---*/
//	List<Address> selectByNameWildcard(String lastName);
	List<Address> selectByNameWildcard(AddressSearchForm search);
	
//	/*--- 詳細画面表示 ---*/
//	List<Address> selectByAddressId(int addressId);

	/*--- 登録 ---*/
	void add(Address address);

	/*--- 更新 ---*/
	void update(Address address);

	/*--- 削除 ---*/
	void delete(Address address);

}
