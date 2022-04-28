package model.bo;

import java.io.IOException;

import model.dao.ProdutoDAO;
import model.vo.ProdutoVO;

public class ProdutoBO {

	public ProdutoVO cadastrarProdutoBO(ProdutoVO produtoVO) throws IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.cadastrarProdutoDAO(produtoVO);
	}

	public ProdutoVO listarProdutoPorCodigoBO(ProdutoVO produtoVO) throws IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.listarProdutoPorCodigoDAO(produtoVO.getCodigo());
	}

	public String listarTodosProdutosBO() throws IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.listarTodosProdutosDAO();
	}

	public String excluirProdutoPorCodigoBO(String codigo) throws IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.excluirProdutoPorCodigoDAO(codigo);
	}

}
