package ProiectJava.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ProiectJava.connection.ConnectionBase;
import ProiectJava.model.Abonat;
import ProiectJava.model.Telefon;



public class AbonatDao {
	
	public static List<Abonat> loadPersoane(int criteriu, String valCriteriu) {
		
		Abonat pers = null;
		List<Abonat> listAbonat = new ArrayList<Abonat>();
		Statement stmt = null;
		
		try{
			stmt = ConnectionBase.getInstance().getConnection().createStatement();
			
			String str = "select nume, prenume, cnp, id, numar from abonat ";
			switch (criteriu) {
			case 0:
				break;
			case 1 :
				str += "where nume like '%" + valCriteriu + "%'";
				break;
			case 2:
				str += "where prenume like '%" + valCriteriu + "%'";
				break;
			case 3:
				str += "where cnp like '%" + valCriteriu + "%'";
			default:
			}
			
			ResultSet r = stmt.executeQuery(str);
			
			while(r.next()){
				pers = new Abonat(r.getString(1), r.getString(2), r.getString(3));
				pers.setId(r.getInt(4));
				Telefon tel = new Telefon(r.getInt(4),0,r.getString(5),0);
				pers.setListaTelefoane(tel);
				listAbonat.add(pers);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		return listAbonat;
	}
	public static void insert(Abonat abo) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		

		try {
			stmt = ConnectionBase.getInstance().getConnection()
					.createStatement();
						abo.setId((max()+1));
			String str = "insert into abonat (id, cnp, nume, prenume, numar) values ( "
					+ String.valueOf((max()+1))
					+ ",'"
					+ abo.getCnp()
					+ "','"
					+ abo.getNume()
					+ "','"
					+ abo.getPrenume() +"','"
					+ abo.getListaTelefoane().get(0).getNumar() + "')";
			stmt.executeUpdate(str);
			ConnectionBase.getInstance().getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Abonat getAbonatById(Object idAbonat) {
		Statement stmt = null;
		Abonat ab = null;
		try {
			stmt = ConnectionBase.getInstance().getConnection().createStatement();
			String str = "select nume, prenume, cnp, id from abonat where id = " + idAbonat;
			
			ResultSet r = stmt.executeQuery(str);
			
			while (r.next())
			{
				ab = new Abonat(r.getString(1), r.getString(2),r.getString(3));
				ab.setId(r.getInt(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ab;
	}
	
	public static int max() {
		Statement stmt = null;
		int max=1;
		try {
			stmt = ConnectionBase.getInstance().getConnection().createStatement();
			String str = "select max(id) from abonat";
			
			ResultSet r = stmt.executeQuery(str);
			
			while (r.next())
			{
				max=r.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return max;
		
	}
	
	public static void update(Abonat abonat) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		
		try {
			stmt = ConnectionBase.getInstance().getConnection().createStatement();
	
			String str = "UPDATE abonat SET nume= '" + abonat.getNume()+ "', prenume= '" + abonat.getPrenume() + "', cnp= '" + abonat.getCnp() + "'" 
					                        + " where id=" + abonat.getId();
			 stmt.executeUpdate(str);
			 ConnectionBase.getInstance().getConnection().commit();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public static void delete(Abonat abonat) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		
		try {
			stmt = ConnectionBase.getInstance().getConnection().createStatement();
	
			String str = "DELETE FROM abonat WHERE id = " + abonat.getId();
			 stmt.executeUpdate(str);
			ConnectionBase.getInstance().getConnection().commit();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void deleteAll() {
		
			Statement stmt = null;
		
		try {
			stmt = ConnectionBase.getInstance().getConnection().createStatement();
	
			String str = "DELETE FROM abonat";
			stmt.executeUpdate(str);
			ConnectionBase.getInstance().getConnection().commit();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
}
