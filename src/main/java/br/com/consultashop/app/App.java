package br.com.consultashop.app;

import br.com.consultashop.view.VendaView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//z
public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		 BorderPane load = FXMLLoader.load(VendaView.class.getResource("venda.fxml"));
		 Scene scene = new Scene(load);
		 primaryStage.setScene(scene);
		 primaryStage.show();
	}
	
}
