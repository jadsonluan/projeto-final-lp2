package principal;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe de controle de ajuda.
 * 
 * @author Arthur de Lima Ferrao - 117110318
 */
public class AjudaController {
	private Map<Integer, Ajuda> listaAjuda;
	private Persistencia persistencia;

	/**
	 * Cria objeto AjudaController
	 */
	public AjudaController() {
		this.listaAjuda = new HashMap<>();
		this.persistencia = new Persistencia();
	}

	/**
	 * Cadastra um pedido de ajuda presencial
	 * 
	 * @param matrAluno
	 *            a matricula do aluno que pede ajuda
	 * @param matrTutor
	 *            a matricula do tutor
	 * @param disciplina
	 *            a disciplina que precisa de ajuda
	 * @param horario
	 *            o horario que deseja ser atendido
	 * @param dia
	 *            o dia que deseja ser atendido
	 * @param localInteresse
	 *            o lacal que deseja
	 */
	public int pedirAjudaPresencial(String matrAluno, String matrTutor,
			String disciplina, String horario, String dia, String localInteresse) {
		int id = this.listaAjuda.values().size() + 1;
		Ajuda ajuda = new AjudaPresencial(id, matrAluno, matrTutor, disciplina,
				horario, dia, localInteresse);
		this.listaAjuda.put(id, ajuda);
		return id;
	}

	/**
	 * Cadastra um pedido de ajuda online
	 * 
	 * @param matrAluno
	 *            a matricula do aluno que pede ajuda
	 * @param matrTutor
	 *            a matricula do tutor
	 * @param disciplina
	 *            a disciplina que precisa de ajuda
	 */
	public int pedirAjudaOnline(String matrAluno, String matrTutor,
			String disciplina) {
		int id = this.listaAjuda.values().size() + 1;
		Ajuda ajuda = new AjudaOnline(id, matrAluno, matrTutor, disciplina);
		this.listaAjuda.put(id, ajuda);
		return id;
	}

	/**
	 * Pega o tutor cadastrado no pedido de ajuda
	 * 
	 * @param idAjuda
	 *            o id do pedido de ajuda
	 * @return representacao do tutor
	 */
	public String pegarTutor(int idAjuda) {
		verificaAjuda(idAjuda);
		Ajuda ajuda = this.listaAjuda.get(idAjuda);
		String representacao = ajuda.pegarTutor();
		return representacao;
	}

	/**
	 * Troca o valor de avaliado para true
	 * 
	 * @param idAjuda
	 *            o id do pedido de ajuda
	 */
	public void avalia(int idAjuda) {
		verificaAjuda(idAjuda);
		Ajuda ajuda = this.listaAjuda.get(idAjuda);

		if (ajuda.foiAvaliada()) {
			throw new IllegalArgumentException("Ajuda ja avaliada");
		}

		ajuda.avalia();
	}

	/**
	 * Pega a matricula do tutor cadastrado na ajuda
	 * 
	 * @param idAjuda
	 *            o id do pedido de ajuda
	 * @return a matricula do tutor
	 */
	public String getMatriculaTutor(int idAjuda) {
		verificaAjuda(idAjuda);
		Ajuda ajuda = this.listaAjuda.get(idAjuda);
		String tutor = ajuda.getTutor();
		return tutor;
	}

	/**
	 * Pega a valor do atributo desejado
	 * 
	 * @param atributo
	 *            o atributo que quer o valor
	 * @param idAjuda
	 *            o id da ajuda
	 * @return retorna o valor do atributo
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		verificaAjuda(idAjuda);
		Ajuda ajuda = this.listaAjuda.get(idAjuda);
		String informacao = ajuda.getInfo(atributo);
		return informacao;
	}

	private void verificaAjuda(int idAjuda) {
		if (idAjuda < 0) {
			throw new IllegalArgumentException("id nao pode menor que zero ");
		}

		if (!listaAjuda.containsKey(idAjuda)) {
			throw new IllegalArgumentException("id nao encontrado ");
		}
	}

	/**
	 * 
	 */
	public void salvar() {
		this.persistencia.salvar(this.listaAjuda, "ajudaMap");
	}
}
