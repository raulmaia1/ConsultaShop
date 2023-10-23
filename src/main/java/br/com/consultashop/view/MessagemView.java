package br.com.consultashop.view;

import com.jfoenix.animation.alert.JFXAlertAnimation;
import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class MessagemView {
	
	
	public static void notificar(String msg) {
		
		JFXDialogLayout layout = new JFXDialogLayout();
		layout.setPrefSize(400, 20);
		layout.getStyleClass().add("material-card-lateral");
		Label label1 = new Label(msg);
		label1.setWrapText(true);
		label1.getStyleClass().add("material-card-label-principal");
		
		layout.setBody(label1);
		
		JFXAlert<Void> alert = new JFXAlert<>();
		alert.setOverlayClose(true);
		alert.setX(20);
		alert.setY(20);
		alert.setAnimation(JFXAlertAnimation.SMOOTH);
		alert.setContent(layout);
	
		alert.initStyle(StageStyle.UNDECORATED);
		alert.initModality(Modality.NONE);
		alert.show();
		
		
		PauseTransition delay = new PauseTransition(Duration.seconds(2));
		delay.setOnFinished( event -> alert.close() );
		delay.play();
	}
}
