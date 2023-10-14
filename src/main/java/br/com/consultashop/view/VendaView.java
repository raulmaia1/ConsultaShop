package br.com.consultashop.view;

import br.com.consultashop.controller.ControllerVendaView;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VendaView {
	@FXML
	private TextField textPesquisar;
	@FXML
	private FlowPane flowResultado;

	@FXML
	private void pesquisarProdutos() {
		flowResultado.getChildren().clear();

		new ControllerVendaView().pesquisa(textPesquisar.getText()).ifPresent(lista -> {
			lista.forEach(p -> {
				VBox vBox = new VBox();
				vBox.setPrefSize(237, 110);
				vBox.getStyleClass().add("material-card");
				vBox.setPadding(new Insets(5, 0, 0, 5));

				Label label1 = new Label(p.getDescricaoProduto());
				label1.getStyleClass().add("material-card-produtos-label");
				vBox.getChildren().add(label1);

				Label label2 = new Label(p.getCodigoBarra());
				label2.getStyleClass().add("material-card-produtos-label");
				vBox.getChildren().add(label2);

				Label label3 = new Label(p.getPrecoUnitario());
				label3.getStyleClass().add("material-card-produtos-label");
				vBox.getChildren().add(label3);
				
				HBox hBox = new HBox();
				hBox.setPrefSize(200, 100);
				hBox.setSpacing(5);
				
				TextField textField = new TextField("1");
				textField.getStyleClass().add("text-configuracao");
				textField.setPrefSize(63, 31);
				hBox.getChildren().add(textField);
				
				Button button = new Button();
				button.getStyleClass().add("material-button-add");
				button.setPrefSize(31, 32);
				hBox.getChildren().add(button);

				
				vBox.getChildren().add(hBox);
				

				flowResultado.getChildren().add(vBox);

			});

		});

	}

}
