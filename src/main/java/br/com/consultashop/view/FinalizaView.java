package br.com.consultashop.view;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;

import br.com.consultashop.controller.ControllerVendaView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FinalizaView implements Initializable {

	@FXML
	private JFXListView<HBox> listView;
	@FXML
	private Label labelTotalParcial, labelTotal;
	@FXML
	private TextField textDesconto;

	private ControllerVendaView controller;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
        textDesconto.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> textDesconto.requestFocus());

		
		textDesconto.focusedProperty().addListener((ov, oldV, newV) -> {
			if (!newV) {
				this.controller.getVenda().setDesconto(textDesconto.getText());
				listView.getItems().clear();
				adicionaItensListView();
				atualizarTotais();
			}
		});
	}

	public void setController(ControllerVendaView controller) {
		this.controller = controller;
		adicionaItensListView();
//		https://stackoverflow.com/a/42943931
	}

	private void adicionaItensListView() {
		this.atualizarTotais();
		
		this.controller.getCarrinho().forEach(p -> {
			HBox box = new HBox();
			box.setSpacing(5);
			box.getStyleClass().add("material-card");
			box.setPadding(new Insets(5));

			VBox vbox = new VBox();

			Label labelDescricao = new Label(p.getProdutoBean().getDescricaoProduto());
			labelDescricao.setWrapText(true);
			labelDescricao.getStyleClass().add("material-card-label-principal");

			Label labelPreco = new Label(p.getProdutoBean().getPrecoUnitario().toString());
			labelPreco.setWrapText(true);
			labelPreco.getStyleClass().add("material-card-label-principal");

			vbox.getChildren().add(labelDescricao);
			vbox.getChildren().add(labelPreco);

			HBox buttonHBox = new HBox();
			buttonHBox.setAlignment(Pos.TOP_RIGHT);
			buttonHBox.setSpacing(5);

			TextField textQuantidade = new TextField();
			textQuantidade.getStyleClass().add("");
			textQuantidade.setText(p.getQuantidade().toString());

			Button buttonAlterar = new Button("Alterar");
			buttonAlterar.getStyleClass().add("");

			buttonAlterar.setOnAction(action -> {
				p.setQuantidade(new BigDecimal(textQuantidade.getText()));
				atualizarTotais();
			});

			buttonHBox.getChildren().add(textQuantidade);
			buttonHBox.getChildren().add(buttonAlterar);

			box.getChildren().add(vbox);
			box.getChildren().add(buttonHBox);

			listView.getItems().add(box);

		});

	}

	private void atualizarTotais() {
		this.controller.getVenda().setDesconto(textDesconto.getText());
		labelTotalParcial.setText(this.controller.getVenda().valorTotalParcial().toString());
		labelTotal.setText(this.controller.getVenda().valorTotal().toString());
	}

	@FXML
	private void finalizarVenda() {
		
		Platform.runLater(() -> {
			new GeraRelatorio().gera(controller.getVenda());
		});
		
		this.controller.getCarrinho().forEach(System.out::println);

	}

}
