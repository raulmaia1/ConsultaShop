package br.com.consultashop.bean;

import java.math.BigDecimal;

public class ProdutoVendaBean {

	private ProdutoBean produtoBean;
	private BigDecimal quantidade = new BigDecimal(1);
	
	public ProdutoVendaBean(ProdutoBean produtoBean) {
		this.produtoBean = produtoBean;
	}
	
	public ProdutoBean getProdutoBean() {
		return produtoBean;
	}
	
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
		
	public BigDecimal valorTotal() {		
		return quantidade.multiply(produtoBean.getPrecoUnitario());
	}
	
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	
	@Override
	public String toString() {
		return produtoBean.getDescricaoProduto() + " " +  produtoBean.getPrecoUnitario() + " " + quantidade;
	}
}
