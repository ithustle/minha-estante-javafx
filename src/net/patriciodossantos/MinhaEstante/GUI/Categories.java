package net.patriciodossantos.MinhaEstante.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Categories extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();

		Scene scene = new Scene(root, 300, 200);

		primaryStage.setTitle("Categorias - Minha Estante");
		primaryStage.setScene(scene);
		primaryStage.initOwner(Main.primaryStage);
		primaryStage.initModality(Modality.WINDOW_MODAL);
		
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UTILITY);
		
		primaryStage.show();

	}

}
