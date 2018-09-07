package com.chenlei.edubook.util;

import java.io.UnsupportedEncodingException;

public class ChineseEncoding {
	public static String changeStr(String input) {
		try {
			input = new String(input.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return input;
	}
}
