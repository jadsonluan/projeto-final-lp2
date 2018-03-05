package principal;

import static org.junit.Assert.*;
import principal.Sistema;

import org.junit.Test;

public class SistemaTest {
	private Sistema sistema;
	
	@Test
	public void testCadastrarAluno() {
		sistema = new Sistema();
		sistema.cadastrarAluno("aluno1", "1", 2, "0000-0000", "aluno@ccc.ufcg.edu.br");
		assertEquals("1 - aluno1 - 2 - 0000-0000 - aluno@ccc.ufcg.edu.br", sistema.recuperaAluno("1"));
	}
	
	@Test
	public void testCadastrarAlunoMatriculaJaCadastrada() {
		sistema = new Sistema();
		sistema.cadastrarAluno("aluno1", "1", 2, "0000-0000", "aluno@ccc.ufcg.edu.br");
		try{
			sistema.cadastrarAluno("aluno1", "1", 2, "0000-0000", "aluno@ccc.ufcg.edu.br");
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testCadastrarAlunoMatriculaNomeVazio() {
		sistema = new Sistema();
		try{
			sistema.cadastrarAluno("", "1", 2, "0000-0000", "aluno@ccc.ufcg.edu.br");
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testRecuperaAlunoNaoExistente() {
		sistema = new Sistema();
		try {
			sistema.recuperaAluno("1");
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testGetInfoAlunoNaoExistente() {
		sistema = new Sistema();
		try {
			sistema.getInfoAluno("1", "nome");
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testTornarTutorAlunoNaoExistente() {
		sistema = new Sistema();
		try {
			sistema.tornarTutor("1", "p2", 5);
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testRecuperaTutorNaoExistente() {
		sistema = new Sistema();
		try {
			sistema.recuperaTutor("1");
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testRecuperaTutorAlunoQueNaoEhTutor() {
		sistema = new Sistema();
		sistema.cadastrarAluno("aluno1", "1", 2, "0000-0000", "aluno@ccc.ufcg.edu.br");
		try {
			sistema.recuperaTutor("1");
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testCadastrarHorarioEmailVazio() {
		sistema = new Sistema();
		sistema.cadastrarAluno("aluno1", "1", 2, "0000-0000", "aluno@ccc.ufcg.edu.br");
		try {
			sistema.cadastrarHorario("", "13:00", "seg");
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testCadastrarHorarioHorarioVazio() {
		sistema = new Sistema();
		sistema.cadastrarAluno("aluno1", "1", 2, "0000-0000", "aluno@ccc.ufcg.edu.br");
		try {
			sistema.cadastrarHorario("aluno@ccc.ufcg.edu.br", "", "seg");
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testCadastrarHorarioDiaVazio() {
		sistema = new Sistema();
		sistema.cadastrarAluno("aluno1", "1", 2, "0000-0000", "aluno@ccc.ufcg.edu.br");
		try {
			sistema.cadastrarHorario("aluno@ccc.ufcg.edu.br", "13:00", "");
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testCadastrarLocalEmailVazio() {
		sistema = new Sistema();
		sistema.cadastrarAluno("aluno1", "1", 2, "0000-0000", "aluno@ccc.ufcg.edu.br");
		try {
			sistema.cadastrarLocalDeAtendimento("", "lcc2");;
			fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testCadastrarLocalLocalVazio() {
		sistema = new Sistema();
		sistema.cadastrarAluno("aluno1", "1", 2, "0000-0000", "aluno@ccc.ufcg.edu.br");
		try {
			sistema.cadastrarLocalDeAtendimento("aluno@ccc.ufcg.edu.br", "");;
			fail();
		}catch(Exception e) {
			
		}
	}
	
	

}
