package com.mastercode.abs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercode.abs.dto.AddressBookDTO;
import com.mastercode.abs.entity.AddressBookEntity;
import com.mastercode.abs.repository.IAddressBookRespository;

@Service
public class AddressBookService implements IAddressBookService{

	@Autowired
	IAddressBookRespository repository;
	
	@Override
	public List<AddressBookEntity> getAllDetails() {

		return repository.findAll();
	}

	@Override
	public AddressBookEntity getById(int id) {
		return repository.findById(id).get();
		
	}

	@Override
	public AddressBookEntity insertRecord(AddressBookDTO dto) {
		AddressBookEntity entity = new AddressBookEntity(dto);
		return repository.save(entity);
	}

	@Override
	public AddressBookEntity updateRecord(int id, AddressBookDTO dto) {
		System.out.println(dto);
		AddressBookEntity entity=repository.findById(id).get();
		entity.setName(dto.getName());
		entity.setCity(dto.getCity());
		entity.setState(dto.getState());
		entity.setZip(dto.getZip());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		return repository.save(entity);
		
	}

	@Override
	public AddressBookEntity deleteRecord(int id) {
		
		repository.deleteById(id);
		return null;
	}

}
