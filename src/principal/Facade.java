package principal;

import easyaccept.EasyAccept;

/**
 * 
 * @author Arthur de Lima Ferrao - 117110318
 */
public class Facade {
	private Sistema sistema;
	
	public Facade() {
		this.sistema = new Sistema();
	}

	/**
	 * @see Sistema#cadastrarAluno(String, String, int, String, String)
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso,
			String telefone, String email) {
		this.sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone,
				email);
	}

	/**
	 * @see Sistema#recuperaAluno(String)
	 */
	public String recuperaAluno(String matricula) {
		return this.sistema.recuperaAluno(matricula);
	}

	/**
	 * @see Sistema#listarAlunos()
	 */
	public String listarAlunos() {
		return this.sistema.listarAlunos();
	}

	/**
	 * @see Sistema#getInfoAluno(String, String)
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return this.sistema.getInfoAluno(matricula, atributo);
	}

	/**
	 * @see Sistema#tornarTutor(String, String, int)
	 */
	public void tornarTutor(String matricula, String disciplina,
			int proficiencia) {
		this.sistema.tornarTutor(matricula, disciplina, proficiencia);
	}

	/**
	 * @see Sistema#recuperaTutor(String)
	 */
	public String recuperaTutor(String matricula) {
		return this.sistema.recuperaTutor(matricula);
	}

	/**
	 * @see Sistema#listarTutores()
	 */
	public String listarTutores() {
		return this.sistema.listarTutores();
	}

	/**
	 * @see Sistema#cadastrarHorario(String, String, String)
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		this.sistema.cadastrarHorario(email, horario, dia);
	}

	/**
	 * @see Sistema#cadastrarLocalDeAtendimento(String, String)
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.sistema.cadastrarLocalDeAtendimento(email, local);
	}

	/**
	 * @see Sistema#consultaHorario(String, String, String)
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.sistema.consultaHorario(email, horario, dia);
	}

	/**
	 * @see Sistema#consultaLocal(String, String)
	 */
	public boolean consultaLocal(String email, String local) {
		return this.sistema.consultaLocal(email, local);
	}
	
	/**
	 * @see Sistema#pegarNivel(String)
	 */
	public String pegarNivel(String matriculaTutor) {
		return this.sistema.pegarNivel(matriculaTutor);
	}

	/**
	 * @see Sistema#pedirAjudaPresencial(String, String, String, String, String)
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina,
			String horario, String dia, String localInteresse) {
		return this.sistema.pedirAjudaPresencial(matrAluno, disciplina,
				horario, dia, localInteresse);
	}

	/**
	 * @see Sistema#pedirAjudaOnline(String, String)
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return this.sistema.pedirAjudaOnline(matrAluno, disciplina);
	}

	/**
	 * @see Sistema#pegarTutor(int)
	 */
	public String pegarTutor(int idAjuda) {
		return this.sistema.pegarTutor(idAjuda);
	}

	/**
	 * @see Sistema#getInfoAjuda(int, String)
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.sistema.getInfoAjuda(idAjuda, atributo);
	}
	/**
	 * @see Sistema#avaliarTutor(int, int)
	 */
	public String avaliarTutor(int idAjuda, int nota) {
		return this.sistema.avaliarTutor(idAjuda, nota);
	}
	/**
	 *@see Sistema#pegarNota(String)
	 */
	public String pegarNota(String matriculaTutor) {
		return this.sistema.pegarNota(matriculaTutor);

	}

	/**
	 * @see Sistema#doar(String, int)
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		sistema.doar(matriculaTutor, totalCentavos);
	}

	/**
	 * @see Sistema#totalDinheiroSistema
	 */
	public int totalDinheiroSistema() {
		return sistema.totalDinheiroSistema();
	}

	/**
	 * @see Sistema#totalDinheiroTutor(String)
	 */
	public int totalDinheiroTutor(String emailTutor) {
		return sistema.totalDinheiroTutor(emailTutor);
	}

	/**
	 * @see Sistema#salvar()
	 */
	public void salvar() {
		this.sistema.salvar();
	}

	/**
	 * @see Sistema#configurarOrdem(String)
	 */
	public void configuraOrdem(String atributo) {
		this.sistema.configurarOrdem(atributo);
	}
	
	/**
	 * @see Sistema#carregar()
	 */
	public void carregar() {
		this.sistema.carregar();
	}
	
	/**
	 * @see Sistema#limpar()
	 */
	public void limpar() {
		this.sistema.limpar();
	}

	public static void main(String[] args) {
		args = new String[] { "principal.Facade",
				"acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt",
				"acceptance_test/us5_test.txt", "acceptance_test/us6_test.txt" };
		EasyAccept.main(args);
	}

}
