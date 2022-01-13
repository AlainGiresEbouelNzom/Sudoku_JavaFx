package Sudoku;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application
{
	Button save = new Button("Save");
	Button load = new Button("Load");

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Sudoku sudoku = new Sudoku();
		HBox root = new HBox();

		VBox group = new VBox(20);

		group.getChildren().addAll(save, load);
		group.setPadding(new Insets(15));

		root.getChildren().addAll(sudoku.getVbox1(), sudoku.getVbox2(), sudoku.getVbox3(), group);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/Sudoku/Styles/style.css").toString());

		allEvents(sudoku);
		buttonsEvents(sudoku);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Sudoku");
	}

	private void buttonsEvents(Sudoku sudoku)
	{
		save.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				try
				{
					BackupSystem.Save(sudoku.getLittleSudokuList());
				} catch (TransformerException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

	private void allEvents(Sudoku sudoku)
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

						}
					});

					/* Application du click de la souris à chacun des littleNumber */
					/*
					 * Lnbr.getTextField().setOnMousePressed(new EventHandler<Event>() {
					 * 
					 * @Override public void handle(Event arg0) {
					 * Lnbr.getTextField().setBackground(new Background( new
					 * BackgroundFill(Color.web("rgb(245, 185, 213)"), null, null))); } });
					 */

					Lnbr.getTextField().setOnKeyPressed(new EventHandler<Event>()
					{
						@Override
						public void handle(Event arg0)
						{
							Lnbr.getTextField().setBackground(new Background(
									new BackgroundFill(Color.web(colorRandom()), null, null)));
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

					}
				});

				/* Application du survol de la souris au bigTextField */
				ind.getBigTextField().setOnMouseExited(new EventHandler<Event>()
				{
					@Override
					public void handle(Event arg0)
					{
						ind.getBigTextField().toFront();

					}
				});

				/* Application du click de la souris au bigTextField */
				ind.getBigTextField().setOnMousePressed(new EventHandler<Event>()
				{

					@Override
					public void handle(Event arg0)
					{
						ind.getBigTextField().toFront();
						ind.setColor("rgb(245, 05, 213)");
					}
				});

				/* Évènement Saisi d'un bigNumber par l'utilisateur */
				ind.getBigTextField().setOnKeyReleased(new EventHandler<Event>()
				{
					@Override
					public void handle(Event arg0)
					{
//						verification(sudoku, ind);
//						try
//						{
//							// BackupSystem.maintest();
//						} catch (ParserConfigurationException | TransformerException e)
//						{
//							e.printStackTrace();
//						}
					}

				});

			}
		}
	}

	private void verification(Sudoku sudoku, IndividualCase ind)
	{
		ArrayList<IndividualCase> IndCaseList = new ArrayList<>();
		IndCaseList.add(ind);

		for (LitltleSudoku ls : sudoku.getLittleSudokuList())
		{
			for (IndividualCase indCase : ls.getIndividualCaseList())
			{
				if (!ind.getBigTextField().getText().trim().equals("")
						&& indCase.getBigTextField().getText().equals(ind.getBigTextField().getText()))
				{
					IndCaseList.add(indCase);

				}
			}
		}

		for (IndividualCase individualCase : IndCaseList)
		{
			individualCase.getBigTextField()
					.setBackground(new Background(new BackgroundFill(Color.web("red"), null, null)));
		}
	}

	private String colorRandom()
	{
		String[] colors = new String[8];

		colors[0] = "red";
		colors[1] = "blue";
		colors[2] = "green";
		colors[3] = "purple";
		colors[4] = "orange";
		colors[5] = "yellow";
		colors[6] = "pink";
		colors[7] = "cyan";

		Random random = new Random();

		return colors[random.nextInt(colors.length)];

	}

	public static void main(String[] args)
	{

		launch(args);
	}

}
