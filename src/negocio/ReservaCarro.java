package negocio;

import java.util.Date;

public class ReservaCarro extends Reserva{
	private String localRetirada;
	private String horaRetirada;
	private String horaEntrega;
	
	public ReservaCarro(double preco, Date dataEntrada, Date dataSaida, Pagamento pagamento, String localRetirada,
			String horaRetirada, String horaEntrega) {
		super(preco, dataEntrada, dataSaida, pagamento);
		this.localRetirada = localRetirada;
		this.horaRetirada = horaRetirada;
		this.horaEntrega = horaEntrega;
	}

	public String getLocalRetirada() {
		return localRetirada;
	}

	public void setLocalRetirada(String localRetirada) {
		this.localRetirada = localRetirada;
	}

	public String getHoraRetirada() {
		return horaRetirada;
	}

	public void setHoraRetirada(String horaRetirada) {
		this.horaRetirada = horaRetirada;
	}

	public String getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(String horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	
	public double calcularPrecoTotal() {
        long diff = dataSaida.getTime() - dataEntrada.getTime(); // Diferença em milissegundos
        int diasAntecedencia = (int) (diff / (24 * 60 * 60 * 1000)); // Converte para dias
        double precoTotal = preco * diasAntecedencia;
        return precoTotal;
    }

	@Override
	public String toString() {
		return "ReservaCarro [localRetirada=" + localRetirada + ", horaRetirada=" + horaRetirada + ", horaEntrega="
				+ horaEntrega + ", preco=" + preco + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida
				+ ", pagamento=" + pagamento + "]";
	}
	
}
