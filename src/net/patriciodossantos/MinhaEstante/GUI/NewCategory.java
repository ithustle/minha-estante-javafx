package net.patriciodossantos.MinhaEstante.GUI;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.patriciodossantos.MinhaEstante.DAO.CategoryDAO;
import net.patriciodossantos.MinhaEstante.Model.Category;

public class NewCategory extends Application {

	private TextField txtName;

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		Group group = new Group();

		txtName = new TextField();
		txtName.setPromptText("Digite o nome da Categoria");

		Button btnSave = new Button("Salvar");
		btnSave.setLayoutY(30);
		btnSave.setOnAction(e -> saveCategory());

		root.setCenter(group);
		group.getChildren().addAll(txtName, btnSave);

		Scene scene = new Scene(root, 300, 200);

		primaryStage.setTitle("Adicionar Categoria - MinhaEstante");
		primaryStage.setScene(scene);

		primaryStage.initOwner(Main.primaryStage);
		primaryStage.initModality(Modality.WINDOW_MODAL);
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UTILITY);

		primaryStage.show();

	}

	private void saveCategory() {
		Category category = new Category();
		category.setName(txtName.getText());

		try {
			CategoryDAO.save(category);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Adicionar Categoria");
			alert.setHeaderText(null);
			alert.setContentText("Nova Categoria Adicionada com Sucesso.");

			alert.showAndWait();

		} catch (Exception e) {
			// http://code.makery.ch/blog/javafx-dialogs-official/
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ocorreu um erro");
			alert.setHeaderText("Ocorreu um erro");
			alert.setContentText("Não foi possivél salvar a nova Categoria.");

			Label label = new Label("The exception stacktrace was:");
			
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String exceptionText = sw.toString();

			TextArea textArea = new TextArea(exceptionText);
			textArea.setEditable(false);
			textArea.setWrapText(true);

			textArea.setMaxWidth(Double.MAX_VALUE);
			textArea.setMaxHeight(Double.MAX_VALUE);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			GridPane expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(textArea, 0, 1);

			// Set expandable Exception into the dialog pane.
			alert.getDialogPane().setExpandableContent(expContent);

			alert.showAndWait();
		}
	}

}
