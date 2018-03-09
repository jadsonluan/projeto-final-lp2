package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class Persistencia {

	public void salvar(Map obj, String tipoValues) {
		FileOutputStream ops = null;
		try {
			ops = new FileOutputStream(tipoValues + ".txt");
			ObjectOutputStream oos = new ObjectOutputStream(ops);
			oos.writeObject(obj);
		} catch (IOException e) {
			System.out.println("erro : " + e);
		} finally {
			if (ops != null) {
				try {
					ops.close();
				} catch (IOException e) {
					System.out.println("erro : " + e);
				}
			}
		}
	}

}
