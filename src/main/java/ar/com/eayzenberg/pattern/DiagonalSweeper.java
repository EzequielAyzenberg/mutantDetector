package ar.com.eayzenberg.pattern;

public class DiagonalSweeper {
	
	private boolean mainSense;

	public DiagonalSweeper(boolean mainSense) {
		this.mainSense = mainSense;
	}
	
	public char[] sweep(int iFrom, int jFrom, char[][] matrix) {
		if (iFrom >= matrix[0].length || jFrom >= matrix.length) {
			return null;
		}
		if (mainSense) {
			return sweepMainSense(iFrom, jFrom, matrix);
		} else {
			return sweepOppositeSense(iFrom, jFrom, matrix);
		}
	}

	private char[] sweepOppositeSense(int iFrom, int jFrom, char[][] matrix) {
		int maxLength = getMaxResultLength(iFrom, jFrom, matrix);
		char[] sweep = new char[maxLength];
		int cursor = 0;
		while(cursor < maxLength) {
			sweep[cursor] = matrix[cursor + jFrom][iFrom - cursor];
			cursor++;
		}
		
		return sweep;
	}

	private char[] sweepMainSense(int iFrom, int jFrom, char[][] matrix) {
		int maxLength = getMaxResultLength(iFrom, jFrom, matrix);
		char[] sweep = new char[maxLength];
		int cursor = 0;
		while(cursor < maxLength) {
			sweep[cursor] = matrix[cursor + jFrom][cursor + iFrom];
			cursor++;
		}
		
		return sweep;
	}

	private int getMaxResultLength(int iFrom, int jFrom, char[][] matrix) {
		int deltaX;
		if (mainSense) {
			deltaX = matrix[0].length - iFrom;
		} else {
			deltaX = iFrom + 1;
		}
		int deltaY = matrix.length - jFrom;
		return deltaX < deltaY ? deltaX : deltaY;
	}
}
