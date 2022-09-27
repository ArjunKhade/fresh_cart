package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto extends BaseDto {

	private String categoryName;

	private String categoryDescription;

	private MultipartFile categoryImage; 
	
	private List<ProductDto> productDtos=new ArrayList<ProductDto>();
	
}
