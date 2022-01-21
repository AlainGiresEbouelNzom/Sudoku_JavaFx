package Sudoku;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class IndividualCase
{
	private TextField bigTextField;
	private HBox hbox;
	private Button borderButton;
	private Group littleNbrGroup;
	private int id;
	private static final String textfieldClass = "textfield";
	private static final String littlefieldClass = "littlefield";
	private StackPane stackPane;
	private ArrayList<LittleNumber> littleNbrList;
	private String color;

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
		bigTextField.setBackground(new Background(new BackgroundFill(Color.web(color), null, null)));
	}

	public IndividualCase(int id)
	{
		this.id = id;

		init();

		bigTextField.getStyleClass().add(textfieldClass);

		stackPane.getChildren().addAll(littleNbrGroup, bigTextField);

		hbox.getChildren().addAll(stackPane, borderButton);

		// littleNbrGroup.toFront();

		setCssIdAndClass();

		littleNbrPosition();

	}

	public HBox getHbox()
	{
		return hbox;
	}

	public Button getBorderButton()
	{
		return borderButton;
	}

	public Group getLittleNbrGroup()
	{
		return littleNbrGroup;

	}

	public TextField getTextField()
	{
		return bigTextField;
	}

	public int getId()
	{
		return id;
	}

	public TextField getBigTextField()
	{
		return bigTextField;
	}

	public StackPane getStackPane()
	{
		return stackPane;
	}

	public String getText()
	{
		return bigTextField.getText();
	}

	/*
	 * public void setBigTextField(TextField bigTextField) { this.bigTextField =
	 * bigTextField; }
	 */

	private void init()
	{
		this.stackPane = new StackPane();

		bigTextField = new TextField();

		littleNbrGroup = new Group();

		hbox = new HBox();

		borderButton = new Button();

		littleNbrList = new ArrayList<>();

		for (int i = 0; i < 5; i++)
		{
			LittleNumber littleNbr = new LittleNumber();
			littleNbrList.add(littleNbr);
			littleNbrGroup.getChildren().add(littleNbr.getTextField());
		}

	}

	private void setCssIdAndClass()
	{
		for (LittleNumber littleNbr : littleNbrList)
		{
			littleNbr.getTextField().getStyleClass().add(littlefieldClass);
		}

		littleNbrList.get(0).getTextField().setId("littleField1");
		littleNbrList.get(1).getTextField().setId("littleField2");
		littleNbrList.get(2).getTextField().setId("littleField3");
		littleNbrList.get(3).getTextField().setId("littleField4");
		littleNbrList.get(4).getTextField().setId("littleField5");
		borderButton.getStyleClass().add("borderButton");

	}

	private void littleNbrPosition()
	{

		littleNbrList.get(0).getTextField().setTranslateY(22);
		littleNbrList.get(1).getTextField().setTranslateY(22);
		littleNbrList.get(1).getTextField().setTranslateX(89);
		littleNbrList.get(2).getTextField().setTranslateX(13);
		littleNbrList.get(3).getTextField().setTranslateY(-22);
		littleNbrList.get(4).getTextField().setTranslateY(-22);
		littleNbrList.get(4).getTextField().setTranslateX(89);
	}

	public ArrayList<LittleNumber> getLittleNbrList()
	{
		return littleNbrList;
	}

}
