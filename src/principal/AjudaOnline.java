package principal;

/**
 * Representa um pedido de ajuda online.
 * 
 * @author Arthur de Lima Ferrao - 117110318
 */
public class AjudaOnline extends Ajuda {

	/**
	 * Constroi um pedido de ajuda online
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
	public AjudaOnline(int id, String matrAluno, String matrTutor,
			String disciplina) {
		super(id, matrAluno, matrTutor, disciplina);
	}

	/**
	 * @see Ajuda#getInfo(String)
	 */
	@Override
	public String getInfo(String atributo) {
		String valor = super.getInfo(atributo);

		if (valor == null) {
			throw new IllegalArgumentException("atributo nao encontrado");
		}

		return valor;
	}
}
