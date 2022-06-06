package com.mindtree.shopping.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "product")
public class Product {

	  @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Integer id;

	    private @NotNull String name;
	    private @NotNull double price;
	    
	    @JsonIgnore
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "category_id", nullable = false)
	    Category category;



	    @JsonIgnore
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	    private List<Cart> carts;
	   
	    

	 

		public Product(Integer id, String name, double price, Category category) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.category = category;
		}

		public Product(String name, double price,Category category) {
	        super();
	        this.name = name;
	        this.price = price;
	        this.category = category;
	    }
		
		

	    public Product(Integer id) {
			super();
			this.id = id;
		}

		public Product() {
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
	    
	    public Category getCategory() {
	        return category;
	    }

	    public void setCategory(Category category) {
	        this.category = category;
	    }


	    @Override
	    public String toString() {
	        return "Product{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", price=" + price +
	                '}';
	    }
}
