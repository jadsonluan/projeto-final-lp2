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
	 * Constrói um aluno (com telefone).
	 * 
	 * @param matricula
	 *            matrícula do aluno
	 * @param nome
	 *            nome do aluno
	 * @param email
	 *            e-mail do aluno
	 * @param codigoCurso
	 *            código do curso do aluno
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
	 * Constrói um aluno. (sem telefone)
	 * 
	 * @param matricula
	 *            matrícula do aluno
	 * @param nome
	 *            nome do aluno
	 * @param email
	 *            e-mail do aluno
	 * @param codigoCurso
	 *            código do curso do aluno
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
	 * Verifica se o aluno é um tutor
	 * 
	 * @return true: é tutor. false: não é tutor
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
	 * Retorna o código do curso do aluno
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
	 * Representação textual de um aluno.<br>
	 * O formato da representação do aluno é:<br>
	 * “Matricula - Nome - CódigoCurso - telefone - email” <br>
	 * Caso não tenha telefone, a impressão do aluno deve ter o formato:<br>
	 * “Matricula - Nome - CódigoCurso - email”
	 */
	public String toString() {
		String repr = matricula;
		repr += " " + nome;
		repr += " " + codigoCurso;

		if (telefone != null)
			repr += " " + telefone;

		repr += " " + email;
		return repr;
	}

	@Override
	/**
	 * Compara esse aluno com outro, baseado em seus nomes.
	 */
	public int compareTo(Aluno other) {
		return this.nome.compareTo(other.nome);
	}
}
