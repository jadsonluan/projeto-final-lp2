package principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Collections;

/**
 * Controla as informações de aluno
 * 
 * @author Arthur de Lima Ferrão - 117110318
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
    	this.alunos.put(matricula, new Aluno(matricula, nome, email, codigoCurso));
    }
    
    /**
     * Recupera o aluno pela matricula
     * O formato da representação do aluno é:<br>
	 * “Matricula - Nome - CódigoCurso - telefone - email” <br>
	 * Caso não tenha telefone, a impressão do aluno deve ter o formato:<br>
	 * “Matricula - Nome - CódigoCurso - email”
     * @param matricula a matricula do aluno
     * @return retorna a representação em String do aluno
     */
    public String recuperaAluno(String matricula){
    	return this.alunos.get(matricula).toString();
    }
    
    /**
     * Lista todos os alunos cadastrados
     * 
     * @return retorna a lista com as representação em String dos alunos
     */
    public String listarAlunos(){
    	ArrayList<Aluno> listAlunos = (ArrayList<Aluno>)alunos.values();
    	Collections.sort(listAlunos);
    	String listaAlunos = null;
    	for(Aluno aluno : listAlunos){
    		listaAlunos += aluno.toString() + System.lineSeparator();
    	}
    	return listaAlunos;
    }
    /**
     * Pega a informação de um atributo do aluno
     * @param matricula a matricula do aluno
     * @param atributo o atributo do aluno (Nome, Telefone, Email, CodigoCurso)
     * @return retorna o valor do atributo do aluno
     */
    public String getInfoAluno(String matricula, String atributo){
    	if(atributo.equals("Nome")){
    		return this.alunos.get(matricula).getNome();
    	}else if(atributo.equals("Email")){
    		return this.alunos.get(matricula).getEmail();
    	}else if(atributo.equals("CodigoCurso")){
    		return this.alunos.get(matricula).getCodigoCurso();
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
    	this.alunos.get(matricula).tornaTutor(disciplina, proficiencia);
    }
    
    /**
     * Recupera um tutor pela matricula
     * @param matricula a matricula do tutor
     * @return retorna a 
     */
    public String recuperaTutor(String matricula){
    	return this.alunos.get(matricula).toString();
    }
    
    /**
     * Lista todos os tutores cadastrados no sistema
     * @return retorna a representação em String do tutor
     */
    public String listarTutores(){
    	String listaTutores = null;
    	for(Aluno aluno : this.alunos.values()){
    		if(aluno.ehTutor()){
    			listaTutores += aluno.toString() + System.lineSeparator();	
    		}
       	}
    	return listaTutores;
    }
    private Aluno recuperaPorEmail(String email){
    	for(Aluno aluno : this.alunos.values()){
    		if(aluno.equals(email)){
    			return aluno;
    		}
    	}
    	return null;
    }
    
    /**
     * Cadastra um horario para o tutor 
     * @param email o email do tutor
     * @param horario o horario para cadastrar
     * @param dia o dia para cadastrar
     */
    public void cadastrarHorario(String email, String horario, String dia){
    	this.recuperaPorEmail(email).cadastrarHorario( horario, dia);
    }
    
    /**
     * Cadastra um local de atendimento para o tutor 
     * @param email o email do tutor
     * @param local o local de atendimento para cadastrar
     */
    public void cadastrarLocalDeAtendimento(String email, String local){
    	this.recuperaPorEmail(email).cadastrarLocalDeAtendimento(local);
    }
    /**
     * Consulta se o horario existe para o tutor
     * @param email o email do tutor
     * @param horario o horario para consulta
     * @param dia o dia para consulta
     * @return retorna um valor boolean, true represetando que existe e false que nao
     */
    public boolean consultaHorario(String email, String horario, String dia){
    	this.recuperaPorEmail(email).consultaHorario(horario,dia);
    }
    
    /**
     * Consulta se o local existe para o tutor
     * @param email o email do tutor
     * @param local o local para ser consultado
     * @return retorna um valor boolean, true represetando que existe e false que nao
     */
    public boolean consultaLocal(String email, String local){
    	this.recuperaPorEmail(email).consultaLocal(local);
    }
}
