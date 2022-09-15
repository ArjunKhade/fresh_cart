package com.app.utils;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
    
	   List<String>loadAll();
	   
	   String store (MultipartFile file);
	   
	   Resource load (String fileName);
	   
	   void delete(String fileName);
	   
}
