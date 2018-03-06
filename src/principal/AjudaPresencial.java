package principal;

public class AjudaPresencial extends Ajuda {
	private String local;
	private String dia;
	private String hora;

	public AjudaPresencial(int id, String matrAluno, String matrTutor, String disciplina, String horario, String dia,
			String localInteresse) {
		super(id, matrAluno, matrTutor, disciplina);
		verificacoes(horario, dia, localInteresse);
		this.local = localInteresse;
		this.dia = dia;
		this.hora = horario;
	}

	private void verificacoes(String horario, String dia, String local) {
		if (horario == null || horario.trim().equals("")) {
			throw new IllegalArgumentException("horario nao pode ser vazio ou em branco");
		}
		
		if (dia == null || dia.trim().equals("")) {
			throw new IllegalArgumentException("dia nao pode ser vazio ou em branco");
		}
		
		if (local == null || local.trim().equals("")) {
			throw new IllegalArgumentException("local de atendimento nao pode ser vazio ou em branco");
		}
	}

	@Override
	public String getInfo(String atributo) {
		String valor = null;
		valor = super.getInfo(atributo);
		if (valor == null) {
			if (atributo.equals("localInteresse")) {
				valor = this.local;
			} else if (atributo.equals("dia")) {
				valor = this.dia;
			} else if (atributo.equals("horario")) {
				valor = this.hora;
			} else {
				throw new IllegalArgumentException("atributo nao encontrado");
			}
		}

		return valor;
	}

	@Override
	public String pegarTutor() {
		String representacao = super.getInfo("matrTutor");
		representacao += ", horario - " + hora;
		representacao += ", dia - " + dia;
		representacao += ", local - " + local;
		representacao += ", disciplina - " + super.getInfo("disciplina");
		return representacao;
	}

}
