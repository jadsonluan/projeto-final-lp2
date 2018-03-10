package principal;

import java.util.Comparator;
/**
 * Compara dois tutores com base em suas matriculas.
 */
public class ComparaMatricula implements Comparator<Tutor> {

	@Override
	public int compare(Tutor tutor1, Tutor tutor2) {
		return tutor1.getAluno().getMatricula().compareTo(tutor2.getAluno().getMatricula());
	}

}
