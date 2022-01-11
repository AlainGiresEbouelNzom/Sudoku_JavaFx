package Sudoku;

import javafx.scene.control.TextField;

public class IndividualCase
{
	private TextField textField ;
	private int id ;
	private static final String textfieldClass = "textfield";
	
	
	public IndividualCase(int id)
	{
		this.textField = new TextField();
		this.id = id;
		textField.getStyleClass().add(textfieldClass);
	}
	public TextField getTextField()
	{
		return textField;
	}
	public int getId()
	{
		return id;
	}
	
}
