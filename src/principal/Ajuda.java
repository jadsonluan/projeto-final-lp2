package principal;

import java.io.Serializable;

public abstract class Ajuda implements Serializable{
	private int id;
	private String matrAluno;
	private String matrTutor;
	private String disciplina;
	private boolean avaliada;

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

	public String pegarTutor() {
		String representacao = matrTutor;
		representacao += ", disciplina - " + disciplina;
		return representacao;
	}

	public String getTutor() {
		return this.matrTutor;
	}
	
	public boolean foiAvaliada() {
		return this.avaliada;
	}
	
	public void avalia() {
		this.avaliada = true;
	}

	public String getDisciplina() {
		return disciplina;
	}
}
