package Sudoku;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoderrColor
{
	private Rectangle rect;
	private String color;
	
	public BoderrColor(int w, int h, Color color)
	{
		rect = new Rectangle(w, h);
		rect.setFill(color);
	}
	public Rectangle getRect()
	{
		return rect;
	}
	public String getColor()
	{
		return color;
	}
	
	
}
