package testes;

import static org.junit.Assert.*;
import principal.Aluno;

import org.junit.Test;

public class AlunoTest {
	private Aluno aluno;
	@Test
	public void testTornaTutor() {
		aluno = new Aluno("1", "aluno1", "aluno@ccc.ufcg.edu.br", 1);
		assertFalse(aluno.ehTutor());
		
		aluno.tornaTutor("p2", 4);
		assertTrue(aluno.ehTutor());
	}
	
	public void testToString() {
		aluno = new Aluno("1", "aluno1", "aluno@ccc.ufcg.edu.br", 2);
		assertEquals("1 - aluno1 - 2 - aluno@ccc.ufcg.edu.br", aluno.toString());
		
		aluno = new Aluno("1", "aluno1", "aluno@ccc.ufcg.edu.br", 2, "0000-0000");
		assertEquals("1 - aluno1 - 2 - 0000-0000 - aluno@ccc.ufcg.edu.br", aluno.toString());
	}

}
