package view;

import javafx.collections.ObservableList;

import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import model.entite.Chapitre;

/*
 * This class hold the interface to show chapter list in the database
 */

public class ChapitreListView {
	
	public ChapitreListView(BorderPane bp,ObservableList<Chapitre> list) {
		bp.setCenter(CreateList(list));
	}
	
	private ListView CreateList(ObservableList<Chapitre> list) {
		return new ListView (list);
	}

}
