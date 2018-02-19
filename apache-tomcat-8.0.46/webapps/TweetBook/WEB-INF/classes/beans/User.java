package beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
	
	private final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");


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

			pst =(PreparedStatement) con.prepareStatement("SELECT password,nom,prenom,role,naissance,email,photo,visibilite_mur FROM comptes WHERE login=? ;"); 
			pst.setString(1, this.login);
			rs = pst.executeQuery();
			rs.next();

			password = rs.getString(1);
			nom = rs.getString(2);
			prenom = rs.getString(3);
			role = rs.getString(4);
			naissance = rs.getDate(5);
			email = rs.getString(6);
			photo = rs.getString(7);
			visibilite = rs.getInt(8);
			
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
