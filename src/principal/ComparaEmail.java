package principal;

import java.util.Comparator;

/**
 * Compara dois tutores com base em seus e-mails. Caso tenham o mesmo e-mail, o
 * desempate sera atraves da matricula
 */
public class ComparaEmail implements Comparator<Tutor> {

	@Override
	public int compare(Tutor tutor1, Tutor tutor2) {
		int result = tutor1.getAluno().getEmail().compareTo(tutor2.getAluno().getEmail());

		if (result == 0) {
			result = (new ComparaMatricula()).compare(tutor1, tutor2);
		}

		return result;
	}

}
