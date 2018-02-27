package principal;

/**
 * Representa um aluno.
 *
 * @author Jadson Luan Soares da Silva, 117110391
 */
public class Aluno implements Comparable<Aluno> {
	private String matricula;
	private String nome;
	private String email;
	private int codigoCurso;
	private String telefone;
	private Tutoria tutoria;

	/**
	 * ConstrÃ³i um aluno (com telefone).
	 * 
	 * @param matricula
	 *            matrÃ­cula do aluno
	 * @param nome
	 *            nome do aluno
	 * @param email
	 *            e-mail do aluno
	 * @param codigoCurso
	 *            cÃ³digo do curso do aluno
	 * @param telefone
	 *            telefone do aluno
	 */
	public Aluno(String matricula, String nome, String email, int codigoCurso, String telefone) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
	}

	/**
	 * ConstrÃ³i um aluno. (sem telefone)
	 * 
	 * @param matricula
	 *            matrÃ­cula do aluno
	 * @param nome
	 *            nome do aluno
	 * @param email
	 *            e-mail do aluno
	 * @param codigoCurso
	 *            cÃ³digo do curso do aluno
	 * @param telefone
	 *            telefone do aluno
	 */
	public Aluno(String matricula, String nome, String email, int codigoCurso) {
		this(matricula, nome, email, codigoCurso, null);
	}

	/**
	 * Torna o aluno tutor de uma disciplina
	 * 
	 * @param disciplina
	 *            disciplina da tutoria
	 * @param proficiencia
	 *            proficiencia na disciplina (1-5)
	 */
	public void tornaTutor(String disciplina, int proficiencia) {
		if (tutoria == null)
			tutoria = new Tutoria();

		tutoria.cadastrarDisciplina(disciplina, proficiencia);
	}

	/**
	 * Verifica se o aluno Ã© um tutor
	 * 
	 * @return true: Ã© tutor. false: nÃ£o Ã© tutor
	 */
	public boolean ehTutor() {
		return tutoria != null;
	}

	/**
	 * Retorna o nome do aluno.
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o e-mail do aluno
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Retorna o cÃ³digo do curso do aluno
	 * 
	 * @return codigoCurso
	 */
	public int getCodigoCurso() {
		return codigoCurso;
	}

	/**
	 * Retorna o telefone do aluno
	 * 
	 * @return telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	@Override
	/**
	 * RepresentaÃ§Ã£o textual de um aluno.<br>
	 * O formato da representaÃ§Ã£o do aluno Ã©:<br>
	 * â€œMatricula - Nome - CÃ³digoCurso - telefone - emailâ€� <br>
	 * Caso nÃ£o tenha telefone, a impressÃ£o do aluno deve ter o formato:<br>
	 * â€œMatricula - Nome - CÃ³digoCurso - emailâ€�
	 */
	public String toString() {
		String repr = matricula;
		repr += " - " + nome;
		repr += " - " + codigoCurso;

		if (telefone != null)
			repr += " - " + telefone;
		
		
		repr += " - " + email;
		return repr;
	}

	/**
	 * Cadastra um horÃ¡rio dentro de um dia especÃ­fico.
	 * 
	 * @param hora
	 *            Ã© a hora que deseja-se cadastrar
	 * @param dia
	 *            Ã© o dia que deseja-se cadastrar a hora
	 */
	public void cadastrarHorario(String hora, String dia) {
		if (tutoria != null) {
			tutoria.cadastrarHorario(hora, dia);
		}
	}

	/**
	 * Cadastra um novo local de atendimento do tutor
	 * 
	 * @param local
	 *            Ã© o local de atendimento a ser cadastrado.
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		if (tutoria != null) {
			tutoria.cadastrarLocalDeAtendimento(local);
		}
	}

	/**
	 * Consulta se o horario do tutor estÃ¡ livre ou ocupado.
	 * 
	 * @param hora
	 *            Ã© a hora que deseja-se consultar
	 * @param dia
	 *            Ã© o dia que deseja-se consultar
	 * @return retorna boolean true se o horÃ¡rio estiver livre. Retorna false se
	 *         nÃ£o.
	 */
	public boolean consultaHorario(String hora, String dia) {
		if (tutoria != null) {
			return tutoria.consultaHorario(hora, dia);
		}
		return false;
	}

	/**
	 * Consulta se o tutor estarÃ¡ em um local especÃ­fico
	 * 
	 * @param local
	 *            Ã© o local que deseja-se consultar
	 * @return retorna o boolean true se o local estiver ocupado. Retorna false se
	 *         estiver livre.
	 */
	public boolean consultaLocal(String local) {
		if (tutoria != null) {
			return tutoria.consultaLocal(local);
		}
		return false;
	}

	@Override
	/**
	 * Compara esse aluno com outro, baseado em seus nomes.
	 */
	public int compareTo(Aluno other) {
		return this.nome.compareTo(other.nome);
	}
}
