package com.mastercode.abs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mastercode.abs.dto.AddressBookDTO;
import com.mastercode.abs.dto.ResponseDTO;
import com.mastercode.abs.entity.AddressBookEntity;
import com.mastercode.abs.service.IAddressBookService;

@RestController
public class AddressBookController {

	@Autowired
	IAddressBookService addressbookservice;
	
	Logger log = LoggerFactory.getLogger(AddressBookController.class);
	
	
	@GetMapping("/retrive")
	public ResponseEntity<ResponseDTO> getAllData()
	{
		log.info("Here, I retrive all the details from AddressBook:");
		List<AddressBookEntity> entity = addressbookservice.getAllDetails();
		ResponseDTO dto = new ResponseDTO("retrive all data from database successfully:",entity);
		return (new ResponseEntity(dto,HttpStatus.OK));
	}
	
	@GetMapping("/retrive/{id}")
	public ResponseEntity<ResponseDTO> findById(@PathVariable int id)
	{
		log.info("data will be retrived for id:" + id);
		AddressBookEntity entity = addressbookservice.getById(id);
		ResponseDTO dto = new ResponseDTO("data retrived successfully:",entity);
		return (new ResponseEntity(dto,HttpStatus.OK));
	}
	
	
	@PostMapping("/insert") 
	public ResponseEntity<ResponseDTO> addRecord( @RequestBody AddressBookDTO addressbookdto) //throws CustomException
	{
			log.info("Inserting data into AddressBook database");
			AddressBookEntity entity = addressbookservice.insertRecord(addressbookdto);
			ResponseDTO dto = new ResponseDTO("Data added successfully:",entity);
			return (new ResponseEntity(dto,HttpStatus.CREATED));
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateRecords( @RequestBody AddressBookDTO addressbookdto,@PathVariable int id)
	{
		AddressBookEntity entity = addressbookservice.updateRecord(id, addressbookdto);
		log.info("Record updated for id: " + id);
		ResponseDTO dto = new ResponseDTO("Record updated successully:",entity);
		return (new ResponseEntity(dto,HttpStatus.OK));
	}
	
		@RequestMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteRecordById(@PathVariable int id)
	{
		log.info("Data deleted for Id:" + id);
		AddressBookEntity entity = addressbookservice.deleteRecord(id);
		ResponseDTO dto = new ResponseDTO("Record deleted successfully:",entity);
		return (new ResponseEntity(dto,HttpStatus.OK));
	}
}
