package Sudoku;

import java.util.ArrayList;

import javafx.scene.layout.VBox;

public class Sudoku
{
	private ArrayList<LitltleSudoku> littleSudokuList;
	private VBox vbox1 = new VBox();
	private VBox vbox2 = new VBox();
	private VBox vbox3 = new VBox();
	private static int IndividualCaseId;
	private static VerificationReviewed VerificationSystem;

	public Sudoku()
	{
		littleSudokuList = new ArrayList<>();
		init(vbox1);
		init(vbox2);
		init(vbox3);
		IndividualCaseId = 1;
		VerificationSystem = new VerificationReviewed(littleSudokuList);

	}

	public static int getIndividualCaseId()
	{
		return IndividualCaseId;
	}

	public VBox getVbox1()
	{
		return vbox1;
	}

	public static VerificationReviewed getVerificationSystem()
	{
		return VerificationSystem;
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

		for (int i = 0; i < 3; i++)
		{
			LitltleSudoku lSudoku = new LitltleSudoku();
			littleSudokuList.add(lSudoku);
			vbox.getChildren().add(lSudoku.getHbox());

		}
	}

	public ArrayList<LitltleSudoku> getLittleSudokuList()
	{
		return littleSudokuList;
	}

}
