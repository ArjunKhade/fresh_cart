package com.app.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class StorageServiceImpl implements IStorageService {

	@Value("${file.upload.basepath}")
	private String BASEPATH;
	
	@PostConstruct
	public void anyInit() {
		// chk if folder exists --if not create one !
		// java.io.File => represents abstract path to a file /folder
		File folder = new File(BASEPATH);
		if (!folder.exists()) {
			folder.mkdirs();
			log.info("folder created....");
		} else
			log.info("folder alrdy exists !");
	}
	
	@Override
	public List<String> loadAll() {
		File dirPath = new File(BASEPATH);
		return List.of(dirPath.list());
	}
	
	

	@Override
	public String store(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		File filePath = new File(BASEPATH,fileName);
		try(FileOutputStream out = new FileOutputStream(filePath)){
			FileCopyUtils.copy(file.getInputStream(),out);
			return fileName;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Resource load(String fileName) {
	   File filePath = new File(BASEPATH,fileName);
	   if(filePath.exists())
		   return new FileSystemResource(filePath);
		return null;
	}

	@Override
	public void delete(String fileName) {
		File filePath = new File(BASEPATH,fileName);
		if(filePath.exists())
			filePath.delete();
	}
	

}
