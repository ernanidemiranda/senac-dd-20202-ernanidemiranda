package model.VO;


public class PessoaVO {
	
	
	private int id;
	private String nome;
	private String dataNascimento;
	private int sexo;
	private String cpf;
	private boolean foiVacinada;
	private int reacaoAVacina;
	private EnderecoVO endereco;
	private int tipo;
	
	public PessoaVO(int id, String nome, String dataNascimento, int sexo, String cpf, boolean foiVacinada,
			int reacaoAVacina, EnderecoVO endereco, int tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.foiVacinada = foiVacinada;
		this.reacaoAVacina = reacaoAVacina;
		this.endereco = endereco;
		this.tipo = tipo;
	}

	public PessoaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isFoiVacinada() {
		return foiVacinada;
	}

	public void setFoiVacinada(boolean foiVacinada) {
		this.foiVacinada = foiVacinada;
	}

	public int getReacaoAVacina() {
		return reacaoAVacina;
	}

	public void setReacaoAVacina(int reacaoAVacina) {
		this.reacaoAVacina = reacaoAVacina;
	}

	public EnderecoVO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
}