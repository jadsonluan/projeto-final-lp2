package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe de controle de tutor
 * 
 * @author Arthur de Lima Ferrao - 117110318
 */
public class TutorController {

	private Map<String, Tutor> tutores;
	private Comparator<Tutor> criterioOrd;

	/**
	 * Cria uma objeto Sistema
	 */
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
	}
	/**
	 * Transforma um aluno em um tutor, atraves das informacoes do aluno
	 * @param matricula eh a matricula do aluno que se tornara tutor
	 * @param aluno eh o aluno especificado
	 * @param disciplina eh uma disciplina especificada pelo tutor para ensinar
	 * @param proficiencia eh a proficiencia do tutor na disciplina especificada
	 */
	public void tornarTutor(String matricula, Aluno aluno, String disciplina, int proficiencia) {
		if (this.tutores.containsKey(matricula)) {
			Tutor tutor = this.tutores.get(matricula);
			tutor.cadastrarDisciplina(disciplina, proficiencia);
		} else {
			Tutor tutor = new Tutor(aluno);
			tutor.cadastrarDisciplina(disciplina, proficiencia);
			tutores.put(matricula, tutor);
		}
	}

	/**
	 * Recupera um tutor pela matricula
	 * 
	 * @param matricula
	 *            a matricula do tutor
	 * @return retorna a
	 */
	public String recuperaTutor(String matricula) {
		if (!this.tutores.containsKey(matricula)) {
			throw new NullPointerException("Erro na busca por tutor: Tutor nao encontrado");
		}

		return this.tutores.get(matricula).getAluno().toString();
	}

	/**
	 * Lista todos os tutores cadastrados no sistema
	 * 
	 * @return retorna a representaÃ§Ã£o em String do tutor
	 */
	public String listarTutores() {
		List<String> listaTutores = new ArrayList<>();
		List<Tutor> tutoresOrdenados = new ArrayList<>(this.tutores.values());

		if (criterioOrd != null) {
			Collections.sort(tutoresOrdenados, criterioOrd);
		}

		for (Tutor tutor : tutoresOrdenados) {
			listaTutores.add(tutor.getAluno().toString());
		}

		return String.join(", ", listaTutores);
	}

	private Tutor recuperaTutorPorEmail(String email) {
		for (Tutor tutor : this.tutores.values()) {
			if (tutor.getAluno().getEmail().equals(email)) {
				return tutor;
			}
		}

		throw new IllegalArgumentException("tutor nao cadastrado");
	}

	/**
	 * Cadastra um horario para o tutor
	 * 
	 * @param email
	 *            o email do tutor
	 * @param horario
	 *            o horario para cadastrar
	 * @param dia
	 *            o dia para cadastrar
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		verificaEmail(email);
		verificaDados("lorem", horario, dia, "lorem");
		this.recuperaTutorPorEmail(email).cadastrarHorario(horario, dia);
	}

	/**
	 * Cadastra um local de atendimento para o tutor
	 * 
	 * @param email
	 *            o email do tutor
	 * @param local
	 *            o local de atendimento para cadastrar
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		verificaEmail(email);

		if (local.trim().equals("")) {
			throw new IllegalArgumentException("local nao pode ser vazio ou em branco");
		}

		this.recuperaTutorPorEmail(email).cadastrarLocalDeAtendimento(local);
	}

	/**
	 * Consulta se o horario existe para o tutor
	 * 
	 * @param email
	 *            o email do tutor
	 * @param horario
	 *            o horario para consulta
	 * @param dia
	 *            o dia para consulta
	 * @return retorna um valor boolean, true representando que existe e false que
	 *         nao
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.recuperaTutorPorEmail(email).consultaHorario(horario, dia);
	}

	/**
	 * Consulta se o local existe para o tutor
	 * 
	 * @param email
	 *            o email do tutor
	 * @param local
	 *            o local para ser consultado
	 * @return retorna um valor boolean, true represetando que existe e false que
	 *         nao
	 */
	public boolean consultaLocal(String email, String local) {
		return this.recuperaTutorPorEmail(email).consultaLocal(local);
	}

	private void verificaEmail(String email) {
		if (email.trim().equals("")) {
			throw new IllegalArgumentException("email nao pode ser vazio ou em branco");
		}
	}

	/**
	 * Pega a nota de um tutor especifico, a partir de sua matricula
	 * 
	 * @param matriculaTutor
	 *            matricula do tutor que deseja-se consultar
	 * @return double nota do tutor especificado
	 */
	public double pegarNota(String matriculaTutor) {
		if (!tutores.containsKey(matriculaTutor)) {
			throw new IllegalArgumentException("Erro: Matricula invalida");
		}

		return tutores.get(matriculaTutor).getNota();
	}

	/**
	 * Pega o nivel de um tutor especifico, a partir de sua matricula
	 * 
	 * @param matriculaTutor
	 *            matricula do tutor que deseja-se consultar
	 * @return String nivel do tutor especificado
	 */
	public String pegarNivel(String matriculaTutor) {
		if (!tutores.containsKey(matriculaTutor)) {
			throw new IllegalArgumentException("Erro: Matricula invalida");
		}

		return tutores.get(matriculaTutor).getNivel();
	}
	
	/**
	 * Pega o tutor com melhor nota, com poficiencia na disciplina e que possui diponibilidade no dia, horario e local desejado.
	 * @param disciplina a disciplina desejada
	 * @param horario o horario desejado
	 * @param dia o dia desejado
	 * @param local o local desejado
	 * @return matricula do tutor
	 */
	public String getTutorAjuda(String disciplina, String horario, String dia, String local) {
		verificaDados(disciplina, horario, dia, local);

		double maior = 0;
		Tutor melhorTutor = null;
		for (Tutor tutor : this.tutores.values()) {
			if (tutor.getNota() > maior && tutor.consultaDisciplina(disciplina) && tutor.consultaLocal(local)
					&& tutor.consultaHorario(horario, dia)) {
				melhorTutor = tutor;
				maior = tutor.getNota();
			}
		}

		return melhorTutor.getAluno().getMatricula();
	}

	private void verificaDados(String disciplina, String horario, String dia, String local) {
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException("disciplina nao pode ser vazio ou em branco");
		}

		if (horario == null || horario.trim().equals("")) {
			throw new IllegalArgumentException("horario nao pode ser vazio ou em branco");
		}

		if (dia == null || dia.trim().equals("")) {
			throw new IllegalArgumentException("dia nao pode ser vazio ou em branco");
		}

		if (local == null || local.trim().equals("")) {
			throw new IllegalArgumentException("local de interesse nao pode ser vazio ou em branco");
		}
	}

	/**
	 * Pega o tutor com melhor nota, com poficiencia na disciplina.
	 * @param disciplina a disciplina desejada
	 * @return matricula do tutor
	 */
	public String getTutorAjuda(String disciplina) {
		verificaDados(disciplina, "lorem", "lorem", "lorem");
		double maior = 0;
		Tutor melhorTutor = null;
		
		for (Tutor tutor : this.tutores.values()) {
			if (tutor.getNota() > maior && tutor.consultaDisciplina(disciplina)) {
				melhorTutor = tutor;
				maior = tutor.getNota();
			}
		}

		return melhorTutor.getAluno().getMatricula();
	}

	/**
	 * Recupera um tutor a partir da sua matricula
	 * 
	 * @param matricula
	 *            eh a matricula do tutor especifico
	 * @return o tutor especificado pela matricula
	 */
	public Tutor recuperaTutorPorMatricula(String matricula) {
		if (!this.tutores.containsKey(matricula)) {
			throw new IllegalArgumentException("Tutor inexistente");
		}

		return this.tutores.get(matricula);
	}

	/**
	 * Recupera a taxa da doaacao que e direcionada ao tutor de um tutor especifico
	 * a partir de sua matricula
	 * 
	 * @param matricula
	 *            matricula do tutor especifico
	 * @return taxa da doacao que e direcionada ao tutor
	 */
	public double getTaxaTutor(String matricula) {
		try {
			return recuperaTutorPorMatricula(matricula).getTaxaTutor();
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Tutor nao encontrado");
		}
	}

	/**
	 * Direciona dinheiro a um tutor
	 * 
	 * @param matricula
	 *            matricula do tutor que recebera o dinheiro
	 * @param dinheiro
	 *            dinheiro direcionado
	 */
	public void recebeDinheiro(String matricula, int dinheiro) {
		if (dinheiro < 0) {
			throw new IllegalArgumentException("");
		}

		try {
			recuperaTutorPorMatricula(matricula).recebeDinheiro(dinheiro);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Tutor nao encontrado");
		}
	}

	public int getDinheiroTutor(String emailTutor) {
		if (emailTutor.trim().equals("")) {
			throw new IllegalArgumentException("emailTutor nao pode ser vazio ou nulo");
		}

		try {
			return recuperaTutorPorEmail(emailTutor).getDinheiro();
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Tutor nao encontrado");
		}
	}

	/**
	 * Configura a ordem de listagem de tutores baseado seus atributos.
	 * 
	 * @param atributo
	 */
	public void configuraOrdem(String atributo) {
		if (atributo == null || atributo.trim().equals("")) {
			throw new IllegalArgumentException("atributo nao pode ser vazio ou nulo");
		}

		switch (atributo.toLowerCase()) {
		case "nome":
			criterioOrd = new ComparaNome();
			break;

		case "matricula":
			criterioOrd = new ComparaMatricula();
			break;

		case "email":
			criterioOrd = new ComparaEmail();
			break;

		default:
			throw new IllegalArgumentException("atributo invalido");
		}
	}
	/**
	 * Salva as informacoes armazenadas de tutores
	 */
	public void salvar() {
		Persistencia.salvar(tutores, "tutorMap");
	}

	/**
	 * Carrega as informacoes armazenadas de tutores
	 */
	public void carregar() {
		HashMap<String, Tutor> aux = (HashMap<String, Tutor>) Persistencia.carregar("tutorMap");
		if (aux != null) {
			this.tutores = aux;
		}
	}
	/**
	 * Limpa as informacoes armazenadas de tutores
	 */
	public void limpar() {
		Persistencia.limpar("tutorMap");
	}
}
