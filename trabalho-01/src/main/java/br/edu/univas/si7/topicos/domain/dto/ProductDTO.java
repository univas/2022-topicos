package br.edu.univas.si7.topicos.domain.dto;

import br.edu.univas.si7.topicos.domain.Product;

public class ProductDTO {

	private Integer id;
	private String name;
	private double price;

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
	}

	public ProductDTO() {
	}

	public ProductDTO(Integer id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
