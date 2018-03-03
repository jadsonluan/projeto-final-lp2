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
	private Map<String, Aluno> alunos;
	private Map<String, Tutor> tutores;

	/**
	 * Cria uma objeto Sistema
	 */
	public Sistema() {
		this.alunos = new HashMap<String, Aluno>();
		this.tutores = new HashMap<String, Tutor>();
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
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		verificaEmailCadastroAluno(email, "Erro no cadastro de aluno: ");
		if (alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		if (telefone.trim().equals("")) {
			this.alunos.put(matricula, new Aluno(matricula, nome, email, codigoCurso));
		} else {
			this.alunos.put(matricula, new Aluno(matricula, nome, email, codigoCurso, telefone));
		}
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
		verificaAluno(matricula, "Erro na busca por aluno: ");
		return this.alunos.get(matricula).toString();
	}

	/**
	 * Lista todos os alunos cadastrados
	 * 
	 * @return retorna a lista com as representaÃ§Ã£o em String dos alunos
	 */
	public String listarAlunos() {
		ArrayList<Aluno> listAlunos = new ArrayList<>();
		for (Aluno a : alunos.values()) {
			listAlunos.add(a);
		}
		Collections.sort(listAlunos);
		String listaAlunos = "";
		for (int i = 0; i < listAlunos.size(); i++) {
			listaAlunos += listAlunos.get(i).toString();
			if (i != listAlunos.size() - 1) {
				listaAlunos += ", ";
			}
		}
		return listaAlunos;
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
		verificaAluno(matricula, "Erro na obtencao de informacao de aluno: ");
		if (atributo.equals("Nome")) {
			return this.alunos.get(matricula).getNome();
		} else if (atributo.equals("Email")) {
			return this.alunos.get(matricula).getEmail();
		} else if (atributo.equals("CodigoCurso")) {
			return this.alunos.get(matricula).getCodigoCurso() + "";
		} else if (atributo.equals("Telefone")) {
			return this.alunos.get(matricula).getTelefone();
		}
		return null;
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
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		if (!this.alunos.containsKey(matricula)) {
			throw new NullPointerException("Erro na definicao de papel: Tutor nao encontrado");
		}

		if (this.tutores.containsKey(matricula)) {
			Tutor tutor = this.tutores.get(matricula);
			tutor.cadastrarDisciplina(disciplina, proficiencia);
		} else {
			Aluno aluno = this.alunos.get(matricula);
			Tutor tutor = new Tutor(aluno);
			tutor.cadastrarDisciplina(disciplina, proficiencia);
			tutores.put(matricula, tutor);
		}
	}

	/**
	 * Recupera um tutor pela matricula
	 * 
	 * @param matricula
	 *            a matricula do tutor
	 * @return retorna a
	 */
	public String recuperaTutor(String matricula) {
		if (!this.tutores.containsKey(matricula)) {
			throw new NullPointerException("Erro na busca por tutor: Tutor nao encontrado");
		}
		return this.tutores.get(matricula).getAluno().toString();
	}

	/**
	 * Lista todos os tutores cadastrados no sistema
	 * 
	 * @return retorna a representaÃ§Ã£o em String do tutor
	 */
	public String listarTutores() {
		List<String> listaTutores = new ArrayList<>();

		for (Tutor tutor : this.tutores.values()) {
			listaTutores.add(tutor.getAluno().toString());
		}

		return String.join(", ", listaTutores);
	}

	private Tutor recuperaTutorPorEmail(String email, String msg) {
		for (Tutor tutor : this.tutores.values()) {
			if (tutor.getAluno().getEmail().equals(email)) {
				return tutor;
			}
		}

		throw new NullPointerException(msg + "tutor nao cadastrado");
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
		verificaEmail(email, "Erro no cadastrar horario: ");
		if (horario.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		if (dia.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		this.recuperaTutorPorEmail(email, "Erro no cadastrar horario: ").cadastrarHorario(horario, dia);
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
		verificaEmail(email, "Erro no cadastrar local de atendimento: ");
		if (local.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		this.recuperaTutorPorEmail(email, "Erro no cadastrar local de atendimento: ")
				.cadastrarLocalDeAtendimento(local);
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
	 * @return retorna um valor boolean, true represetando que existe e false que
	 *         nao
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.recuperaTutorPorEmail(email, "Erro ao consultar horario de atendimento: ").consultaHorario(horario,
				dia);
	}

	/**
	 * Consulta se o local existe para o tutor
	 * 
	 * @param email
	 *            o email do tutor
	 * @param local
	 *            o local para ser consultado
	 * @return retorna um valor boolean, true represetando que existe e false que
	 *         nao
	 */
	public boolean consultaLocal(String email, String local) {
		return this.recuperaTutorPorEmail(email, "Erro ao consultar local de atendimento: ").consultaLocal(local);
	}

	private void verificaAluno(String matricula, String msg) {
		if (!alunos.containsKey(matricula)) {
			throw new NullPointerException(msg + "Aluno nao encontrado");
		}
	}

	private void verificaEmail(String email, String msg) {
		if (email.trim().equals("")) {
			throw new IllegalArgumentException(msg + "email nao pode ser vazio ou em branco");
		}
	}

	private void verificaEmailCadastroAluno(String email, String msg) {
		String inicioEmail = String.valueOf(email.charAt(0));
		String fimEmail = String.valueOf(email.charAt(email.length() - 1));
		if (inicioEmail.equals("@") || fimEmail.equals("@")) {
			throw new IllegalArgumentException(msg + "Email invalido");
		}

		boolean temArroba = false;
		for (int i = 0; i < email.length(); i++) {
			if (String.valueOf(email.charAt(i)).equals("@")) {
				temArroba = true;
			}
		}

		if (!temArroba) {
			throw new IllegalArgumentException(msg + "Email invalido");
		}
	}
	/**
	 * Pega a nota de um tutor especifico, a partir de sua matricula
	 * @param matriculaTutor matricula do tutor que deseja-se consultar
	 * @return double nota do tutor especificado
	 */
	public double pegarNota(String matriculaTutor) {
		if (tutores.containsKey(matriculaTutor)) {
			return tutores.get(matriculaTutor).getNota();
		}
		throw new IllegalArgumentException("Erro: Matricula invalida");
	}
	/**
	 * Pega o nivel de um tutor especifico, a partir de sua matricula
	 * @param matriculaTutor matricula do tutor que deseja-se consultar
	 * @return String nivel do tutor especificado
	 */
	public String pegarNivel(String matriculaTutor) {
		if (tutores.containsKey(matriculaTutor)) {
			return tutores.get(matriculaTutor).getNivel();
		}
		throw new IllegalArgumentException("Erro: Matricula invalida");
	}
	
}
