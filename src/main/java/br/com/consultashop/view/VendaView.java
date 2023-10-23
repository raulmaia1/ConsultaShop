package br.com.consultashop.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.consultashop.controller.ControllerVendaView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class VendaView implements Initializable {
	
	@FXML
	private BorderPane painelPrincipal;
	private ControllerVendaView controller = new ControllerVendaView();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		((ConsultaView) abrijanela("consulta.fxml")).setController(this.controller);		
	}
	
	@FXML
	private void abrirConsulta() {
		 ((ConsultaView) abrijanela("consulta.fxml")).setController(this.controller);
	}
	
	@FXML
	private void abrirFinalizar() {
		((FinalizaView) abrijanela("finalizar.fxml")).adicionaItensListView(this.controller);
	}
	
	@FXML
	private void abrirConfiguracao() {

	}
	
	
	private <T> T abrijanela(String janela) {
		try {	
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(VendaView.class.getResource(janela));
			BorderPane load = fxmlLoader.load();
			painelPrincipal.setCenter(load);			
			return fxmlLoader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Erro ao carregar FXML");
	}
	
}
