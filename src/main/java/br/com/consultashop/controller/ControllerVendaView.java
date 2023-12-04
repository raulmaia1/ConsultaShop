package br.com.consultashop.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.consultashop.bean.ProdutoBean;
import br.com.consultashop.bean.ProdutoVendaBean;
import br.com.consultashop.bean.VendaBean;
import br.com.consultashop.listasimulada.ListaSimulada;

public class ControllerVendaView {
	
	private VendaBean venda = new VendaBean();
	
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

	public void adicionaProdutoCarrinho(ProdutoVendaBean p) {
		this.venda.adiciona(p);
	}
	
	public List<ProdutoVendaBean> getCarrinho() {
		return venda.getCarrinho();
	}
	
	public VendaBean getVenda() {
		return venda;
	}
}
