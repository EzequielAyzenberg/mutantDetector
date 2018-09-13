package ar.com.eayzenberg.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectorRegex {
	
	public static int find(char[] chars) {
        Matcher m = Pattern
        		.compile("(.)\\1{3}")
        		.matcher(String.valueOf(chars));
        int matches = 0;
        while (m.find()) {
        	// Secuence must be just 4
        	String match = m.group();
        	matches++;
        	System.err.println(match);
        }
        return matches;
    }
}
