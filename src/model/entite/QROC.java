package model.entite;

import java.util.Arrays;

/*
 * This class hold the QROC table for the database ,and it inherit from question table so idQuestion it is primary key too and
 * motCle hold all three motCle in the database 
 */

public class QROC extends Question {

	private String[]  motCle = new String[3];
	
	public QROC(int idQuation, int idChaptre, String enoonce,String[]  motCle) {
		super(idQuation, idChaptre, enoonce);
		// TODO Auto-generated constructor stub
		this.motCle = motCle;
	}

	public String[] getMotCle() {
		return motCle;
	}

	@Override
	public String toString() {
		return "QROC [motCle=" + Arrays.toString(motCle) + "]";
	}
}
