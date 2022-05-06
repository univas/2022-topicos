package br.edu.univas.si7.topicos.domain.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.edu.univas.si7.topicos.domain.Customer;
import lombok.Data;

@Data
public class CustomerDTO {

	private String id;

	private String name;

	private String email;

	private Integer type;

	@NotNull(message = "Phone number can not be null.")
	@NotEmpty(message = "Phone number can not be empty.")
	@Size(min = 8, max = 20, message = "The size must be between 8 and 20.")
	private String phoneNumber;

	private List<AddressDTO> addresses = new ArrayList<>();
	
	private String password;

	private List<String> profiles;

	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.email = customer.getEmail();
		this.type = customer.getType().getCode();
		this.phoneNumber = customer.getPhoneNumber();
		this.password = customer.getPassword();
		customer.getProfiles().stream().map(p -> this.profiles.add(p.toString()));
		customer.getAddresses().forEach(a -> addresses.add(new AddressDTO(a)));
	}

}