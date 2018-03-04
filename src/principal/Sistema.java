package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/**
 * Controla as informaÃ§Ãµes de aluno
 * 
 * @author Arthur de Lima FerrÃ£o - 117110318
 */
public class Sistema {
	private AlunoController alunoController;
	private TutorController tutorController;
	private AjudaController ajudaController;

	/**
	 * Cria uma objeto Sistema
	 */
	public Sistema() {
		this.alunoController = new AlunoController();
		this.tutorController = new TutorController();
		this.ajudaController = new AjudaController();
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
		this.alunoController.cadastrarAluno(nome, matricula, codigoCurso,
				telefone, email);
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
		return this.alunoController.recuperaAluno(matricula);
	}

	/**
	 * Lista todos os alunos cadastrados
	 * 
	 * @return retorna a lista com as representaÃ§Ã£o em String dos alunos
	 */
	public String listarAlunos() {
		return this.alunoController.listarAlunos();
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
		return this.alunoController.getInfoAluno(matricula, atributo);
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
		Aluno aluno = alunoController.getAluno(matricula);
		this.tutorController.tornarTutor(matricula, aluno, disciplina,
				proficiencia);
	}

	/**
	 * Recupera um tutor pela matricula
	 * 
	 * @param matricula
	 *            a matricula do tutor
	 * @return retorna a
	 */
	public String recuperaTutor(String matricula) {
		return this.tutorController.recuperaTutor(matricula);
	}

	/**
	 * Lista todos os tutores cadastrados no sistema
	 * 
	 * @return retorna a representaÃ§Ã£o em String do tutor
	 */
	public String listarTutores() {
		return this.tutorController.listarTutores();
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
		this.tutorController.cadastrarHorario(email, horario, dia);
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
		this.tutorController.cadastrarLocalDeAtendimento(email, local);
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
		return this.tutorController.consultaHorario(email, horario, dia);
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
		return this.tutorController.consultaLocal(email, local);
	}

	/**
	 * Pega a nota de um tutor especifico, a partir de sua matricula
	 * 
	 * @param matriculaTutor
	 *            matricula do tutor que deseja-se consultar
	 * @return double nota do tutor especificado
	 */
	public double pegarNota(String matriculaTutor) {
		return this.tutorController.pegarNota(matriculaTutor);
	}

	/**
	 * Pega o nivel de um tutor especifico, a partir de sua matricula
	 * 
	 * @param matriculaTutor
	 *            matricula do tutor que deseja-se consultar
	 * @return String nivel do tutor especificado
	 */
	public String pegarNivel(String matriculaTutor) {
		return this.tutorController.pegarNivel(matriculaTutor);
	}


	public int pedirAjudaPresencial(String matrAluno, String disciplina,String horario, String dia, String localInteresse) {
		String matrTutor = this.tutorController.getTutorAjuda(disciplina, horario, dia, localInteresse);
		return this.ajudaController.pedirAjudaPresencial(matrAluno, matrTutor,disciplina, horario, dia, localInteresse);
	}

	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		String matrTutor = this.tutorController.getTutorAjuda(disciplina);
		return this.ajudaController.pedirAjudaOnline(matrAluno, matrTutor,disciplina);
	}

	public String pegarTutor(int idAjuda) {
		String matricula = this.ajudaController.pegarTutor(idAjuda);
		return this.tutorController.recuperaTutor(matricula);
	}

	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.ajudaController.getInfoAjuda(idAjuda, atributo);
	}

}
