package principal;

import easyaccept.EasyAccept;

/**
 * 
 * @author Arthur de Lima FerrÃ£o - 117110318
 */
public class Facade {
	private Sistema sistema;

	public Facade() {
		this.sistema = new Sistema();
	}

	/**
	 * Cadastra um aluno no sistema
	 * 
	 * @param nome
	 *            o nome do aluno
	 * @param matricula
	 *            a matricula do aluno
	 * @param codigoCurso
	 *            o codigo do curso do aluno
	 * @param telefone
	 *            o telefone do aluno
	 * @param email
	 *            o email do aluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso,
			String telefone, String email) {
		this.sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone,
				email);
	}

	/**
	 * Recupera o aluno pela matricula O formato da representaÃ§Ã£o do aluno Ã©:<br>
	 * â€œMatricula - Nome - CÃ³digoCurso - telefone - emailâ€� <br>
	 * Caso nÃ£o tenha telefone, a impressÃ£o do aluno deve ter o formato:<br>
	 * â€œMatricula - Nome - CÃ³digoCurso - emailâ€�
	 * 
	 * @param matricula
	 *            a matricula do aluno
	 * @return retorna a representaÃ§Ã£o em String do aluno
	 */
	public String recuperaAluno(String matricula) {
		return this.sistema.recuperaAluno(matricula);
	}

	/**
	 * Lista todos os alunos cadastrados
	 * 
	 * @return retorna a lista com as representaÃ§Ã£o em String dos alunos
	 */
	public String listarAlunos() {
		return this.sistema.listarAlunos();
	}

	/**
	 * Pega a informaÃ§Ã£o de um atributo do aluno
	 * 
	 * @param matricula
	 *            a matricula do aluno
	 * @param atributo
	 *            o atributo do aluno (Nome, Telefone, Email, CodigoCurso)
	 * @return retorna o valor do atributo do aluno
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return this.sistema.getInfoAluno(matricula, atributo);
	}

	/**
	 * Torna o aluno tutor de uma disciplina
	 * 
	 * @param matricula
	 *            a matricula do aluno
	 * @param disciplina
	 *            a disciplina da tutoria
	 * @param proficiencia
	 *            a proficiencia da disciplina (1-5)
	 */
	public void tornarTutor(String matricula, String disciplina,
			int proficiencia) {
		this.sistema.tornarTutor(matricula, disciplina, proficiencia);
	}

	/**
	 * Recupera um tutor pela matricula
	 * 
	 * @param matricula
	 *            a matricula do tutor
	 * @return retorna a
	 */
	public String recuperaTutor(String matricula) {
		return this.sistema.recuperaTutor(matricula);
	}

	/**
	 * Lista todos os tutores cadastrados no sistema
	 * 
	 * @return retorna a representaÃ§Ã£o em String do tutor
	 */
	public String listarTutores() {
		return this.sistema.listarTutores();
	}

	/**
	 * Cadastra um horario para o tutor
	 * 
	 * @param email
	 *            o email do tutor
	 * @param horario
	 *            o horario para cadastrar
	 * @param dia
	 *            o dia para cadastrar
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		this.sistema.cadastrarHorario(email, horario, dia);
	}

	/**
	 * Cadastra um local de atendimento para o tutor
	 * 
	 * @param email
	 *            o email do tutor
	 * @param local
	 *            o local de atendimento para cadastrar
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.sistema.cadastrarLocalDeAtendimento(email, local);
	}

	/**
	 * Consulta se o horario existe para o tutor
	 * 
	 * @param email
	 *            o email do tutor
	 * @param horario
	 *            o horario para consulta
	 * @param dia
	 *            o dia para consulta
	 * @return retorna um valor boolean, true represetando que existe e false
	 *         que nao
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.sistema.consultaHorario(email, horario, dia);
	}

	/**
	 * Consulta se o local existe para o tutor
	 * 
	 * @param email
	 *            o email do tutor
	 * @param local
	 *            o local para ser consultado
	 * @return retorna um valor boolean, true represetando que existe e false
	 *         que nao
	 */
	public boolean consultaLocal(String email, String local) {
		return this.sistema.consultaLocal(email, local);
	}

	public String pegarNivel(String matriculaTutor) {
		return this.sistema.pegarNivel(matriculaTutor);
	}

	public int pedirAjudaPresencial(String matrAluno, String disciplina,
			String horario, String dia, String localInteresse) {
		return this.sistema.pedirAjudaPresencial(matrAluno, disciplina,
				horario, dia, localInteresse);
	}

	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return this.sistema.pedirAjudaOnline(matrAluno, disciplina);
	}

	public String pegarTutor(int idAjuda) {
		return this.sistema.pegarTutor(idAjuda);
	}

	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.sistema.getInfoAjuda(idAjuda, atributo);
	}

	public String avaliarTutor(int idAjuda, int nota) {
		return this.sistema.avaliarTutor(idAjuda, nota);
	}

	public String pegarNota(String matriculaTutor) {
		return this.sistema.pegarNota(matriculaTutor);

	}

	/**
	 * Efetua uma doacao a um tutor especifico, este fica com uma taxa do
	 * dinheiro doado e o restante e direcionado ao caixa do sistema
	 * 
	 * @param matriculaTutor
	 *            matricula do tutor que recebera a doacao
	 * @param totalCentavos
	 *            valor doado
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		sistema.doar(matriculaTutor, totalCentavos);
	}

	/**
	 * Retorna o dinheiro armazenado pelo sistema
	 * 
	 * @return dinheiro armazenado pelo sistema
	 */
	public int totalDinheiroSistema() {
		return sistema.totalDinheiroSistema();
	}

	/**
	 * Retorna o dinheiro total recebido por um tutor
	 * 
	 * @param emailTutor
	 *            email do tutor a ser verificado
	 * @return dinheiro total recebido pelo tutor
	 */
	public int totalDinheiroTutor(String emailTutor) {
		return sistema.totalDinheiroTutor(emailTutor);
	}

	public void salvar() {
		this.sistema.salvar();
	}
	
	/**
	 * @see Sistema#configurarOrdem(String) 
	 */
	public void configuraOrdem(String atributo) {
		this.sistema.configurarOrdem(atributo);
	}

	public static void main(String[] args) {
		args = new String[] { "principal.Facade",
				"acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt",
				"acceptance_test/us5_test.txt", "acceptance_test/us6_test.txt" };
		EasyAccept.main(args);
	}

}
