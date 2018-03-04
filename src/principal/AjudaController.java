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
		this.listaAjuda.put(id,
				new AjudaPresencial(id, matrAluno, matrTutor, disciplina, horario, dia, localInteresse));
		return id;
	}

	public int pedirAjudaOnline(String matrAluno, String matrTutor, String disciplina) {
		int id = this.listaAjuda.values().size() + 1;
		this.listaAjuda.put(id, new AjudaOnline(id, matrAluno, matrTutor, disciplina));
		return id;
	}

	public String pegarTutor(int idAjuda) {
		return this.listaAjuda.get(idAjuda).getTutor();
	}

	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.listaAjuda.get(idAjuda).getInfo(atributo);
	}

}
