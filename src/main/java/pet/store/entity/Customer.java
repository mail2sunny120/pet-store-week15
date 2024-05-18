package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
	//@JdbcTypeCode(SqlTypes.JSON)
	private Set<PetStore> petStores = new HashSet<>();
}
