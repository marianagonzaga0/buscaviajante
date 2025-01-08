package main;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import dados.Dados;
import negocio.Pagamento;
import negocio.Passageiro;
import negocio.ReservaCarro;
import negocio.ReservaHotel;
import negocio.ReservaVoo;
import negocio.Usuario;

public class Main {
	
	public static Dados dados = new Dados();
	public static Scanner in = new Scanner(System.in);
	public static Usuario usuarioSelecionado = new Usuario();
	public static Usuario usuario = new Usuario();
	
	    public static void main(String[] args) {
	    	int op = -1;
			int aux;
			dados.preencherDados();
			
			while(op != 0) {
				System.out.print(imprimirMenu());
				op = in.nextInt();
				 switch (op) {
				 	case 0:
				 		System.out.println("Obrigada por utilizar o sistema. Ate logo!");
				 		break;
				 	case 1:
				 		cadastrarUsuario();
				 		break;
				 	case 2:
				 		removerUsuario();
				 		break;
				 	case 3:
				 		listarUsuarios();
				 		break;
				 	case 4:
				 	    System.out.println("Escolha um dos usuários a seguir para editar as informações:\n");
				 	    listarUsuarios();
				 	    aux = in.nextInt();
				 	    Usuario usuarioEditado = lerDadosUsuario();
				 	    editarUsuario(aux, usuarioEditado);
				 	    break;
				 	case 5: 
				 		cadastrarPassageiro();
				 		break;
				 	case 6:
				 		removerPassageiro();
				 		break;
				 	case 7:
				 		listarPassageiros();
				 		break;
				 	case 8:
				 		listarPassageiros();
				 		System.out.println("Escolha um dos passageiros para editar as informações:\n");
				 		aux = in.nextInt();
				 	    Passageiro passageiroEditado = lerDadosPassageiro();
				 	    editarPassageiro(aux, passageiroEditado);
				 	    break;
				 	case 9:
				 		cadastrarPagamento();
				 		break;
				 	case 10:
				 		removerPagamento();
				 		break;
				 	case 11:
				 		listarPagamentos();
				 		break;
				 	case 12:
				 	    listarPagamentos();
				 	    System.out.println("Escolha um dos pagamento para editar as informações:\n");
				 	    aux = in.nextInt();
				 	    Pagamento pagamentoEditado = lerDadosPagamento();
				 	    editarPagamento(aux, pagamentoEditado);
				 	    break;
				 	case 13:
				 		cadastrarReservaHotel();
				 		break;
				 	case 14:
				 		listarReservasHotel();
				 		break;
				 	case 15:
				 		cadastrarReservaCarro();
				 		break;
				 	case 16:
				 		listarReservasCarro();
				 		break;
				 	case 17:
				 		cadastrarReservaVoo();
				 		break;
				 	case 18:
				 		listarReservasVoo();
				 		break;	
				 	case 19:
				 		calcularPrecoReservaHotel();
				 		break;
				 	case 20:
				 		calcularPrecoReservaCarro();
				 		break;
				 	case 21:
				 		calcularPrecoReservaVoo();
				 		break;
				 }
			}
	    }
				 		
			public static String imprimirMenu() {
				String s = new String("Escolha uma das opções: ");
				s = s + "00 - Sair do sistema\n";
				s = s + "01 - Cadatrar usuario\n";
				s = s + "02 - Remover usuario\n";
				s = s + "03 - Listar usuarios\n";
				s = s + "04 - Editar usuario\n";
				s = s + "05 - Cadastrar passageiro\n";
				s = s + "06 - Remover passageiro\n";
				s = s + "07 - Listar passageiros\n";
				s = s + "08 - Editar passageiro\n";
				s = s + "09 - Cadastrar pagamento\n";
				s = s + "10 - Remover pagamento\n";
				s = s + "11 - Listar pagamento\n";
				s = s + "12 - Editar pagamento\n";
				s = s + "13 - Cadastrar reserva de hotel\n";
				s = s + "14 - Listar reservas de hotel\n";
				s = s + "15 - Cadastrar reserva de carro\n";
				s = s + "16 - Listar reservas de carro\n";
				s = s + "17 - Cadastrar reserva de voo\n";
				s = s + "18 - Listar reservas de voo\n";
				s = s + "19 - Calcular preco de uma reserva de hotel\n";
				s = s + "20 - Calcular preco de uma reserva de carro\n";
				s = s + "21 - Calcular preco de uma reserva de voo\n";
				return s;
			}
			
//			metodos usuario
			
