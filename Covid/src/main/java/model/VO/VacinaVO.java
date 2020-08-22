package model.VO;


public class VacinaVO {
	
	private int id;
	private String paisOrigem;
	private int estagioPesquisa;
	private String dataInicioPesquisa;
	private PesquisadorVO pesquisador;
	
	public VacinaVO(int id, String paisOrigem, int estagioPesquisa, String dataInicioPesquisa,
			PesquisadorVO pesquisador) {
		super();
		this.id = id;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.dataInicioPesquisa = dataInicioPesquisa;
		this.pesquisador = pesquisador;
	}

	public VacinaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public int getEstagioPesquisa() {
		return estagioPesquisa;
	}

	public void setEstagioPesquisa(int estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}

	public String getDataInicioPesquisa() {
		return dataInicioPesquisa;
	}

	public void setDataInicioPesquisa(String dataInicioPesquisa) {
		this.dataInicioPesquisa = dataInicioPesquisa;
	}

	public PesquisadorVO getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(PesquisadorVO pesquisador) {
		this.pesquisador = pesquisador;
	}

	
}