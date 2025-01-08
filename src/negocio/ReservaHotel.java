package negocio;

import java.util.Date;

public class ReservaHotel extends Reserva{
	private String nomeHotel;
	private String localizacaoHotel;
	private int numHospedes;
	private String tipoDeQuarto;
	
	public ReservaHotel(double preco, Date dataEntrada, Date dataSaida, Pagamento pagamento, String nomeHotel,
			String localizacaoHotel, int numHospedes,
			String tipoDeQuarto) {
		super(preco, dataEntrada, dataSaida, pagamento);
		this.nomeHotel = nomeHotel;
		this.localizacaoHotel = localizacaoHotel;
		this.numHospedes = numHospedes;
		this.tipoDeQuarto = tipoDeQuarto;
	}

	public String getNomeHotel() {
		return nomeHotel;
	}

	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}

	public String getLocalizacaoHotel() {
		return localizacaoHotel;
	}

	public void setLocalizacaoHotel(String localizacaoHotel) {
		this.localizacaoHotel = localizacaoHotel;
	}

	public int getNumHospedes() {
		return numHospedes;
	}

	public void setNumHospedes(int numHospedes) {
		this.numHospedes = numHospedes;
	}

	public String getTipoDeQuarto() {
		return tipoDeQuarto;
	}

	public void setTipoDeQuarto(String tipoDeQuarto) {
		this.tipoDeQuarto = tipoDeQuarto;
	}
	
	public double calcularPrecoTotal() {
        long diff = dataSaida.getTime() - dataEntrada.getTime(); // Diferença em milissegundos
        int diasAntecedencia = (int) (diff / (24 * 60 * 60 * 1000)); // Converte para dias
        double precoTotal = preco * diasAntecedencia;
        return precoTotal;
    }

	@Override
	public String toString() {
		return "ReservaHotel [nomeHotel=" + nomeHotel + ", localizacaoHotel=" + localizacaoHotel + ", numHospedes=" + numHospedes
				+ ", tipoDeQuarto=" + tipoDeQuarto + ", preco=" + preco + ", dataEntrada=" + dataEntrada
				+ ", dataSaida=" + dataSaida + ", pagamento=" + pagamento + "]";
	}

	
}
