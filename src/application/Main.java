package application;
	
import controle.Controle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	//The Main ui container
	private BorderPane root = new BorderPane();
	private Controle controle = new Controle(root);
	private Button ajouterChapitre = new Button ("add");
	private Button ajouterQuestion = new Button ("add");
	private Button suivant = new Button("next");
	private Button ajouterExamen = new Button("add");
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			menu();
			primaryStage.show();
			choisir();
			ajouterChapitre();
			ajouterQuestion();
			genereExamen();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/*
	 * This method setup the menu and their click
	 */
	private void menu() {
		MenuBar menuBar= new MenuBar();
		root.setTop(menuBar);
		Menu chaptreMenu = new Menu("Chapter");
		Menu examMenu = new Menu("Exam");
		Menu expImpMenu = new Menu("Export/Import");
		menuBar.getMenus().addAll(chaptreMenu,examMenu,expImpMenu);
		MenuItem chaptreListMenuItem = new MenuItem("Chapter list");
		MenuItem chaptreAddMenuItem = new MenuItem("Add Chapter");
		MenuItem addQuestionMenuItem = new MenuItem("Add Question");
		MenuItem exitMenuItem = new MenuItem("Exit");
		chaptreMenu.getItems().addAll(chaptreListMenuItem,chaptreAddMenuItem,addQuestionMenuItem
				,exitMenuItem);
		MenuItem databaseAlimentationMenuItem = new MenuItem("Database implimentation");
		MenuItem chaptrExportMenuItem = new MenuItem("Export chapter");
		MenuItem ExamExportMenuItem = new MenuItem("Export exam");
		expImpMenu.getItems().addAll(databaseAlimentationMenuItem,chaptrExportMenuItem
				,ExamExportMenuItem);
		MenuItem examListMenuItem = new MenuItem("Exam list");
		MenuItem examCreateMenuItem = new MenuItem("Generate Exam");
		examMenu.getItems().addAll(examListMenuItem,examCreateMenuItem);
		chaptreAddMenuItem.setOnAction(e ->{
			controle.ajoutChapitreInterface(ajouterChapitre);
		});
		
		exitMenuItem.setOnAction(event ->{
			Platform.exit();
		});
		
		chaptreListMenuItem.setOnAction(e -> controle.afficherListeChapitre());
		
		addQuestionMenuItem.setOnAction(e -> controle.ajoutQuestionInterface(ajouterQuestion,suivant));
		
		examCreateMenuItem.setOnAction(e ->{
			controle.genereExamenInterface(ajouterExamen);
		});
		
		examListMenuItem.setOnAction(e -> controle.ExamenListInterface());
		
		chaptrExportMenuItem.setOnAction(e ->controle.creerChapitreFichier());
		
		ExamExportMenuItem.setOnAction(e ->controle.creerExamenFichier());
		
		databaseAlimentationMenuItem.setOnAction(e ->controle.implelenterBaseDonnee());
	}
	
	/*
	 * this method will call ajouterChapitre method from Conrole if ajouterChapitre button clicked
	 */
	private void ajouterChapitre() {
		ajouterChapitre.setOnAction(e -> controle.ajouterChapitre());
	}
	
	/*
	 * this method will call ajouterQCM method from Conrole if ajouterChapitre button clicked and isQCM from Controle is true
	 * this method will call ajouterQROC method from Conrole if ajouterChapitre button clicked and isQROC from Controle is true
	 */
	private void ajouterQuestion() {
		ajouterQuestion.setOnAction(e -> {
			if (controle.isQCM()) {
				controle.ajouterQCM();
				
			}
			if(controle.isQROC()) {
				controle.ajouterQROC();
			}
		});
	}
	/*
	 * If the user click the suivant(next) button it will check afficherAjoutquestionButton from Controle
	 * , call ajouterQuestion  from Controle
	 * and completerQuestionFomulaire from controle the will set ajouterQuestion visible so we can add the question 
	 * to the data base
	 * cl: we set the chapter number and question text chose qcm or qroc
	 * click next it will add question to the datoa base then complete the forum that will appear based 
	 * on our choice click add to add qroc or qcmto the database
	 */
	private void choisir() {
			suivant.setOnAction(e -> {
				if(controle.afficherAjoutquestionButton()) {
				controle.ajouterQuestion();
				controle.completerQuestionFomulaire();
				ajouterQuestion.setVisible(true);
				root.setBottom(null);
				}else {
					root.setRight(new Label("Please complete all the forum"));
				}
			});
		
		
	}
	
	/*
	 * this method will call genereExamen method from Conrole if ajouterChapitre button clicked
	 */
	private void genereExamen() {
		ajouterExamen.setOnAction(e -> controle.genereExamen());
	}
}
