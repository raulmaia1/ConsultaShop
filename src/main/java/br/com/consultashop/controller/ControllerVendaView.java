package br.com.consultashop.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.consultashop.bean.ProdutoBean;
import br.com.consultashop.listasimulada.ListaSimulada;
import javafx.stage.Stage;

public class ControllerVendaView {

	private Stage stage;

	public List<ProdutoBean> pesquisa(String text) {
		
		List<ProdutoBean> lista = new ArrayList<>();
		
		new ListaSimulada().getListaProdutos().forEach(p ->{
			if (p.getDescricaoProduto().contains(text) || (p.getCodigoBarra().contains(text))) {
				lista.add(p);
			}
		});
	
		return lista;
	}

	public void adicionaProdutoCarrinho(ProdutoBean p) {
		
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public Stage getStage() {
		return stage;
	}

}
