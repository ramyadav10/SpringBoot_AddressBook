package com.mastercode.abs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mastercode.abs.dto.AddressBookDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Address_Book")
public class AddressBookEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String phone;

	public AddressBookEntity(AddressBookDTO dto) {
		this.name = dto.getName();
		this.city = dto.getCity();
		this.state = dto.getState();
		this.zip = dto.getZip();
		this.email = dto.getEmail();
		this.phone = dto.getPhone();
	}
}
