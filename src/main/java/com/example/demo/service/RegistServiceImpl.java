package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService {

	// @RequiredArgsConstructor→repositoryを初期化するコンストラクタが生成
	// →repositoryをDI
	// コンストラクタが1つなので@AutoWiredは不要
	private final AddressRepository repository;
	
	@Override
	public void regist(Address address) {
		
		repository.add(address);

	}

}