			public static boolean cadastrarUsuario() {
		        Usuario u = lerDadosUsuario();
		        if (dados.getNumUsuarios() < 100) {
		        	dados.addUsuario(u);
		            System.out.println("Usuário cadastrado com sucesso!\n");
		            return true;
		        } else {
		            System.out.println("Não foi possível cadastrar o usuário!\n");
		            return false;
		        }
		    }

		    public static Usuario lerDadosUsuario() {
		        String email;
		        String nome;
		        String sexo;
		        String nacionalidade;
		        String dtNascimento;

		        in.nextLine(); // Esvazia dados do teclado
		        System.out.println("Digite o email do usuário:");
		        email = in.nextLine();
		        System.out.println("Digite o nome do usuário:");
		        nome = in.nextLine();
		        System.out.println("Digite o sexo do usuário:");
		        sexo = in.nextLine();
		        System.out.println("Digite a nacionalidade do usuário:");
		        nacionalidade = in.nextLine();
		        System.out.println("Digite a data de nascimento do usuário:");
		        dtNascimento = in.nextLine();

		        Usuario u = new Usuario(email, nome, sexo, nacionalidade, dtNascimento);
		        return u;
		    }
		
		    public static void removerUsuario() {
		        System.out.println("Escolha um dos usuários a seguir para ser removido:\n");
		        listarUsuarios();
		        int i = in.nextInt();
		        if (i < dados.getNumUsuarios() && i >= 0) {
		            swapListaUsuarios(i);
		            dados.setUsuario(dados.getNumUsuarios(), null);
		            dados.setNumUsuarios(dados.getNumUsuarios() - 1);
		            System.out.println("Usuário removido com sucesso");
		        } else {
		            System.out.println("Você escolheu um número inválido!");
		        }
		    }

		    public static void swapListaUsuarios(int u) {
		        for (int i = u; i < dados.getNumUsuarios() - 1; i++) {
		            dados.setUsuario(i, dados.getUsuario(i + 1));
		        }
		    }

		    public static void listarUsuarios() {
		        in.nextLine(); 
		        for (int i = 0; i < dados.getNumUsuarios(); i++)
		            System.out.println(i + " -> " + dados.getUsuarios()[i].getNome());
		    }
		    
		    public static void editarUsuario(int i, Usuario u) {
		        if (i < dados.getNumUsuarios() && i >= 0) {
		            dados.setUsuario(i, u);
		            System.out.println("Dados do usuário editados com sucesso");
		        } else {
		            System.out.println("Você escolheu um número inválido!");
		        }
		    }
		    
//		    metodos passageiros
		    		 		    
		    public static boolean cadastrarPassageiro() {
		        System.out.println("Escolha um dos usuários para cadastrar o passageiro:\n");
		        listarUsuarios();
		        int aux = in.nextInt();

		        if (aux >= 0 && aux < dados.getNumUsuarios()) {
		            usuarioSelecionado = dados.getUsuarios()[aux];
		        } else {
		            System.out.println("Escolha de usuário inválida!");
		            return false;
		        }

		        Passageiro passageiro = lerDadosPassageiro();
		        
		        if (usuarioSelecionado.getNumPassageiros() < 100) {
		            dados.addPassageiro(passageiro);
		            usuarioSelecionado.addPassageiro(passageiro);
		            System.out.println("Passageiro cadastrado com sucesso!\n");
		            // System.out.println(usuarioSelecionado.verPassageiros());
		            return true;
		        } else {
		            System.out.println("Não foi possível cadastrar o passageiro!\n");
		            return false;
		        }
		    }

