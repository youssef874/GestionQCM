package controle;

import javafx.collections.ObservableList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import model.entite.Chapitre;
import model.entite.Question;
import modele.Model;
import view.AjoutFichierView;
import view.AjoutQuestionView;
import view.ChapitreListView;
import view.ExamenListView;
import view.GenererExamenView;

/*
 * This class contain the user interaction to the application and bond the main with the rest
 */

public class Controle {
	
	private BorderPane bp;
	private AjoutFichierView a;
	private ChapitreListView c;
	private AjoutQuestionView aQ;
	private GenererExamenView gQ;
	private ExamenListView eL ;
	private Model model = new Model();
	//To indicate if the user chose question to be qcm in the add question ui 
	private boolean isQCM = false;
	//To indicate if the user chose question to be qroc in the add question ui 
	private boolean isQROC = false;

	public Controle(BorderPane bp) {
		this.bp = bp;
	}
	
	/*
	 * This method to show add chapter
	 * ui
	 */
	public void ajoutChapitreInterface(Button ajouter) {
		a = new AjoutFichierView(bp,ajouter);
	}
	
	/*
	 * This method responsible of reading l'utulisateur input
	 * from TextField and add them to chapter table in the database
	 * with Model class help
	 */
	public void ajouterChapitre() {
		int id = Integer.parseInt(a.getIdTextField().getText());
		
		String titre = a.getTitreTextField().getText();
		model.ajoutChpitre(new Chapitre(id,titre));
		model.setListChapiter();
	}
	
	/*
	 * This method responsible in showing chapter list ui
	 */
	public void afficherListeChapitre() {
		ObservableList<Chapitre> listChapitre =  model.getListChapitre();
		if(!listChapitre.isEmpty()) {
			c = new ChapitreListView(bp,listChapitre);
		}
	}
	
	/*
	 * This method showing add question ui
	 */
	public void ajoutQuestionInterface(Button ajouter,Button suivant) {
		aQ= new AjoutQuestionView(ajouter,bp,suivant);
	}
	
	/*
	 * This method responsible of reading l'utulisateur input
	 * from TextField and add them to question table in the data base
	 * with Model class help
	 */
	public void ajouterQuestion() {
		int idChapitre = Integer.parseInt(aQ.getIdChapitreTextField().getText());
		System.out.println("idChapitre :"+idChapitre);
		String enoncee = aQ.getEnonceeTextField().getText();
		System.out.println("enoncee :"+enoncee);
		model.ajouterQuestion(idChapitre, enoncee);
		model.setListQuestion();
		System.out.println(model.getListQuestion());
	}
	
	/*
	 * This method verify the requires condition next button in  AjoutQuestionView
	 * to function correctly 
	 */
	
	public boolean afficherAjoutquestionButton() {
		if(aQ != null) {
			if((aQ.getQcm().isSelected() || aQ.getQroc().isSelected())
					&& (!aQ.getEnonceeTextField().getText().isEmpty() && 
							!aQ.getIdChapitreTextField().getText().isEmpty())) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	/*
	 * This method work when the user click next button of class 
	 *  AjoutQuestionView to chose QCm or CROC forum and show it
	 */
	public void completerQuestionFomulaire() {
		if(aQ.getQcm().isSelected() && !aQ.getQroc().isSelected()) {
			bp.setRight(aQ.qcmSetup());
			isQCM = true;
			isQROC = false;
		}else if(!aQ.getQcm().isSelected() && aQ.getQroc().isSelected()) {
			bp.setRight(aQ.qrocSetup());
			isQCM = false;
			isQROC = true;
		}else if(aQ.getQcm().isSelected() && aQ.getQroc().isSelected()) {
			bp.setRight(new Label("svp choisir un seul type de question"));
			isQCM = false;
			isQROC = false;
		}
	}
	
	/*
	 * This method to add qcm to database with Model help
	 */
	public void ajouterQCM() {
		
		Question question = model.getListQuestion().get(model.getListQuestion().size()-1);
		
		String[] proposition = {aQ.getPropositinTextField1().getText(),aQ.getPropositinTextField2().getText()
				,aQ.getPropositinTextField3().getText()};
		boolean[] propositionCorrecte = new boolean[3];
		if(aQ.getPropositionCorrecteCheckBox1().isSelected()) {
			propositionCorrecte[0] = true;
		}else {
			propositionCorrecte[0] = false;
		}
		if(aQ.getPropositionCorrecteCheckBox2().isSelected()) {
			propositionCorrecte[1] = true;
		}else {
			propositionCorrecte[1] = false;
		}
		if(aQ.getPropositionCorrecteCheckBox3().isSelected()) {
			propositionCorrecte[2] = true;
		}else {
			propositionCorrecte[2] = false;
		}
		if(question != null) {
			model.ajouterQCM(question, proposition, propositionCorrecte);
			
		}
	}
	
	/*
	 * This method to add qroc to database with Model help
	 */
	public void ajouterQROC() {
		Question question = model.getListQuestion().get(model.getListQuestion().size()-1);
		System.out.println(question);
		String[] motCle = {aQ.getMotCleTextField1().getText()
				,aQ.getMotCleTextField2().getText(),aQ.getMotCleTextField3().getText()};
		if(question != null) {
			model.ajouterQROC(question, motCle);
		}
	}

	/*
	 * This method to show create exam ui 
	 */
	
	public void genereExamenInterface(Button ajouter) {
		gQ = new GenererExamenView(ajouter,bp);
		
	}
	
	/*
	 * This method to add exam to database with Model help
	 */
	public void genereExamen() {
		int nbreQuestion = Integer.parseInt(gQ.getNbrQuestionTextField().getText());
		float duree = Float.parseFloat(gQ.getDureeTextField().getText());
		System.out.println("nbre question :"+nbreQuestion);
		System.out.println("duree :"+duree);
		model.ajouterExamen(nbreQuestion, duree);
		model.setListExamen();
	}
	
	/*
	 * This method to show exam list 
	 */
	public void ExamenListInterface() {
		eL = new ExamenListView(model.getListExamen(),bp);
	}
	
	/*
	 * This method call creeFichierChapitre method creeFichierChapitre of Model
	 * and give it a path how contain Chapter id
	 */
	public void creerChapitreFichier() {
		model.creeFichierChapitre("C:\\Users\\Youssef\\eclipse-workspace\\GestionQcm2\\chapitre/chapitre"
				+model.getListChapitre().get(model.getListChapitre().size()-1).getIdChapitre()+".txt");
	}
	
	/*
	 * This method call creeFichierExam method creeFichierChapitre of Model
	 * and give it a path how contain exam id
	 */
	public void creerExamenFichier() {
		model.creerFichierExamen("C:\\Users\\Youssef\\eclipse-workspace\\GestionQcm2\\Examens/examen"
				+model.getListExamen().get(model.getListExamen().size()-1).getIdExam()+".txt");
	}
	
	/*
	 * This method call implementerFichier from Model which update the database with data imported from file
	 */
	public void implelenterBaseDonnee() {
		model.implementerFichier("base de donnee/question22.txt");
	}
	
	public boolean isQCM() {
		return isQCM;
	}

	public boolean isQROC() {
		return isQROC;
	}
}

