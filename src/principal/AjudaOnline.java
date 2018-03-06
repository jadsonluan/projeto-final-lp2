package principal;


public class AjudaOnline extends Ajuda{
	
	public AjudaOnline(int id, String matrAluno, String matrTutor,String disciplina) {
		super(id, matrAluno, matrTutor, disciplina);
	}

	@Override
	public String getInfo(String atributo) {
		String valor = super.getInfo(atributo);
		
		if (valor == null) {
			throw new IllegalArgumentException("atributo nao encontrado");
		}
		
		return valor;
	}
}
