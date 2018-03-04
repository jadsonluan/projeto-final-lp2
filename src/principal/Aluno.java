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

	@Override
	/**
	 * Compara esse aluno com outro, baseado em seus nomes.
	 */
	public int compareTo(Aluno other) {
		return this.nome.compareTo(other.nome);
	}

	public String getMatricula() {
		return matricula;
	}
}