package com.sisyphusWeb.webService.service;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sisyphusWeb.webService.exception.FileStorageException;
import com.sisyphusWeb.webService.exception.MyFileNotFoundException;
import com.sisyphusWeb.webService.model.Image;
import com.sisyphusWeb.webService.property.FileStorageProperties;
import com.sisyphusWeb.webService.repository.ImageRepository;
import com.sisyphusWeb.webService.repository.TrackRepository;

@Service
public class FileStorageService {

    private final Path imageStorageLocation;
    
    private final Path converterLocation;
    
    private final Path previewStorageLocation;
    
    private final Path thetaStorateLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.imageStorageLocation = Paths.get(fileStorageProperties.getStorageDir() + "images/")
                .toAbsolutePath().normalize();
        
        this.converterLocation = Paths.get("E:\\Documents\\GitHub\\ImageToTrack")
                .toAbsolutePath().normalize();
        
        this.previewStorageLocation = Paths.get(fileStorageProperties.getStorageDir() + "previews/")
                .toAbsolutePath().normalize();
        
        this.thetaStorateLocation = Paths.get(fileStorageProperties.getStorageDir() + "thetas/")
                .toAbsolutePath().normalize();
        
        try {
            Files.createDirectories(this.imageStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
    
    @Autowired
    ImageRepository imageRepository;
    
    @Autowired
    TrackRepository trackRepo;

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
            Path targetLocation = this.imageStorageLocation.resolve(fileName);
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
    		Path filePath = this.imageStorageLocation.resolve(fileName).normalize();
    		deleted = Files.deleteIfExists(filePath);
    		imageRepository.delete(image);
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	}
		return deleted;
    }
    
    public void convertToTrack(String fullFileName) throws IOException, InterruptedException {
    	
    	String imageLocation = imageRepository.findByfileName(fullFileName).getLocation();
    	String converterDirectory = converterLocation.toString();
    	String command;
    	String[] commandToExecute;
    	String name = fullFileName.split("\\.")[0];
    	
    	//windows commands
    	command = "copy " + imageLocation + " " + converterDirectory;
    	commandToExecute = new String[] {"cmd.exe", "/c", command};
    	Runtime.getRuntime().exec(commandToExecute);
    	
    	command = "cd " + converterDirectory + " & py ImageToTrack.py " + fullFileName;
    	commandToExecute = new String[] {"cmd.exe", "/c", command};
    	Runtime.getRuntime().exec(commandToExecute);
    	
    	Thread.sleep(5000);
    	
    	convertPointsToThr(converterDirectory, name);
//    	
//    	command = "rename " + converterDirectory + "\\" + "result.png " + previewName;
//    	commandToExecute = new String[] {"cmd.exe", "/c", command};
//    	Runtime.getRuntime().exec(commandToExecute);
//    	
//    	command = "move " + converterDirectory + "\\" + previewName + " " + previewStorageLocation.toString();
//    	commandToExecute = new String[] {"cmd.exe", "/c", command};
//    	Runtime.getRuntime().exec(commandToExecute);
    }
    
    public void convertPointsToThr(String directory, String fileName) {
    	String command = "cd " + directory + " & py Calculate.py " + fileName + ".txt";
    	String[] commandToExecute = new String[] {"cmd.exe", "/c", command};
    	try {
			Runtime.getRuntime().exec(commandToExecute);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}