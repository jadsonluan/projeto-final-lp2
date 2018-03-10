package principal;

import java.io.Serializable;
/**
 * Representa um caixa, incluindo as transacoes e calculos, destinados ao sistema
 * @author Gabriel de Souza Barros
 *
 */
public class Caixa implements Serializable{
	private int dinheiro;

	public Caixa() {
		this.dinheiro = 0;
	}
	/**
	 * Metodo que retorna o dinheiro do caixa
	 * @return int dinheiro do caixa
	 */
	public int getDinheiro() {
		return dinheiro;
	}

	/**
	 * Adiciona dinheiro ao caixa
	 * 
	 * @param dinheiro
	 *            dinheiro a ser adicionado ao caixa
	 */
	public void adicionaDinheiro(int dinheiro) {
		if(dinheiro < 0) {
			throw new IllegalArgumentException("Erro ao adicionar dinheiro ao caixa: dinheiro nao pode ser negativo");
		}
		this.dinheiro += dinheiro;
	}

	/**
	 * Retira dinheiro do caixa
	 * 
	 * @param dinheiro
	 *            dinheiro a ser retirado do caixa
	 */
	public void removeDinheiro(int dinheiro) {
		if (this.dinheiro > dinheiro) {
			this.dinheiro -= dinheiro;
		} else {
			throw new IllegalArgumentException("Erro ao retirar dinheiro do caixa: dinheiro insuficiente");
		}
	}
}
