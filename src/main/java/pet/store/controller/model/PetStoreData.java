package pet.store.controller.model;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor 
public class PetStoreData {
	private Long petStoreId;
	
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	
	Set<PetStoreCustomer> customers;

	Set<PetStoreEmployee> employees;	
	
	public PetStoreData(PetStore p) {
		
		petStoreId = p.getPetStoreId() ;
		petStoreName = p.getPetStoreName() ;
		petStoreAddress =p.getPetStoreAddress();
		petStoreCity =p.getPetStoreCity();
		petStoreState =p.getPetStoreState();
		petStoreZip =p.getPetStoreZip();
		petStorePhone =p.getPetStorePhone();
		
		for(Customer customer: p.getCustomers() ) {
			customers.add(new PetStoreCustomer(customer));
		}
		for(Employee employee: p.getEmployees() ) {
			employees.add(new PetStoreEmployee(employee));
		}
	}


	@Data
	@NoArgsConstructor 
	
	public static class PetStoreCustomer {
		private int customerId;
		
		private String customerFirstName;
		private String customerLastName;
		private String customerEmail;
		
		public PetStoreCustomer(Customer c) {
			
			customerId = c.getCustomerId();
			
			customerFirstName = c.getCustomerFirstName();
			customerLastName = c.getCustomerLastName();
			customerEmail = c.getCustomerEmail();
		}
	
	}

	
	@Data
	@NoArgsConstructor 
	
	public static class PetStoreEmployee {
		private Long employeeId;
		private String employeeFirstName;
		private String employeeLastName;
		private String employeePhone;
		private String employeeJobTitle;

		
		public PetStoreEmployee(Employee e) {
			
			employeeId = e.getEmployeeId();
			
			employeeFirstName = e.getEmployeeFirstName();
			employeeLastName = e.getEmployeeLastName();
			employeePhone = e.getEmployeePhone();
			employeeJobTitle = e.getEmployeeJobTitle();
		}
	
	}
	
}
	

