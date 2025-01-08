package negocio;

public class Passageiro {
	private String nome;
	private String sexo;
	private String nacionalidade;
	private String dataNascimento;
	
	public Passageiro(String nome, String sexo, String nacionalidade, String dataNascimento) {
		this.nome = nome;
		this.sexo = sexo;
		this.nacionalidade = nacionalidade;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Passageiro [nome=" + nome + ", sexo=" + sexo + ", nacionalidade=" + nacionalidade + ", dataNascimento="
				+ dataNascimento + "]";
	}
	
	
}
