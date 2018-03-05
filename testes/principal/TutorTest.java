package principal;

import principal.Aluno;
import principal.Tutor;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Gabriel de Sousa Barros
 *
 */
public class TutorTest {

	private Tutor tutoria;

	@Test
	public void testCadastrarDisciplinaJaCadastrada() {
		tutoria = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		tutoria.cadastrarDisciplina("disciplina1", 1);
		try {
			tutoria.cadastrarDisciplina("disciplina1", 1);
			fail();
		} catch (Exception e) {

		}
	}

	@Test
	public void testCadastrarDisciplinaProficienciaInvalida() {
		tutoria = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		try {
			tutoria.cadastrarDisciplina("disciplina1", 0);
			fail();
		} catch (Exception e) {
		}

		try {
			tutoria.cadastrarDisciplina("disciplina1", 6);
			fail();
		} catch (Exception e) {

		}
	}

	@Test
	public void testConsultaHorario() {
		tutoria = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		tutoria.cadastrarHorario("13:00", "seg");
		assertTrue(tutoria.consultaHorario("13:00", "seg"));
		assertFalse(tutoria.consultaHorario("14:00", "seg"));
		assertFalse(tutoria.consultaHorario("13:00", "sex"));
	}

	@Test
	public void testConsultaLocal() {
		tutoria = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		tutoria.cadastrarLocalDeAtendimento("lcc1");
		assertTrue(tutoria.consultaLocal("lcc1"));
		assertFalse(tutoria.consultaLocal("biblioteca"));
	}
}
