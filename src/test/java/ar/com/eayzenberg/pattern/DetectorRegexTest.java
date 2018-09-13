package ar.com.eayzenberg.pattern;

import org.junit.Assert;
import org.junit.Test;

public class DetectorRegexTest {

	@Test
	public void detectar1PatronTest() {
		String p = "aaaabb";
		int matches = DetectorRegex.find(p.toCharArray());
		
		Assert.assertEquals(1, matches);
	}
	
	@Test
	public void detectar0PatronesTest() {
		String p = "aaabb";
		int matches = DetectorRegex.find(p.toCharArray());
		
		Assert.assertEquals(0, matches);
	}
	
	@Test
	public void detectar2PatronesTest() {
		String p = "aaaaZbbbb";
		int matches = DetectorRegex.find(p.toCharArray());
		
		Assert.assertEquals(2, matches);
	}
}
