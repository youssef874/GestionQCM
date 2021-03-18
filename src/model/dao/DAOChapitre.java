package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entite.Chapitre;


public class DAOChapitre extends DAO<Chapitre> {

	@Override
	public void create(Chapitre o) {
		// TODO Auto-generated method stub
				Connection conn =super.connect();
				String requet = "insert into chapitre (idChapitre,titre) values('"+o.getIdChapitre()+"','"
				+o.getTitre()+"')";
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
	public void update(Chapitre o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "update chapitre"
				+ "idChapitre = '"+o.getIdChapitre()+"', titre = '"+o.getTitre()+"'"
				+ "where 'idChapitre' = "+o.getIdChapitre();
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
	public Chapitre find(Chapitre o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "select * from chapitre where idChapitre = "+o.getIdChapitre();
		Statement ps= null;
		ResultSet rs = null;
		Chapitre C =null;
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				C=new Chapitre(rs.getInt("idChapitre"),rs.getString("titre"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return C; 
	}

	@Override
	public void delete(Chapitre o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "delete from 'chapitre' where 'idChapitre' = "+o.getIdChapitre();
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
	public List<Chapitre> findAll() {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "select * from chapitre";
		Statement ps= null;
		ResultSet rs = null;
		List<Chapitre> listChapitre = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				listChapitre.add(new Chapitre(rs.getInt("idChapitre"),rs.getString("titre")));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listChapitre;
	}

}
