package br.com.consultashop.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.consultashop.listasimulada.ListaSimulada;

public class VendaBean {
	private List<ProdutoVendaBean> carrinho = new ArrayList<>();

	private String digitadoDesconto = "0";
	
	public List<ProdutoVendaBean> getCarrinho() {
		return carrinho;
	}
	
	public void adiciona(ProdutoVendaBean p) {
		this.carrinho.add(p);
	}
	
	public BigDecimal valorTotalParcial() {
		BigDecimal vT = carrinho
							.stream()
							.map(p -> p.getProdutoBean().getPrecoUnitario().multiply(p.getQuantidade()))
							.reduce(BigDecimal.ZERO, BigDecimal::add);
				
			
		return vT; 
	}
	public void setDesconto(String desconto) {	
		this.digitadoDesconto = desconto.replace(",", ".");
	}
	
	public BigDecimal getDesconto() {
		
		if(this.digitadoDesconto.contains("%")) {
			 BigDecimal porcento = BigDecimal.valueOf(Double.valueOf(this.digitadoDesconto.replaceAll("%","")));
			 
			 BigDecimal x = porcento.multiply(this.valorTotalParcial());
			 
			 return x.divide(new BigDecimal(100.0));
					 
		}
		
		return new BigDecimal(digitadoDesconto);
	}
	
	public BigDecimal valorTotal() {
		return valorTotalParcial().subtract(this.getDesconto()) ;
	}
	
	
	public static void main(String[] args) {
		VendaBean vendaBean = new VendaBean();
		new ListaSimulada().getListaProdutos().forEach(p -> {
			ProdutoVendaBean p1 = new ProdutoVendaBean(p);
			p1.setQuantidade(new BigDecimal(2));
			vendaBean.adiciona(p1);			
		});
		
		System.out.println(vendaBean.valorTotal());
		vendaBean.setDesconto("10%");
		System.out.println(vendaBean.valorTotal());

	}
	
}
