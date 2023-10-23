package br.com.consultashop.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.consultashop.bean.ProdutoBean;
import br.com.consultashop.listasimulada.ListaSimulada;

public class ControllerVendaView {

	private List<ProdutoBean> carrinho = new ArrayList<>();

	public List<ProdutoBean> pesquisa(String text) {
		
		List<ProdutoBean> lista = new ArrayList<>();
		
		new ListaSimulada().getListaProdutos().forEach(p ->{
			if (p.getDescricaoProduto().contains(text) || (p.getCodigoBarra().contains(text))
					|| (p.getDescricaoProduto().contains(text.toUpperCase()))) {
				
				lista.add(p);
			}
		});
	
		return lista;
	}

	public void adicionaProdutoCarrinho(ProdutoBean p) {
		carrinho.add(p);
	}
	
	public List<ProdutoBean> getCarrinho() {
		return carrinho;
	}
}
