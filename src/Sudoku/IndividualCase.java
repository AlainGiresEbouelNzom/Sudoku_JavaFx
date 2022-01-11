package Sudoku;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class IndividualCase
{
	private TextField bigTextField;
	TextField textField1;
	TextField textField2;
	TextField textField3;
	TextField textField4;
	TextField textField5;

	VBox littleFaces;
	HBox vbox1;
	HBox vbox2;
	HBox vbox3;
	private int id;
	private static final String textfieldClass = "textfield";
	private static final String littlefieldClass = "littlefield";

	private StackPane stackPane;

	public IndividualCase(int id)
	{
		this.id = id;

		init();

		bigTextField.getStyleClass().add(textfieldClass);

		stackPane.getChildren().addAll(littleFaces, bigTextField);

		littleFaces.toFront();

		CreateLittleCssClass();

	}

	public TextField getBigTextField()
	{
		return bigTextField;
	}

	public void setBigTextField(TextField bigTextField)
	{
		this.bigTextField = bigTextField;
	}

	public TextField getTextField1()
	{
		return textField1;
	}

	public void setTextField1(TextField textField1)
	{
		this.textField1 = textField1;
	}

	public TextField getTextField2()
	{
		return textField2;
	}

	public void setTextField2(TextField textField2)
	{
		this.textField2 = textField2;
	}

	public TextField getTextField3()
	{
		return textField3;
	}

	public void setTextField3(TextField textField3)
	{
		this.textField3 = textField3;
	}

	public TextField getTextField4()
	{
		return textField4;
	}

	public void setTextField4(TextField textField4)
	{
		this.textField4 = textField4;
	}

	public TextField getTextField5()
	{
		return textField5;
	}

	public void setTextField5(TextField textField5)
	{
		this.textField5 = textField5;
	}

	public VBox getLittleFaces()
	{
		return littleFaces;
	}

	public void setLittleFaces(VBox littleFaces)
	{
		this.littleFaces = littleFaces;
	}

	public StackPane getStackPane()
	{
		return stackPane;
	}

	public void setStackPane(StackPane stackPane)
	{
		this.stackPane = stackPane;
	}

	private void init()
	{
		this.stackPane = new StackPane();

		bigTextField = new TextField();

		this.textField1 = new TextField();
		this.textField2 = new TextField();

		this.textField3 = new TextField();

		textField3.setAlignment(Pos.CENTER);

		this.textField4 = new TextField();
		this.textField5 = new TextField();

		littleFaces = new VBox();

		this.vbox1 = new HBox();
		this.vbox2 = new HBox();
		this.vbox3 = new HBox();

		littleFaces.getChildren().addAll(vbox1, vbox2, vbox3);
		vbox1.getChildren().addAll(textField1, textField2);
		vbox2.getChildren().addAll(textField3);
		vbox3.getChildren().addAll(textField4, textField5);

	}

	private void CreateLittleCssClass()
	{
		textField1.getStyleClass().add(littlefieldClass);
		textField2.getStyleClass().add(littlefieldClass);
		textField3.getStyleClass().add(littlefieldClass);
		textField4.getStyleClass().add(littlefieldClass);
		textField5.getStyleClass().add(littlefieldClass);
	}

	public TextField getTextField()
	{
		return bigTextField;
	}

	public int getId()
	{
		return id;
	}

}
