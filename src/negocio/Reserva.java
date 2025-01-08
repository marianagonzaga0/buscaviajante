package negocio;

import java.util.Date;

public abstract class Reserva {
	protected double preco;
	protected Date dataEntrada;
	protected Date dataSaida;
	protected Pagamento pagamento;
		
	public Reserva(double preco, Date dataEntrada, Date dataSaida, Pagamento pagamento) {
		super();
		this.preco = preco;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.pagamento = pagamento;
	}
	
	public Reserva(double preco, Pagamento pagamento) {
		this.preco = preco;
		this.pagamento = pagamento;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public double calcularPrecoTotal() {
		return preco;
	}
	
}
