package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.VO.EnderecoVO;
import model.VO.InstituicaoVO;

public class InstituicaoDAO {
	
	public int cadastrarInstituicao(InstituicaoVO instituicao) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "INSERT INTO `instituicao` VALUES (" +
				"NULL, '"
				+ instituicao.getNome() + "','"
				+ instituicao.getCnpj() + "','"
				+ instituicao.getEndereco().getRua() + "','"
				+ instituicao.getEndereco().getNumero() + "','"
				+ instituicao.getEndereco().getBairro() + "','"
				+ instituicao.getEndereco().getCidade() + "','"
				+ instituicao.getEndereco().getEstado() + "'"
				+ ")";

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar instituição");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}
	
	public int excluirInstituicao(int idInstituicao) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "DELETE FROM `instituicao` WHERE id = " + idInstituicao;

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao excluir instituição");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}
	
	public int alterarInstituicao(InstituicaoVO instituicao, int idInstituicao) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "UPDATE `instituicao` SET NOME = '"
				+ instituicao.getNome() + "', CNPJ = '"
				+ instituicao.getCnpj() +"', RUA = '"
				+ instituicao.getEndereco().getRua() +"', NUMERO = '"
				+ instituicao.getEndereco().getNumero()+"', BAIRRO = '"
				+ instituicao.getEndereco().getBairro()+"', CIDADE = '"
				+ instituicao.getEndereco().getCidade()+"', ESTADO = '"
				+ instituicao.getEndereco().getEstado()+"'"
				+ " WHERE ID = " + idInstituicao;

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao alterar instituição");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}
	
	public InstituicaoVO encontrarInstituicao(int idInstituicao) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		InstituicaoVO instituicao = new InstituicaoVO();
		EnderecoVO endereco = new EnderecoVO();
		String query = "SELECT * FROM `instituicao` WHERE ID = " + idInstituicao;

		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				instituicao.setId(Integer.parseInt(resultado.getString("ID")));
				instituicao.setNome(resultado.getString("NOME"));
				instituicao.setCnpj(resultado.getString("CNPJ"));
				endereco.setRua(resultado.getString("RUA"));
				endereco.setNumero(resultado.getString("NUMERO"));
				endereco.setBairro(resultado.getString("BAIRRO"));
				endereco.setCidade(resultado.getString("CIDADE"));
				endereco.setEstado(resultado.getString("ESTADO"));
				instituicao.setEndereco(endereco);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar instituição");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			Banco.closeResultSet(resultado);
		}
		return instituicao;
	}

	public ArrayList<InstituicaoVO> listarInstituicoes() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		InstituicaoVO instituicao = new InstituicaoVO();
		EnderecoVO endereco = new EnderecoVO();
		ArrayList<InstituicaoVO> listaDeInstituicoes = new ArrayList();
		String query = "SELECT * FROM `instituicao`";

		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {

				instituicao.setId(Integer.parseInt(resultado.getString("ID")));
				instituicao.setNome(resultado.getString("NOME"));
				instituicao.setCnpj(resultado.getString("CNPJ"));
				endereco.setRua(resultado.getString("RUA"));
				endereco.setNumero(resultado.getString("NUMERO"));
				endereco.setBairro(resultado.getString("BAIRRO"));
				endereco.setCidade(resultado.getString("CIDADE"));
				endereco.setEstado(resultado.getString("ESTADO"));
				instituicao.setEndereco(endereco);

				listaDeInstituicoes.add(instituicao);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar todas as instituições");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaDeInstituicoes;
	}

}

