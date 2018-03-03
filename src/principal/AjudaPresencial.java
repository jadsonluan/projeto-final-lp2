package principal;


public class AjudaPresencial extends Ajuda {
	private String local;
	private String dia;
	private String hora;
	
	
	public AjudaPresencial(int id, String matrAluno, String matrTutor, String disciplina, String horario, String dia, String localInteresse) {
		super(id, matrAluno,matrTutor, disciplina);
		this.local = localInteresse;
		this.dia = dia;
		this.hora = horario;
	}


	@Override
	public String getInfo(String atributo) {
		String valor = null;
		valor = super.getInfo(atributo);
		if(valor == null){
			if(atributo.equals("Local")){
				valor = this.local;
			}else if(atributo.equals("Dia")){
				valor = this.dia;
			}else if(atributo.equals("Hora")){
				valor = this.hora;
			}
		}
		return valor;
	}
	
	
}
