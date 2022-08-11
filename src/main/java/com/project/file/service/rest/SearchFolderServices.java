package com.project.file.service.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.file.controller.SearchFoldersController;

@CrossOrigin
@RestController
public class SearchFolderServices {
		
//	@GetMapping("/archive")
//	List<Object> findAllFilesInFolderByFolderService() {
//		SearchFoldersController sc = new SearchFoldersController();
//		return sc.findAllFilesInFolderByFolder();
//	}
	
	@GetMapping("/contract")
	List<Object> findAllFilesInFolderByFolderContractService() {
		SearchFoldersController sc = new SearchFoldersController();
		return sc.findAllFilesInFolderByFolderContract();
	}
	
	@GetMapping("/props")
	List<Object> loadProperties() {
		SearchFoldersController sc = new SearchFoldersController();
		return sc.getProperties();
	}
	
	@RequestMapping("/archive")
	List<Object> subFolderService(@RequestParam("dir") String dir) {
		SearchFoldersController sc = new SearchFoldersController();
		return sc.subFolder(dir);
	}
	
}
