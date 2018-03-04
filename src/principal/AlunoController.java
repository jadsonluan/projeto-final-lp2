package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AlunoController {
	private Map<String, Aluno> alunos;

	/**
	 * Cria uma objeto Sistema
	 */
	public AlunoController() {
		this.alunos = new HashMap<String, Aluno>();
	}
	
	public Aluno getAluno(String matricula){
		if (!this.alunos.containsKey(matricula)) {
			throw new NullPointerException("Erro na definicao de papel: Tutor nao encontrado");
		}
		
		return this.alunos.get(matricula);
	}
	
	private void verificaAluno(String matricula) {
		if (!alunos.containsKey(matricula)) {
			throw new NullPointerException("Aluno nao encontrado");
		}
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
		try {
			verificaEmailCadastroAluno(email);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: " + iae.getMessage());
		}
		
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
		try {
			verificaAluno(matricula);
		} catch (NullPointerException npe) {
			throw new NullPointerException("Erro na busca por aluno: " + npe.getMessage());
		}
		
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
		try {
			verificaAluno(matricula);
		} catch (NullPointerException npe) {
			throw new NullPointerException("Erro na obtencao de informacao de aluno: " + npe.getMessage());
		}
		
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

}
