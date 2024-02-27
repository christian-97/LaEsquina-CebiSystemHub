package com.LaEsquina.CebiSystemHub.ServiceImpl;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.LaEsquina.CebiSystemHub.Service.UploadFileService;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    private final String uploadDirectory = "src/main/resources/static/images";

    @Override
    public Resource load(String filename) throws MalformedURLException {
        Path file = Paths.get(uploadDirectory).resolve(filename);
        Resource resource = new UrlResource(file.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new MalformedURLException("Could not load the file: " + filename);
        }
    }

    @Override
    public String copy(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        Path destinationFile = Paths.get(uploadDirectory).resolve(filename).normalize().toAbsolutePath();
        Files.copy(file.getInputStream(), destinationFile);
        return filename;
    }

    @Override
    public boolean delete(String filename) {
        Path file = Paths.get(uploadDirectory).resolve(filename);
        File f = new File(file.toUri());
        return f.delete();
    }
}
