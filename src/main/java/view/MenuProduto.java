package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ProdutoController;
import model.vo.ProdutoVO;

public class MenuProduto {

	private static final int OPCAO_MENU_CADASTRAR_PRODUTO = 1;
	private static final int OPCAO_MENU_LISTAR_PRODUTO_POR_CODIGO = 2;
	private static final int OPCAO_MENU_LISTAR_TODOS_PRODUTOS = 3;
	private static final int OPCAO_MENU_EXCLUIR_PRODUTO_POR_CODIGO = 4;
	private static final int OPCAO_MENU_SAIR = 5;

	public void apresentarMenuProduto(ProdutoVO produtoVO) throws IOException{
		byte opcao = 0;
		while (opcao >= 0) {
			String opcoesMenu = JOptionPane.showInputDialog("Menu: \n" 
					+ OPCAO_MENU_CADASTRAR_PRODUTO + " - Cadastrar produto\n" 
					+ OPCAO_MENU_LISTAR_PRODUTO_POR_CODIGO + " - Listar produto por código\n" 
					+ OPCAO_MENU_LISTAR_TODOS_PRODUTOS + " - Listar todos os produtos\n" 
					+ OPCAO_MENU_EXCLUIR_PRODUTO_POR_CODIGO + " - Excluir produto\n" 
					+ OPCAO_MENU_SAIR + " - Encerrar o programa");

			if (opcoesMenu == null || opcoesMenu.equals("") || opcoesMenu.equals("5")) {
				opcao = -1;
			}
			
			try {
				opcao = Byte.parseByte(opcoesMenu);
				switch (opcao) {
				case OPCAO_MENU_CADASTRAR_PRODUTO:
					this.cadastrarProduto(produtoVO);
					break;
				case OPCAO_MENU_LISTAR_PRODUTO_POR_CODIGO:
					this.listarProdutoPorCodigo();
					break;
				case OPCAO_MENU_LISTAR_TODOS_PRODUTOS:
					this.listarTodosProdutos();
					break;
				case OPCAO_MENU_EXCLUIR_PRODUTO_POR_CODIGO:
					this.excluirProdutoPorCodigo();
					break;
				//case OPCAO_MENU_SAIR:
					//break;
				default:
					opcao = -1;				
				}
			} catch(NumberFormatException e) {
				opcao = -1;
				e.printStackTrace();
				//this.apresentarMenuProduto(produtoVO);
			}
		}

	}

	private void cadastrarProduto(ProdutoVO produtoVO) throws IOException {
		String nome = JOptionPane.showInputDialog("Digite o Nome do produto");
		produtoVO.setNome(nome);
		float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o Preço do Produto"));  
		produtoVO.setPreco(preco);
		short codigo = Short.parseShort(JOptionPane.showInputDialog("Digite o Código do Produto"));
		produtoVO.setCodigo(codigo);
		
		ProdutoController produtoController = new ProdutoController();
		produtoVO = produtoController.cadastrarProdutoController(produtoVO);			
		
	}

	private void  listarProdutoPorCodigo() throws IOException {
		ProdutoVO  produtoVO = new ProdutoVO(); 
		
		produtoVO.setCodigo(Short.parseShort(JOptionPane.showInputDialog("Digite o Código do produto para Apresentar")));
		
		ProdutoController produtoController = new ProdutoController();
		produtoVO = produtoController.listarProdutoPorCodigoController(produtoVO);
		
		JOptionPane.showMessageDialog(null, "NOME       PREÇO      CÓDIGO\n" + produtoVO);
	}
	
	private void listarTodosProdutos() throws IOException {
		String produtosVO = listaTodosProdutos();
		JOptionPane.showMessageDialog(null, "NOME       PREÇO      CÓDIGO\n" + produtosVO);
	}
	
	private void excluirProdutoPorCodigo() throws IOException {
		String  produtoVO = ""; 
		
		short codigo = Short.parseShort(JOptionPane.showInputDialog("Digite o Código do produto para Excluir"));
		
		produtoVO(String.valueOf(codigo));
	}

	private void produtoVO(String codigo) throws IOException {
		ProdutoController produtoControllerVO = new ProdutoController();
		produtoControllerVO.excluirProdutoPorCodigoController(codigo);
	}

	private String listaTodosProdutos() throws IOException {
		ProdutoController produtoController = new ProdutoController();
		return produtoController.listarTodosProdutosController();
	}

}
