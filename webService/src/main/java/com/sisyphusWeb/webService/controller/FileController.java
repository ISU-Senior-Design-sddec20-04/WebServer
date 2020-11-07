package com.sisyphusWeb.webService.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sisyphusWeb.webService.payload.UploadFileResponse;
import com.sisyphusWeb.webService.service.FileStorageService;
import com.sisyphusWeb.webService.service.TrackService;
import com.sisyphusWeb.webService.service.UserService;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TrackService trackService;
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam String name, @RequestParam("file") MultipartFile file) {
    	if(!userService.exists(name)) return new UploadFileResponse("This user does not exist", "", "", 0);
    	
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/" + name + "/downloadFile/")
                .path(fileName)
                .toUriString();
        
        List<String> directories = fileStorageService.convertToTrack(fileName);
        
        trackService.addTrack(directories, fileName, name);
        
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam String name, @RequestParam("files") MultipartFile[] files) {
    	if(!userService.exists(name)) return new ArrayList<UploadFileResponse>(Arrays.asList(new UploadFileResponse("This user does not exist", "", "", 0)));
    	return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(name, file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String name, @PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    
    //probably doesn't work as intended
    @GetMapping("/")
    public ResponseEntity<List<String>> getAllFiles() {
    	return new ResponseEntity<>(fileStorageService.getAllFiles(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteFile/{fileName:.+}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
    	Boolean isDeleted = fileStorageService.removeFile(fileName);
    	if(!isDeleted) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<>("Deleted file " + fileName, HttpStatus.OK);
    }
    
    //Test request will be deleted soon...
    @GetMapping("/convertFileTest/{fileName:.+}")
    public String convertFile(@PathVariable String fileName) throws IOException, InterruptedException {
    	fileStorageService.convertToTrack(fileName);
    	return "converted";
    }
}
