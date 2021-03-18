package view;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
 * This Class contain add interface to add question into database
 */


public class AjoutQuestionView {

	//the input how will hold the chapter number which is the chapter primary key in the chapter table
	private TextField idChapitreTextField = new TextField();
	//The input how will hold the question text which is the ennoncee column in the question table
	private TextField EnonceeTextField = new TextField();
	//The input how will hold the qcm  first proposition which is the column in the qcm table
	private TextField propositinTextField1 = new TextField(); 
	//The input how will hold the qcm  second proposition which is the column in the qcm table
	private TextField propositinTextField2 = new TextField(); 
	//The text how will hold the qcm  third proposition which is the column in the qcm table
	private TextField propositinTextField3 = new TextField(); 
	//The text how will hold the qroc  first motCle which is the column in the qroc table
	private TextField motCleTextField1 = new TextField(); 
	//The text how will hold the qroc  second motCle which is the  column in the qroc table 
	private TextField motCleTextField2 = new TextField();
	//The text how will hold the qroc  third motCle which is the  column in the qroc table 
	private TextField motCleTextField3 = new TextField();
	//The CheckBox to indicate whether the first proposition is the correct one
	private CheckBox propositionCorrecteCheckBox1 = new CheckBox();
	//The CheckBox to indicate whether the second proposition is the correct one
	private CheckBox propositionCorrecteCheckBox2 = new CheckBox();
	//The CheckBox to indicate whether the third proposition is the correct one
	private CheckBox propositionCorrecteCheckBox3 = new CheckBox();
	//The CheckBox to indicate if this question is qcm
	private CheckBox qcm = new CheckBox("QCM ");
	//The CheckBox to indicate if this question is qcm
	private CheckBox qroc = new CheckBox("QROC ");
	//the add button that will add the question to the database if clicked
	private Button ajouter ;
	
	//@param:suivant is the button that will creat the question Forum if it is qcm or qroc
	public AjoutQuestionView(Button ajouter,BorderPane bp,Button suivant) {
		this.ajouter = ajouter;
		bp.setRight(null);
		bp.setCenter(layoutSetup());
		bp.setBottom(questionTypeSetup(suivant,qcm,qroc));
		ajouter.setVisible(false);
	}
	
	/*
	 * Setup the id part to help the user to know the place to put the chapter id for the question
	 */
	private HBox idChapitreSetup() {
		HBox hb =new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(new Label("The chapter number for this question "));
		hb.getChildren().add(idChapitreTextField);
		return hb;
	}
	
	/*
	 * Setup the id part to help the user to know the place to put the question text
	 */
	private HBox enonceeSetup() {
		HBox hb =new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(new Label("the question text "));
		hb.getChildren().add(EnonceeTextField);
		return hb;
	}
	
	/*
	 * This method set the chapter id and question text parts in the layout with the add button
	 */
	public VBox layoutSetup() {
		VBox vb = new VBox();
		vb.setPadding(new Insets(20, 10, 20, 10));
		vb.getChildren().add(idChapitreSetup());
		vb.getChildren().add(enonceeSetup());
		vb.getChildren().add(ajouter);
		ajouter.setPadding(new Insets(20, 10, 20, 10));
		return vb;
	}
	
	/*
	 * This method set the qcm CheckBox  and qroc CheckBox parts in the layout with the next button
	 */
	public VBox questionTypeSetup(Button suivant,CheckBox qcm,CheckBox qroc) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(20, 10, 20, 10));
		vb.getChildren().add(qcm);
		vb.getChildren().add(qroc);
		vb.getChildren().add(suivant);
		return vb;
	}

	/*
	 * This method set the  CheckBox and Text field 
	 */
	private HBox hboxSetup(TextField t ,CheckBox c,String s) {
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(t);
		hb.getChildren().add(c);
		t.setPromptText(s); //to set the hint text
		t.getParent().requestFocus(); //to not setting the focus on that node so that the hint will display immediately
		return hb;
	}
	
	/*
	 * This method set the Text field 
	 */
	private HBox hboxSetup(TextField t ,String s) {
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(t);
		t.setPromptText(s); //to set the hint text
		t.getParent().requestFocus(); //to not setting the focus on that node so that the hint will display immediately
		return hb;
	}
	
	/*
	 * This method set the  qcm layout if the user chose the question to be qcm type
	 */
	public VBox qcmSetup() {
		VBox vb = new VBox();
		vb.setPadding(new Insets(20, 10, 20, 10));
		vb.getChildren().add(hboxSetup(propositinTextField1,propositionCorrecteCheckBox1,"proposition1"));
		vb.getChildren().add(hboxSetup(propositinTextField2,propositionCorrecteCheckBox2,"proposition2"));
		vb.getChildren().add(hboxSetup(propositinTextField3,propositionCorrecteCheckBox3,"proposition3"));
		return vb;
	}
	
	/*
	 * This method set the  qroc layout if the user chose the question to be qroc type
	 */
	public VBox qrocSetup() {
		VBox vb = new VBox();
		vb.setPadding(new Insets(20, 10, 20, 10));
		vb.getChildren().add(hboxSetup(motCleTextField1,"proposition1"));
		vb.getChildren().add(hboxSetup(motCleTextField2,"proposition2"));
		vb.getChildren().add(hboxSetup(motCleTextField3,"proposition3"));
		return vb;
	}
	
	public TextField getIdChapitreTextField() {
		return idChapitreTextField;
	}

	public TextField getEnonceeTextField() {
		return EnonceeTextField;
	}

	public CheckBox getQcm() {
		return qcm;
	}

	public CheckBox getQroc() {
		return qroc;
	}

	public TextField getPropositinTextField1() {
		return propositinTextField1;
	}

	public TextField getPropositinTextField2() {
		return propositinTextField2;
	}

	public TextField getPropositinTextField3() {
		return propositinTextField3;
	}

	public CheckBox getPropositionCorrecteCheckBox1() {
		return propositionCorrecteCheckBox1;
	}

	public CheckBox getPropositionCorrecteCheckBox2() {
		return propositionCorrecteCheckBox2;
	}

	public CheckBox getPropositionCorrecteCheckBox3() {
		return propositionCorrecteCheckBox3;
	}

	public TextField getMotCleTextField1() {
		return motCleTextField1;
	}

	public TextField getMotCleTextField2() {
		return motCleTextField2;
	}

	public TextField getMotCleTextField3() {
		return motCleTextField3;
	}
	
	
}
