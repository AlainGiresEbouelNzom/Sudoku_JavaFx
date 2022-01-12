package Sudoku;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/Sudoku/Styles/style.css").toString());

		eventMethode(sudoku);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Sudoku");

	}

	private void eventMethode(Sudoku sudoku)
	{
		/* Changement de vue */
		for (LitltleSudoku ls : sudoku.getLittleSudokuList())
		{
			for (IndividualCase ind : ls.getIndividualCaseList())
			{
				for (LittleNumber Lnbr : ind.getLittleNbrList())
				{
					/* Application du survol de la souris à chacun des littleNumber */
					Lnbr.getTextField().setOnMouseEntered(new EventHandler<Event>()
					{
						@Override
						public void handle(Event arg0)
						{
							ind.getBigTextField().toBack();
							Lnbr.getTextField().setBackground(new Background(
									new BackgroundFill(Color.web("rgb(245, 185, 213)"), null, null)));

						}
					});

					Lnbr.getTextField().setOnMouseExited(new EventHandler<Event>()
					{
						@Override
						public void handle(Event arg0)
						{
							ind.getBigTextField().toFront();
							Lnbr.getTextField().setBackground(new Background(
									new BackgroundFill(Color.web("#a6f5d5"), null, null)));
						}
					});

					/* Application du click de la souris à chacun des littleNumber */
					Lnbr.getTextField().setOnMousePressed(new EventHandler<Event>()
					{
						@Override
						public void handle(Event arg0)
						{
							Lnbr.getTextField().setBackground(new Background(
									new BackgroundFill(Color.web("rgb(245, 185, 213)"), null, null)));
						}
					});
				}

				/* Application du survol de la souris au bigTextField */
				ind.getBigTextField().setOnMouseEntered(new EventHandler<Event>()
				{
					@Override
					public void handle(Event arg0)
					{
						ind.getBigTextField().toBack();
						;
					}
				});

				/* Application du survol de la souris au bigTextField */
				ind.getBigTextField().setOnMouseExited(new EventHandler<Event>()
				{
					@Override
					public void handle(Event arg0)
					{
						ind.getBigTextField().toFront();
						ind.getBigTextField().setBackground(
								new Background(new BackgroundFill(Color.web("#fff"), null, null)));
					}
				});

				/* Application du click de la souris au bigTextField */
				ind.getBigTextField().setOnMousePressed(new EventHandler<Event>()
				{

					@Override
					public void handle(Event arg0)
					{
						ind.getBigTextField().toFront();
						ind.getBigTextField().setBackground(new Background(
								new BackgroundFill(Color.web("rgb(245, 185, 213)"), null, null)));

					}
				});
			}
		}

	}

	public static void main(String[] args)
	{

		launch(args);
	}

}
