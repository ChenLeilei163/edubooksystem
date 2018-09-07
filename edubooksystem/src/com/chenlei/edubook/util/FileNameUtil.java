package com.chenlei.edubook.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameUtil {
	public static String getNewFileName(String filename) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String newName = simpleDateFormat.format(new Date().getTime());
		String suffix = filename.substring(filename.lastIndexOf("."));
		return newName + suffix;
	}
}