		    public static Passageiro lerDadosPassageiro() {
		        String nome;
		        String sexo;
		        String nacionalidade;
		        String dtNascimento;

		        in.nextLine(); 
		        System.out.println("Digite o nome do passageiro:");
		        nome = in.nextLine();
		        System.out.println("Digite o sexo do passageiro:");
		        sexo = in.nextLine();
		        System.out.println("Digite a nacionalidade do passageiro:");
		        nacionalidade = in.nextLine();
		        System.out.println("Digite a data de nascimento do passageiro:");
		        dtNascimento = in.nextLine();

		        Passageiro p = new Passageiro(nome, sexo, nacionalidade, dtNascimento);
		        return p;
		    }
		    		    
		    public static void removerPassageiro() {
		        listarPassageiros();
		        System.out.println("Escolha um dos passageiros para ser removido:\n");
		        int i = in.nextInt();

		        if (i < usuarioSelecionado.getNumPassageiros() && i >= 0) {
		            for (int j = i; j < usuarioSelecionado.getNumPassageiros() - 1; j++) {
		                usuarioSelecionado.setPassageiros(j, usuarioSelecionado.getPassageiros(j + 1));
		            }

		            usuarioSelecionado.setPassageiros(usuarioSelecionado.getNumPassageiros() - 1, null);
		            usuarioSelecionado.setNumPassageiros(usuarioSelecionado.getNumPassageiros() - 1);

		            System.out.println("Passageiro removido com sucesso");
		        } else {
		            System.out.println("Você escolheu um número inválido!");
		        }
		    }
		    		    
		    public static void listarPassageiros() {
		        System.out.println("Escolha um dos usuários para listar os passageiros:\n");
		        listarUsuarios();
		        int aux = in.nextInt();

		        if (aux >= 0 && aux < dados.getNumUsuarios()) {
		            usuarioSelecionado = dados.getUsuarios()[aux];
		        } else {
		            System.out.println("Escolha de usuário inválida!");
		            return;
		        }

		        if (usuarioSelecionado.getNumPassageiros() == 0) {
		            System.out.println("Esse usuário não tem passageiros");
		        } else {
		            System.out.println(usuarioSelecionado.verPassageiros());
		        }
		    }
		    
		    public static void editarPassageiro(int i, Passageiro p) {
		        if (i < usuarioSelecionado.getNumPassageiros() && i >= 0) {
		            usuarioSelecionado.setPassageiros(i, p);
		            System.out.println("Dados do passageiro editados com sucesso");
		        } else {
		            System.out.println("Você escolheu um número inválido!");
		        }
		    }
		    
//		    metodos pagamento
		    
		    public static boolean cadastrarPagamento() {
		        System.out.println("Escolha um dos usuários para cadastrar o pagamento:\n");
		 	    listarUsuarios();
		 	    int aux = in.nextInt();
		 	    
		 	    if (aux >= 0 && aux < dados.getNumUsuarios()) {
		 	    	usuarioSelecionado = dados.getUsuarios()[aux];
		 	    }else {
		 	    	System.out.println("Escolha de usuário inválida!");
		 	    }
		        Pagamento pagamento = lerDadosPagamento();
		        if (usuarioSelecionado.getNumPagamentos() < 100) {
		            dados.addPagamento(pagamento);
		            usuarioSelecionado.addPagamento(pagamento);
		            System.out.println("Pagamento cadastrado com sucesso!\n");
		            // System.out.println(usuarioSelecionado.verPagamento());
		            return true;
		        } else {
		            System.out.println("Não foi possível cadastrar o pagamento!\n");
		            return false;
		        }
		    }

