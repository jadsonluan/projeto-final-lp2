package principal;

import java.util.ArrayList;
import java.util.Collections;

public class Facade {
		private Sistema sistema;
	public Facade(){
		this.sistema = new Sistema();
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
    	this.sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
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
    	return this.sistema.recuperaAluno(matricula);
    }
    
    /**
     * Lista todos os alunos cadastrados
     * 
     * @return retorna a lista com as representação em String dos alunos
     */
    public String listarAlunos(){
    	return this.sistema.listarAlunos();
    }
    /**
     * Pega a informação de um atributo do aluno
     * @param matricula a matricula do aluno
     * @param atributo o atributo do aluno (Nome, Telefone, Email, CodigoCurso)
     * @return retorna o valor do atributo do aluno
     */
    public String getInfoAluno(String matricula, String atributo){
    	return this.sistema.getInfoAluno(matricula, atributo);
    }
    
    /**
	 * Torna o aluno tutor de uma disciplina
	 * 
	 * @param matricula a matricula do aluno
	 * @param disciplina a disciplina da tutoria
	 * @param proficiencia a proficiencia da disciplina (1-5)
	 */
    public void tornarTutor(String matricula, String disciplina, int proficiencia){
    	this.sistema.tornarTutor(matricula, disciplina, proficiencia);
    }
    
    /**
     * Recupera um tutor pela matricula
     * @param matricula a matricula do tutor
     * @return retorna a 
     */
    public String recuperaTutor(String matricula){
    	return this.sistema.recuperaTutor(matricula);
    }
    
    /**
     * Lista todos os tutores cadastrados no sistema
     * @return retorna a representação em String do tutor
     */
    public String listarTutores(){
    	return this.sistema.listarTutores();
    }
    
    /**
     * Cadastra um horario para o tutor 
     * @param email o email do tutor
     * @param horario o horario para cadastrar
     * @param dia o dia para cadastrar
     */
    public void cadastrarHorario(String email, String horario, String dia){
    	this.sistema.cadastrarHorario(email, horario, dia);
    }
    
    /**
     * Cadastra um local de atendimento para o tutor 
     * @param email o email do tutor
     * @param local o local de atendimento para cadastrar
     */
    public void cadastrarLocalDeAtendimento(String email, String local){
    	this.sistema.cadastrarLocalDeAtendimento(email, local);
    }
    /**
     * Consulta se o horario existe para o tutor
     * @param email o email do tutor
     * @param horario o horario para consulta
     * @param dia o dia para consulta
     * @return retorna um valor boolean, true represetando que existe e false que nao
     */
    public boolean consultaHorario(String email, String horario, String dia){
    	return this.sistema.consultaHorario(email, horario, dia);
    }
    
    /**
     * Consulta se o local existe para o tutor
     * @param email o email do tutor
     * @param local o local para ser consultado
     * @return retorna um valor boolean, true represetando que existe e false que nao
     */
    public boolean consultaLocal(String email, String local){
    	return this.sistema.consultaLocal(email, local);
    }
}
