package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.vo.ProdutoVO;

public class ProdutoDAO {
	
	String produto_path = "C:\\Users\\gabriel.garbin\\git\\programacaoDesktopNot\\Produtos.txt";
	String dataLog_path = "C:\\Users\\gabriel.garbin\\git\\programacaoDesktopNot\\Log.txt";
	
	String localTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

	public ProdutoVO cadastrarProdutoDAO(ProdutoVO produtoVO) throws IOException {
		File f = new File(produto_path);
		try {
			FileOutputStream fos = new FileOutputStream(f, true);
			fos.write(new String(produtoVO.toString() + "\n").getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataLog("Produto Cadastrado ".toUpperCase());
	}
	
	private ProdutoVO dataLog(String mensagemLog) throws IOException {
		mensagemLog = localTime + " - " + mensagemLog;
			
		File f = new File(dataLog_path);
		FileOutputStream fos = new FileOutputStream(f, true);
		fos.write(mensagemLog.getBytes());
		fos.write("\n".getBytes());
		fos.close();
		System.out.println("Executando");
			
		return null;
	}

	public ProdutoVO listarProdutoPorCodigoDAO(short codigo) throws IOException {
		File f = new File(produto_path);
		ProdutoVO produto =  new ProdutoVO();
		
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] dados = fis.readAllBytes();
			String conteudoArquivo = new String(dados);
			String[] linhas = conteudoArquivo.split("\n");
			fis.close();
			
			for(String linha: linhas) {
				String[] colunas = linha.split("-");
				if(colunas[2].trim().equals(String.valueOf(codigo))) {
				produto.setNome(colunas[0]);
				produto.setPreco(Float.parseFloat(colunas[1].trim()));
				produto.setCodigo(Short.parseShort(colunas[2].trim()));
				}
			}
			} catch (Exception e) {
			System.out.println(e);
		}
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.dataLog("Exibiu o produto selecionado".toUpperCase());
		return produto;
	}

	public String listarTodosProdutosDAO() throws IOException {
		String retorno = "";
		File f = new File(produto_path);
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] conteudo = fis.readAllBytes();
			retorno = new String(conteudo);
			retorno = retorno.replaceAll(",", "-");
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.dataLog("Exibiu todos Produtos".toUpperCase());
		return retorno;
	}

	public String excluirProdutoPorCodigoDAO(String codigo) throws IOException {
		File f = new File(produto_path);
		String produto = "";
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] conteudo = fis.readAllBytes();
			produto = new String(conteudo);
			String[] linhas = produto.split("\n");
			String novoTexto = "";
			
			int i = 0;
			for(String linha: linhas) {
			String[] colunas = linha.split("-");
				if(!colunas[2].trim().equals(codigo)) {
					 novoTexto = novoTexto + linha +"\n";
				}
			}
			
			FileOutputStream fos = new FileOutputStream(f, false);
			fos.write(new String(novoTexto).getBytes());
			fos.close();
			fis.close();
			System.out.println(novoTexto);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.dataLog("Excluiu o Produto Selecionado".toUpperCase());
		return produto;
	}

}
