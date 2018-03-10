package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * 
 * @author Arthur de Lima Ferrao
 */
public class Persistencia {

	/**
	 * Salva um objeto em um arquivo txt
	 * @param obj o objeto para salvar
	 * @param tipoValues o nome do arquivo
	 */
	public void salvar(Object obj, String tipoValues) {
		FileOutputStream ops = null;
		ObjectOutputStream oos = null;
		try {
			ops = new FileOutputStream("arquivo" + File.separator + tipoValues + ".txt");
			oos = new ObjectOutputStream(ops);
			oos.writeObject(obj);
		} catch (IOException e) {
			System.out.println("erro : " + e);
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println("erro : " + e);
				}
			}
		}
	}

	public static Object carregar(String nomeArquivo) {
		FileInputStream ops = null;
		ObjectInputStream oos = null;

		try {
			ops = new FileInputStream(new File(nomeArquivo));
			oos = new ObjectInputStream(ops);
			return oos.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("erro : " + e);
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println("erro : " + e);
				}
			}
		}
		return null;
	}

}
