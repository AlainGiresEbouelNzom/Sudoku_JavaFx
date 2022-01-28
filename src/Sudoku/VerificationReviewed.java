package Sudoku;

import java.util.ArrayList;

public class VerificationReviewed
{

	private ArrayList<LitltleSudoku> LittleSudokuList;
	private ArrayList<ArrayList<IndividualCase>> ListOfRowList;
	private ArrayList<ArrayList<IndividualCase>> ListOfColumnList;
	private ArrayList<IndividualCase> FalseIndCaseList;

	public VerificationReviewed(ArrayList<LitltleSudoku> littleSudokuList)
	{
		LittleSudokuList = littleSudokuList;
		ListOfRowList = new ArrayList<ArrayList<IndividualCase>>();
		ListOfColumnList = new ArrayList<ArrayList<IndividualCase>>();
		FalseIndCaseList = new ArrayList<IndividualCase>();

		for (int i = 0; i < 9; i++)
		{
			ListOfRowList.add(new ArrayList<IndividualCase>());
			ListOfColumnList.add(new ArrayList<IndividualCase>());
		}
		LittleSudokuDistribution();

	}

	/* Repartir les individuals cases dans les listes */
	private void LittleSudokuDistribution()
	{
		// LittleSudokuList[0].IndividualCaseList[0].BorderColor = "red";
		int column = 0;
		int row = 0;

		for (int i = 0; i < 3; i++)
		{
			Distribution(LittleSudokuList.get(i), column, row);
			column += 3;
		}

		column = 0;
		row += 3;
		for (int i = 3; i < 6; i++)
		{
			Distribution(LittleSudokuList.get(i), column, row);
			column += 3;
		}

		column = 0;
		row += 3;
		for (int i = 6; i < 9; i++)
		{
			Distribution(LittleSudokuList.get(i), column, row);
			column += 3;
		}
	}

	private void Distribution(LitltleSudoku littleSudokuView, int column, int row)
	{
		int initialColumn = column;
		for (int i = 0; i < 3; i++)
		{
			SubDistribution(littleSudokuView, column++, row, i);
		}

		row += 1;
		column = initialColumn;
		for (int i = 3; i < 6; i++)
		{
			SubDistribution(littleSudokuView, column++, row, i);
		}

		row += 1;
		column = initialColumn;
		for (int i = 6; i < 9; i++)
		{
			SubDistribution(littleSudokuView, column++, row, i);
		}
	}

	private void SubDistribution(LitltleSudoku littleSudokuView, int column, int row, int i)
	{
		IndividualCase indCase = littleSudokuView.getIndividualCaseList().get(i);

		indCase.getBelongingList().add(littleSudokuView.getIndividualCaseList());
		ListOfColumnList.get(column).add(indCase);
		ListOfRowList.get(row).add(indCase);

		indCase.getBelongingList().add(ListOfColumnList.get(column));
		indCase.getBelongingList().add(ListOfRowList.get(row));
	}

	public void Verification_2()
	{
		for (LitltleSudoku lsudoku : LittleSudokuList)
		{
			for (IndividualCase indCase : lsudoku.getIndividualCaseList())
			{
				Verification_2(indCase);

			}
		}

	}

	private void Verification_2(IndividualCase indCase)
	{
		boolean isRed = false;
		for (ArrayList<IndividualCase> list : indCase.getBelongingList())
		{
			for (IndividualCase indC : list)
				if (indCase != indC
						&& indC.getBigTextField().getText().equals(indCase.getBigTextField().getText())
						&& indC.getBigTextField().getText() != "")
				{
					indC.setColor("red");
					indCase.setColor("red");
					FalseIndCaseList.add(indC);
					FalseIndCaseList.add(indCase);
					isRed = true;
					break;
				}
		}

		if (!isRed && indCase.getColor() != "white")
			indCase.setColor("white");

	}

}
