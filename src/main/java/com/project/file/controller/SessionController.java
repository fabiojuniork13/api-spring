package com.project.file.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.project.file.util.ClassConst;
import com.project.file.util.ClassUtil;

public class SessionController {

	public List<Object> getProperties() {
		String time = "";
		try {
			Properties prop = ClassUtil.getProp();
			time = prop.getProperty(ClassConst.TIME_TO_EXPIRE_PAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Object> obj = new ArrayList<Object>();
		obj.add(time);
		return obj;
	}
	
}
