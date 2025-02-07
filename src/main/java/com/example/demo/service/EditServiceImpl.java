package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditServiceImpl implements EditService {

	private final AddressRepository repository;
	
	@Override
	public void edit(Address address) {
		
		repository.update(address);

	}

}
