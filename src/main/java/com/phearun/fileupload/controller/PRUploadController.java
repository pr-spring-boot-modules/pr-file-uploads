package com.phearun.fileupload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.phearun.fileupload.service.PRFileUploadService;

@RestController
@RequestMapping("/pr")
public class PRUploadController {

	private PRFileUploadService fileUploadService;

	@Autowired
	public PRUploadController(PRFileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	@PostMapping(value = "/uploads")
	public List<String> upload(List<MultipartFile> files, @RequestParam(value="folder", required=false, defaultValue = "") String folder) {
		return fileUploadService.upload(files, folder);
	}

}
