package principal;

import static org.junit.Assert.*;

import org.junit.Before;

import principal.Sistema;

import org.junit.Test;

public class SistemaTest {
	private Sistema sistema;

	@Test
	public void testConstrutor() {
		new Sistema();
	}
	
	@Before
	public void criaSistema() {
		sistema = new Sistema();
		sistema.cadastrarAluno("Matheus", "1001", 9999, "4000-0004", "matheus.g@ccc.ufcg.edu.br");
		sistema.tornarTutor("1001", "Programação 2", 5);
	}
	
	@Test
	public void testCadastrarAluno() {
		sistema.cadastrarAluno("Luan", "3522", 10000, "4002-8922", "jadson.silva@ccc.ufcg.edu.br");
		String info = "3522 - Luan - 10000 - 4002-8922 - jadson.silva@ccc.ufcg.edu.br";
		assertEquals(info, sistema.recuperaAluno("3522"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAlunoEmailInvalido() {
		sistema.cadastrarAluno("Luan", "3522", 10000, "4002-8922", "jadson.silvaccc.ufcg.edu.br");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAlunoMatriculaExistente() {
		sistema.cadastrarAluno("Luan", "3522", 10000, "4002-8922", "jadson.silva@ccc.ufcg.edu.br");
		sistema.cadastrarAluno("Batman", "3522", 10000, "4112-8922", "bat.silva@ccc.ufcg.edu.br");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAlunoNomeVazio() {
		sistema.cadastrarAluno("   ", "3522", 10000, "4002-8922", "jadson.silva@ccc.ufcg.edu.br");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAlunoNomeNulo() {
		sistema.cadastrarAluno(null, "3522", 10000, "4002-8922", "jadson.silva@ccc.ufcg.edu.br");
	}
	
	@Test
	public void testCadastrarAlunoSemTelefone() {
		sistema.cadastrarAluno("Luan", "3522", 10000, "", "jadson.silva@ccc.ufcg.edu.br");
	}

	@Test(expected = NullPointerException.class)
	public void testRecuperaAlunoNaoExistente() {
		sistema.recuperaAluno("1");
	}

	@Test
	public void testGetInfoAluno() {
		sistema.cadastrarAluno("Luan", "3522", 10000, "4002-8922", "jadson.silva@ccc.ufcg.edu.br");
		String info = sistema.getInfoAluno("3522", "Nome");
		assertEquals("Luan", info);
		
		info = sistema.getInfoAluno("3522", "Email");
		assertEquals("jadson.silva@ccc.ufcg.edu.br", info);
		
		info = sistema.getInfoAluno("3522", "CodigoCurso");
		assertEquals("10000", info);
		
		info = sistema.getInfoAluno("3522", "Telefone");
		assertEquals("4002-8922", info);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetInfoAlunoInexistente() {
		sistema.getInfoAluno("1", "Nome");
	}
	
	@Test(expected = NullPointerException.class)
	public void testTornarTutorAlunoNaoExistente() {
		sistema.tornarTutor("1", "P2", 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRecuperaTutorNaoExistente() {
		sistema.recuperaTutor("1");
	}
	
	@Test(expected = NullPointerException.class)
	public void testRecuperaTutorQueNaoEhTutor() {
		sistema.cadastrarAluno("Luan", "123", 10000, "4002-8922", "jadson.silva@ccc.ufcg.edu.br");
		sistema.recuperaTutor("1");
	}
	
	@Test
	public void testCadastrarHorario() {
		sistema.cadastrarAluno("Luan", "123", 10000, "4002-8922", "jadson.silva@ccc.ufcg.edu.br");
		sistema.tornarTutor("123", "P2", 5);
		sistema.cadastrarHorario("jadson.silva@ccc.ufcg.edu.br", "15:00", "seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioEmailVazio() {
		sistema.cadastrarAluno("Luan", "123", 10000, "4002-8922", "jadson.silva@ccc.ufcg.edu.br");
		sistema.tornarTutor("123", "P2", 5);
		sistema.cadastrarHorario("", "15:00", "seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioVazio() {
		sistema.cadastrarAluno("Luan", "123", 10000, "4002-8922", "jadson.silva@ccc.ufcg.edu.br");
		sistema.tornarTutor("123", "P2", 5);
		sistema.cadastrarHorario("jadson.silva@ccc.ufcg.edu.br", "", "seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioDiaVazio() {
		sistema.cadastrarAluno("Luan", "123", 10000, "4002-8922", "jadson.silva@ccc.ufcg.edu.br");
		sistema.tornarTutor("123", "P2", 5);
		sistema.cadastrarHorario("jadson.silva@ccc.ufcg.edu.br", "15:00", "");
	}
	
	@Test
	public void testCadastrarLocalDeAtendimento() {
		sistema.cadastrarLocalDeAtendimento("matheus.g@ccc.ufcg.edu.br", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoEmailVazio() {
		sistema.cadastrarLocalDeAtendimento("", "LCC3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoVazio() {
		sistema.cadastrarLocalDeAtendimento("matheus.g@ccc.ufcg.edu.br", "");
	}
	
	@Test
	public void testConsultaHorario() {
		assertEquals(false, sistema.consultaHorario("matheus.g@ccc.ufcg.edu.br", "15:00", "seg"));
		sistema.cadastrarHorario("matheus.g@ccc.ufcg.edu.br", "15:00", "seg");
		assertEquals(true, sistema.consultaHorario("matheus.g@ccc.ufcg.edu.br", "15:00", "seg"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioTutorInexistente() {
		sistema.consultaHorario("romaro.g@ccc.ufcg.edu.br", "15:00", "seg");
	}
	
	@Test
	public void testConsultaLocal() {
		assertEquals(false, sistema.consultaLocal("matheus.g@ccc.ufcg.edu.br", "LCC3"));
		sistema.cadastrarLocalDeAtendimento("matheus.g@ccc.ufcg.edu.br", "LCC3");
		assertEquals(true, sistema.consultaLocal("matheus.g@ccc.ufcg.edu.br", "LCC3"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaLocalTutorInexistente() {
		sistema.consultaLocal("romaro.g@ccc.ufcg.edu.br", "LCC3");
	}
	
	@Test
	public void testPegarNota() {
		assertEquals("4,00", sistema.pegarNota("1001"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNotaTutorInexistente() {
		sistema.pegarNota("101");
	}
	
	@Test
	public void testPegarNivel() {
		assertEquals("Tutor", sistema.pegarNivel("1001"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNivelTutorInexistente() {
		sistema.pegarNivel("101");
	}
}
