package view;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
 * This Class contain add interface to add chapter into database
 */

public class AjoutFichierView {
	//the add button that will add the chapter to the database if clicked
	private Button ajouter;
	//the input how will hold the chapter number which is the chapter primary key in the chapter table
	private TextField idTextField = new TextField();
	//the input how will hold the chapter title which is the titre column in the chapter table
	private TextField titreTextField = new TextField();;

	public AjoutFichierView(BorderPane bp,Button ajouter) {
		this.ajouter =  ajouter;
		bp.setCenter(layoutSetup());
		
	}
	
	/*
	 * Setup the id part to help the user to know the place to put the chapter id
	 */
	private HBox idSetup() {
		HBox hb =new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(new Label("The chapter number"));
		hb.getChildren().add(idTextField);
		return hb;
	}

	/*
	 * Setup the id part to help the user to know the place to put the chapter title
	 */
	
	private HBox titreSetup() {
		HBox hb =new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(new Label("The chapter title"));
		hb.getChildren().add(titreTextField);
		return hb;
	}
	
	
	/*
	 * Setup the Layout put everything together
	 */
	public VBox layoutSetup() {
		VBox vb = new VBox();
		vb.setPadding(new Insets(20, 10, 20, 10));
		vb.getChildren().add(idSetup());
		vb.getChildren().add(titreSetup());
		vb.getChildren().add(ajouter);
		ajouter.setPadding(new Insets(20, 10, 20, 10));
		return vb;
	}

	public TextField getIdTextField() {
		return idTextField;
	}

	public TextField getTitreTextField() {
		return titreTextField;
	}
	
	
}
