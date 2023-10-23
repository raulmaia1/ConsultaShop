package br.com.consultashop.app;

import br.com.consultashop.view.VendaView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(VendaView.class.getResource("venda.fxml"));
		BorderPane load = fxmlLoader.load();
		//Teste
		
		 Scene scene = new Scene(load);
		 primaryStage.setScene(scene);
		 ((VendaView) fxmlLoader.getController()).setStage(primaryStage);
		 
		 primaryStage.initStyle(StageStyle.DECORATED);
		 
		 primaryStage.show();
	}
	
}
