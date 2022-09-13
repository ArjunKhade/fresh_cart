package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "productList")
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
public class Category  extends BaseEntity{
   
	@Column(name = "category_name", length = 100, unique=true)
	private String categoryName;

	@Column(name = "category_description", length = 500)
	private String categoryDescription;

	@Column(name = "category_image", length = 100)
	private String categoryImage;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Product> productList=new ArrayList<Product>();
	
	
}
