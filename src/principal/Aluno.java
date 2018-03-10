package principal;

import java.io.Serializable;

/**
 * Representa um aluno.
 *
 * @author Jadson Luan Soares da Silva, 117110391
 */
public class Aluno implements Comparable<Aluno>, Serializable {
	private String matricula;
	private String nome;
	private String email;
	private int codigoCurso;
	private String telefone;

	/**
	 * Constroi um aluno (com telefone).
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * @param nome
	 *            nome do aluno
	 * @param email
	 *            e-mail do aluno
	 * @param codigoCurso
	 *            codigo do curso do aluno
	 * @param telefone
	 *            telefone do aluno
	 */
	public Aluno(String matricula, String nome, String email, int codigoCurso, String telefone) {
		try {
			verificaEmailCadastroAluno(email);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(iae.getMessage());
		}
		if (matricula == null || matricula.trim().equals("")) {
			throw new IllegalArgumentException("Matricula nao pode ser vazia ou nula");
		}		
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome nao pode ser vazio ou nulo");
		}
		if(telefone != null && telefone.trim().equals("")) {
			throw new IllegalArgumentException("Telefone nao pode ser vazio");
		}
		if(codigoCurso < 0) {
			throw new IllegalArgumentException("Codigo do curso nao pode ser negativo");
		}
		
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
	}

	/**
	 * Constroi um aluno. (sem telefone)
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * @param nome
	 *            nome do aluno
	 * @param email
	 *            e-mail do aluno
	 * @param codigoCurso
	 *            codigo do curso do aluno
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
	 * Retorna o codigo do curso do aluno
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
	 * Representacao textual de um aluno.<br>
	 * O formato da representacao do aluno eh:<br>
	 * Matricula - Nome - CodigoCurso - telefone - email <br>
	 * Caso nao tenha telefone, a impressao do aluno deve ter o formato:<br>
	 * Matricula - Nome - CodigoCurso - email
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
	/**
	 * Metodo que retorna a matricula do aluno
	 * @return String matricula do aluno
	 */
	public String getMatricula() {
		return matricula;
	}
	
	private void verificaEmailCadastroAluno(String email) {
		String inicioEmail = String.valueOf(email.charAt(0));
		String fimEmail = String.valueOf(email.charAt(email.length() - 1));
		
		if (inicioEmail.equals("@") || fimEmail.equals("@")) {
			throw new IllegalArgumentException("Email invalido");
		}

		boolean temArroba = false;
		
		for (int i = 0; i < email.length(); i++) {
			if (String.valueOf(email.charAt(i)).equals("@")) {
				temArroba = true;
			}
		}

		if (!temArroba) {
			throw new IllegalArgumentException("Email invalido");
		}
	}
}