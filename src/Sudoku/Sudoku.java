package Sudoku;

import java.util.ArrayList;

import javafx.scene.layout.VBox;

public class Sudoku
{
	private static ArrayList <LitltleSudoku> littleSudokuList;
	private VBox vbox1 = new VBox();
	private VBox vbox2 = new VBox();
	private VBox vbox3 = new VBox();
	private static int IndividualCaseId;
	
	public Sudoku()
	{
		littleSudokuList =  new ArrayList<>();
		init(vbox1);
		init(vbox2);
		init(vbox3);
		IndividualCaseId = 1;
	}

	public static int getIndividualCaseId()
	{
		return IndividualCaseId;
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

	private void init(VBox vbox)
	{
		
		for(int i = 0; i < 3; i++)
		{
			LitltleSudoku lSudoku = new LitltleSudoku();
			littleSudokuList.add(lSudoku);
			vbox.getChildren().add(lSudoku.getHbox());	
			
		}
	}

	public static ArrayList<LitltleSudoku> getLittleSudokuList()
	{
		return littleSudokuList;
	}

		

}
