package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.VO.EnderecoVO;
import model.VO.PesquisadorVO;

public class UsuarioDAO {
	
	public int cadastrarUsuario(PesquisadorVO usuario) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "INSERT INTO `usuario` VALUES (NULL, '"
				+ usuario.getNome() +"', '"
				+ usuario.getDataNascimento() +"', "
				+ usuario.getSexo() +", '"
				+ usuario.getCpf()+"', "
				+ usuario.getTipo()+", "
				+ usuario.isFoiVacinada()+", "
				+ usuario.getReacaoAVacina()+", '"
				+ usuario.getEndereco().getRua()+"', '"
				+ usuario.getEndereco().getNumero()+"', '"
				+ usuario.getEndereco().getBairro()+"', '"
				+ usuario.getEndereco().getCidade()+"', '"
				+ usuario.getEndereco().getEstado()+"')";

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar usuário");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}	
		return resultado;
	}

	public int excluirUsuario(int idUsuario) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "DELETE FROM `usuario` WHERE ID = " + idUsuario;

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar usuário");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int alterarUsuario(PesquisadorVO usuario, int usuarioId) {
		int resultado = 0;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "UPDATE `usuario` "
				+ "SET NOME = '"+usuario.getNome()+"', "
				+ "DATANASCIMENTO = '"+usuario.getDataNascimento()+"', "
				+ "SEXO = "+usuario.getSexo()+", "
				+ "CPF = '"+usuario.getCpf()+"', "
				+ "TIPO = "+usuario.getTipo()+", "
				+ "FOIVACINADA = "+usuario.isFoiVacinada()+", "
				+ "REACAO = "+usuario.getReacaoAVacina()+", "
				+ "RUA = '"+usuario.getEndereco().getRua()+"', "
				+ "NUMERO = '"+usuario.getEndereco().getNumero()+"', "
				+ "BAIRRO = '"+usuario.getEndereco().getBairro()+"', "
				+ "CIDADE = '"+usuario.getEndereco().getCidade()+"', "
				+ "ESTADO = '"+usuario.getEndereco().getEstado()+"' WHERE ID = " + usuarioId;

		try {
			resultado = stmt.executeUpdate(query);
		} catch(SQLException e) {
			System.out.println("Erro ao atualizar usuário");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}	

		return resultado;
	}

	public PesquisadorVO encontrarUsuario(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		PesquisadorVO usuario = new PesquisadorVO();
		EnderecoVO endereco = new EnderecoVO();
		String query = "SELECT * FROM `usuario` WHERE ID = " + idUsuario;

		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				usuario.setId(Integer.parseInt(resultado.getString("ID")));
				usuario.setNome(resultado.getString("NOME"));
				usuario.setDataNascimento(resultado.getString("DATANASCIMENTO"));
				usuario.setSexo(Integer.parseInt(resultado.getString("SEXO")));
				usuario.setCpf(resultado.getString("CPF"));
				usuario.setTipo(Integer.parseInt(resultado.getString("TIPO")));
				usuario.setFoiVacinada(Boolean.parseBoolean(resultado.getString("FOIVACINADA")));
				usuario.setReacaoAVacina(Integer.parseInt(resultado.getString("REACAO")));
				endereco.setRua(resultado.getString("RUA"));
				endereco.setNumero(resultado.getString("NUMERO"));
				endereco.setBairro(resultado.getString("BAIRRO"));
				endereco.setCidade(resultado.getString("CIDADE"));
				endereco.setEstado(resultado.getString("ESTADO"));
				usuario.setEndereco(endereco);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar usuário");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			Banco.closeResultSet(resultado);
		}
		return usuario;
	}

	public ArrayList<PesquisadorVO> listarUsuarios() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		PesquisadorVO usuario = new PesquisadorVO();
		EnderecoVO endereco = new EnderecoVO();
		ArrayList<PesquisadorVO> listaDeUsuarios = new ArrayList();
		String query = "SELECT * FROM `usuario`";

		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {

				usuario.setId(Integer.parseInt(resultado.getString("ID")));
				usuario.setNome(resultado.getString("NOME"));
				usuario.setDataNascimento(resultado.getString("DATANASCIMENTO"));
				usuario.setSexo(Integer.parseInt(resultado.getString("SEXO")));
				usuario.setCpf(resultado.getString("CPF"));
				usuario.setTipo(Integer.parseInt(resultado.getString("TIPO")));
				usuario.setFoiVacinada(Boolean.parseBoolean(resultado.getString("FOIVACINADA")));
				usuario.setReacaoAVacina(Integer.parseInt(resultado.getString("REACAO")));
				endereco.setRua(resultado.getString("RUA"));
				endereco.setNumero(resultado.getString("NUMERO"));
				endereco.setBairro(resultado.getString("BAIRRO"));
				endereco.setCidade(resultado.getString("CIDADE"));
				endereco.setEstado(resultado.getString("ESTADO"));
				usuario.setEndereco(endereco);

				listaDeUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar todos os usuários");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaDeUsuarios;
	}

}
