package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Sql_list {
	
	private ArrayList<String> list = new ArrayList<>();
	
	public void init(String select,String table,int nb_arg){
		
		Context initCtx;
		Context envCtx;
		DataSource ds;
		Connection con = null;
		Statement stmt;
		ResultSet rs = null;
		String temp = "";

		try {
	
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("da2i");
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT "+select+" FROM "+table+" ;");
			
	
			while(rs.next()){
				for (int i = 1; i <= nb_arg; i++) {
					temp+=rs.getString(i)+",";
				}
				list.add(temp);
				temp = "";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String> getList() {
		return list;
	}

}
