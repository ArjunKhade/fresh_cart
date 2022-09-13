package com.app.dto;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto {

	private String productName;

	private String productDescription;

	private int quantity;

	private double productPrice;

	private double productDiscount;

	private double productRating;

	private MultipartFile productImage;

//	private String seller;
//
//	private String category;

}

