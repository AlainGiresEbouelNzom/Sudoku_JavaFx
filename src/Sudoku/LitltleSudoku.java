package Sudoku;

import java.util.ArrayList;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LitltleSudoku
{
	private ArrayList <IndividualCase> individualCaseList;
	private HBox hbox = new HBox();	
	private VBox vbox1 = new VBox();
	private VBox vbox2 = new VBox();
	private VBox vbox3 = new VBox();
	private static final String LsudokuClass = "LsudokuClass";
	
	public ArrayList<IndividualCase> getIndividualCaseList()
	{
		return individualCaseList;
		
		
	}

	public HBox getHbox()
	{
		return hbox;
	}

	public VBox getVbox1()
	{
		return vbox1;
	}

	public VBox getVbox2()
	{
		return vbox2;
	}

	public VBox getVbox3()
	{
		return vbox3;
	}

	
	public LitltleSudoku()
	{
		individualCaseList = new ArrayList<>();
		init(vbox1);
		init(vbox2);
		init(vbox3);
		
		hbox.getChildren().addAll(vbox1, vbox2, vbox3);
		hbox.getStyleClass().add(LsudokuClass);
		
	}

	private void init(VBox vbox)
	{
		for(int i = 0; i < 3; i++)
		{
			IndividualCase indCase = new IndividualCase(Sudoku.getIndividualCaseId());
			individualCaseList.add(indCase);
			vbox.getChildren().add(indCase.getTextField());	
			
		}
	}	

}
