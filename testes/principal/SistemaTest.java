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
		sistema.cadastrarAluno("Gabriel", "1111", 10000, "0000-1000", "gabriel@ccc.ufcg.edu.br");
		sistema.tornarTutor("1001", "Programação 2", 5);
		sistema.cadastrarHorario("matheus.g@ccc.ufcg.edu.br", "15:00", "sex");
		sistema.cadastrarLocalDeAtendimento("matheus.g@ccc.ufcg.edu.br", "LCC2");
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
	
	@Test
	public void testPedirAjudaPresencial() {
		int id = sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", "LCC2");
		assertEquals(1, id);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrAlunoVazia() {
		sistema.pedirAjudaPresencial("     ", "Programação 2", "15:00", "sex", "LCC2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrAlunoNula() {
		sistema.pedirAjudaPresencial(null, "Programação 2", "15:00", "sex", "LCC2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaVazia() {
		sistema.pedirAjudaPresencial("1111", "     ", "15:00", "sex", "LCC2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaNula() {
		sistema.pedirAjudaPresencial("1111", null, "15:00", "sex", "LCC2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioVazio() {
		sistema.pedirAjudaPresencial("1111", "Programação 2", "     ", "sex", "LCC2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioNulo() {
		sistema.pedirAjudaPresencial("1111", "Programação 2", null, "sex", "LCC2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaVazio() {
		sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "    ", "LCC2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaNulo() {
		sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", null, "LCC2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalVazio() {
		sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", "     ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalNulo() {
		sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", null);
	}
	
	@Test
	public void testPedirAjudaOnline() {
		int id = sistema.pedirAjudaOnline("1111", "Programação 2");
		assertEquals(1, id);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrAlunoVazia() {
		sistema.pedirAjudaOnline("     ", "Programação 2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrAlunoNula() {
		sistema.pedirAjudaOnline(null, "Programação 2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaVazia() {
		sistema.pedirAjudaOnline("1111", "     ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaNula() {
		sistema.pedirAjudaOnline("1111", null);
	}
	
	@Test
	public void testPegarTutorAjudaOnline() {
		int id = sistema.pedirAjudaOnline("1111", "Programação 2");
		assertEquals("Tutor - 1001, disciplina - Programação 2", sistema.pegarTutor(id));
	}
	
	@Test
	public void testPegarTutorAjudaPresencial() {
		int id = sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", "LCC2");
		assertEquals("Tutor - 1001, horario - 15:00, dia - sex, local - LCC2, disciplina - Programação 2", sistema.pegarTutor(id));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaInexistente() {
		sistema.pegarTutor(1);
	}
	
	@Test
	public void testAvaliarTutor() {
		int id = sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", "LCC2");
		assertEquals("4,17", sistema.avaliarTutor(id, 5));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaMenorQueZero() {
		int id = sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", "LCC2");
		sistema.avaliarTutor(id, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaMaiorQueCinco() {
		int id = sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", "LCC2");
		sistema.avaliarTutor(id, 6);
	}
	
	@Test
	public void testGetInfoAjudaOnline() {
		int id = sistema.pedirAjudaOnline("1111", "Programação 2");
		assertEquals("1111", sistema.getInfoAjuda(id, "matrAluno"));
		assertEquals("1001", sistema.getInfoAjuda(id, "matrTutor"));
		assertEquals("Programação 2", sistema.getInfoAjuda(id, "disciplina"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineIdInvalido() {
		sistema.getInfoAjuda(1, "matrAluno");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoNulo() {
		int id = sistema.pedirAjudaOnline("1111", "Programação 2");
		sistema.getInfoAjuda(id, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoVazio() {
		int id = sistema.pedirAjudaOnline("1111", "Programação 2");
		sistema.getInfoAjuda(id, "   ");
	}
	
	@Test
	public void testGetInfoAjudaPresencial() {
		int id = sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", "LCC2");
		assertEquals("1111", sistema.getInfoAjuda(id, "matrAluno"));
		assertEquals("1001", sistema.getInfoAjuda(id, "matrTutor"));
		assertEquals("Programação 2", sistema.getInfoAjuda(id, "disciplina"));
		assertEquals("15:00", sistema.getInfoAjuda(id, "horario"));
		assertEquals("sex", sistema.getInfoAjuda(id, "dia"));
		assertEquals("LCC2", sistema.getInfoAjuda(id, "localInteresse"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoInvalido() {
		int id = sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", "LCC2");
		sistema.getInfoAjuda(id, "roupas");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoVazio() {
		int id = sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", "LCC2");
		sistema.getInfoAjuda(id, "       ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoNulo() {
		int id = sistema.pedirAjudaPresencial("1111", "Programação 2", "15:00", "sex", "LCC2");
		sistema.getInfoAjuda(id, null);
	}
	
	@Test
	public void testDoar() {
		sistema.doar("1001", 1000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoarTutorInexistente() {
		sistema.doar("100", 1000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoarQuantiaInvalida() {
		sistema.doar("1001", -1000);
	}
	
	@Test
	public void testTotalDinheiroSistema() {
		assertEquals(0, sistema.totalDinheiroSistema());
		sistema.doar("1001", 1000);
		assertEquals(200, sistema.totalDinheiroSistema());
	}
	
	@Test
	public void testTotalDinheiroTutor() {
		assertEquals(0, sistema.totalDinheiroTutor("matheus.g@ccc.ufcg.edu.br"));
		sistema.doar("1001", 1000);
		assertEquals(800, sistema.totalDinheiroTutor("matheus.g@ccc.ufcg.edu.br"));
	}
	
	@Test
	public void testConfiguraOrdem() {
		sistema.cadastrarAluno("Robert", "1002", 10000, "0200-1000", "robert@ccc.ufcg.edu.br");
		sistema.tornarTutor("1002", "Programação 2", 5);
		
		sistema.cadastrarAluno("Matheus", "1003", 10000, "0200-1000", "matheus.gomes@ccc.ufcg.edu.br");
		sistema.tornarTutor("1003", "Programação 1", 5);
		
		sistema.cadastrarAluno("Marcelo Robert", "1004", 10000, "0200-1000", "robert@ccc.ufcg.edu.br");
		sistema.tornarTutor("1004", "Introdução a Computação", 5);
		
		// ORDENAÇÃO PADRÃO
		String tutores = "";
		tutores += sistema.recuperaTutor("1004") + ", ";
		tutores += sistema.recuperaTutor("1003") + ", ";
		tutores += sistema.recuperaTutor("1002") + ", ";
		tutores += sistema.recuperaTutor("1001");
		
		assertEquals(tutores, sistema.listarTutores());
		
		// ORDENAÇÃO POR MATRICULA
		sistema.configurarOrdem("MATRICULA");
		
		tutores = "";
		tutores += sistema.recuperaTutor("1001") + ", ";
		tutores += sistema.recuperaTutor("1002") + ", ";
		tutores += sistema.recuperaTutor("1003") + ", ";
		tutores += sistema.recuperaTutor("1004");
		
		assertEquals(tutores, sistema.listarTutores());
		
		// ORDENAÇÃO POR NOME
		sistema.configurarOrdem("NOME");
		
		tutores = "";
		tutores += sistema.recuperaTutor("1004") + ", ";
		tutores += sistema.recuperaTutor("1001") + ", ";
		tutores += sistema.recuperaTutor("1003") + ", ";
		tutores += sistema.recuperaTutor("1002");
		
		assertEquals(tutores, sistema.listarTutores());
		
		// ORDENAÇÃO POR EMAIL
		sistema.configurarOrdem("EMAIL");
		
		tutores = "";
		tutores += sistema.recuperaTutor("1001") + ", ";
		tutores += sistema.recuperaTutor("1003") + ", ";
		tutores += sistema.recuperaTutor("1002") + ", ";
		tutores += sistema.recuperaTutor("1004");
		
		assertEquals(tutores, sistema.listarTutores());
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConfiguraOrdemAtributoNulo() {
		sistema.configurarOrdem(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConfiguraOrdemAtributoVazio() {
		sistema.configurarOrdem("      ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConfiguraOrdemAtributoInvalido() {
		sistema.configurarOrdem("beleza");
	}
}
