package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

/**
 * Controla as informaÃ§Ãµes de aluno
 * 
 * @author Arthur de Lima FerrÃ£o - 117110318
 */
public class Sistema {
	private HashMap<String,Aluno> alunos;
	
	/**
	 * Cria uma objeto Sistema
	 */
	public Sistema(){
		this.alunos = new HashMap<String, Aluno>();
	}
	
	/**
	 * Cadastra um aluno no sistema
	 * 
	 * @param nome o nome do aluno
	 * @param matricula a matricula do aluno
	 * @param codigoCurso o codigo do curso do aluno
	 * @param telefone o telefone do aluno
	 * @param email o email do aluno
	 */
    public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email){
    	if(alunos.containsKey(matricula)) {
    		throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
    	}
    	if(nome == null || nome.trim().equals("")) {
    		throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
    	}
    	//verificaEmail(email, "Erro no cadastro de aluno: ");
    	this.alunos.put(matricula, new Aluno(matricula, nome, email, codigoCurso, telefone));
    }
    
    /**
     * Recupera o aluno pela matricula
     * O formato da representaÃ§Ã£o do aluno Ã©:<br>
	 * â€œMatricula - Nome - CÃ³digoCurso - telefone - emailâ€� <br>
	 * Caso nÃ£o tenha telefone, a impressÃ£o do aluno deve ter o formato:<br>
	 * â€œMatricula - Nome - CÃ³digoCurso - emailâ€�
     * @param matricula a matricula do aluno
     * @return retorna a representaÃ§Ã£o em String do aluno
     */
    public String recuperaAluno(String matricula){
    	verificaAluno(matricula, "Erro na busca por aluno: ");
    	return this.alunos.get(matricula).toString();
    }
    
    /**
     * Lista todos os alunos cadastrados
     * 
     * @return retorna a lista com as representaÃ§Ã£o em String dos alunos
     */
    public String listarAlunos(){
    	ArrayList<Aluno> listAlunos = new ArrayList<>();
    	for(Aluno a : alunos.values()) {
    		listAlunos.add(a);
    	}
    	Collections.sort(listAlunos);
    	String listaAlunos = "";
    	for(int i = 0; i < listAlunos.size(); i++) {
    		listaAlunos += listAlunos.get(i).toString();
    		if(i != listAlunos.size() - 1) {
    			listaAlunos += ", ";
    		}
    	}
    	return listaAlunos;
    }
    /**
     * Pega a informaÃ§Ã£o de um atributo do aluno
     * @param matricula a matricula do aluno
     * @param atributo o atributo do aluno (Nome, Telefone, Email, CodigoCurso)
     * @return retorna o valor do atributo do aluno
     */
    public String getInfoAluno(String matricula, String atributo){
    	verificaAluno(matricula, "Erro na obtencao de informacao de aluno: ");
    	if(atributo.equals("Nome")){
    		return this.alunos.get(matricula).getNome();
    	}else if(atributo.equals("Email")){
    		return this.alunos.get(matricula).getEmail();
    	}else if(atributo.equals("CodigoCurso")){
    		//return this.alunos.get(matricula).getCodigoCurso();
    	}else if(atributo.equals("Telefone")){
    		return this.alunos.get(matricula).getTelefone();
    	}
    	return null;
    }
    
    /**
	 * Torna o aluno tutor de uma disciplina
	 * 
	 * @param matricula a matricula do aluno
	 * @param disciplina a disciplina da tutoria
	 * @param proficiencia a proficiencia da disciplina (1-5)
	 */
    public void tornarTutor(String matricula, String disciplina, int proficiencia){
    	if(!this.alunos.containsKey(matricula)) {
    		throw new NullPointerException("Erro na definicao de papel: Tutor nao encontrado");
    	}
    	this.alunos.get(matricula).tornaTutor(disciplina, proficiencia);
    }
    
    /**
     * Recupera um tutor pela matricula
     * @param matricula a matricula do tutor
     * @return retorna a 
     */
    public String recuperaTutor(String matricula){
    	if(!this.alunos.containsKey(matricula)|| !this.alunos.get(matricula).ehTutor()) {
    		throw new NullPointerException("Erro na busca por tutor: Tutor nao encontrado");
    	}
    	return this.alunos.get(matricula).toString();
    }
    
    /**
     * Lista todos os tutores cadastrados no sistema
     * @return retorna a representaÃ§Ã£o em String do tutor
     */
    public String listarTutores(){
    	String listaTutores = "";
    	boolean i = true;
    	for(Aluno aluno : this.alunos.values()){
    		if(aluno.ehTutor()){
    			if(i) {
    				listaTutores += aluno.toString();	
    				i = false;
    			}else {
    				listaTutores += ", " + aluno.toString();	
    			}
    		}
       	}
    	return listaTutores;
    }
    
    private Aluno recuperaPorEmail(String email, String msg){
    	for(Aluno aluno : this.alunos.values()){
    		if(aluno.getEmail().equals(email)){
    			return aluno;
    		}
    	}
    	throw new NullPointerException(msg + "tutor nao cadastrado");    	
    }
    
    /**
     * Cadastra um horario para o tutor 
     * @param email o email do tutor
     * @param horario o horario para cadastrar
     * @param dia o dia para cadastrar
     */
    public void cadastrarHorario(String email, String horario, String dia){
    	verificaEmail(email, "Erro no cadastrar horario: ");
    	if(horario.trim().equals("")) {
    		throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
    	}
    	if(dia.trim().equals("")) {
    		throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
    	}
    	this.recuperaPorEmail(email, "Erro no cadastrar horario: ").cadastrarHorario( horario, dia);
    }
    
    /**
     * Cadastra um local de atendimento para o tutor 
     * @param email o email do tutor
     * @param local o local de atendimento para cadastrar
     */
    public void cadastrarLocalDeAtendimento(String email, String local){
    	verificaEmail(email, "Erro no cadastrar local de atendimento: ");
    	if(local.trim().equals("")) {
    		throw new IllegalArgumentException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
    	}
    	this.recuperaPorEmail(email, "Erro no cadastrar local de atendimento: ").cadastrarLocalDeAtendimento(local);
    }
    /**
     * Consulta se o horario existe para o tutor
     * @param email o email do tutor
     * @param horario o horario para consulta
     * @param dia o dia para consulta
     * @return retorna um valor boolean, true represetando que existe e false que nao
     */
    public boolean consultaHorario(String email, String horario, String dia){
    	return this.recuperaPorEmail(email, "Erro ao consultar horario de atendimento: ").consultaHorario(horario,dia);
    }
    
    /**
     * Consulta se o local existe para o tutor
     * @param email o email do tutor
     * @param local o local para ser consultado
     * @return retorna um valor boolean, true represetando que existe e false que nao
     */
    public boolean consultaLocal(String email, String local){
    	return this.recuperaPorEmail(email, "Erro ao consultar local de atendimento: ").consultaLocal(local);
    }
    
    private void verificaAluno(String matricula, String msg) {
    	if(!alunos.containsKey(matricula)) {
    		throw new NullPointerException(msg + "Aluno nao encontrado");
    	}
    }
    
    private void verificaEmail(String email, String msg) {
    	if(email.trim().equals("")) {
    		throw new IllegalArgumentException(msg + "email nao pode ser vazio ou em branco");
    	}
    }
}
