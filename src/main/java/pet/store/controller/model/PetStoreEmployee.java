package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Employee;

@Data
@NoArgsConstructor 
public class PetStoreEmployee {
	//@Id
	//@GeneratedValue
	private Long employeeId;
	
	//@Id
	//@GeneratedValue
	//private int petStoreId;
	
	private String employeeFirstName;
	private String employeeLastName;
	private String employeePhone;
	private String employeeJobTitle;
	
	public PetStoreEmployee(Employee e)
	{
		this.employeeFirstName = e.getEmployeeFirstName();
		this.employeeLastName = e.getEmployeeLastName();
		this.employeeJobTitle =e.getEmployeeJobTitle();
		this.employeePhone =e.getEmployeePhone();
		this.employeeId = e.getEmployeeId();
	}
}
