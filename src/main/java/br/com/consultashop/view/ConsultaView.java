package br.com.consultashop.view;

import br.com.consultashop.controller.ControllerVendaView;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConsultaView {
	@FXML
	private TextField textPesquisar;
	@FXML
	private FlowPane flowResultado;
	
	private ControllerVendaView controller;

	@FXML
	private void pesquisarProdutos() {
		flowResultado.getChildren().clear();

		this.controller.pesquisa(textPesquisar.getText()).forEach(p -> {
			VBox vBoxPrincipal = new VBox();
			vBoxPrincipal.setPrefSize(237, 170);
			vBoxPrincipal.getStyleClass().add("material-card");

			AnchorPane paneImage = new AnchorPane();
			paneImage.getStyleClass().add("material-card-image");
			paneImage.setPrefSize(120, 70);

			vBoxPrincipal.getChildren().add(paneImage);

			VBox vBox = new VBox();
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
			hBox.setPrefSize(50, 20);
			hBox.setSpacing(5);
			hBox.setAlignment(Pos.CENTER);

			Button button = new Button("Adicionar");
			button.getStyleClass().add("material-button-add-quantidade");
			button.setPrefSize(80, 20);

			button.setOnAction(ev -> {
				controller.adicionaProdutoCarrinho(p);
				MessagemView.notificar("Produto adicionado com sucesso.");
			});

			hBox.getChildren().add(button);

			vBox.getChildren().add(hBox);
			vBoxPrincipal.getChildren().add(vBox);

			flowResultado.getChildren().add(vBoxPrincipal);

		});
	}

	public void setController(ControllerVendaView controller) {
		this.controller = controller;
	}

}
