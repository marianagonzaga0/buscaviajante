package negocio;

//import java.util.Arrays;

public class Usuario {
	private String email;
	private String nome;
	private String sexo;
	private String nacionalidade;
	private String dtNascimento;
	private ReservaHotel[] reservasHotel;
	private int numReservasHotel = 0;
	private ReservaVoo[] reservasVoo;
	private int numReservasVoo = 0;
	private ReservaCarro[] reservasCarro;
	private int numReservasCarro = 0;
	private Passageiro[] passageiros;
	private int numPassageiros = 0;
	private Pagamento[] pagamentos;
	private int numPagamentos = 0;
	
	
	public Usuario(String email, String nome, String sexo, String nacionalidade, String dtNascimento) {
		this.email=email;
		this.nome=nome;
		this.sexo=sexo;
		this.nacionalidade=nacionalidade;
		this.dtNascimento=dtNascimento;
		reservasCarro = new ReservaCarro[100];
		reservasHotel = new ReservaHotel[100];
		reservasVoo = new ReservaVoo[100];
		passageiros = new Passageiro[50];
		pagamentos = new Pagamento[25];
	}
	
	public Usuario() {
	}

	public String getEmail() {
		return email;
	}

	public void editarEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void editarNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void editarDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public Reserva getReservasHotel(int i) {
		return reservasHotel[i];
	}

	public void setReservasHotel(int i, ReservaHotel[] reservasHotel) {
		this.reservasHotel = reservasHotel;
	}

	public Reserva getReservasVoo(int i) {
		return reservasVoo[i];
	}

	public void setReservasVoo(int i, ReservaVoo[] reservasVoo) {
		this.reservasVoo = reservasVoo;
	}

	public Reserva getReservasCarro(int i) {
		return reservasCarro[i];
	}

	public void setReservasCarro(ReservaCarro[] reservasCarro) {
		this.reservasCarro = reservasCarro;
	}
	
	public Passageiro getPassageiros(int i) {
		return passageiros[i];
	}

	public void setPassageiros(Passageiro[] passageiros) {
		this.passageiros = passageiros;
	}
	
	public void setPassageiros(int i, Passageiro p) {
		passageiros[i] = p;
	}
	
	public int getNumReservasHotel() {
		return numReservasHotel;
	}

	public void setNumReservasHotel(int numReservasHotel) {
		this.numReservasHotel = numReservasHotel;
	}

	public int getNumReservasVoo() {
		return numReservasVoo;
	}

	public void setNumReservasVoo(int numReservasVoo) {
		this.numReservasVoo = numReservasVoo;
	}

	public int getNumReservasCarro() {
		return numReservasCarro;
	}

	public void setNumReservasCarro(int numReservasCarro) {
		this.numReservasCarro = numReservasCarro;
	}
	
	public int getNumPassageiros() {
		return numPassageiros;
	}

	public void setNumPassageiros(int numPassageiros) {
		this.numPassageiros = numPassageiros;
	}

	public Pagamento getPagamentos(int i) {
		return pagamentos[i];
	}

	public void setPagamentos(Pagamento[] pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	public void setPagamentos(int i, Pagamento pag) {
		pagamentos[i] = pag;
	}

	public int getNumPagamentos() {
		return numPagamentos;
	}

	public void setNumPagamentos(int numPagamentos) {
		this.numPagamentos = numPagamentos;
	}

	public void addPassageiro(Passageiro p) {
        for (int i=0; i<50; i++) {
            if (passageiros[i] != null) {
                numPassageiros++;
            }
        }
		passageiros[numPassageiros]=p;
		numPassageiros++;
		
	}
	
	public String verPassageiros() {
		String mensagem = "";
		int j = 0;
		
		for (int i=0; i<50; i++) {
			if(this.passageiros[i] != null) {
				mensagem = mensagem +"passageiro" + j + ": " + this.passageiros[i].getNome() + "\n";
				j++;
			}
		}
		
		return mensagem;
		
	}
	
	public void addPagamento(Pagamento pagamento) {
	    for (int i = 0; i < 25; i++) {
	        if (pagamentos[i] != null) {
	            numPagamentos++;
	        }
	    }
	    pagamentos[numPagamentos] = pagamento;
	    numPagamentos++;
	}

	public String verPagamentos() {
	    String mensagem = "";
	    int j = 0;

	    for (int i = 0; i < 25; i++) {
	        if (this.pagamentos[i] != null) {
	            mensagem = mensagem + "pagamento" + j + ": " + this.pagamentos[i].toString() + "\n";
	            j++;
	        }
	    }
	    return mensagem;
	}

	public void addReservaCarro(ReservaCarro r) {
        for (int i=0; i<100; i++) {
            if (reservasCarro[i] != null) {
                numReservasCarro++;
            }
        }
		reservasCarro[numReservasCarro]=r;
		numReservasCarro++;	
	}
	
	public void addReservaHotel(ReservaHotel r) {
        for (int i=0; i<100; i++) {
            if (reservasHotel[i] != null) {
                numReservasHotel++;
            }
        }
		reservasHotel[numReservasHotel]=r;
		numReservasHotel++;
		
	}
	
	public void addReservaVoo(ReservaVoo r) {
        for (int i=0; i<100; i++) {
            if (reservasVoo[i] != null) {
                numReservasVoo++;
            }
        }
		reservasVoo[numReservasVoo]=r;
		numReservasVoo++;
		
	}
		
	public String verReservaCarro() {
		String mensagem = "";
		int j = 0;
		for (int i=0; i<numReservasCarro; i++) {
			if(reservasCarro[i] != null) {
				mensagem = mensagem + "reserva" + j + ": " + reservasCarro[i].toString() + "\n";
				j++;
			}
		}	
		return mensagem;	
	}
	
	public String verReservaHotel() {
		String mensagem = "";
		int j = 0;
		for (int i=0; i<numReservasHotel; i++) {
			if(reservasHotel[i] != null) {
				mensagem = mensagem + "reserva" + j + ": " + reservasHotel[i].toString() + "\n";
				j++;
			}
		}	
		return mensagem;	
	}
	
	public String verReservaVoo() {
		String mensagem = "";
		int j = 0;
		for (int i=0; i<numReservasHotel; i++) {
			if(reservasVoo[i] != null) {
				mensagem = mensagem + "reserva" + j + ": " + reservasVoo[i].toString() + "\n";
				j++;
			}
		}	
		return mensagem;	
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nome=" + nome + ", sexo=" + sexo + ", nacionalidade=" + nacionalidade
				+ ", dtNascimento=" + dtNascimento + "]";
	}
	
}
