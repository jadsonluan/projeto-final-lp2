package principal;


public abstract class Ajuda {
	private int id;
	private String matrAluno;
	private String matrTutor;
	private String disciplina;
	
	
	public Ajuda(int id, String matrAluno, String matrTutor, String disciplina) {
		this.id = id;
		this.matrAluno = matrAluno;
		this.matrTutor = matrTutor;
		this.disciplina = disciplina;
	}



	public String getInfo(String atributo){
		String valor = null;
		if(atributo.equals("mastrAluno")){
			valor = this.matrAluno;
		}else if(atributo.equals("disciplina")){
			valor = this.disciplina;
		}
		return valor;
	}
	
	public String getTutor(){
		return this.matrTutor;
	}
	
}
