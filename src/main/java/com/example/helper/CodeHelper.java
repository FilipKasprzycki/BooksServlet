package com.example.helper;

public class CodeHelper {

	private static final String prefix = "WEB-INF/jsp/";
	private static final String suffix = ".jsp";
	
	public static String path(String file) {
		return prefix + file + suffix;
	}
}
