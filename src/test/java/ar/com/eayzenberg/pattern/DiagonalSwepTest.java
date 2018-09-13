package ar.com.eayzenberg.pattern;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiagonalSwepTest {

	private char[][] matrix;

	@Before
	public void setUp() {
		matrix = new char[][] {
				{ 'A','A','A','A','B' },
				{ 'T','A','A','B','T' },
				{ 'T','T','A','A','T' },
				{ 'T','B','T','A','T' },
				{ 'B','T','T','A','X' },
		};
	}
	
	@Test
	public void barrerSentidoOpuestoTest() {
		DiagonalSweeper barridor = new DiagonalSweeper(false);
		
		char[] barrida;
		char[] esperado;
		
		barrida = barridor.sweep(4, 0, matrix);
		esperado = new char[] {'B','B','A','B','B'};
		Assert.assertArrayEquals(esperado, barrida);
		
		barrida = barridor.sweep(4, 1, matrix);
		esperado = new char[] {'T','A','T','T'};
		Assert.assertArrayEquals(esperado, barrida);
	}
	
	@Test
	public void barrerSentidoPrincipalTest() {
		DiagonalSweeper barridor = new DiagonalSweeper(true);
		
		char[] barrida;
		char[] esperado;
		
		barrida = barridor.sweep(0, 0, matrix);
		esperado = new char[] {'A','A','A','A','X'};
		Assert.assertArrayEquals(esperado, barrida);
		
		barrida = barridor.sweep(0, 1, matrix);
		esperado = new char[] {'T','T','T','A'};
		Assert.assertArrayEquals(esperado, barrida);
		
		barrida = barridor.sweep(1, 0, matrix);
		esperado = new char[] {'A','A','A','T'};
		Assert.assertArrayEquals(esperado, barrida);
	}
	
	@Test
	public void barrerSentidoPrincipalFueraLimitesTest() {
		DiagonalSweeper barridor = new DiagonalSweeper(true);
		char[] barrida = barridor.sweep(6, 6, matrix);
		
		Assert.assertArrayEquals(null, barrida);
	}
}
