package Sudoku;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainApp extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		
		Sudoku sudoku = new Sudoku();
		
		HBox root = new HBox();
		root.getChildren().addAll(sudoku.getVbox1(), sudoku.getVbox2(), sudoku.getVbox3());
				
		Scene scene =  new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/Sudoku/Styles/style.css").toString());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Sudoku");
		
	}
	public static void main(String[] args)
	{
	
		launch(args);
	}

}
