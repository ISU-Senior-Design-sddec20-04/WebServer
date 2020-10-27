package com.sisyphusWeb.webService.service;


import com.sisyphusWeb.webService.exception.FileStorageException;
import com.sisyphusWeb.webService.exception.MyFileNotFoundException;
import com.sisyphusWeb.webService.model.Image;
import com.sisyphusWeb.webService.property.FileStorageProperties;
import com.sisyphusWeb.webService.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
    
    @Autowired
    ImageRepository imageRepository;

    public List<String> getAllFiles() {
    	List<Image> images = imageRepository.findAll();
    	List<String> allFiles = new ArrayList<String>();
    	for(Image image : images) {
    		allFiles.add(image.getFileName());
    	}
    	return allFiles;
    }
    
    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            imageRepository.save(new Image(fileName, targetLocation.toString()));
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
    	
        try {
        	
        	//Get the image from the repository
        	Image image = imageRepository.findByfileName(fileName);
        	
        	//Get the file path property from the image
        	Path filePath = Paths.get(image.getLocation());
        	
        	//turn that file path into a new resource to be returned
            Resource resource = new UrlResource(filePath.toUri());
            
            //return the resource if it exists, otherwise throw an exception
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
            
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
    
    public Boolean removeFile(String fileName) {
    	Boolean deleted = false;
    	Image image = imageRepository.findByfileName(fileName);
    	try	{
    		Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
    		deleted = Files.deleteIfExists(filePath);
    		imageRepository.delete(image);
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	}
		return deleted;
    	
    }
}