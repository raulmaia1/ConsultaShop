package br.com.consultashop.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.consultashop.bean.ProdutoBean;

public class ControllerVendaView {

	public Optional<List<ProdutoBean>> pesquisa(String text) {
		ProdutoBean produtoBean = new ProdutoBean();
		produtoBean.setDescricaoProduto("ARROZ COMUM");
		produtoBean.setCodigoBarra("78911111111111");
		produtoBean.setPrecoUnitario("4,50");
	
		return Optional.ofNullable(Arrays.asList(produtoBean));
	}

}
