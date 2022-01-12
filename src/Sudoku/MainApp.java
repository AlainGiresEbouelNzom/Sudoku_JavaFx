package Sudoku;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
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
		
		
		/*Changement de vue*/			
		for (LitltleSudoku ls   : sudoku.getLittleSudokuList())
		{
			for (IndividualCase ind   : ls.getIndividualCaseList())
			{
				/*Application du survol de la souris à chacun des littleNumber*/
				for (Node node : ind.getLittleNbrGroup().getChildrenUnmodifiable())
				{
					node.setOnMouseEntered(new EventHandler<Event>()
					{
						@Override
						public void handle(Event arg0)
						{
							ind.getBigTextField().toBack();									
						}
					});
					
					node.setOnMouseExited(new EventHandler<Event>()
					{
						@Override
						public void handle(Event arg0)
						{
							ind.getBigTextField().toFront();									
						}
					});
				}				
				
				
				/*Application du click de la souris à chacun des littleNumber*/
				for (Node node : ind.getLittleNbrGroup().getChildrenUnmodifiable())
				{
					node.setOnMousePressed(new EventHandler<Event>()
					{
						@Override
						public void handle(Event arg0)
						{
							
						}
					});				
				}
				
				/*Application du survol de la souris au bigTextField*/
				ind.getBigTextField().setOnMouseEntered(new EventHandler<Event>()
				{
					@Override
					public void handle(Event arg0)
					{
						ind.getBigTextField().toBack();;						
					}
				});			
				
				/*Application du survol de la souris au bigTextField*/
				ind.getBigTextField().setOnMouseExited(new EventHandler<Event>()
				{
					@Override
					public void handle(Event arg0)
					{
						ind.getBigTextField().toFront();	
						ind.getBigTextField().setBackground(new Background(new BackgroundFill(Color.web("#fff"), null, null)));
					}
				});
				
				/*Application du click de la souris au bigTextField*/
				ind.getBigTextField().setOnMousePressed(new EventHandler<Event>()
				{

					@Override
					public void handle(Event arg0)
					{
						ind.getBigTextField().toFront();
						ind.getBigTextField().setBackground(new Background(new BackgroundFill(Color.web("rgb(245, 185, 213)"), null, null)));
						
					}
				});
			}
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
