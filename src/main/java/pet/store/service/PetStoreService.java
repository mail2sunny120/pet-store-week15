package pet.store.service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.dao.EmployeeDao;
import pet.store.dao.PetStoreDao;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {

	@Autowired
	private PetStoreDao petStoreDao;
	
	// new autowire added 5/17 
	@Autowired
	private EmployeeDao employeeDao;
	
	public PetStore savePetStore(PetStoreData  p)
	{
	
		Long petStoreId = p.getPetStoreId();
		//petStoreId = null;
		PetStore newPetstore=findOrCreatePetStore(petStoreId);
		copyPetStoreFields(newPetstore, p);
		
		newPetstore = petStoreDao.save(newPetstore);
		
		return newPetstore;
	}

	

	private PetStore findOrCreatePetStore(Long petStoreId) {
	
		if(Objects.isNull(petStoreId)) {
			return new PetStore();
		}
		else {
			return findPetStorebyId(petStoreId);
		}
	}
	
	private PetStore findPetStorebyId(Long petStoreId) {
		// TODO Auto-generated method stub
		return petStoreDao.findById(petStoreId).orElseThrow(()->new NoSuchElementException("Pet Store "+petStoreId +  "was not found"));
	}



	private void copyPetStoreFields(PetStore petStore,PetStoreData petStoreData)
	{
		petStore.setPetStoreName(petStoreData.getPetStoreName());
		petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
		petStore.setPetStoreCity(petStoreData.getPetStoreCity());
		
		petStore.setPetStoreId(petStoreData.getPetStoreId());
		petStore.setPetStorePhone(petStoreData.getPetStorePhone());
		petStore.setPetStoreZip(petStoreData.getPetStoreZip());
		
	}
	
	//Added 5/17
	@Transactional(readOnly = false)
	public PetStoreEmployee saveEmployee(Long petStoreId,PetStoreEmployee petStoreEmployee )
	{
		PetStore petStore =		findPetStorebyId(petStoreId);
		Long employeeID = petStoreEmployee.getEmployeeId();
		Employee employee =findOrCreateEmployee(petStoreId,employeeID);
		copyEmployeeFields(employee,petStoreEmployee);
		
		// set the petStore in employee
		employee.setPetStore(petStore);
		Set<Employee> employeeSet = new HashSet<Employee>();
		employeeSet.add(employee);
		petStore.setEmployees(employeeSet);
		Employee dbEmployee = employeeDao.save(employee,employeeID);
		//Employee dbEmployee = new Employee();
		return new PetStoreEmployee(dbEmployee);
		
		
	}
	
	// helper method 1
	private void copyEmployeeFields(Employee employee,PetStoreEmployee petStoreEmployee )
	{
		employee.setEmployeeFirstName(petStoreEmployee.getEmployeeFirstName());
		employee.setEmployeeId(petStoreEmployee.getEmployeeId());
		employee.setEmployeeJobTitle(petStoreEmployee.getEmployeeJobTitle());
		employee.setEmployeeLastName(petStoreEmployee.getEmployeeLastName());
		employee.setEmployeePhone(petStoreEmployee.getEmployeePhone());
	}
	
	//helper method 2
	public Employee findOrCreateEmployee(Long petStoreId, Long employeeID)
	{
		if(Objects.isNull(employeeID)) {
			return new Employee();
		}
		else {
			return findEmployeeById(petStoreId,employeeID);
		}
		
	}
	
	/*
	 * private Employee findEmployeeById(Long petStoreId,Long employeeID ) {
	 * Employee employee = (Employee) employeeDao.findById(employeeID);
	 * 
	 * // employee not found if(employee.equals(null)) { throw new
	 * NoSuchElementException(); }
	 * 
	 * // if matching employee found(everything okay
	 * if(employee.get().equals(petStoreId)) { return employee; } else { throw new
	 * IllegalArgumentException(); } }
	 */

	
	private Employee findEmployeeById(Long petStoreId,Long employeeID ) {
		// TODO Auto-generated method stub
		return employeeDao.findById(employeeID).orElseThrow(()->new NoSuchElementException("Employee Id "+employeeID +  "was not found"));
	}	
	
	
}
