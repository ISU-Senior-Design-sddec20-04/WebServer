package com.sisyphusWeb.webService.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sisyphusWeb.webService.payload.UploadFileResponse;
import com.sisyphusWeb.webService.service.ImageStorageService;

@RestController
public class ImageController {
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	@Autowired
	private ImageStorageService imageStorageService;
	
	@PostMapping("/uploadFile")
	public UploadFileResponse uploadImage(@RequestParam("file") MultipartFile file) {
		String fileName = imageStorageService.storeImage(file);
		
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/downloadFile/")
					.path(fileName)
					.toUriString();
		
		return new UploadFileResponse(fileName, fileDownloadUri, 
				file.getContentType(), file.getSize());
	}
	
	@GetMapping("/downloadFile/{fileName:.+")
	public ResponseEntity<Resource> downloadImage(@PathVariable String fileName, HttpServletRequest request) {
		Resource resource = imageStorageService.loadImageAsResource(fileName);
		
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch(IOException ex) {
			logger.info("Could not determine file type.");
		}
		
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		
		return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"" + resource.getFilename() + "\"")
					.body(resource);
	}
}
