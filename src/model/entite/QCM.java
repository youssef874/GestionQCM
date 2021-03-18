package model.entite;

/*
 * This class hold the QCM table for the database ,and it inherit from question table so idQuestion it is primary key too,
 * proposition hold all three proposition in the database and propositionCorrect hold all three propositionCorrecte 
 * in the database
 */

import java.util.Arrays;

public class QCM extends Question {

	private String[] proposition = new String[3];
	private boolean[] propositionCorrect = new boolean[3];
	
	public QCM(int idQuation, int idChaptre, String enoonce
			,String[] proposition,boolean[] propositionCorrect) {
		super(idQuation, idChaptre, enoonce);
		// TODO Auto-generated constructor stub
		this.proposition  = proposition;
		this.propositionCorrect = propositionCorrect;
	}

	public String[] getProposition() {
		return proposition;
	}

	public boolean[] getPropositionCorrect() {
		return propositionCorrect;
	}

	@Override
	public String toString() {
		return "QCM [proposition=" + Arrays.toString(proposition) + ", propositionCorrect="
				+ Arrays.toString(propositionCorrect) + "]";
	}

	
	
}
