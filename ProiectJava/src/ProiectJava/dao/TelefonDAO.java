package ProiectJava.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ProiectJava.connection.ConnectionBase;
import ProiectJava.model.Abonat;
import ProiectJava.model.Telefon;

public class TelefonDAO {

	public static List<Telefon> loadTelefonByAbonat(String idAbonat, int first) {

		Telefon tel = null;
		List<Telefon> list = new ArrayList<Telefon>();
		Statement stmt = null;

		try {
			stmt = ConnectionBase.getInstance().getConnection()
					.createStatement();

			String str = "select id, id_abonat, numar, tip, first from telefon where id_abonat = "
					+ idAbonat;
			// if(first==1) str+= " and first = 1";
			ResultSet r = stmt.executeQuery(str);

			while (r.next()) {
				tel = new Telefon();
				if (r.getInt(1) != 0)
					tel.setId(r.getInt(1));
				tel.setId_abonat(r.getInt(2));
				tel.setNumar(r.getString(3));
				tel.setTip(r.getInt(4));
				tel.setFirst(r.getInt(5));

				list.add(tel);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return list;
	}

	public static void insert(Telefon tel) {
		// TODO Auto-generated method stub
		Statement stmt = null;

		try {
			stmt = ConnectionBase.getInstance().getConnection()
					.createStatement();

			String str = "insert into telefon (id, id_abonat, numar, tip, first) values ( "
					+ String.valueOf((max()+1))
					+ ","
					+ tel.getId_abonat()
					+ " ,"
					+ "'"
					+ tel.getNumar()
					+ "',"
					+ tel.getTip()
					+ ","
					+ tel.getFirst() + ")";
			stmt.executeUpdate(str);
			ConnectionBase.getInstance().getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(Telefon tel) {
		// TODO Auto-generated method stub
		Statement stmt = null;

		try {
			stmt = ConnectionBase.getInstance().getConnection()
					.createStatement();

			String str = "UPDATE telefon SET id_abonat = " + tel.getId_abonat()
					+ ", numar= '" + tel.getNumar() + "', tip= "
					+ tel.getTip() + ", first=" + tel.getFirst();
			stmt.executeUpdate(str);
			ConnectionBase.getInstance().getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(Abonat abonat) {
		// TODO Auto-generated method stub
		Statement stmt = null;

		try {
			stmt = ConnectionBase.getInstance().getConnection()
					.createStatement();

			String str = "DELETE FROM telefon WHERE id_abonat = "
					+ abonat.getId();
			;
			stmt.executeUpdate(str);
			ConnectionBase.getInstance().getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteAll() {
		// TODO Auto-generated method stub
		Statement stmt = null;

		try {
			stmt = ConnectionBase.getInstance().getConnection()
					.createStatement();

			String str = "DELETE * FROM telefon ";
			stmt.executeUpdate(str);
			ConnectionBase.getInstance().getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int max() {
		Statement stmt = null;
		int max = 1;
		try {
			stmt = ConnectionBase.getInstance().getConnection()
					.createStatement();
			String str = "select max(id) from telefon";

			ResultSet r = stmt.executeQuery(str);

			while (r.next()) {
				max = r.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return max;

	}

	public static List<Telefon> getAbonatByIdAbonat(Object idAbonat) {
		Statement stmt = null;
		Telefon tel = null;
		List<Telefon> listTel = new ArrayList<Telefon>();
		try {
			stmt = ConnectionBase.getInstance().getConnection()
					.createStatement();
			String str = "select numar, tip, first from telefon where id_abonat = "
					+ idAbonat;

			ResultSet r = stmt.executeQuery(str);
			
			while (r.next()) {
				tel = new Telefon(Integer.parseInt(idAbonat.toString()), r.getInt(2), r.getString(1), r.getInt(3));
				listTel.add(tel);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listTel;
	}
}