		    public static Pagamento lerDadosPagamento() {
		        int numeroCartao;
		        String dataValidade;
		        String nome;
		        String bandeira;
		        String enderecoCobranca;
		        		    	
		        System.out.println("Digite o número do cartão:");
		        numeroCartao = in.nextInt();
		        in.nextLine(); // Limpar o buffer do teclado
		        System.out.println("Digite a data de validade:");
		        dataValidade = in.nextLine();
		        System.out.println("Digite o nome:");
		        nome = in.nextLine();
		        System.out.println("Digite a bandeira:");
		        bandeira = in.nextLine();
		        System.out.println("Digite o endereço de cobrança:");
		        enderecoCobranca = in.nextLine();

		        return new Pagamento(numeroCartao, dataValidade, nome, bandeira, enderecoCobranca);
		    }
		    
		    public static void removerPagamento() {
		        listarPagamentos();
		        System.out.println("Escolha um dos pagamentos para ser removido:\n");
		        int i = in.nextInt();
		        
		        if (i < usuarioSelecionado.getNumPagamentos() && i >= 0) {
		            for (int j = i; j < usuarioSelecionado.getNumPagamentos() - 1; j++) {
		                usuarioSelecionado.setPagamentos(j, usuarioSelecionado.getPagamentos(j + 1));
		            }
		            
		            usuarioSelecionado.setPagamentos(usuarioSelecionado.getNumPagamentos() - 1, null);
		            usuarioSelecionado.setNumPagamentos(usuarioSelecionado.getNumPagamentos() - 1);
		            
		            System.out.println("Pagamento removido com sucesso");
		        } else {
		            System.out.println("Você escolheu um número inválido!");
		        }
		    }
		    
		    public static void editarPagamento(int i, Pagamento p) {
		    	if (i < usuarioSelecionado.getNumPagamentos() && i >= 0) {
		            usuarioSelecionado.setPagamentos(i, p);
		            System.out.println("Dados do pagamento editados com sucesso");
		        } else {
		            System.out.println("Você escolheu um número inválido!");
		        }
		    }

		    public static void listarPagamentos() {
		    	 System.out.println("Escolha um dos usuários para listar os pagamentos:\n");
			 	    listarUsuarios();
			 	    int aux = in.nextInt();
			 	    
			 	    if (aux >= 0 && aux < dados.getNumUsuarios()) {
			 	    	usuarioSelecionado = dados.getUsuarios()[aux];
			 	    }else {
			 	    	System.out.println("Escolha de usuário inválida!");
			 	    }
			 	    
			 	   if (usuarioSelecionado.getNumPagamentos()==0) {
			        	System.out.println("Esse usuario nao tem pagamento");
			        }else {
			        	System.out.println(usuarioSelecionado.verPagamentos());;
			        }
			}
			 			    
//		  métodos de reserva hotel 
		    	    
		    public static boolean cadastrarReservaHotel() {
		        ReservaHotel reservaHotel = lerDadosReservaHotel();
		        if (usuarioSelecionado.getNumReservasHotel() < 100) {
		            dados.addReservaHotel(reservaHotel);
					usuarioSelecionado.addReservaHotel(reservaHotel);
		            System.out.println("Reserva de hotel cadastrada com sucesso!\n");
//		            System.out.println(usuarioSelecionado.verReservaHotel());
		            return true;
		        } else {
		            System.out.println("Não foi possível cadastrar a reserva de hotel!\n");
		            return false;
		        }
		    }
		    
