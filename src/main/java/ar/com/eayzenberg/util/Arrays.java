package ar.com.eayzenberg.util;

public class Arrays {

	public static char[][] traspose(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		char[][] traspuesta = new char[n][m];

	    for(int x = 0; x < n; x++)
	    {
	        for(int y = 0; y < m; y++)
	        {
	        	traspuesta[x][y] = matrix[y][x];
	        }
	    }
	    
	    return traspuesta;
	}
}
