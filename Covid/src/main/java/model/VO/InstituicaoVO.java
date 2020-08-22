package model.VO;

public class InstituicaoVO {
	
	private int id;
	private String nome;
	private String cnpj;
	private EnderecoVO endereco;
	
	public InstituicaoVO(int id, String nome, String cnpj, EnderecoVO endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

	public InstituicaoVO() {
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public EnderecoVO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}
	
	
	
}