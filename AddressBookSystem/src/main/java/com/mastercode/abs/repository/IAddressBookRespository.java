package com.mastercode.abs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastercode.abs.entity.AddressBookEntity;

public interface IAddressBookRespository extends JpaRepository<AddressBookEntity, Integer> {

}
