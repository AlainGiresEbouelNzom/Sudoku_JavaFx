package Sudoku;

import javafx.scene.control.TextField;

public class IndividualCase
{
	private TextField textField ;
	private int id ;
	
	
	public IndividualCase(int id)
	{
		this.textField = new TextField();
		this.id = id;
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
