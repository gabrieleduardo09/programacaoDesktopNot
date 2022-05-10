package executavel;

import java.io.IOException;

import model.vo.ProdutoVO;
import view.MenuProduto;
import view.TelaMenuPrincipal;

public class Executavel {

	public static void main(String[] args) throws IOException {

		ProdutoVO produtoVO = new ProdutoVO();
		MenuProduto menuProduto = new MenuProduto();
		menuProduto.apresentarMenuProduto(produtoVO);
		//TelaMenuPrincipal telaMenuPrincipal = new TelaMenuPrincipal();

	}

}
