package dados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import negocio.*;

public class Dados {
    private Usuario[] usuarios;
    private int numUsuarios = 0;
    private Passageiro[] passageiros;
    private int numPassageiros = 0;
    private Pagamento[] pagamentos;
    private int numPagamentos = 0;
	private ReservaCarro[] reservasCarro;
	private int numReservasCarros = 0;
	private ReservaVoo[] reservasVoo;
	private int numReservasVoo = 0;
	private ReservaHotel[] reservasHotel;
	private int numReservasHotel = 0;
	
	public Dados() {
		usuarios = new Usuario[100];
		passageiros = new Passageiro[50];
		pagamentos = new Pagamento[25];
		reservasCarro = new ReservaCarro[100];
		reservasHotel = new ReservaHotel[100];
		reservasVoo = new ReservaVoo[100];
	}

//	getters e setters de usuarios
	
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	
	public Usuario getUsuario(int i) {
		return usuarios[i];
	}

	public String[] getNomeUsuarios(){
		String[] s = new String[numUsuarios];
		for (int i=0; i<numUsuarios; i++) {
			s[i] = usuarios[i].getNome();
		}
		return s;
	}
		
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	
	public void setUsuario(int i, Usuario u) {
		usuarios[i] = u;
	}
	
	
	public int getNumUsuarios() {
		return numUsuarios;
	}

	public void setNumUsuarios(int numUsuarios) {
		this.numUsuarios = numUsuarios;
	}
	
//	getters e setters de passageiros

	public Passageiro[] getPassageiros() {
		return passageiros;
	}
	
	public Passageiro getPassageiro(int i) {
		return passageiros[i];
	}

	public String[] getNomePassageiro(){
		String[] s = new String[numPassageiros];
		for (int i=0; i<numPassageiros; i++) {
			s[i] = passageiros[i].getNome();
		}
		return s;
	}
	
	public void setPassageiros(Passageiro[] passageiros) {
		this.passageiros = passageiros;
	}
	
	public void setPassageiro(int i, Passageiro p) {
		passageiros[i] = p;
	}

	public int getNumPassageiros() {
		return numPassageiros;
	}

	public void setNumPassageiros(int numPassageiros) {
		this.numPassageiros = numPassageiros;
	}

//	getters e setters de pagamentos
	
	public Pagamento[] getPagamentos() {
		return pagamentos;
	}
	
	public Pagamento getPagamento(int i) {
		return pagamentos[i];
	}

	public void setPagamentos(Pagamento[] pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	public void setPagamento(int i, Pagamento pag) {
		pagamentos[i] = pag;
	}

	public int getNumPagamentos() {
		return numPagamentos;
	}

	public void setNumPagamentos(int numPagamentos) {
		this.numPagamentos = numPagamentos;
	}
	
// getters e setters de reservasCarro
	
	public ReservaCarro[] getReservasCarro() {
		return reservasCarro;
	}
	
	public ReservaCarro getReservaCarro(int i) {
		return reservasCarro[i];
	}

	public void setReservasCarro(ReservaCarro[] reservasCarro) {
		this.reservasCarro = reservasCarro;
	}
	
	public void setReservaCarro(int i, ReservaCarro res_car) {
		reservasCarro[i] = res_car;
	}

	public int getNumReservasCarros() {
		return numReservasCarros;
	}

	public void setNumReservasCarros(int numReservasCarros) {
		this.numReservasCarros = numReservasCarros;
	}
	
//	getters e setters reservaVoo
	
	public ReservaVoo[] getReservasVoo() {
		return reservasVoo;
	}
	
	public ReservaVoo getReservaVoo(int i) {
		return reservasVoo[i];
	}

	public void setReservasVoo(ReservaVoo[] reservasVoo) {
		this.reservasVoo = reservasVoo;
	}
	
	public void setReservaVoo(int i, ReservaVoo res_voo) {
		reservasVoo[i] = res_voo;
	}

	public int getNumReservasVoo() {
		return numReservasVoo;
	}

	public void setNumReservasVoo(int numReservasVoo) {
		this.numReservasVoo = numReservasVoo;
	}
// getters e setters de reservaHotel
	
	public ReservaHotel[] getReservasHotel() {
		return reservasHotel;
	}
	
	public ReservaHotel getReservaHotel(int i) {
		return reservasHotel[i];
	}

	public void setReservasHotel(ReservaHotel[] reservasHotel) {
		this.reservasHotel = reservasHotel;
	}
	
	public void setReservaHotel(int i, ReservaHotel res_hot) {
		reservasHotel[i] = res_hot;
	}

	public int getNumReservasHotel() {
		return numReservasHotel;
	}

	public void setNumReservasHotel(int numReservasHotel) {
		this.numReservasHotel = numReservasHotel;
	}
	
	public void preencherDados(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataEntrada = null;
	    Date dataSaida = null;
		try {
			dataSaida = sdf.parse("05/11/2023");
			dataEntrada = sdf.parse("01/11/2023");
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
		
		for (int i=0; i<10; i++) {
			String s = String.valueOf(i);
			usuarios[i] = new Usuario("email".concat(s), "nome".concat(s), "sexo".concat(s), "nacionalidade".concat(s), "dtNascimento".concat(s));
			passageiros[i] = new Passageiro("nome".concat(s), "sexo".concat(s), "nacionalidade".concat(s), "dataNascimento".concat(s));
			pagamentos[i] = new Pagamento(i, "dataValidade".concat(s), "nome".concat(s), "bandeira".concat(s), "enderecoCobranca".concat(s));
			reservasCarro[i] = new ReservaCarro(Double.parseDouble(s),  dataEntrada, dataSaida, pagamentos[i], "localRetirada".concat(s), "horaRetirada".concat(s), "horaEntrega".concat(s));
			reservasVoo[i] = new ReservaVoo(Double.parseDouble(s), pagamentos[i], "origem".concat(s), "destino".concat(s), dataEntrada, dataSaida, i, true) ;
			reservasHotel[i] = new ReservaHotel(Double.parseDouble(s), dataEntrada, dataSaida, pagamentos[i], "nomeHotel".concat(s), "localizacaoHotel".concat(s), i, "tipoDeQuarto".concat(s));	
			usuarios[i].addReservaCarro(reservasCarro[i]);
			usuarios[i].addReservaVoo(reservasVoo[i]);
			usuarios[i].addReservaHotel(reservasHotel[i]);
			usuarios[i].addPagamento(pagamentos[i]);
			usuarios[i].addPassageiro(passageiros[i]);
			
		}
		numUsuarios = numPassageiros = numPagamentos = numReservasHotel = numReservasCarros = numReservasVoo= 10;	
		
	}

	

	public void addUsuario(Usuario u) {
		int count=0;
        for (int i=0; i<100; i++) {
            if (usuarios[count] != null) {
                count++;
            }
        }
		usuarios[count]=u;
		numUsuarios++;
	}

	public void addPassageiro(Passageiro p) {
	    int count = 0;
	    for (int i = 0; i < 50; i++) {
	        if (passageiros[count] != null) {
	            count++;
	        }
	    }
	    passageiros[count] = p;
	    numPassageiros++;
	}
	
	public void addPagamento(Pagamento p) {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (pagamentos[count] != null) {
                count++;
            }
        }
        pagamentos[count] = p;
        numPagamentos++;
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
	
	public void addReservaCarro(ReservaCarro r) {
        for (int i=0; i<100; i++) {
            if (reservasCarro[i] != null) {
                numReservasCarros++;
            }
        }
		reservasCarro[numReservasCarros]=r;
		numReservasCarros++;
		
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

}
	

