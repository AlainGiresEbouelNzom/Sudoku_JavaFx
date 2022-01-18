package Sudoku;

import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class LittleNumber
{
	private TextField textField;
	private String color;

	public LittleNumber()
	{
		this.textField = new TextField();
		// textField.setText(" ");

	}

	public TextField getTextField()
	{
		return textField;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
		textField.setBackground(new Background(new BackgroundFill(Color.web(color), null, null)));
	}

}
