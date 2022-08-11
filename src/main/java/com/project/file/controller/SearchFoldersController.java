package com.project.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.web.bind.annotation.RequestParam;

import com.project.file.folder.Archive;
import com.project.file.folder.Folder;
import com.project.file.util.ClassConst;
import com.project.file.util.ClassUtil;

public class SearchFoldersController {
	
	public List<Object> findAllFilesInFolderByFolderContract() {
		Folder folders = null;
		String dir = "";
		
		try {
			Properties prop = ClassUtil.getProp();
			dir = prop.getProperty(ClassConst.LOCAL_IMAGE_PROPERTIE);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		File folder = new File(dir);
		
		List<Object> archivesOrFolders = new ArrayList<Object>();
		
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
			} 
			else 
			{
				
				System.out.println("Is a folder: " + file.getPath());
				folders = new Folder();
				
				int position = 0;
				char[] c = file.getPath().toCharArray();
				for(int i = 0; i < c.length; i++) {
					if(c[i] == '/') {
						position = i;
					}
				}
				
				String path = file.getPath().substring(position+1, c.length);
				
				folders.setName(path);
				archivesOrFolders.add(folders);
			}
		}
		
		return archivesOrFolders;
		
	}
	
	public List<Object> subFolder(@RequestParam("dir") String dir) {
		Folder folders = null;
		File folder = new File(dir);
		List<Object> archivesOrFolders = new ArrayList<Object>();
		
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
				Archive archive = new Archive(file.getAbsolutePath());
				ImageController imgController = new ImageController();
				String img64 = imgController.encodeFileToBase64Binary(file);
				archivesOrFolders.add(img64);
				System.out.println("Is a archive: " + file.getPath());
			} 
			else 
			{
				
				System.out.println("Is a folder: " + file.getPath());
				folders = new Folder();
				
				int position = 0;
				char[] c = file.getPath().toCharArray();
				for(int i = 0; i < c.length; i++) {
					if(c[i] == '/') {
						position = i;
					}
				}
				
				String path = file.getPath().substring(position+1, c.length);
				
				folders.setName(path);
				archivesOrFolders.add(folders);
			}
		}
		
		return archivesOrFolders;
		
	}
	
	public List<Object> getProperties() {
		String dir = "";
		try {
			Properties prop = ClassUtil.getProp();
			dir = prop.getProperty(ClassConst.LOCAL_IMAGE_PROPERTIE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Object> obj = new ArrayList<Object>();
		obj.add(dir);
		return obj;
	}

}
