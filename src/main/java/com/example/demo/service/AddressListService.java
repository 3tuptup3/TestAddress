package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Address;

public interface AddressListService {

	// 部分一致検索
	List<Address> findByNameWildcard(String lastName);
	
//	// 詳細画面表示
//	List<Address> findByAddressId(int addressId);
	
}
