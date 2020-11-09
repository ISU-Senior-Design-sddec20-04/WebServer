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
    
    private final Path thetaStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.imageStorageLocation = Paths.get(fileStorageProperties.getStorageDir() + "images/")
                .toAbsolutePath().normalize();
        
        this.converterLocation = Paths.get("E:\\Documents\\GitHub\\ImageToTrack")
                .toAbsolutePath().normalize();
        
        this.previewStorageLocation = Paths.get(fileStorageProperties.getStorageDir() + "previews/")
                .toAbsolutePath().normalize();
        
        this.thetaStorageLocation = Paths.get(fileStorageProperties.getStorageDir() + "thetas/")
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
    
    public List<String> convertToTrack(String fullFileName) {
    	
    	String imageLocation = imageRepository.findByfileName(fullFileName).getLocation();
    	List<String> directories = new ArrayList<String>();
    	String converterDirectory = converterLocation.toString();
    	String name = fullFileName.split("\\.")[0];
    	String previewName = name + "Preview.png";
    	
    	//windows commands
    	//move image to converter directory
    	copyWindows(imageLocation, converterDirectory);
    	
    	//convert image
    	executeWindows(converterDirectory,"py ImageToTrack.py", fullFileName);
    	
    	sleep(6500);
    	
    	//create thr file from output
    	executeWindows(converterDirectory,"py Calculate.py", name+".txt");
    	
    	//rename preview file
    	renameWindows(converterDirectory + "\\result.png", previewName);
    	
    	//move output files to their respective directories
    	moveWindows(converterDirectory+"\\"+previewName, previewStorageLocation.toString());
    	moveWindows(converterDirectory + "\\Output_Track.thr", thetaStorageLocation.toString());
    	
    	directories.add(previewStorageLocation.toString() + "\\" +previewName);
    	directories.add(thetaStorageLocation.toString() + "\\Output_Track.thr");
    	directories.add(thetaStorageLocation.toString());
    	
    	//remove un-needed files
    	deleteWindows(converterDirectory + "\\" + fullFileName);
    	deleteWindows(converterDirectory + "\\" + name+".txt");
    	
    	return directories;
    }
    
    public void moveWindows(String source, String destination) {
    	String command = "move " + source + " " + destination;
    	String[] commandToExecute = new String[] {"cmd.exe", "/c", command};
    	try {
			Runtime.getRuntime().exec(commandToExecute);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void copyWindows(String source, String destination) {
    	String command = "copy " + source + " " + destination;
    	String[] commandToExecute = new String[] {"cmd.exe", "/c", command};
    	try {
			Runtime.getRuntime().exec(commandToExecute);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void renameWindows(String source, String name) {
    	String command = "rename " + source + " " + name;
    	String[] commandToExecute = new String[] {"cmd.exe", "/c", command};
    	try {
			Runtime.getRuntime().exec(commandToExecute);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void deleteWindows(String source) {
    	String command = "del " + source;
    	String[] commandToExecute = new String[] {"cmd.exe", "/c", command};
    	try {
    		Runtime.getRuntime().exec(commandToExecute);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void executeWindows(String directory, String program, String file) {
    	String command = "cd " + directory + " & " + program + " " + file;
    	String[] commandToExecute = new String[] {"cmd.exe", "/c", command};
    	try {
			Runtime.getRuntime().exec(commandToExecute);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void sleep(int time) {
    	try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}