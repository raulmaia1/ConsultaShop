package br.com.consultashop.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;

import br.com.consultashop.controller.ControllerVendaView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FinalizaView implements Initializable {
	
	@FXML
 	private JFXListView<HBox> listView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	
	public void adicionaItensListView(ControllerVendaView controller) {
		
		controller.getCarrinho().forEach(p ->{
			HBox box = new HBox();
			box.setSpacing(1);
			box.getStyleClass().add("material-card");
			box.setPadding(new Insets(5));
			
			VBox vbox = new VBox();

			
			Label labelDescricao = new Label(p.getDescricaoProduto());
			labelDescricao.setWrapText(true);
			labelDescricao.getStyleClass().add("material-card-label-principal");
			
			Label labelPreco = new Label(p.getPrecoUnitario());
			labelPreco.setWrapText(true);
			labelPreco.getStyleClass().add("material-card-label-principal");
			
			vbox.getChildren().add(labelDescricao);
			vbox.getChildren().add(labelPreco);
			
			
			HBox buttonHBox = new HBox();
			buttonHBox.setAlignment(Pos.CENTER_RIGHT);
			
			Button button = new Button();
			button.getStyleClass().add("");
			
			buttonHBox.getChildren().add(button);
			
			box.getChildren().add(vbox);
			box.getChildren().add(buttonHBox);

			listView.getItems().add(box);
			
		});
		
	}
	
	
}
