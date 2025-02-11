package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Address;
import com.example.demo.form.AddressSearchForm;

public interface AddressListService {

	/*--- 連絡先リスト検索 ---*/
	List<Address> findByNameWildcard(AddressSearchForm search);

//	/*--- ドロップダウン（区分）リスト検索 ---*/
//	List<String> findCategoryList();
	
}
