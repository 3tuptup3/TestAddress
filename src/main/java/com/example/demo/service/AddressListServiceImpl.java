package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.form.AddressSearchForm;
import com.example.demo.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressListServiceImpl implements AddressListService {
	
	private final AddressRepository repository;

	/*--- 連絡先リスト検索 ---*/
	@Override
	public List<Address> findByNameWildcard(AddressSearchForm search) {
		
		List<Address> list = repository.selectByNameWildcard(search);
		
		return list;
	}
	
}
