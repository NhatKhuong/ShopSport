package com.se.util;

public class RenerateId {
	public static String fomatAANumber(String s) {
		int maxLenth = s.length();
		String[] array = s.split("");
		int number, i;

		for (i = maxLenth - 1; i >= 0; i--) {
			if (isNumeric(array[i])) {
				number = Integer.parseInt(array[i]);
				if (number != 9) {

					array[i] = ++number + "";
					return String.join("", array);
				} else {
					array[i] = "0";
				}
			} else {
//					it is letter
				if (!array[i].equalsIgnoreCase("Z")) {
					array[i] = String.valueOf((char) ((int) array[i].charAt(0) + 1));
					return String.join("", array);
				}
			}
			
			
		}
		
		if (i == -1) {
			// plus one character
			s = s.replaceAll("9", "0");
			s = s.replaceAll("[zZ]", "A");
			s = "A"+s;
		
		}
		return s;

	
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}
}
