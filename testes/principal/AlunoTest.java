package principal;

import static org.junit.Assert.*;
import principal.Aluno;

import org.junit.Test;

public class AlunoTest {
	private Aluno aluno;

	@Test
	public void testConstrutorSemTelefone() {
		new Aluno("1", "Jones", "jones@ccc.ufcg.edu.br", 2);
	}

	@Test
	public void testConstrutorComTelefone() {
		new Aluno("1", "Jones", "jones@ccc.ufcg.edu.br", 2, "0000-0000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorComTelefoneEmailComecandoComArroba() {
		new Aluno("1", "Jones", "@ccc.ufcg.edu.br", 2, "0000-0000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorComTelefoneEmailTerminandoComArroba() {
		new Aluno("1", "Jones", "jones@ccc.ufcg.edu.br@", 2, "0000-0000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorComTelefoneEmailSemArroba() {
		new Aluno("1", "Jones", "jones@ccc.ufcg.edu.br", 2, "0000-0000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorComTelefoneMatriculaNula() {
		new Aluno(null, "Jones", "jones@ccc.ufcg.edu.br", 2, "0000-0000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorComTelefoneMatriculaVazia() {
		new Aluno("", "Jones", "jones@ccc.ufcg.edu.br", 2, "0000-0000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorComTelefoneNomeNulo() {
		new Aluno("1", null, "jones@ccc.ufcg.edu.br", 2, "0000-0000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorComTelefoneNomeVazio() {
		new Aluno("1", "", "jones@ccc.ufcg.edu.br", 2, "0000-0000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorComTelefoneTelefoneVazio() {
		new Aluno("1", "Jones", "jones@ccc.ufcg.edu.br", 2, "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorComTelefoneCodigoCursoNegativo() {
		new Aluno("1", "Jones", "jones@ccc.ufcg.edu.br", -1, "0000-0000");
	}

	@Test
	public void testToStringAlunoSemTelefone() {
		aluno = new Aluno("1", "aluno1", "aluno@ccc.ufcg.edu.br", 2);
		assertEquals("1 - aluno1 - 2 - aluno@ccc.ufcg.edu.br", aluno.toString());
	}

	@Test
	public void testToStringAlunoComTelefone() {
		aluno = new Aluno("1", "aluno1", "aluno@ccc.ufcg.edu.br", 2, "0000-0000");
		assertEquals("1 - aluno1 - 2 - 0000-0000 - aluno@ccc.ufcg.edu.br", aluno.toString());
	}

}
