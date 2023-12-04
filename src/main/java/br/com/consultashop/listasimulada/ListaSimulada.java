package br.com.consultashop.listasimulada;

import java.util.ArrayList;
import java.util.List;

import br.com.consultashop.bean.ProdutoBean;

public class ListaSimulada {
	
	
	public List<ProdutoBean> getListaProdutos() {
			
		List<ProdutoBean> lista = new ArrayList<>();
		
		ProdutoBean produtoBean1 = new ProdutoBean();
		produtoBean1.setDescricaoProduto("ARROZ COMUM");
		produtoBean1.setCodigoBarra("78911111111111");
		produtoBean1.setPrecoUnitario("10.50");
		lista.add(produtoBean1);
		
		ProdutoBean produtoBean2 = new ProdutoBean();
		produtoBean2.setDescricaoProduto("FEIJAO");
		produtoBean2.setCodigoBarra("78911111111111");
		produtoBean2.setPrecoUnitario("9");
		lista.add(produtoBean2);
		
		ProdutoBean produtoBean3 = new ProdutoBean();
		produtoBean3.setDescricaoProduto("MANTEIGA");
		produtoBean3.setCodigoBarra("78911111111111");
		produtoBean3.setPrecoUnitario("4.50");
		lista.add(produtoBean3);

		
		ProdutoBean produtoBean4 = new ProdutoBean();
		produtoBean4.setDescricaoProduto("PAO INTEGRAL");
		produtoBean4.setCodigoBarra("78911111111111");
		produtoBean4.setPrecoUnitario("7.50");
		lista.add(produtoBean4);

		
		ProdutoBean produtoBean5 = new ProdutoBean();
		produtoBean5.setDescricaoProduto("FARINHA");
		produtoBean5.setCodigoBarra("78911111111111");
		produtoBean5.setPrecoUnitario("15.5");
		lista.add(produtoBean5);
		
		return lista;

	}
	
}
