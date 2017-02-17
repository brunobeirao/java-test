package teste.java;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import control.LeitorController;
import interfaces.ILeitorArquivo;

public class LeitorArquivoTest {

	ILeitorArquivo leitorArquivo;

	String testFilter = "[1100189, RO, Pimenta Bueno, , -61.1836656736, -11.67753699, Pimenta Bueno, , Vilhena, Leste Rondoniense]";

	@Before
	public void before() throws IOException {
		leitorArquivo = new LeitorController();
	}

	@Test
	public void getCount() throws IOException {
		assertEquals(5565, leitorArquivo.getCount(), 0);
	}

	@Test
	public void getCountDistinct() throws IOException {
		assertEquals(27, leitorArquivo.getCountDistinct("count distinct uf"), 0);
	}

	@Test
	public void getFilter() throws IOException {
		assertEquals(testFilter, leitorArquivo.getFilter("filter microregion Vilhena"));
	}
}