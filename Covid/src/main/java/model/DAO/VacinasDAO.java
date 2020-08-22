package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.VO.PesquisadorVO;
import model.VO.VacinaVO;

public class VacinasDAO {
	
	public int cadastrarVacina(VacinaVO vacina) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "INSERT INTO `vacinas` VALUES (NULL, '"
				+ vacina.getPaisOrigem() +"', "
				+ vacina.getEstagioPesquisa() +", '"
				+ vacina.getDataInicioPesquisa() +") "
				+ vacina.getPesquisador().getId() +")"; 

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar vacina.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public int excluirVacina(int idVacina) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "DELETE FROM `vacinas` WHERE id = " + idVacina;

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao excluir vacina");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public int alterarVacina(VacinaVO vacina, int idVacina) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "UPDATE `vacinas` SET "
				+ "PAIS = '"+vacina.getPaisOrigem()+"', "
				+ "ESTAGIO = "+vacina.getEstagioPesquisa()+", "
				+ "DATAINICIO = '"+vacina.getDataInicioPesquisa()+"', "
				+ "PESQUISADOR = "+vacina.getPesquisador().getId()+" WHERE ID = " + idVacina;

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao alterar vacina");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public VacinaVO encontrarVacina(int idVacina) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		VacinaVO vacina = new VacinaVO();
		PesquisadorVO pesquisador = new PesquisadorVO();
		String query = "SELECT * FROM `vacinas` WHERE ID = " + idVacina;

		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				vacina.setId(Integer.parseInt(resultado.getString("ID")));
				vacina.setPaisOrigem(resultado.getString("PAIS"));
				vacina.setEstagioPesquisa(Integer.parseInt(resultado.getString("ESTAGIO")));
				vacina.setDataInicioPesquisa(resultado.getString("DATAINICIO"));
				pesquisador.setId(Integer.parseInt(resultado.getString("PESQUISADOR")));
				vacina.setPesquisador(pesquisador);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar vacina");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			Banco.closeResultSet(resultado);
		}
		return vacina;
	}

	public ArrayList<VacinaVO> listarVacinas() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		VacinaVO vacina = new VacinaVO();
		PesquisadorVO pesquisador = new PesquisadorVO();
		ArrayList<VacinaVO> listaDeVacinas = new ArrayList();
		String query = "SELECT * FROM `vacinas`";

		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {

				vacina.setId(Integer.parseInt(resultado.getString("ID")));
				vacina.setPaisOrigem(resultado.getString("PAIS"));
				vacina.setEstagioPesquisa(Integer.parseInt(resultado.getString("ESTAGIO")));
				vacina.setDataInicioPesquisa(resultado.getString("DATAINICIO"));
				pesquisador.setId(Integer.parseInt(resultado.getString("PESQUISADOR")));
				vacina.setPesquisador(pesquisador);

				listaDeVacinas.add(vacina);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar todas as vacinas");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaDeVacinas;

}
}
