package view;

import model.DAO.InstituicaoDAO;
import model.DAO.UsuarioDAO;
import model.DAO.VacinasDAO;
import model.VO.EnderecoVO;
import model.VO.InstituicaoVO;
import model.VO.PesquisadorVO;
import model.VO.VacinaVO;

public class Aplicativo {

	public static void main(String[] args) {
		
		// cadastro de instituição 
		EnderecoVO endereco = new EnderecoVO();
		endereco.setRua("Rua Leonel Pereira Nelito");
		endereco.setNumero("1350");
		endereco.setBairro("Cachoeira do Bom Jesus");
		endereco.setCidade("Florianópolis");
		endereco.setEstado("SC");

		InstituicaoVO instituicao = new InstituicaoVO();
		instituicao.setNome("Hospital do centro da Ilha");
		instituicao.setCnpj("12345678/91");
		instituicao.setEndereco(endereco);

		// cadastro de vacina
		
		PesquisadorVO pesquisador = new PesquisadorVO();
		pesquisador.setId(2);

		VacinaVO vacina = new VacinaVO();
		vacina.setPaisOrigem("CHINA");
		vacina.setEstagioPesquisa(1);
		vacina.setDataInicioPesquisa("2020-08-22");
		vacina.setPesquisador(pesquisador);

		// cadastro de usuário
		PesquisadorVO usuario = new PesquisadorVO();
		usuario.setNome("ORLANDO DA SILVA");
		usuario.setDataNascimento("1955-04-16");
		usuario.setSexo(1);
		usuario.setCpf("05546689978");
		usuario.setTipo(1);
		usuario.setFoiVacinada(false);
		usuario.setReacaoAVacina(3);
		
		EnderecoVO enderecoUsuario = new EnderecoVO();
		enderecoUsuario.setRua("Rua das corujas");
		enderecoUsuario.setNumero("116");
		enderecoUsuario.setBairro("Canasvieras");
		enderecoUsuario.setCidade("Florianópolis");
		enderecoUsuario.setEstado("SC");
		usuario.setEndereco(enderecoUsuario);

		
		InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		VacinasDAO vacinaDAO = new VacinasDAO();

		// OPERAÇÕES DE CRUD EM INSTITUIÇÃO 
		
		// cadastra a instituição 
		//instituicaoDAO.cadastrarInstituicao(instituicao);

		// altera instituição passando um objeto instituição e o ID dela no banco de dados 
		//instituicaoDAO.alterarInstituicao(instituicao, 1);

		// retorna uma instituição usando o ID como parâmetro 
		/*InstituicaoVO inst = instituicaoDAO.encontrarInstituicao(1);
		System.out.println(	inst.getNome());*/ 
		
		// retorna um arraylist de instituições com todas as instituições 
		//instituicaoDAO.listarInstituicoes();

		// exclui instituição usando o ID como parâmetro */
		//instituicaoDAO.excluirInstituicao(3);
		
		
		

		// OPERAÇÕES DE CRUD EM USUARIO 
		
		// cadastra usuário 
		//usuarioDAO.cadastrarUsuario(usuario);

		// exclui um usuário pelo ID 
		//usuarioDAO.excluirUsuario(1);

		// alterar usuário pelo ID 
		//usuarioDAO.alterarUsuario(usuario, 2);

		// encontrar usuário pelo ID 
		//usuarioDAO.encontrarUsuario(2);

		// listar todos os usuários 
		//usuarioDAO.listarUsuarios();
		
		
		

		// OPERAÇÕES DE CRUD EM VACINAS
		
		//cadastrar vacina 
		//vacinaDAO.cadastrarVacina(vacina);

		// excluir vacina pelo ID 
		//vacinaDAO.excluirVacina(2);

		// alterar vacina através do ID 
		//vacinaDAO.alterarVacina(vacina, 3);

		// encontrarvacina através do IF 
		//vacinaDAO.encontrarVacina(1);

		// lista todas as vacinas 
		//vacinaDAO.listarVacinas();

	}


	}


	

