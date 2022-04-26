package model.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProdutoDAO {
	
	String produto_path = "C:\\Users\\gabriel.garbin\\git\\programacaoDesktopNot\\Produtos.txt";
	String dataLog_path = "C:\\Users\\gabriel.garbin\\git\\programacaoDesktopNot\\Log.txt";
	
	String localTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	
	

}