		    public static ReservaHotel lerDadosReservaHotel() {
		    	double preco;
		    	String dataEntradaString;
		    	String dataSaidaString;
		    	Pagamento pagamentoSelecionado = null;
		    	String nomeHotel;
		    	String localizacaoHotel;
		    	int numHospedes;
		    	String tipoDeQuarto;
		    		    	
		    	System.out.println("Escolha um dos usuários para realizar a reserva:\n");
		 	    listarUsuarios();
		 	    int aux = in.nextInt();
		 	    
		 	    if (aux >= 0 && aux < dados.getNumUsuarios()) {
		 	    	usuarioSelecionado = dados.getUsuarios()[aux];
		 	    }else {
		 	    	System.out.println("Escolha de usuário inválida!");
		 	    }
		 	    
		 	    System.out.println("Escolha um dos pagamentos:\n");
		 	    listarPagamentos();
		 	    aux = in.nextInt();
		 	    if (aux >= 0 && aux < dados.getNumUsuarios()) {
		 	    	pagamentoSelecionado = dados.getPagamentos()[aux];
		 	    }else {
		 	    	System.out.println("Escolha de pagamento inválida!");
		 	    }
			 	   
		 	    
		 	    System.out.println("Digite o preco da reserva: ");
		        preco = in.nextDouble();
		        
		        in.nextLine();
		        
		        System.out.println("Digite a data de entrada(Observacao: escreva no formato dd/MM/yyyy): ");
		        dataEntradaString = in.nextLine();
		        
		        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		        Date dataEntrada = null;
		        
		        try {

		            dataEntrada = formato.parse(dataEntradaString);

		        } catch (ParseException e) {
		        	System.out.println("Formato de data inválido. Certifique-se de usar o formato especificado.");
		        	return null;
		        }
		        
		        System.out.println("Digite a data de saida(Observação: escreva no formato dd/MM/yyyy):");
		        dataSaidaString = in.nextLine();
		        
		        Date dataSaida = null;
		        
		        try {

		            dataSaida = formato.parse(dataSaidaString);

		        } catch (ParseException e) {
		            System.out.println("Formato de data inválido. Certifique-se de usar o formato especificado.");
		            return null;
		        }
		        
		    	System.out.println("Digite o nome do hotel:");
		        nomeHotel = in.nextLine();
		        System.out.println("Digite a localização do hotel:");
		        localizacaoHotel = in.nextLine();
		        System.out.println("Digite o número de hóspedes:");
		        numHospedes = in.nextInt();
		        in.nextLine(); // Limpar o buffer do teclado
		        System.out.println("Digite o tipo de quarto:");
		        tipoDeQuarto = in.nextLine();

		        ReservaHotel reservaHotel = new ReservaHotel(preco, dataEntrada, dataSaida, pagamentoSelecionado, nomeHotel, localizacaoHotel, numHospedes, tipoDeQuarto);

		        return reservaHotel;
		    }
		   	    		    
		    public static void listarReservasHotel() {
		    	System.out.println("Escolha um dos usuários para listar as reservas:\n");
		 	    listarUsuarios();
		 	    int aux = in.nextInt();
		 	    
		 	    if (aux >= 0 && aux < dados.getNumUsuarios()) {
		 	    	usuarioSelecionado = dados.getUsuarios()[aux];
		 	    }else {
		 	    	System.out.println("Escolha de usuário inválida!");
		 	    }
		 	    
		 	    if (usuarioSelecionado.getNumReservasHotel()==0) {
		        	System.out.println("Esse usuario nao tem reservas");
		        }else {
		        	System.out.println(usuarioSelecionado.verReservaHotel());;
		        }
		    }
		    
//		    metodos reserva carro
		    
		    public static boolean cadastrarReservaCarro() {
		        ReservaCarro reservaCarro = lerDadosReservaCarro();
		        if (usuarioSelecionado.getNumReservasCarro() < 100) {
		            dados.addReservaCarro(reservaCarro);
		            usuarioSelecionado.addReservaCarro(reservaCarro);
		            System.out.println("Reserva de carro cadastrada com sucesso!\n");
		            // System.out.println(usuarioSelecionado.verReservaCarro());
		            return true;
		        } else {
		            System.out.println("Não foi possível cadastrar a reserva de carro!\n");
		            return false;
		        }
		    }

