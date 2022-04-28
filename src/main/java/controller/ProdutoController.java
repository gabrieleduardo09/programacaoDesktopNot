package controller;

import java.io.IOException;

import model.bo.ProdutoBO;
import model.vo.ProdutoVO;

public class ProdutoController {

	public ProdutoVO cadastrarProdutoController(ProdutoVO produtoVO) throws IOException {
		ProdutoBO produtoBO = new ProdutoBO();
		return produtoBO.cadastrarProdutoBO(produtoVO);
	}

	public ProdutoVO listarProdutoPorCodigoController(ProdutoVO produtoVO) throws IOException  {
		ProdutoBO produtoBO = new ProdutoBO();
		return produtoBO.listarProdutoPorCodigoBO(produtoVO);
	}

	public String listarTodosProdutosController() throws IOException {
		ProdutoBO produtoBO = new ProdutoBO();
		return produtoBO.listarTodosProdutosBO();
	}

	public String excluirProdutoPorCodigoController(String codigo) throws IOException {
		ProdutoBO produtoBO = new ProdutoBO();
		return produtoBO.excluirProdutoPorCodigoBO(codigo);
	}

}
