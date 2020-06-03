package com.ibm.handson.loginservicems.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "product")
public class Product {

		/*
		 * @Autowired
		 * 
		 * @Transient private ProductRepository repo;
		 */

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		private String name;
		@Column(name = "shortdescription", table = "product")
		private String shortDescription;
		
		private double mrp;
		
		/*
		 * public void saveProduct() { repo.save(this); }
		 */
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Product(int id, String name, String shortDescription,  double mrp) {
			super();
			this.id = id;
			this.name = name;
			this.shortDescription = shortDescription;
			this.mrp = mrp;
		}



		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getShortDescription() {
			return shortDescription;
		}

		public void setShortDescription(String shortDescription) {
			this.shortDescription = shortDescription;
		}

		public double getMrp() {
			return mrp;
		}

		public void setMrp(double mrp) {
			this.mrp = mrp;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	}
