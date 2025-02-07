package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RemoveServiceImpl implements RemoveService {
	
	private final AddressRepository repository;

	@Override
	public void remove(Address address) {
		
		repository.delete(address);

	}

}
