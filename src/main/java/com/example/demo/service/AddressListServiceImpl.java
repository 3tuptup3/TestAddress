package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressListServiceImpl implements AddressListService {
	
	private final AddressRepository repository;

	@Override
	public List<Address> findByNameWildcard(String lastName) {
		// errorページテスト
//		if (restaurantName != null) {
//			throw new RuntimeException();
//		}
		
		List<Address> list = repository.selectByNameWildcard(lastName);
		
		return list;
	}

//	@Override
//	public List<Address> findByAddressId(int addressId) {
//
//		List<Address> list = repository.selectByAddressId(addressId);
//		
//		return list;
//	}

}
