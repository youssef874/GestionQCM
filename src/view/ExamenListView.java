package view;

import javafx.collections.ObservableList;

import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import model.entite.Exam;

/*
 * This class hold the interface to show exam list in the database
 */

public class ExamenListView {

	private ListView<Exam> listExamen;
	
	public ExamenListView(ObservableList<Exam> list,BorderPane bp) {
		listExamen = new ListView<>(list);
		bp.setLeft(null);
		bp.setRight(null);
		bp.setBottom(null);
		bp.setCenter(listExamen);
	}

	public ListView<Exam> getListExamen() {
		return listExamen;
	}
	
	
}
