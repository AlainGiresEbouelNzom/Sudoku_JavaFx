package Sudoku;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BackupSystem
{
	private static Stack<String> UndoStack = new Stack<String>();
	private static Stack<String> RedoStack = new Stack<String>();
	private static boolean StackIsLocked;
	private static boolean Undo_redo_is_Active;

	/*
	 * public static void Undo() { StackIsLocked = true; Undo_redo_is_Active = true;
	 * RedoStack.push(UndoStack.pop());
	 * 
	 * Load(UndoStack.peek()); StackIsLocked = false; Undo_redo_is_Active = false; }
	 * 
	 * public static void Redo() { StackIsLocked = true; Undo_redo_is_Active = true;
	 * UndoStack.push(RedoStack.pop());
	 * 
	 * Load(UndoStack.peek()); StackIsLocked = false; Undo_redo_is_Active = false; }
	 */

	/*
	 * public static void SaveOnStacks() { if (StackIsLocked == false) {
	 * UndoStack.Push(Save(SudokuGridViewModel.littleGridViewModels));
	 * 
	 * if (RedoStack.size() > 0) { RedoStack.clear(); } } }
	 */

	/*
	 * public static void BackupActivation() { string DataToSave;
	 * 
	 * DataToSave = Save(SudokuGridViewModel.littleGridViewModels);
	 * File.WriteAllText(@"backupFile.txt", DataToSave); }
	 */

	public static void Save(ArrayList<LitltleSudoku> listOfLittleNumber)
			throws TransformerException, ParserConfigurationException
	{

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document gameData = docBuilder.newDocument();

		Element sudoku = gameData.createElement("Sudoku");
		gameData.appendChild(sudoku);

		Element littleSudoku = gameData.createElement("LittleSudoku");
		sudoku.appendChild(littleSudoku);

		for (LitltleSudoku l : listOfLittleNumber)
		{
			Element childLittleSudoku = gameData.createElement("ChildLittleSudoku");
			littleSudoku.appendChild(childLittleSudoku);

			for (IndividualCase ind : l.getIndividualCaseList())
			{
				Element individualCase = gameData.createElement("IndividualCase");

				Attr BgNbr = gameData.createAttribute("id3");
				Attr color = gameData.createAttribute("id2");

				BgNbr.setValue(ind.getBigTextField().getText());
				color.setValue(ind.getColor());
				individualCase.setAttributeNode(BgNbr);
				individualCase.setAttributeNode(color);
				childLittleSudoku.appendChild(individualCase);

				for (LittleNumber LNumber : ind.getLittleNbrList())
				{
					Element LNumbers = gameData.createElement("LNumbers");
					Attr lnumber = gameData.createAttribute("lnumber");

					lnumber.setValue(LNumber.getTextField().getText());
					LNumbers.setAttributeNode(lnumber);
					individualCase.appendChild(LNumbers);
				}
			}

		}

		try (FileOutputStream output = new FileOutputStream("save.xml"))
		{

			writeXml(gameData, output);
		}

		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public static void Load(ArrayList<LitltleSudoku> listOfLittleNumber)
			throws TransformerException, ParserConfigurationException
	{

		for (LitltleSudoku l : listOfLittleNumber)
		{
			for (IndividualCase ind : l.getIndividualCaseList())
			{
				if (!ind.getBigTextField().getText().trim().equals(""))
				{
					ind.setColor(MainApp.colorRandom());

					for (LittleNumber LNumber : ind.getLittleNbrList())
					{
						if (!LNumber.getTextField().getText().trim().equals(""))
							LNumber.setColor(MainApp.colorRandom());

					}
				}
			}

		}
	}

//	/*	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//		
//		FileInputStream input = new FileInputStream("save.xml");
//		String data = input.toString();
//
//	
//
//        ArrayList<String> dataList = new ArrayList<String>();
//        int i = 0;
//
//        Document gameData = docBuilder.newDocument();
//        //XmlDocument gameData = new XmlDocument();*/
//        
//
//        //gameData.setXmlVersion(data);
//
//        for ( Node little : gameData.getc ("/Sudoku/LittleSudoku/ChildLittleSudoku"))
//        {
//            foreach (XmlNode individual in little.SelectNodes("IndividualCase"))
//            {
//                dataList.Add(individual.Attributes["id3"].Value);
//                dataList.Add(individual.Attributes["id2"].Value);
//
//                foreach (XmlNode lnumber in individual.SelectNodes("LNumbers"))
//                {
//                    if (lnumber.Attributes["lnumber"].Value == "")
//                        dataList.Add("0");
//                    else
//                        dataList.Add(lnumber.Attributes["lnumber"].Value);
//                }
//            }
//        }
//        
//        foreach (LittleSudokuGridViewModel little in SudokuGridViewModel.littleGridViewModels)
//        {
//            foreach (IndividualCaseViewModel ind in little.IndividualCaseViewModels)
//            {
//                if (dataList[i] == "0")
//                {
//                    ind.bnvm.BigNumber = "";
//                    i++;
//                }
//                else
//                {
//                    ind.bnvm.BigNumber = dataList[i++];
//                }
//                ind.CurrentColor = dataList[i++];
//
//                string[] arrayLnumber = new string[ind.lnvm.GetNumbers().Count];
//                
//
//                for (int j = 0; j < ind.lnvm.GetNumbers().Count; j++)
//                {
//                    if (dataList[i] == "0")
//                    {
//                        arrayLnumber[j] = "";
//                        i++;
//                    }
//                    else
//                    {
//                        arrayLnumber[j] = dataList[i++];
//                    }
//                }
//                
//                ind.lnvm.LittleNumber1 = arrayLnumber[0];
//                ind.lnvm.LittleNumber2 = arrayLnumber[1];
//                ind.lnvm.LittleNumber3 = arrayLnumber[2];
//                ind.lnvm.LittleNumber4 = arrayLnumber[3];
//                ind.lnvm.LittleNumber5 = arrayLnumber[4];
//                                   
//            }
//        }
//        
//    }

	// write doc to output stream
	private static void writeXml(Document doc, OutputStream output) throws TransformerException
	{

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		// pretty print
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(output);

		transformer.transform(source, result);

	}
}
//}
