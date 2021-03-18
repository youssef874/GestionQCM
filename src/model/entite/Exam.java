package model.entite;

/*
 * This class hold the Exam table for the database ,and it contain idExam as primary key, durree in number and nbreQuestion
 *  of type number
 */

public class Exam {

	private int idExam;
	private float durree;
	private int nbreQuestion;
	
	public Exam(int idExam, float durree, int nbreQuestion) {
		super();
		this.idExam = idExam;
		this.durree = durree;
		this.nbreQuestion = nbreQuestion;
	}
	
	public Exam(float durree, int nbreQuestion) {
		super();
		this.durree = durree;
		this.nbreQuestion = nbreQuestion;
	}

	public int getIdExam() {
		return idExam;
	}
	public float getDurree() {
		return durree;
	}
	public int getNbreQuestion() {
		return nbreQuestion;
	}
	@Override
	public String toString() {
		return "Exam [idExam=" + idExam + ", durree=" + durree + ", nbreQuestion=" + nbreQuestion + "]";
	}
	
	
}
