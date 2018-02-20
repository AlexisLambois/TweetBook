package beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
	private HashMap<String,Timestamp> amis = new HashMap<>();

	private final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	public void init(String login){

		this.login = login;

		Context initCtx;
		Context envCtx;
		DataSource ds;
		Connection con = null;
		PreparedStatement pst;
		ResultSet rs = null;

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

			pst =(PreparedStatement) con.prepareStatement("SELECT cno2,depuis from amis WHERE cno1=? UNION SELECT cno1,depuis FROM amis WHERE cno2=?;"); 
			pst.setString(1, this.login);
			pst.setString(2, this.login);
			rs = pst.executeQuery();

			while(rs.next()){
				amis.put(rs.getString(1), rs.getTimestamp(2));
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

	public void setLogin(String login) {
		this.login = login;
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

	public void setRole(String role) {
		this.role = role;
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

	public HashMap<String, Timestamp> getAmis() {
		return amis;
	}

	public void setAmis(HashMap<String, Timestamp> amis) {
		this.amis = amis;
	}

	public SimpleDateFormat getFormat() {
		return format;
	}

	public String afficheVisiteur(){

		if( this.getVisibilite() == 2 ){
			return "<h1>Profil BLoque</h1>";
		}

		String res = "<table>";

		res+="<tr><th> Login : </th><td>"+this.login+"</td></tr>";
		res+="<tr><th> Nom : </th><td>"+this.nom+"</td></tr>";
		res+="<tr><th> Prenom : </th><td>"+this.prenom+"</td></tr>";
		if( this.naissance == null ){
			res+="<tr><th> Naissance : </th><td>Non renseignee</td></tr>";
		}else{
			res+="<tr><th> Naissance : </th><td>"+this.naissance+"</td></tr>";
		}
		res+="<tr><th> Email : </th><td>"+this.email+"</td></tr>";
		if( this.photo == null ){
			res+="<tr><th> Photo : </th><td>Non renseignee</td></tr>";
		}else{
			res+="<tr><th> Photo : </th><td>"+this.photo+"</td></tr>";
		}
		res+="<tr><th> Amis avec : </th><td>";
		Iterator it = amis.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			res+=" <b><a href=profil.jsp?login_search="+pair.getKey()+">"+pair.getKey() + "</a></b> depuis le " + pair.getValue()+"<br>";
			it.remove();
		}
		return res+"</td></table>";
	}

	public boolean verifier_amitie(User u){
		return this.amis.containsKey(u.getLogin()) || this.login.equals(u.login);
	}
	
	public void ajouter_amis(User u){

		Context initCtx;
		Context envCtx;
		DataSource ds;
		Connection con = null;
		PreparedStatement pst;

		try {

			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("da2i");
			con = ds.getConnection();

			pst =(PreparedStatement) con.prepareStatement("INSERT INTO amis VALUES(?,?,?);"); 
			pst.setString(1, this.login);
			pst.setString(2, u.getLogin());
			pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pst.executeUpdate();
			
			this.amis.put(u.getLogin(), new Timestamp(System.currentTimeMillis()));

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
