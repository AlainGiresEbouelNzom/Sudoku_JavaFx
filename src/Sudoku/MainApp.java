package Sudoku;

import java.beans.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.ev;

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
		
		
		
		TextField text =  new TextField();
		text.setOnAction(new javafx.event.EventHandler<ActionEvent>()
		{
			
			@Override
			public void handle(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		
		for (Node vb : root.getChildren())
		{
			
		
		}
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Sudoku");
		
	}
	public static void main(String[] args)
	{
	
		launch(args);
	}

}
