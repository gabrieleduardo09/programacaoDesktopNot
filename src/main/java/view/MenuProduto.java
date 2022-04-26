package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.vo.ProdutoVO;

public class MenuProduto {

	private static final int OPCAO_MENU_CADASTRAR_PRODUTO = 1;
	private static final int OPCAO_MENU_LISTAR_PRODUTO_POR_ID = 2;
	private static final int OPCAO_MENU_LISTAR_TODOS_PRODUTOS = 3;
	private static final int OPCAO_MENU_EXCLUIR_PRODUTO = 4;
	private static final int OPCAO_MENU_SAIR = 5;

	public void apresentarMenuProduto(ProdutoVO produtoVO) throws IOException{
		byte opcao = 0;
		while (opcao >= 0) {
			String opcoesMenu = JOptionPane.showInputDialog("Menu: \n" 
					+ OPCAO_MENU_CADASTRAR_PRODUTO + " - Cadastrar produto\n" 
					+ OPCAO_MENU_LISTAR_PRODUTO_POR_ID + " - Listar produto por código\n" 
					+ OPCAO_MENU_LISTAR_TODOS_PRODUTOS + " - Listar todos os produtos\n" 
					+ OPCAO_MENU_EXCLUIR_PRODUTO + " - Excluir produto\n" 
					+ OPCAO_MENU_SAIR + " - Encerrar o programa");

			if (opcoesMenu == null || opcoesMenu.equals("") || opcoesMenu.equals("5")) {
				opcao = -1;
			}
			
			try {
				opcao = Byte.parseByte(opcoesMenu);
				switch (opcao) {
				case OPCAO_MENU_CADASTRAR_PRODUTO:
					break;
				case OPCAO_MENU_LISTAR_PRODUTO_POR_ID:
					break;
				case OPCAO_MENU_LISTAR_TODOS_PRODUTOS:
					break;
				case OPCAO_MENU_EXCLUIR_PRODUTO:
					break;
				case OPCAO_MENU_SAIR:
					break;
				default:
					opcao = -1;				
				}
			} catch(NumberFormatException e) {
				opcao = -1;
				e.printStackTrace();
			}
		}

	}

}
