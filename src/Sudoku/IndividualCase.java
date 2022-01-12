package Sudoku;

import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class IndividualCase
{
	private TextField bigTextField;	
	private TextField textField1;
	private TextField textField2;
	private TextField textField3;
	private TextField textField4;
	private TextField textField5;	
	private Group littleNbrGroup;
	private int id;
	private static final String textfieldClass = "textfield";
	private static final String littlefieldClass = "littlefield";
	private StackPane stackPane;
	private boolean bigFaceToFront;
	private boolean littleGroupToFront;

	public IndividualCase(int id)
	{
		this.id = id;
		bigFaceToFront = true;
		init();

		bigTextField.getStyleClass().add(textfieldClass);

		stackPane.getChildren().addAll(littleNbrGroup, bigTextField);

		//littleNbrGroup.toFront();

		CreateLittleCssClass();
		
		littleNbrPosition();		
		
	}		

	public Group getLittleNbrGroup()
	{
		return littleNbrGroup;
	}

	public boolean isBigFaceToFront()
	{
		return bigFaceToFront;
	}

	public void setBigFaceToFront(boolean bigFaceToFront)
	{
		this.bigFaceToFront = bigFaceToFront;
	}

	public boolean isLittleGroupToFront()
	{
		return littleGroupToFront;
	}

	public void setLittleGroupToFront(boolean littleGroupToFront)
	{
		this.littleGroupToFront = littleGroupToFront;
	}

	public TextField getTextField()
	{
		return bigTextField;
	}

	public int getId()
	{
		return id;
	}
	
	public TextField getBigTextField()
	{
		return bigTextField;
	}	

	public TextField getTextField1()
	{
		return textField1;
	}	

	public TextField getTextField2()
	{
		return textField2;
	}
	
	public TextField getTextField3()
	{
		return textField3;
	}

	public TextField getTextField4()
	{
		return textField4;
	}

	public TextField getTextField5()
	{
		return textField5;
	}		

	public StackPane getStackPane()
	{
		return stackPane;
	}
	

	private void init()
	{
		this.stackPane = new StackPane();

		bigTextField = new TextField();

		this.textField1 = new TextField();
		this.textField2 = new TextField();
		this.textField3 = new TextField();
		this.textField4 = new TextField();
		this.textField5 = new TextField();

		littleNbrGroup = new Group();
		littleNbrGroup.getChildren().addAll(textField1, textField2, textField3, textField4, textField5);

	}	

	private void CreateLittleCssClass()
	{
		textField1.getStyleClass().add(littlefieldClass);
		textField2.getStyleClass().add(littlefieldClass);
		textField3.getStyleClass().add(littlefieldClass);
		textField4.getStyleClass().add(littlefieldClass);
		textField5.getStyleClass().add(littlefieldClass);
		
		textField1.setId("littleField1");
		textField2.setId("littleField2");
		textField3.setId("littleField3");
		textField4.setId("littleField4");
		textField5.setId("littleField5");
	}
	
	private void littleNbrPosition()
	{
		textField1.setTranslateY(22);
		textField2.setTranslateY(22);
		textField2.setTranslateX(89);
		//textField3.setTranslateX(45);		
		textField4.setTranslateY(-22);
		textField5.setTranslateY(-22);		
		textField5.setTranslateX(89);		
	}

	
		
	


}
