package principal;

import java.util.HashMap;
import java.util.Map;

public class AjudaController {
	private Map<Integer, Ajuda> listaAjuda;

	public AjudaController() {
		this.listaAjuda = new HashMap<>();
	}

	public int pedirAjudaPresencial(String matrAluno, String matrTutor, String disciplina, String horario, String dia,
			String localInteresse) {
		int id = this.listaAjuda.values().size() + 1;
		Ajuda ajuda = new AjudaPresencial(id, matrAluno, matrTutor, disciplina, horario, dia, localInteresse);
		this.listaAjuda.put(id, ajuda);
		return id;
	}

	public int pedirAjudaOnline(String matrAluno, String matrTutor, String disciplina) {
		int id = this.listaAjuda.values().size() + 1;
		Ajuda ajuda = new AjudaOnline(id, matrAluno, matrTutor, disciplina);
		this.listaAjuda.put(id, ajuda);
		return id;
	}

	public String pegarTutor(int idAjuda) {
		verificaAjuda(idAjuda);
		Ajuda ajuda = this.listaAjuda.get(idAjuda);
		String representacao = ajuda.pegarTutor();
		return representacao;
	}
	
	public void avalia(int idAjuda) {
		verificaAjuda(idAjuda);
		Ajuda ajuda = this.listaAjuda.get(idAjuda);
		
		if (ajuda.foiAvaliada()) {
			throw new IllegalArgumentException("Ajuda ja avaliada");
		}
		
		ajuda.avalia();
	}

	public String getMatriculaTutor(int idAjuda) {
		verificaAjuda(idAjuda);
		Ajuda ajuda = this.listaAjuda.get(idAjuda);
		String tutor = ajuda.getTutor();
		return tutor;
	}

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
}
