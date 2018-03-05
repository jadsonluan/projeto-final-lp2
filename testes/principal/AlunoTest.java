package principal;

import static org.junit.Assert.*;
import principal.Aluno;

import org.junit.Test;

public class AlunoTest {
	private Aluno aluno;

	public void testToString() {
		aluno = new Aluno("1", "aluno1", "aluno@ccc.ufcg.edu.br", 2);
		assertEquals("1 - aluno1 - 2 - aluno@ccc.ufcg.edu.br", aluno.toString());

		aluno = new Aluno("1", "aluno1", "aluno@ccc.ufcg.edu.br", 2, "0000-0000");
		assertEquals("1 - aluno1 - 2 - 0000-0000 - aluno@ccc.ufcg.edu.br", aluno.toString());
	}

}