		    public static ReservaCarro lerDadosReservaCarro() {
		        double preco;
		        String dataEntradaString;
		        String dataSaidaString;
		        Pagamento pagamentoSelecionado = null;
		        String localRetirada;
		        String horaRetirada;
		        String horaEntrega;

		        System.out.println("Escolha um dos usuários para realizar a reserva:\n");
		 	    listarUsuarios();
		 	    int aux = in.nextInt();
		 	    
		 	    if (aux >= 0 && aux < dados.getNumUsuarios()) {
		 	    	usuarioSelecionado = dados.getUsuarios()[aux];
		 	    }else {
		 	    	System.out.println("Escolha de usuário inválida!");
		 	    }
		 	    
		 	    System.out.println("Escolha um dos pagamentos:\n");
		 	    listarPagamentos();
		 	    aux = in.nextInt();
		 	    if (aux >= 0 && aux < dados.getNumUsuarios()) {
		 	    	pagamentoSelecionado = dados.getPagamentos()[aux];
		 	    }else {
		 	    	System.out.println("Escolha de pagamento inválida!");
		 	    }
			 	   
		 	    
		 	    System.out.println("Digite o preco da reserva: ");
		        preco = in.nextDouble();
		        
		        in.nextLine();
		        
		        System.out.println("Digite a data de retirada(Observacao: escreva no formato dd/MM/yyyy): ");
		        dataEntradaString = in.nextLine();
		        
		        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		        Date dataEntrada = null;
		        
		        try {

		            dataEntrada = formato.parse(dataEntradaString);

		        } catch (ParseException e) {
		        	System.out.println("Formato de data inválido. Certifique-se de usar o formato especificado.");
		        	return null;
		        }
		        
		        System.out.println("Digite a data de entrega(Observação: escreva no formato dd/MM/yyyy):");
		        dataSaidaString = in.nextLine();
		        
		        Date dataSaida = null;
		        
		        try {

		            dataSaida = formato.parse(dataSaidaString);

		        } catch (ParseException e) {
		            System.out.println("Formato de data inválido. Certifique-se de usar o formato especificado.");
		            return null;
		        }
		        		        
		    	System.out.println("Digite o local de retirada:");
		    	localRetirada = in.nextLine();
		        System.out.println("Digite a hora de retirada:");
		        horaRetirada = in.nextLine();
		        System.out.println("Digite a hora de entrega:");
		        horaEntrega = in.nextLine();

		        ReservaCarro reservaCarro = new ReservaCarro(preco, dataEntrada, dataSaida, pagamentoSelecionado, localRetirada, horaRetirada, horaEntrega);

		        return reservaCarro;
		    }

		    public static void listarReservasCarro() {
		        System.out.println("Escolha um dos usuários para listar as reservas de carro:\n");
		        listarUsuarios();
		        int aux = in.nextInt();

		        if (aux >= 0 && aux < dados.getNumUsuarios()) {
		            usuarioSelecionado = dados.getUsuarios()[aux];
		        } else {
		            System.out.println("Escolha de usuário inválida!");
		        }

		        if (usuarioSelecionado.getNumReservasCarro() == 0) {
		            System.out.println("Esse usuário não tem reservas de carro");
		        } else {
		            System.out.println(usuarioSelecionado.verReservaCarro());
		        }
		    }
    
//		    metodos reservaVoo
		    
		    public static boolean cadastrarReservaVoo() {
		        ReservaVoo reservaVoo = lerDadosReservaVoo();
		        if (usuarioSelecionado.getNumReservasVoo() < 100) {
		            dados.addReservaVoo(reservaVoo);
		            usuarioSelecionado.addReservaVoo(reservaVoo);
		            System.out.println("Reserva de voo cadastrada com sucesso!\n");
		            // System.out.println(usuarioSelecionado.verReservaVoo());
		            return true;
		        } else {
		            System.out.println("Não foi possível cadastrar a reserva de voo!\n");
		            return false;
		        }
		    }

