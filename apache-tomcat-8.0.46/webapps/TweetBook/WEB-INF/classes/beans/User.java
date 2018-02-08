package beans;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class User {

	private String login;
	private String password;
	private String nom;
	private String prenom;
	private String role;
	private Date naissance;
	private String email;
	private String photo;
	private int visibilite;


	public void init(String login){

		this.login = login;

		Context initCtx;
		Context envCtx;
		DataSource ds;
		Connection con = null;
		PreparedStatement pst;
		ResultSet rs = null;;

		try {

			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("da2i");
			con = ds.getConnection();

			pst =(PreparedStatement) con.prepareStatement("SELECT * FROM comptes WHERE login=? ;"); 
			pst.setString(1, this.login);
			rs = pst.executeQuery();
			rs.next();

			String field;
			
			Field[] fields = User.class.getDeclaredFields();
			
			for (int i = 0; i < fields.length; i++){
				field = fields[i].toString();
				System.out.println(field.substring(field.lastIndexOf('.')+1,field.length()) + " : " + rs.getString(i+1));
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

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRole() {
		return role;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(int visibilite) {
		this.visibilite = visibilite;
	}



}
