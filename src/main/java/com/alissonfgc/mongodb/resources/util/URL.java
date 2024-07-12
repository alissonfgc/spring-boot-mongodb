package com.alissonfgc.mongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static LocalDate convertDate(String stringDate, LocalDate defautValue) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			return LocalDate.parse(stringDate, fmt);
		} catch (RuntimeException e) {
			return defautValue;
		}
	}
}
