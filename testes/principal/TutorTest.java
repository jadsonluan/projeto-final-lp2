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
	private Tutor tutor;
	
	@Test
	public void testConstrutorTutor() {
		new Tutor(new Aluno("1", "Jones", "jones@ccc.ufcg.edu.br", 2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstrutorTutorAlunoNulo() {
		new Tutor(null);
	}
	
	@Test
	public void testCadastrarDisciplina() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		tutor.cadastrarDisciplina("disciplina1", 1);
		assertTrue(tutor.consultaDisciplina("disciplina1"));
	}
	
	@Test
	public void testCadastrarDisciplinaJaCadastrada() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		tutor.cadastrarDisciplina("disciplina1", 1);
		try {
			tutor.cadastrarDisciplina("disciplina1", 1);
			fail();
		} catch (Exception e) {

		}
	}

	@Test
	public void testCadastrarDisciplinaProficienciaInvalida() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		try {
			tutor.cadastrarDisciplina("disciplina1", 0);
			fail();
		} catch (Exception e) {
		}

		try {
			tutor.cadastrarDisciplina("disciplina1", 6);
			fail();
		} catch (Exception e) {

		}
	}

	@Test
	public void testCadastraHorario() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		tutor.cadastrarHorario("13:00", "seg");
		assertTrue(tutor.consultaHorario("13:00", "seg"));
		assertFalse(tutor.consultaHorario("14:00", "seg"));
		assertFalse(tutor.consultaHorario("13:00", "sex"));
		tutor.cadastrarHorario("18:00", "seg");
	}

	@Test
	public void testCadastraLocal() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		tutor.cadastrarLocalDeAtendimento("lcc1");
		assertTrue(tutor.consultaLocal("lcc1"));
		assertFalse(tutor.consultaLocal("biblioteca"));
	}
	
	@Test
	public void testAvaliacaoTutor() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		assertEquals("3.3333333333333335", tutor.avaliacaoTutor(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliacaoTutorNotaMenorQueZero() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		tutor.avaliacaoTutor(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliacaoTutorNotaMaiorQueCinco() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		tutor.avaliacaoTutor(6);
	}
	
	@Test
	public void testGetNivelTutor() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		assertEquals("Tutor", tutor.getNivel());
	}
	
	@Test
	public void testGetNivelTOP() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		for(int i = 0; i < 4; i++) {
			tutor.avaliacaoTutor(5);
		}
		assertEquals("TOP", tutor.getNivel());
	}
	
	@Test
	public void testGetNivelAprendiz() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		for(int i = 0; i < 2; i++) {
			tutor.avaliacaoTutor(0);
		}
		assertEquals("Aprendiz", tutor.getNivel());
	}
	
	@Test
	public void testGetTaxaTutorTutor() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		assertEquals(0.8, tutor.getTaxaTutor(), 0);
	}
	
	@Test
	public void testGetTaxaTutorTOP() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		for(int i = 0; i < 6; i++) {
			tutor.avaliacaoTutor(5);
		}
		assertEquals(0.91, tutor.getTaxaTutor(), 0);
	}
	
	@Test
	public void testGetTaxaTutorAprendiz() {
		tutor = new Tutor(new Aluno("123", "Luan", "luan@gmail.com", 1));
		for(int i = 0; i < 2; i++) {
			tutor.avaliacaoTutor(0);
		}
		assertEquals(0.38, tutor.getTaxaTutor(), 0);
	}
}
