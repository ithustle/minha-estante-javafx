package net.patriciodossantos.MinhaEstante.GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Main.primaryStage = primaryStage;

		BorderPane root = new BorderPane();
		VBox topContainer = new VBox();

		MenuBar menuBar = new MenuBar();
		ToolBar toolBar = new ToolBar();
		HBox statusBar = new HBox();

		// Menu Ficheiro e os Sub-menus
		final Menu menuFile = new Menu("Ficheiro");
		MenuItem openCategories = new MenuItem("Categorias");
		openCategories.setOnAction(e -> {
			try {
				new Categories().start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		MenuItem exitApplication = new MenuItem("Sair da Aplicação");
		exitApplication.setOnAction(e -> {
			Platform.exit();
		});

		menuFile.getItems().addAll(openCategories, exitApplication);

		// START Menu Category and its Sub-menus
		Menu menuCategories = new Menu("Categorias");
		MenuItem menuItemNewCategory = new MenuItem("Adicionar Nova Categoria");
		menuItemNewCategory.setOnAction(e -> {
			try {
				new NewCategory().start(new Stage());
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		});
		menuCategories.getItems().add(menuItemNewCategory);
		// END Menu Category
		
		
		final Menu menuBooks = new Menu("Livros");
		final Menu menuHelp = new Menu("Ajuda");

		menuBar.getMenus()
				.addAll(menuFile, menuCategories, menuBooks, menuHelp);

		topContainer.getChildren().addAll(menuBar, toolBar);

		root.setTop(topContainer);
		root.setBottom(statusBar);

		Scene scene = new Scene(root, 300, 250);
		scene.getStylesheets().add(
				getClass().getResource("application.css").toExternalForm());

		primaryStage.setTitle("Dashboard - Minha Estante");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(
				new Image(getClass().getResourceAsStream(
						"/net/patriciodossantos/MinhaEstante/resources/images/MinhaEstante.png")));
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
