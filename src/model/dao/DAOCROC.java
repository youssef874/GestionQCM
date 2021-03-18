package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entite.QROC;



public class DAOCROC extends DAO<QROC> {

	@Override
	public void create(QROC o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "insert into qroc(idQuestion,motCle1,motCle2,motCle3) values('"+o.getIdQuation()
		+"','"+o.getMotCle()[0]+"','"+o.getMotCle()[1]+"','"+o.getMotCle()[2]+"')";
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
	public void update(QROC o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "update qcm"
				+ "idQuestion = '"+o.getIdQuation()+"',"
						+ " ennoncee = '"+o.getEnoonce()+"'"
						+ "', isChapitre = '"+o.getIdChaptre()+"',"
						+ " motCle1 = '"+o.getMotCle()[0]+"',"
								+ " motCle2 = '"+o.getMotCle()[1]+
								"',"
								+ " motCle3 = '"+o.getMotCle()[2]+
						 "' where 'idQuestion' = "+o.getIdQuation();
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
	public QROC find(QROC o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "select * from qroc where idQuestion = "+o.getIdQuation();
		Statement ps= null;
		ResultSet rs = null;
		QROC Q =null;
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			
			while (rs.next()) {
				String[] p = {rs.getString("motCle1")		
				,rs.getString("motCle2"),rs.getString("motCle3")};
				Q=new QROC(rs.getInt("idQuestion"),
						rs.getInt("idChapitre"),rs.getString("ennoncee"),p);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Q; 
	}

	@Override
	public void delete(QROC o) {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "delete from 'qroc' where 'idQuestion' = "+o.getIdQuation();
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
	public List<QROC> findAll() {
		// TODO Auto-generated method stub
		Connection conn =super.connect();
		String requet = "select * from qroc";
		Statement ps= null;
		ResultSet rs = null;
		List<QROC> listQROC = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				String[] p = {rs.getString("motCle1")		
						,rs.getString("motCle2"),rs.getString("motCle3")};
				listQROC.add(new QROC(rs.getInt("idQuestion"),rs.getInt("idChapitre")
						,rs.getString("ennoncee"),p));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listQROC;
	}

}
