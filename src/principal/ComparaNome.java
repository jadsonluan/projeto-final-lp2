package principal;

import java.util.Comparator;

/**
 * Compara dois tutores com base em seus nomes. Caso tenham o mesmo nome, o
 * desempate sera atraves da matricula
 */
public class ComparaNome implements Comparator<Tutor> {

	@Override
	public int compare(Tutor tutor1, Tutor tutor2) {
		int result = tutor1.getAluno().getNome().compareTo(tutor2.getAluno().getNome());

		if (result == 0) {
			result = (new ComparaMatricula()).compare(tutor1, tutor2);
		}

		return result;
	}

}
