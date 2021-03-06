package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entite.Exam;



public class DAOExam extends DAO<Exam> {

	@Override
	public void create(Exam o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "insert into examen(nbreQuestion,durree) values('"
		+o.getNbreQuestion()+"','"+o.getDurree()+"')";
		Statement ps= null;
		
		try {
			ps = conn.createStatement();
			ps.execute(requet);
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Exam o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "update examen"
				+ "idExamen = '"+o.getIdExam()+"', nbreQuestion = '"+o.getNbreQuestion()+"'"
						+ "', durree = '"+o.getDurree()
				+ "' where 'idExamen' = "+o.getIdExam();
		Statement ps= null;
		
		try {
			ps = conn.createStatement();
			ps.executeUpdate(requet);
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Exam find(Exam o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "select * from examen where idExamen = "+o.getIdExam();
		Statement ps= null;
		ResultSet rs = null;
		Exam E =null;
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				E=new Exam(rs.getInt("idExamen")
						,rs.getFloat("durree"),rs.getInt("nbreQuestion"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return E; 
	}

	@Override
	public void delete(Exam o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "delete from 'examen' where 'idExamen' = "+o.getIdExam();
		Statement ps= null;
		
		try {
			ps = conn.createStatement();
			ps.execute(requet);
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Exam> findAll() {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "select * from examen";
		Statement ps= null;
		ResultSet rs = null;
		List<Exam> listExamen = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				listExamen.add(new Exam(rs.getInt("idExamen"),rs.getFloat("durree")
						,rs.getInt("nbreQuestion")));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listExamen;
	}

}
