package principal;

import java.util.*;

/**
 * Classe que representa a posição de tutoria exercida por um aluno
 * 
 * @author Mateus Augusto Souza Santos
 */
public class Tutor {
	private Map<String, Integer> disciplinas;
	private double avaliacao;
	private Set<String> locais;
	private Map<String, ArrayList<String>> horarios;
	private int dinheiro;
	private Aluno aluno;

	/**
	 * Construtor de uma tutoria
	 */
	public Tutor(Aluno aluno) {
		this.aluno = aluno;
		this.disciplinas = new HashMap<String, Integer>();
		this.avaliacao = 4;
		this.locais = new HashSet<String>();
		this.horarios = new HashMap<String, ArrayList<String>>();
		this.dinheiro = 0;
	}

	/**
	 * Cadastra uma nova disciplina para o tutor, incluindo sua proficiência na
	 * mesma.
	 * 
	 * @param disciplina
	 *            é a nova disciplina cadastrada
	 * @param proficiencia
	 *            é a proficiencia do tutor nessa disciplina
	 */
	public void cadastrarDisciplina(String disciplina, int proficiencia) {
		if (this.disciplinas.containsKey(disciplina)) {
			throw new IllegalArgumentException(
					"Erro na definicao de papel: Ja eh tutor dessa disciplina");
		}
		if ((proficiencia > 5) || (proficiencia < 1)) {
			throw new IllegalArgumentException(
					"Erro na definicao de papel: Proficiencia invalida");

		}
		this.disciplinas.put(disciplina, proficiencia);
	}

	/**
	 * Cadastra um horário dentro de um dia específico.
	 * 
	 * @param hora
	 *            é a hora que deseja-se cadastrar
	 * @param dia
	 *            é o dia que deseja-se cadastrar a hora
	 */
	public void cadastrarHorario(String hora, String dia) {
		ArrayList<String> horarios = this.horarios.get(dia);

		if (horarios == null) {
			horarios = new ArrayList<String>();
			horarios.add(hora);
			this.horarios.put(dia, horarios);
		} else {
			if (!horarios.contains(hora))
				horarios.add(hora);
		}
	}

	/**
	 * Cadastra um novo local de atendimento do tutor
	 * 
	 * @param local
	 *            é o local de atendimento a ser cadastrado.
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		this.locais.add(local);

	}

	/**
	 * Consulta se o horario do tutor está livre ou ocupado.
	 * 
	 * @param hora
	 *            é a hora que deseja-se consultar
	 * @param dia
	 *            é o dia que deseja-se consultar
	 * @return retorna boolean true se o horário estiver livre. Retorna false se
	 *         não.
	 */
	public boolean consultaHorario(String hora, String dia) {
		if (this.horarios.containsKey(dia)) {
			for (String horario : this.horarios.get(dia)) {
				if (horario.equals(hora)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Consulta se o tutor estará em um local específico
	 * 
	 * @param local
	 *            é o local que deseja-se consultar
	 * @return retorna o boolean true se o local estiver ocupado. Retorna false
	 *         se estiver livre.
	 */
	public boolean consultaLocal(String local) {
		return locais.contains(local);
	}

	public boolean consultaDisciplina(String disciplina) {
		return this.disciplinas.containsKey(disciplina);
	}

	/**
	 * Retorna o aluno com a funçao de tutor
	 * 
	 * @return Objeto Aluno
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * Metodo que avalia o tutor atraves de uma nota dada.
	 * 
	 * @param nota
	 *            inteiro da nota que sera utilizada para avaliar o tutor
	 * @return retorna a nota do tutor apos a avaliacao
	 */
	public String avaliacaoTutor(int nota) {
		if ((nota > 5) || (nota < 0)) {
			throw new IllegalArgumentException("Erro: Nota inválida.");
		}
		this.avaliacao = ((this.avaliacao * 5 + nota) / 6);
		return (String.valueOf(this.avaliacao));
	}

	/**
	 * Retorna a nota do Tutor
	 * 
	 * @return int nota do tutor
	 */
	public double getNota() {
		return this.avaliacao;
	}

	/**
	 * Metodo que retorna o nivel do Tutor.
	 * 
	 * @return String "TOP" se o nivel for acima de 4.5; "Tutor" se for entre
	 *         4.5 e 3; "Aprendiz" se for menor que 3"
	 */
	public String getNivel() {

		if (this.avaliacao > 4.5) {
			return "TOP";
		} else if ((this.avaliacao <= 4.5) && (this.avaliacao > 3)) {
			return "Tutor";
		} else {
			return "Aprendiz";
		}
	}

}