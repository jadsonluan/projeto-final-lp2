package principal;

import java.text.DecimalFormat;

/**
 * Controla as informaÃ§Ãµes de aluno
 * 
 * @author Arthur de Lima FerrÃ£o - 117110318
 */
public class Sistema {
	private AlunoController alunoController;
	private TutorController tutorController;
	private AjudaController ajudaController;
	private Caixa caixa;

	/**
	 * Cria uma objeto Sistema
	 */
	public Sistema() {
		this.alunoController = new AlunoController();
		this.tutorController = new TutorController();
		this.ajudaController = new AjudaController();
		this.caixa = new Caixa();
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
		this.alunoController.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
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
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		Aluno aluno = alunoController.getAluno(matricula);
		this.tutorController.tornarTutor(matricula, aluno, disciplina, proficiencia);
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
		try {
			this.tutorController.cadastrarHorario(email, horario, dia);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro no cadastrar horario: " + iae.getMessage());
		}
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
		try {
			this.tutorController.cadastrarLocalDeAtendimento(email, local);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: " + iae.getMessage());
		}
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
		try {
			return this.tutorController.consultaHorario(email, horario, dia);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro no cadastrar horario de atendimento: " + iae.getMessage());
		}
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
		return this.tutorController.consultaLocal(email, local);
	}

	/**
	 * Pega a nota de um tutor especifico, a partir de sua matricula
	 * 
	 * @param matriculaTutor
	 *            matricula do tutor que deseja-se consultar
	 * @return double nota do tutor especificado
	 */
	public String pegarNota(String matriculaTutor) {
		DecimalFormat formatacao = new DecimalFormat("0.00");
		return formatacao.format(this.tutorController.pegarNota(matriculaTutor));
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

	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		int id = -1;

		try {
			String matrTutor = this.tutorController.getTutorAjuda(disciplina, horario, dia, localInteresse);
			id = this.ajudaController.pedirAjudaPresencial(matrAluno, matrTutor, disciplina, horario, dia,
					localInteresse);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: " + iae.getMessage());
		}

		return id;
	}

	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		int id = -1;

		try {
			String matrTutor = this.tutorController.getTutorAjuda(disciplina);
			id = this.ajudaController.pedirAjudaOnline(matrAluno, matrTutor, disciplina);
		} catch (IllegalArgumentException iae) {
			throw new IllegalAccessError("Erro no pedido de ajuda online: " + iae.getMessage());
		}

		return id;
	}

	public String pegarTutor(int idAjuda) {
		String tutor = null;

		try {
			tutor = this.ajudaController.pegarTutor(idAjuda);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : " + iae.getMessage());
		}

		return "Tutor - " + tutor;
	}

	/**
	 * Avalia um tutor a partir do seu idAjuda especifico e de uma nota escolhida
	 * pelo aluno
	 * 
	 * @param idAjuda
	 *            int com o id de ajuda do tutor
	 * @param nota
	 *            eh a nota que o aluno dara ao tutor
	 * @return String contendo a nota atual do tutor especificado
	 */
	public String avaliarTutor(int idAjuda, int nota) {
		try {
			if (nota < 0) {
				throw new IllegalArgumentException("nota nao pode ser menor que 0");
			} else if (nota > 5) {
				throw new IllegalArgumentException("nota nao pode ser maior que 5");
			}

			String matricula = this.ajudaController.getMatriculaTutor(idAjuda);
			Tutor tutor = this.tutorController.recuperaTutorPorMatricula(matricula);
			this.ajudaController.avalia(idAjuda);
			String retorno = tutor.avaliacaoTutor(nota);
			return retorno;
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: " + iae.getMessage());
		}
	}

	public String getInfoAjuda(int idAjuda, String atributo) {
		String informacao = null;

		try {
			informacao = this.ajudaController.getInfoAjuda(idAjuda, atributo);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : " + iae.getMessage());
		}

		return informacao;
	}

	/**
	 * Efetua uma doacao a um tutor especifico, este fica com uma taxa do dinheiro
	 * doado e o restante e direcionado ao caixa do sistema
	 * 
	 * @param matriculaTutor
	 *            matricula do tutor que recebera a doacao
	 * @param totalCentavos
	 *            valor doado
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		try {
			if (totalCentavos < 0) {
				throw new IllegalArgumentException("totalCentavos nao pode ser menor que zero");
			}
			
			int totalSistema = (int) (((10 - tutorController.getTaxaTutor(matriculaTutor) * 10) / 10) * totalCentavos);
			int totalTutor = totalCentavos - totalSistema;

			caixa.adicionaDinheiro(totalSistema);
			tutorController.recebeDinheiro(matriculaTutor, totalTutor);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na doacao para tutor: " + iae.getMessage());
		}
	}

	/**
	 * Retorna o dinheiro armazenado pelo sistema
	 * 
	 * @return dinheiro armazenado pelo sistema
	 */
	public int totalDinheiroSistema() {
		return this.caixa.getDinheiro();
	}

	/**
	 * Retorna o dinheiro total recebido por um tutor
	 * 
	 * @param emailTutor
	 *            email do tutor a ser verificado
	 * @return dinheiro total recebido pelo tutor
	 */
	public int totalDinheiroTutor(String emailTutor) {
		try {
			return tutorController.getDinheiroTutor(emailTutor);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na consulta de total de dinheiro do tutor: " + iae.getMessage());
		}
	}
}