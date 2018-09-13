package ar.com.eayzenberg.pattern;

import ar.com.eayzenberg.util.Arrays;

public class Detector {

	public int matchedPatternsAmount(char[][] matrix) {
		int amount = linealPatterns(matrix);
		amount += linealPatterns(Arrays.traspose(matrix));
		amount += diagonalPatternsMainSense(matrix);
		amount += diagonalPatternsOppositeSense(matrix);
		return amount;
	}

	public boolean isMutant(String[] strings) {
		char[][] matrix = new char[strings.length][0];
		for (int i = 0; i < strings.length; i++) {
			String line = strings[i];
			matrix[i] = line.toCharArray();
		}
		return isMutant(matrix);
	}
	
	// Lazy processing
	public boolean isMutant(char[][] matrix) {
		
		// Horizontal sweep
		int amount = linealPatterns(matrix);
		
		if (amount > 1) {
			return true;
		}
		
		// Vertical sweep
		amount += linealPatterns(Arrays.traspose(matrix));
		
		if (amount > 1) {
			return true;
		}
		
		// Diagonal sweep in main sense
		amount += diagonalPatternsMainSense(matrix);

		if (amount > 1) {
			return true;
		}
		
		// Diagonal sweep in opposite sense
		amount += diagonalPatternsOppositeSense(matrix);
		
		if (amount > 1) {
			return true;
		}
		
		return false;
	}

	private int diagonalPatternsOppositeSense(char[][] matrix) {
		int M = matrix.length;
		int N = matrix[0].length;
		if (N < 4 || M < 4) {
			// Minimun is 4x4, if not avoid. 
			return 0;
		}
		
		int patternAmount = 0;
		
		// Use valid initial search indexes
		DiagonalSweeper sweeper = new DiagonalSweeper(false);
		char[] line = sweeper.sweep(N - 1, 0, matrix);
		patternAmount += DetectorRegex.find(line);
		
		// (N-1,0) already verified. Starting from N-2
		for (int i = N - 2; i > 2; i-- ) {
			line = sweeper.sweep(i, 0, matrix);
			patternAmount += DetectorRegex.find(line);
		}
		for (int j = 1; M - j >= 4; j++) {
			line = sweeper.sweep(N - 1, j, matrix);
			patternAmount += DetectorRegex.find(line);
		}
		
		return patternAmount;
	}

	private int diagonalPatternsMainSense(char[][] matrix) {
		int M = matrix.length;
		int N = matrix[0].length;
		if (N < 4 || M < 4) {
			// Minimun is 4x4, if not avoid. 
			return 0;
		}
		
		int patternAmount = 0;
		
		// Use valid initial search indexes
		DiagonalSweeper sweeper = new DiagonalSweeper(true);
		char[] line = sweeper.sweep(0, 0, matrix);
		patternAmount += DetectorRegex.find(line);
		
		// (0,0) already verified. Starting from 1
		for (int i = 1; N - i >= 4; i++ ) {
			line = sweeper.sweep(i, 0, matrix);
			patternAmount += DetectorRegex.find(line);
		}
		for (int j = 1; M - j >= 4; j++) {
			line = sweeper.sweep(0, j, matrix);
			patternAmount += DetectorRegex.find(line);
		}
		
		return patternAmount;
	}

	private int linealPatterns(char[][] matrix) {
		if (matrix[0].length < 4) {
			return 0;
		}
		
		int patternAmount = 0;
		
		for (char[] line : matrix) {
			patternAmount += DetectorRegex.find(line);
		}
		
		return patternAmount;
	}

}
