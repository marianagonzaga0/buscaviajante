package negocio;

public class Pagamento {
    private int numeroCartao;
    private String dataValidade;
    private String nome;
    private String bandeira;
    private String enderecoCobranca;

    public Pagamento(int numeroCartao, String dataValidade, String nome, String bandeira, String enderecoCobranca) {
        this.numeroCartao = numeroCartao;
        this.dataValidade = dataValidade;
        this.nome = nome;
        this.bandeira = bandeira;
        this.enderecoCobranca = enderecoCobranca;
    }

    // Getters
    public int getNumeroCartao() {
        return numeroCartao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public String getEnderecoCobranca() {
        return enderecoCobranca;
    }

    // Setters
    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public void setEnderecoCobranca(String enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

	@Override
	public String toString() {
		return "Pagamento [numeroCartao=" + numeroCartao + ", dataValidade=" + dataValidade + ", nome=" + nome
				+ ", bandeira=" + bandeira + ", enderecoCobranca=" + enderecoCobranca + "]";
	}
    
    
}

