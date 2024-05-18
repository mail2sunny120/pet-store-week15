package pet.store.controller.model;

import java.util.Set;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor 

public class PetStoreCustomer {

	//@Id
	//@GeneratedValue
	private int customerId;
	
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	
	public void PetStoreCustomer(Customer c) {
		
	}

}
