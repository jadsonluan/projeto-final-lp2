package principal;

import java.util.*;

/**
 * Classe que representa a posição de tutoria exercida por um aluno
 * 
 * @author Mateus Augusto Souza Santos
 */
public class Tutoria {
	HashMap<String, Integer> disciplinas;
	double avaliacao;
	HashSet<String> locais;
	HashMap<String, ArrayList<String>> horarios;
	int dinheiro;

	/**
	 * Construtor de uma tutoria
	 */
	public Tutoria() {
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
		if ((proficiencia > 5) || (proficiencia < 1)) {
			throw new IllegalArgumentException("Erro: Proficiência inválida. (1-5)");

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
					return false;
				}
			}
			return true;
		}
		throw new NoSuchElementException("Erro: Dia especificado não foi cadastrado.");
	}

	/**
	 * Consulta se o tutor estará em um local específico
	 * 
	 * @param local
	 *            é o local que deseja-se consultar
	 * @return retorna o boolean true se o local estiver ocupado. Retorna false se
	 *         estiver livre.
	 */
	public boolean consultaLocal(String local) {
		if (locais.contains(local)) {
			return true;
		}
		return false;
	}

}