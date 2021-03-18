package model.entite;

/*
 * This class hold the ExamQuestion table for the database ,and it contain idExamQuestion as primary key, idExamn a foreign key
 * from Exam table and idQuestion is a foreign key from question table
 */

public class ExamQuestion {
	private int idExamQuestion;
	private int idExamn;
	private int idQuestion;
	public ExamQuestion(int idExamQuestion, int idExamn, int idQuestion) {
		super();
		this.idExamQuestion = idExamQuestion;
		this.idExamn = idExamn;
		this.idQuestion = idQuestion;
	}
	public int getIdExamQuestion() {
		return idExamQuestion;
	}
	public int getIdExamn() {
		return idExamn;
	}
	public int getIdQuestion() {
		return idQuestion;
	}
	@Override
	public String toString() {
		return "ExamQuestion [idExamQuestion=" + idExamQuestion + ", idExamn=" + idExamn + ", idQuestion=" + idQuestion
				+ "]";
	}
}
