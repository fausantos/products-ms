package br.com.productms.entities.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.productms.entities.Product;

public class ProductDTO {

	private String id;

	@NotEmpty(message = "Campo obrigatório!")
	private String name;

	@NotEmpty(message = "Campo obrigatório.")
	private String description;

	@NotNull(message = "Campo Obrigtório.")
	private Double price;
	
	

	public ProductDTO(String id, String name, String description,
			Double price) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public ProductDTO(Product product) {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
