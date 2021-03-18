package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
 * This class hold the interface to create Exam and add it to the database
 */

public class GenererExamenView {

	//the input how will hold the number of questions which is the QuestionNbr column in the Exam table
	private TextField nbrQuestionTextField = new TextField();
	//the input how will hold the exam tmer which is the duree column in the Exam table
	private TextField dureeTextField = new TextField();
	//the add button that will add the Exam to the database if clicked
	private Button ajouter;
	
	public GenererExamenView(Button ajouter,BorderPane bp) {
		this.ajouter = ajouter;
		bp.setLeft(null);
		bp.setRight(null);
		bp.setBottom(null);
		bp.setCenter(layoutSetup());
	}
	
	/*
	 * This method set up the inteface of this class
	 */
	private VBox layoutSetup() {
		VBox vb = new VBox();
		vb.setPadding(new Insets(20, 10, 20, 10));
		vb.getChildren().add((nbreQuestionSetup()));
		vb.getChildren().add(dureeSetUp());
		vb.getChildren().add(ajouter);
		return vb;
	}
	
	/*
	 * This method setup the number question ui
	 */
	private HBox nbreQuestionSetup() {
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(new Label("nombre des question"));
		hb.getChildren().add(nbrQuestionTextField);
		return hb;
	}

	/*
	 * This method setup the number exam time ui
	 */
	private HBox dureeSetUp() {
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(new Label("durree de l'examen"));
		hb.getChildren().add(dureeTextField);
		return hb;
	}

	public TextField getDureeTextField() {
		return dureeTextField;
	}

	public TextField getNbrQuestionTextField() {
		return nbrQuestionTextField;
	}

	
	
	
}
