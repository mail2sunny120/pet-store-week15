package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.entity.PetStore;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
//@RequestMapping(value = "/pet_store",method = RequestMethod.POST)
@Slf4j
public class PetStoreController {

	@Autowired
	PetStoreService petStoreService;
	
	@PostMapping
	public PetStore  myPost(@RequestBody PetStoreData petStoreData)
	{
		//log.info(petStoreData.toString());
		
		PetStore petStore = petStoreService.savePetStore(petStoreData);
		return petStore;
		
	}

	@PutMapping("{petStoreId}")
	public PetStore  storeUpdate(@PathVariable Long petStoreId,@RequestBody PetStoreData petStoreData)
	{
		PetStore petStore = null;
		//log.info(petStoreData.toString());
		
		// 
		//saveEmployee()
		return petStore;
		
	}
	
	//newcode for week15
	
	@PostMapping("/pet_store/{petStoreId}/employee")
//			consumes = MediaType.APPLICATION_JSON_VALUE, 
//			produces  = MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping
	//@ResponseStatus(code=HttpStatus.CREATED)
	public PetStoreEmployee  addEmployee(@RequestBody PetStoreEmployee petStoreEmployee, @RequestBody Long petstoreid)
	{
		
		//log the request
		
		log.info(petStoreEmployee.toString());
		log.info(petstoreid.toString());
		
		PetStoreEmployee objPetStoreEmployee =		petStoreService.saveEmployee(petstoreid, petStoreEmployee);
		return objPetStoreEmployee;
		
	}

//


	
	
	
	
}
