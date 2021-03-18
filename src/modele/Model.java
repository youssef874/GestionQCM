package modele;

import java.io.BufferedInputStream;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.DAOCROC;
import model.dao.DAOChapitre;
import model.dao.DAOExam;
import model.dao.DAOQCM;
import model.dao.DAOQuestion;
import model.entite.Chapitre;
import model.entite.Exam;
import model.entite.QCM;
import model.entite.QROC;
import model.entite.Question;

/*
 * This Class hold all the data the application need like data base 
 */

public class Model {

	private DAOChapitre dCh;
	private DAOQuestion dQ;
	private DAOQCM dQCM;
	private DAOCROC dQROC;
	private DAOExam dE;
	private List<Chapitre> listeDesChapitre = new ArrayList<>();
	private List<Question> listeQuestion = new ArrayList<>();
	private List<Exam> listExamen = new ArrayList<>();

	public Model() {
		dCh = new DAOChapitre();
		dQ = new DAOQuestion();
		dQCM = new DAOQCM();
		dQROC = new DAOCROC();
		dE = new DAOExam();
		listeDesChapitre = dCh.findAll();
		listeQuestion = dQ.findAll();
		listExamen = dE.findAll();
	}

	/*
	 * This method to add a chapter in database 
	 * @param c: is chapter to add 
	 */
	public void ajoutChpitre(Chapitre c) {
		dCh.create(c);
	}

	/*
	 * This method to add a Question in database 
	 * @param id: is chapter id  which is a column in question table
	 * @param ennonce: is ennoncee which is a column in question table
	 */
	public void ajouterQuestion(int idChapitre, String ennoncee) {
		dQ.create(new Question(idChapitre, ennoncee));
	}

	/*
	 *This method convert chapter list in ObservableArray for the ListView
	 */
	
	public ObservableList<Chapitre> getListChapitre() {
		return FXCollections.observableArrayList(listeDesChapitre);
	}

	/*
	 * This method to refresh the database to update us the latest question list
	 */
	public void setListQuestion() {
		dQ = new DAOQuestion();
		this.listeQuestion = dQ.findAll();
	}

	/*
	 * This method to refresh the database to update us the latest chapter list
	 */
	public void setListChapiter() {
		dCh = new DAOChapitre();
		listeDesChapitre = dCh.findAll();
	}

	/*
	 * This method to refresh the database to update us the latest exam list
	 */
	public void setListExamen() {
		dE = new DAOExam();
		listExamen = dE.findAll();
	}

	/*
	 *This method convert question list in ObservableArray for the ListView
	 */
	
	public ObservableList<Question> getListQuestion() {

		return FXCollections.observableArrayList(listeQuestion);
	}

	/*
	 *This method convert exam list in ObservableArray for the ListView
	 */
	
	public ObservableList<Exam> getListExamen() {

		return FXCollections.observableArrayList(listExamen);
	}

	/*
	 * This method to add a qcm question to the database 
	 * @param question: hold the question property as the qcm is inherit from the question
	 * @param proposition: hold propositions 
	 * @propositionCorrecte: hold propositionCorrect 
	 */
	public void ajouterQCM(Question question, String[] proposition, boolean[] propositionCorrecte) {
		dQCM.create(new QCM(question.getIdQuation(), question.getIdChaptre(), question.getEnoonce(), proposition,
				propositionCorrecte));
	}

	/*
	 * This method to add a qroc question to the database 
	 * @param question: hold the question property as the qcm is inherit from the question
	 * @param motCle: hold motCle 
	 */
	public void ajouterQROC(Question question, String[] motCle) {
		dQROC.create(new QROC(question.getIdQuation(), question.getIdChaptre(), question.getEnoonce(), motCle));
	}
	
	/*
	 * This method to add a exam question to the database 
	 * @param nbreQuestion: hold nbreQuestion
	 * @param durree: hold durree
	 */
	public void ajouterExamen(int nbreQuestion,float durree) {
		dE.create(new Exam(durree,nbreQuestion));
	}
	
	/*
	 * This Method to create a text file hold all chapter in the database
	 * @param fichirer: it the path file which the file will be created in
	 */
	public void creeFichierChapitre(String fichier) {
		try {
			FileWriter file = new FileWriter(fichier);
			for(int i=0;i< listeDesChapitre.size();i++) {
				file.write("chapitre de nombre: "+listeDesChapitre.get(i).getIdChapitre()+" est de titre: "
			+listeDesChapitre.get(i).getTitre()+"\n");
				
			}
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * This Method to create a text file hold all Exam in the database
	 * @param fichirer: it the path file which the file will be created in
	 */
	public void creerFichierExamen(String chemin ) {
		try {
			FileWriter file = new FileWriter(chemin);
			System.out.println(listExamen);
			for(int i=0;i< listExamen.size();i++) {
				file.write("chapitre de nombre: "+listExamen.get(i).getIdExam()+" , de duree: "
			+listExamen.get(i).getDurree()+" et a de "+listExamen.get(i).getNbreQuestion()+" questions"+"\n");
				
			}
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * This Method to read a text file an implemented it into question and(qroc/qcm) tables in the database 
	 * @param fichirer: it the path file which the file will be reading it
	 */
	
	public void implementerFichier(String chemin) {
		try {
			FileInputStream f = new FileInputStream(chemin);
			BufferedInputStream f11 = new BufferedInputStream(f);
			DataInputStream f111 = new DataInputStream(f11);
			while(f.read() != -1) {
				//int idChapitre = f111.readInt();
				Scanner s = new Scanner(new File(chemin));
				int idChapitre = s.nextInt();
				f111.readShort();
				System.out.println("idChapitre: "+idChapitre);
				f111.readLine();
				String choix  = s.next();
				System.out.println("choix: "+choix);
				String enoncee = f111.readLine();
				System.out.println("enoncee: "+enoncee);
				dQ.create(new Question(idChapitre,enoncee));
				if(choix.equals("QCM")) {
					readQCM(f111);
				}else if(choix.equals("QROC")) {
					readQROC(f111);
				}
				
			}
			f111.close();
			f11.close();
			f.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * This Method to read a text file an implemented it into qcm table in the database 
	 * @param fichirer: it the path file which the file will be reading it
	 */
	
	private void readQCM(DataInputStream data) {
		try {
			
			Question q = dQ.findAll().get(dQ.findAll().size()-1);
			String[] propsition = {data.readLine(),data.readLine(),data.readLine()};
			System.out.println("proposition: "+propsition[0]+","+propsition[1]+","+propsition[2]);
			String reponce = data.readLine();
			System.out.println("reponce: "+reponce);
			boolean[] propositionCorrecte = {false,false,false};
			if(reponce.contains("A")) {
				propositionCorrecte[0] = true;
			}
			if(reponce.contains("B")) {
				propositionCorrecte[1] = true;
			}
			if(reponce.contains("C")) {
				propositionCorrecte[2] = true;
			}
			dQCM.create(new QCM(q.getIdQuation(),q.getIdChaptre(),q.getEnoonce(),propsition,propositionCorrecte));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * This Method to read a text file an implemented it into qroc table in the database 
	 * @param fichirer: it the path file which the file will be reading it
	 */
	
	private void readQROC(DataInputStream data) {
		try {
			Question q = dQ.findAll().get(dQ.findAll().size()-1);
			String[] motCle = {data.readLine(),data.readLine(),data.readLine()};
			dQROC.create(new QROC(q.getIdQuation(),q.getIdChaptre(),q.getEnoonce(),motCle));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
