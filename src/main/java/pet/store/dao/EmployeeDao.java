package pet.store.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.store.entity.Employee;
import pet.store.entity.PetStore;

// new class 5/17 (DS)
public interface EmployeeDao extends JpaRepository<Employee, Long> 
{

	//Employee findById(Long employeeID);

	//Employee save(PetStore petStore, Long employeeID);

	
	
}


