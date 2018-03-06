package principal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AjudaPresencialTest {

	@Test
	public void testConstrutor() {
		new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorIdInvalido() {
		new AjudaPresencial(-1, "123", "321", "Prog2", "15:00", "seg", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorMatrAlunoVazia() {
		new AjudaPresencial(0, "   ", "321", "Prog2", "15:00", "seg", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorMatrTutorVazia() {
		new AjudaPresencial(0, "123", "    ", "Prog2", "15:00", "seg", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorDisciplinaVazia() {
		new AjudaPresencial(0, "123", "321", "      ", "15:00", "seg", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorHorarioVazio() {
		new AjudaPresencial(0, "123", "321", "Prog2", "    ", "seg", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorDiaVazio() {
		new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "     ", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorLocalVazio() {
		new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", "     ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorHorarioNulo() {
		new AjudaPresencial(0, "123", "321", "Prog2", null, "seg", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorDiaNulo() {
		new AjudaPresencial(0, "123", "321", "Prog2", "15:00", null, "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorLocalNulo() {
		new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorMatrAlunoNula() {
		new AjudaPresencial(0, null, "321", "Prog2", "15:00", "seg", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorMatrTutorNula() {
		new AjudaPresencial(0, "123", null, "Prog2", "15:00", "seg", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorDisciplinaNula() {
		new AjudaPresencial(0, "123", "321", null, "15:00", "seg", "LCC3");
	}
	
	@Test
	public void testPegarTutor() {
		Ajuda ajuda = new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", "LCC3");
		assertEquals("321, horario - 15:00, dia - seg, local - LCC3, disciplina - Prog2", ajuda.pegarTutor());
	}
	
	@Test
	public void testGetTutor() {
		Ajuda ajuda = new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", "LCC3");
		assertEquals("321", ajuda.getTutor());
	}
	
	@Test
	public void testGetDisciplina() {
		Ajuda ajuda = new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", "LCC3");
		assertEquals("Prog2", ajuda.getDisciplina());
	}
	
	@Test
	public void testFoiAvaliada() {
		Ajuda ajuda = new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", "LCC3");
		assertEquals(false, ajuda.foiAvaliada());
		
		ajuda.avalia();
		assertEquals(true, ajuda.foiAvaliada());
	}
	
	@Test
	public void testGetInfo() {
		Ajuda ajuda = new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", "LCC3");
		assertEquals("123", ajuda.getInfo("matrAluno"));
		assertEquals("321", ajuda.getInfo("matrTutor"));
		assertEquals("Prog2", ajuda.getInfo("disciplina"));
		assertEquals("15:00", ajuda.getInfo("horario"));
		assertEquals("seg", ajuda.getInfo("dia"));
		assertEquals("LCC3", ajuda.getInfo("localInteresse"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoNulo() {
		Ajuda ajuda = new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", "LCC3");
		ajuda.getInfo(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoVazio() {
		Ajuda ajuda = new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", "LCC3");
		ajuda.getInfo("    ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoInexistente() {
		Ajuda ajuda = new AjudaPresencial(0, "123", "321", "Prog2", "15:00", "seg", "LCC3");
		ajuda.getInfo("escola");
	}
}
