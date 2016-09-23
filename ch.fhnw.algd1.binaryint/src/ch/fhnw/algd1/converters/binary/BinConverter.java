package ch.fhnw.algd1.converters.binary;

public class BinConverter {
	public static String toString(int x) {
		// expect x to be in range [-128, 127], return string with 8
		// binary digits representing x in 2-complement

		String pattern = "00000000"; // 8 * 0
		if (x == 0)
			return pattern;

		StringBuilder sb = new StringBuilder();
		int y = x;

		if (y < 0)
			y = (int) (Math.pow(2, 8) + y);

		while (y > 0) {
			if ((y % 2) == 0)
				sb.insert(0, "0");
			else
				sb.insert(0, "1");
			y /= 2;
		}
		String fromSB = sb.toString();
		String formatted = (pattern + fromSB).substring(fromSB.length());
		if (x > 0)
			return formatted;

		sb = new StringBuilder(formatted);
		sb.setCharAt(0, '1');
		return sb.toString();
	}

	public static int fromString(String text) {
		int retVal = 0;
		int counter = 0;
		for (int i = text.length() - 1; i > 0; i--) {
			if (text.charAt(i) == '1')
				retVal += Math.pow(2, counter);
			counter++;
		}
		// if negative
		if (text.charAt(0) == '1')
			retVal -= Math.pow(2, text.length() - 1);
		return retVal;
	}
}