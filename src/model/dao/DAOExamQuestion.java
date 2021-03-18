package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entite.ExamQuestion;



public class DAOExamQuestion extends DAO<ExamQuestion> {

	@Override
	public void create(ExamQuestion o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "insert into examenQuestion values('"+o.getIdExamQuestion()+"'"
		+o.getIdExamn()+"','"+o.getIdQuestion()+"')";
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
	public void update(ExamQuestion o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "update exameQestion"
				+ "idExamenQuestion = '"+o.getIdExamQuestion()+"',"
						+ " idExamen = '"+o.getIdExamn()+"'"
						+ "', isQuestion = '"+o.getIdQuestion()+
						 "' where 'idExamenQuestion' = "+o.getIdExamQuestion();
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
	public ExamQuestion find(ExamQuestion o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "select * from examenQuestion where idExamenQuestion = "+o.getIdExamQuestion();
		Statement ps= null;
		ResultSet rs = null;
		ExamQuestion QC =null;
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			
			while (rs.next()) {
				
				QC=new ExamQuestion(rs.getInt("idexamenQuestion"),
						rs.getInt("idExamen"),rs.getInt("idQestion"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return QC; 
	}

	@Override
	public void delete(ExamQuestion o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "delete from 'examenQuestion' where 'idexamenQuestion' = "+o.getIdExamQuestion();
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
	public List<ExamQuestion> findAll() {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "select * from examenQuestion";
		Statement ps= null;
		ResultSet rs = null;
		List<ExamQuestion> listExamenQuestion = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				listExamenQuestion.add(new ExamQuestion(rs.getInt("idExamenQuestion")
						,rs.getInt("idExamen"),rs.getInt("idQuestion")));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listExamenQuestion;
	}

}
