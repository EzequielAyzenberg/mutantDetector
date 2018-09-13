package ar.com.eayzenberg.pattern;

import org.junit.Assert;
import org.junit.Test;

public class DetectorTest {
	
	@Test
	public void detectsTwoCrazyPatternsTest() {
		
		// There are four horizontal As at first array
		// There are four diagonal Bs in opposite sense at (4,0)
		char[][] dna = {
				{ 'A','A','A','A','B' },
				{ 'T','A','A','B','T' },
				{ 'T','T','B','A','T' },
				{ 'T','B','T','A','T' },
		};
		Detector detector = new Detector();
		
		Assert.assertEquals(2, detector.matchedPatternsAmount(dna));
		Assert.assertEquals(true, detector.isMutant(dna));
	}
	
	@Test
	public void detectsTwoHorizontalPatternsTest() {
		
		// There are four horizontal As at first array
		// There are four diagonal Bs in opposite sense at (4,0)
		char[][] dna = {
				{ 'A','A','A','A','B' },
				{ 'C','Z','Z','Z','Z' },
		};
		Detector detector = new Detector();
		
		Assert.assertEquals(2, detector.matchedPatternsAmount(dna));
		Assert.assertEquals(true, detector.isMutant(dna));
	}
	
	@Test
	public void detectsTwoVerticalPatternsTest() {
		
		char[][] dna = {
				{ 'T','A' },
				{ 'T','A' },
				{ 'T','A' },
				{ 'T','A' },
		};
		Detector detector = new Detector();
		
		Assert.assertEquals(2, detector.matchedPatternsAmount(dna));
		Assert.assertEquals(true, detector.isMutant(dna));
	}
	
	@Test
	public void verySmallDoesNotDetectTest() {
		
		char[][] dna = {
				{ 'A' }
		};
		Detector detector = new Detector();
		
		Assert.assertEquals(0, detector.matchedPatternsAmount(dna));
		Assert.assertEquals(false, detector.isMutant(dna));
	}
	
	@Test
	public void justOnePatternDoesNotDetectTest() {
		
		// Hay 4 A horizontales en linea 1
		// Hay 4 B oblicuas sentido opuesto en (4,0)
		char[][] dna = {
				{ 'A','A','A','A','B' },
				{ 'T','A','A','B','T' },
				{ 'T','T','B','A','T' },
				{ 'T','A','T','A','T' },
		};
		Detector detector = new Detector();
		
		Assert.assertEquals(1, detector.matchedPatternsAmount(dna));
		Assert.assertEquals(false, detector.isMutant(dna));
	}
	
	@Test
	public void bigArrayDectectsJustTwoPatternsTest() {
		
		char[][] dna = {
				{ 'B','A','A','A','B','B','A','A','A','B' },
				{ 'T','A','A','Z','T','T','A','A','B','T' },
				{ 'T','T','B','A','Z','T','T','B','A','A' },
				{ 'T','A','T','A','T','Z','T','B','A','T' },
				{ 'Z','Z','T','Z','T','Z','T','Z','A','T' },
				{ 'T','A','Z','A','Z','Z','A','T','T','T' },
				{ 'T','A','T','A','T','T','A','T','T','A' },
				{ 'T','A','T','A','T','Z','T','T','A','T' },
		};
		Detector detector = new Detector();
		
		Assert.assertEquals(2, detector.matchedPatternsAmount(dna));
		Assert.assertEquals(true, detector.isMutant(dna));
	}
}
