package negocio;

import java.util.Date;

public class ReservaVoo extends Reserva{
	private String origem;
	private String destino;
	private Date dataIda;
	private Date dataVolta;
	private int numPassageiros;
	private boolean IdaEVolta;
			
	public ReservaVoo(double preco, Pagamento pagamento, String origem, String destino, Date dataIda, Date dataVolta,
			int numPassageiros, boolean idaEVolta) {
		super(preco, pagamento);
		this.origem = origem;
		this.destino = destino;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.numPassageiros = numPassageiros;
		IdaEVolta = idaEVolta;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getNumPassageiros() {
		return numPassageiros;
	}

	public void setNumPassageiros(int numPassageiros) {
		this.numPassageiros = numPassageiros;
	}
	
	public boolean isIdaEVolta() {
		return IdaEVolta;
	}

	public void setIdaEVolta(boolean idaEVolta) {
		IdaEVolta = idaEVolta;
	}
	
	public Date getDataIda() {
		return dataIda;
	}

	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}

	public Date getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}

	public double calcularPrecoTotal() {
		if (IdaEVolta == true) {
			preco = 2 * preco;
			return preco;
		}else {
			return preco;
		}
	}

	@Override
	public String toString() {
		return "ReservaVoo [origem=" + origem + ", destino=" + destino + ", dataIda=" + dataIda + ", dataVolta="
				+ dataVolta + ", numPassageiros=" + numPassageiros + ", IdaEVolta=" + IdaEVolta + ", preco=" + preco
				+ ", pagamento=" + pagamento + "]";
	}
	
}
