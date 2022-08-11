package com.project.file.folder;

public class Archive {
	
	private String nameArchive;

	public Archive(String absolutePath) {
		setName(absolutePath);
	}

	public String getName() {
		return nameArchive;
	}

	public void setName(String name) {
		this.nameArchive = name;
	}

}
