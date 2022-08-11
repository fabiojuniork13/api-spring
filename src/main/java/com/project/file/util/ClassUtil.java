package com.project.file.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ClassUtil {
	
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				ClassConst.LOCAL_PROPERTIES);
		props.load(file);
		return props;
	}

}
