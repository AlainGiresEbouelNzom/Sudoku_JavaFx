package Sudoku;

import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.ChoiceDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application
{
	Button saveButton = new Button("Save");
	Button loadButton = new Button("Load");
	Button UndoButton = new Button("Undo");
	Button RedoButton = new Button("Redo");
	ChoiceDialog<Rectangle> borderChoice = new ChoiceDialog<Rectangle>();;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Sudoku sudoku = new Sudoku();
		HBox root = new HBox();

		VBox group = new VBox(20);

		group.getChildren().addAll(saveButton, loadButton, UndoButton, RedoButton);
		group.setPadding(new Insets(75));

		root.getChildren().addAll(sudoku.getVbox1(), sudoku.getVbox2(), sudoku.getVbox3(), group);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/Sudoku/Styles/style.css").toString());

		allEvents(sudoku, root);
		buttonsEvents(sudoku);
		
		primaryStage.setScene(scene);
		borderChoice.initOwner(primaryStage);
		primaryStage.show();
		primaryStage.setTitle("Sudoku");
	}

	private void initBorderChoice()
	{
		Button b1 = new Button();
		b1.setBackground(new Background(new BackgroundFill(null, null, null)));

		Rectangle rect1 = new Rectangle(200, 20);
		rect1.setFill(Color.AQUA);
		Rectangle rect2 = new Rectangle(200, 20);
		rect2.setFill(Color.AQUAMARINE);
		Rectangle rect3 = new Rectangle(200, 20);
		rect3.setFill(Color.BEIGE);
		Rectangle rect4 = new Rectangle(200, 20);
		rect4.setFill(Color.BLUE);
		Rectangle rect5 = new Rectangle(200, 20);
		rect5.setFill(Color.BROWN);
		Rectangle rect6 = new Rectangle(200, 20);
		rect6.setFill(Color.CHARTREUSE);
		Rectangle rect7 = new Rectangle(200, 20);
		rect7.setFill(Color.DARKGRAY);
		Rectangle rect8 = new Rectangle(200, 20);
		rect8.setFill(Color.DARKMAGENTA);
		Rectangle rect9 = new Rectangle(200, 20);
		rect9.setFill(Color.PINK);
		Rectangle rect10 = new Rectangle(200, 20);
		rect10.setFill(null);
		
	this.borderChoice = new ChoiceDialog<>(rect10, rect1, rect2, rect3, rect2, rect4, rect5, rect6, rect7, rect8, rect9);
		
		
	}

	private void buttonsEvents(Sudoku sudoku)
	{
		saveButton.setOnAction(new EventHandler<ActionEvent>()
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
		
		

		loadButton.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				try
				{
					BackupSystem.Load(sudoku.getLittleSudokuList());
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

		UndoButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0)
			{
				BackupSystem.Undo();
			}
		});

		RedoButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0)
			{
				BackupSystem.Redo();
			}
		});
	}

	private void allEvents(Sudoku sudoku, HBox root)
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
							Lnbr.getTextField().setBorder(
									new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,
											CornerRadii.EMPTY, new BorderWidths(3))));
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
							Lnbr.getTextField().setBorder(
									new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,
											CornerRadii.EMPTY, new BorderWidths(3))));
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

				ind.getBigTextField().setOnMouseClicked(new EventHandler<MouseEvent>()
				{

					@Override

					public void handle(MouseEvent e)
					{
						if (e.isControlDown())
						{
							ind.getBigTextField().toFront();
							ind.getBigTextField().setBorder(new Border(new BorderStroke(Color.RED,
									BorderStrokeStyle.SOLID, null, new BorderWidths(3))));
							BackupSystem.SaveOnStacks(ind);
//							ind.getTextField().setBackground(new Background(
//									new BackgroundFill(Color.web(colorRandom()), null, null)));

						}
						// TODO Auto-generated method stub

					}
				});

				/* Application du click de la souris au bigTextField */
				/*
				 * ind.getBigTextField().setOnMousePressed(new EventHandler<Event>() {
				 * 
				 * public void handle(MouseEvent arg0) { if() ind.getBigTextField().toFront();
				 * ind.getBigTextField().setBorder(new Border(new BorderStroke(Color.RED,
				 * BorderStrokeStyle.DOTTED, null, new BorderWidths(3))));
				 * BackupSystem.SaveOnStacks(ind); ind.getTextField().setBackground(new
				 * Background( new BackgroundFill(Color.web(colorRandom()), null, null)));
				 * 
				 * }
				 * 
				 * @Override public void handle(Event arg0) { // TODO Auto-generated method stub
				 * 
				 * } });
				 */

				/* Évènement Saisi d'un bigNumber par l'utilisateur */
				ind.getBigTextField().setOnKeyReleased(new EventHandler<Event>()
				{
					@Override
					public void handle(Event arg0)
					{
						ind.getTextField().setBackground(new Background(
								new BackgroundFill(Color.web(colorRandom()), null, null)));
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
				
				ind.getBorderButton().setOnAction(new EventHandler<ActionEvent>()
				{


					@Override
					public void handle(ActionEvent arg0)
					{
						initBorderChoice();
						Optional<Rectangle> border = borderChoice.showAndWait();
						border.ifPresent(e->{
							ind.getTextField().setBorder(
									new Border(new BorderStroke(Color.web(colorRandom()), BorderStrokeStyle.SOLID,
											CornerRadii.EMPTY, new BorderWidths(3))));
							ind.getTextField().setBackground(new Background(
									new BackgroundFill(e.getFill(), null, null)));
						});
						SetIndividualCaseBorder(ind);
					}

				

					
				});

			}
		}
	}

	private void SetIndividualCaseBorder(IndividualCase ind)
	{
		
		
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

	public static String colorRandom()
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
