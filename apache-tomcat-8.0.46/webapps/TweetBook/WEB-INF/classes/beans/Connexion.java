package beans;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Connexion {

	private Context initCtx;
	private Context envCtx;
	private DataSource ds;
	private Connection con = null;

	public Connexion(){

		try {
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("da2i");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Connection getCon() {
		return con;
	}

	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
