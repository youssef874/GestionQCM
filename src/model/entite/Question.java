package model.entite;

/*
 * This class hold the Question table for the database ,and it contain idQuation as primary key, idChaptre it is a foreign key 
 * from chapitre table,enoonce it is column of type varchar
 */

public class Question {

	private int idQuation;
	private int idChaptre;
	private String enoonce;
	
	public Question(int idQuation, int idChaptre, String enoonce) {
		super();
		this.idQuation = idQuation;
		this.idChaptre = idChaptre;
		this.enoonce = enoonce;
	}
	
	public Question(int idChaptre, String enoonce) {
		super();
		this.idChaptre = idChaptre;
		this.enoonce = enoonce;
	}
	
	public int getIdQuation() {
		return idQuation;
	}
	public int getIdChaptre() {
		return idChaptre;
	}
	public String getEnoonce() {
		return enoonce;
	}
	@Override
	public String toString() {
		return "Question [idQuation=" + idQuation + ", idChaptre=" + idChaptre + ", enoonce=" + enoonce + "]";
	}
	
	
}
