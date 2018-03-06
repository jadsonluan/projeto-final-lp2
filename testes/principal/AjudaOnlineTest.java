package principal;

import org.junit.*;

import principal.Ajuda;
import principal.AjudaOnline;

import static org.junit.Assert.*;

public class AjudaOnlineTest {

	@Test
	public void testConstrutor() {
		new AjudaOnline(0, "123", "321", "Prog2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorIdInvalido() {
		new AjudaOnline(-1, "123", "321", "Prog2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorMatrAlunoVazia() {
		new AjudaOnline(0, "   ", "321", "Prog2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorMatrTutorVazia() {
		new AjudaOnline(0, "123", "    ", "Prog2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorDisciplinaVazia() {
		new AjudaOnline(0, "123", "321", "      ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorMatrAlunoNula() {
		new AjudaOnline(0, null, "321", "Prog2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorMatrTutorNula() {
		new AjudaOnline(0, "123", null, "Prog2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorDisciplinaNula() {
		new AjudaOnline(0, "123", "321", null);
	}
	
	@Test
	public void testPegarTutor() {
		Ajuda ajuda = new AjudaOnline(0, "123", "321", "Prog2");
		assertEquals("321, disciplina - Prog2", ajuda.pegarTutor());
	}
	
	@Test
	public void testGetTutor() {
		Ajuda ajuda = new AjudaOnline(0, "123", "321", "Prog2");
		assertEquals("321", ajuda.getTutor());
	}
	
	@Test
	public void testGetDisciplina() {
		Ajuda ajuda = new AjudaOnline(0, "123", "321", "Prog2");
		assertEquals("Prog2", ajuda.getDisciplina());
	}
	
	@Test
	public void testFoiAvaliada() {
		Ajuda ajuda = new AjudaOnline(0, "123", "321", "Prog2");
		assertEquals(false, ajuda.foiAvaliada());
		
		ajuda.avalia();
		assertEquals(true, ajuda.foiAvaliada());
	}
	
	@Test
	public void testGetInfo() {
		Ajuda ajuda = new AjudaOnline(0, "123", "321", "Prog2");
		assertEquals("123", ajuda.getInfo("matrAluno"));
		assertEquals("321", ajuda.getInfo("matrTutor"));
		assertEquals("Prog2", ajuda.getInfo("disciplina"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoVazio() {
		Ajuda ajuda = new AjudaOnline(0, "123", "321", "Prog2");
		ajuda.getInfo("   ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoNulo() {
		Ajuda ajuda = new AjudaOnline(0, "123", "321", "Prog2");
		ajuda.getInfo(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoInexistente() {
		Ajuda ajuda = new AjudaOnline(0, "123", "321", "Prog2");
		ajuda.getInfo("roupa");
	}
}
