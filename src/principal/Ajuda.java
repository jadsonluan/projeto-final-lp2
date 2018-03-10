package principal;

import java.io.Serializable;

/**
 * Representa um pedido de ajuda.
 *
 * @author Arthur de Lima Ferrao - 117110318
 */
public abstract class Ajuda implements Serializable {
	private int id;
	private String matrAluno;
	private String matrTutor;
	private String disciplina;
	private boolean avaliada;

	/**
	 * Constroi um pedido de ajuda
	 * 
	 * @param id
	 *            o idendificador do pedido de ajuda
	 * @param matrAluno
	 *            a matricula do aluno que pede ajuda
	 * @param matrTutor
	 *            a matricula do tutor
	 * @param disciplina
	 *            a disciplina que precisa de ajuda
	 */
	public Ajuda(int id, String matrAluno, String matrTutor, String disciplina) {
		verificaDados(id, matrAluno, matrTutor, disciplina);
		this.id = id;
		this.matrAluno = matrAluno;
		this.matrTutor = matrTutor;
		this.disciplina = disciplina;
		this.avaliada = false;
	}

	private void verificaDados(int id, String matrAluno, String matrTutor, String disciplina) {
		if (id < 0) {
			throw new IllegalArgumentException("id nao pode menor que zero ");
		}

		if (matrAluno == null || matrAluno.trim().equals("")) {
			throw new IllegalArgumentException("matricula de aluno nao pode ser vazio ou em branco");
		}

		if (matrTutor == null || matrTutor.trim().equals("")) {
			throw new IllegalArgumentException("matricula de tutor nao pode ser vazio ou em branco");
		}

		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException("disciplina nao pode ser vazio ou em branco");
		}
	}

	/**
	 * Pega a valor do atributo desejado
	 * 
	 * @param atributo
	 *            o atributo que quer o valor
	 * @return retorna o valor do atributo
	 */
	public String getInfo(String atributo) {
		if (atributo == null || atributo.trim().equals("")) {
			throw new IllegalArgumentException("atributo nao pode ser vazio ou em branco");
		}

		String valor = null;

		if (atributo.equals("matrAluno")) {
			valor = this.matrAluno;
		} else if (atributo.equals("matrTutor")) {
			valor = this.matrTutor;
		} else if (atributo.equals("disciplina")) {
			valor = this.disciplina;
		}

		return valor;
	}

	/**
	 * Pega a representacao do tutor no formato "matriculaTutor, disciplina:
	 * disciplina"
	 * 
	 * @return retorna a representacao do tutor
	 */
	public String pegarTutor() {
		String representacao = matrTutor;
		representacao += ", disciplina - " + disciplina;
		return representacao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ajuda other = (Ajuda) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * Pega a matricula do tutor
	 * 
	 * @return matricula do tutor
	 */
	public String getTutor() {
		return this.matrTutor;
	}

	/**
	 * Retorna um valor boolean para se foi avalido ou nao
	 * 
	 * @return avaliado - true se sim, false se nao
	 */
	public boolean foiAvaliada() {
		return this.avaliada;
	}

	/**
	 * Troca o valor de avaliado para true
	 */
	public void avalia() {
		this.avaliada = true;
	}

	/**
	 * Pega o nome da disciplina
	 * 
	 * @return nome da disciplina
	 */
	public String getDisciplina() {
		return disciplina;
	}
}
