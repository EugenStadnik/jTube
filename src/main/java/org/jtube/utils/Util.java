package org.jtube.utils;

public class Util {
	public static String normalizeTitle(String rawTitle) {
		return rawTitle.replaceAll("[ ]", "_")
				.replaceAll("[:!{}()\\[\\]><=]", "");
	}
}