		    public static ReservaVoo lerDadosReservaVoo() {
		        double preco;
		        Pagamento pagamentoSelecionado = null;
		        String origem;
		        String destino;
		        String dataIdaString;
		        String dataVoltaString;
		        int numPassageiros;
		        boolean idaEVolta;

		        System.out.println("Escolha um dos usuários para realizar a reserva:\n");
		 	    listarUsuarios();
		 	    int aux = in.nextInt();
		 	    
		 	    if (aux >= 0 && aux < dados.getNumUsuarios()) {
		 	    	usuarioSelecionado = dados.getUsuarios()[aux];
		 	    }else {
		 	    	System.out.println("Escolha de usuário inválida!");
		 	    }
		 	    
		 	    System.out.println("Escolha um dos pagamentos:\n");
		 	    listarPagamentos();
		 	    aux = in.nextInt();
		 	    if (aux >= 0 && aux < dados.getNumUsuarios()) {
		 	    	pagamentoSelecionado = dados.getPagamentos()[aux];
		 	    }else {
		 	    	System.out.println("Escolha de pagamento inválida!");
		 	    }
			 	   
		 	    
		 	    System.out.println("Digite o preco da reserva: ");
		        preco = in.nextDouble();
		        
		        in.nextLine();
		        
		        System.out.println("Digite a data de ida(Observacao: escreva no formato dd/MM/yyyy): ");
		        dataIdaString = in.nextLine();
		        
		        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		        Date dataIda = null;
		        
		        try {

		            dataIda = formato.parse(dataIdaString);

		        } catch (ParseException e) {
		        	System.out.println("Formato de data inválido. Certifique-se de usar o formato especificado.");
		        	return null;
		        }
		        
		        System.out.println("Digite a data de volta(Observação: escreva no formato dd/MM/yyyy, caso seja apenas ida, digite 00/00/0000):");
		        dataVoltaString = in.nextLine();
		        
		        Date dataVolta = null;
		        
		        try {

		            dataVolta = formato.parse(dataVoltaString);

		        } catch (ParseException e) {
		            System.out.println("Formato de data inválido. Certifique-se de usar o formato especificado.");
		            return null;
		        }
		        
		        System.out.println("Digite o local de origem:");
		    	origem = in.nextLine();
		        System.out.println("Digite o destino:");
		        destino = in.nextLine();
		        System.out.println("Digite o numero de passageiros:");
		        numPassageiros = in.nextInt();
		        System.out.println("A reserva é de ida e volta? (Digite 'true' para sim, 'false' para não):");
		        idaEVolta = in.nextBoolean();
		        in.nextLine();
		        
		        ReservaVoo reservaVoo = new ReservaVoo(preco, pagamentoSelecionado, origem, destino, dataIda, dataVolta, numPassageiros, idaEVolta);

		        return reservaVoo;
		    }

		    public static void listarReservasVoo() {
		    	
		        System.out.println("Escolha um dos usuários para listar as reservas de voo:\n");
		        listarUsuarios();
		        int aux = in.nextInt();

		        if (aux >= 0 && aux < dados.getNumUsuarios()) {
		            usuarioSelecionado = dados.getUsuarios()[aux];
		        } else {
		            System.out.println("Escolha de usuário inválida!");
		        }

		        if (usuarioSelecionado.getNumReservasVoo() == 0) {
		            System.out.println("Esse usuário não tem reservas de voo");
		        } else {
		            System.out.println(usuarioSelecionado.verReservaVoo());
		        }
		    }
		    
//		    metodos de calcular preco
		    
		    public static void calcularPrecoReservaHotel() {	
		    	listarReservasHotel();
		    	System.out.println("Escolha uma reserva para calcular o preco\n");
		        int aux = in.nextInt();
		        System.out.println(usuarioSelecionado.getReservasHotel(aux).calcularPrecoTotal());
		    }
		    
		    public static void calcularPrecoReservaCarro() {	
		    	listarReservasCarro();
		    	System.out.println("Escolha uma reserva para calcular o preco\n");
		        int aux = in.nextInt();
		        System.out.println(usuarioSelecionado.getReservasCarro(aux).calcularPrecoTotal());
		    }
		    
		    public static void calcularPrecoReservaVoo() {	
		    	listarReservasHotel();
		    	System.out.println("Escolha uma reserva para calcular o preco\n");
		        int aux = in.nextInt();
		        System.out.println(usuarioSelecionado.getReservasVoo(aux).calcularPrecoTotal());
		    }
		        	
}