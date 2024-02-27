package com.LaEsquina.CebiSystemHub.Service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;



public interface UploadFileService {
	public Resource load(String filename) throws MalformedURLException;
	public String copy(MultipartFile file)throws IOException;
	public boolean delete(String filename);

}
