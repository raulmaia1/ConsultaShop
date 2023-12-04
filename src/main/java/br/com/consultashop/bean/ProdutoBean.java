package br.com.consultashop.bean;

import java.math.BigDecimal;

public class ProdutoBean {
//	ok
	private String descricaoProduto, codigoBarra;
	private BigDecimal precoUnitario;
	
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(String precoUnitario) {
		this.precoUnitario = new BigDecimal(precoUnitario.replace(",", "."));
	}
	
}
