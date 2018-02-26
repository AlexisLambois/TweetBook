package beans;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

	Connexion con = null;
	private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public void init(String login){

		this.login = login;

		con = new Connexion();
		PreparedStatement pst;
		ResultSet rs = null;

		try {

			pst =(PreparedStatement) con.getCon().prepareStatement("SELECT password,nom,prenom,role,naissance,email,photo,visibilite_mur FROM comptes WHERE login=? ;"); 
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

			pst =(PreparedStatement) con.getCon().prepareStatement("SELECT cno2,depuis from amis WHERE cno1=? UNION SELECT cno1,depuis FROM amis WHERE cno2=?;"); 
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
			res+=" <b><a href=profil.jsp?login_search="+pair.getKey()+">"+pair.getKey() + "</a></b> depuis le " + format.format(pair.getValue())+"<br>";
			it.remove();
		}

		return res+"</td></table>";
	}

	public boolean verifier_amitie(User u){
		return this.amis.containsKey(u.getLogin()) || this.login.equals(u.login);
	}

	public void ajouter_amis(User u){

		PreparedStatement pst;
		con = new Connexion();
		try {

			pst =(PreparedStatement) con.getCon().prepareStatement("INSERT INTO amis VALUES(?,?,?);"); 
			pst.setString(1, this.login);
			pst.setString(2, u.getLogin());
			pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pst.executeUpdate();

			pst =(PreparedStatement) con.getCon().prepareStatement("INSERT INTO actualite(contenu,date_ecriture,ecrit_par) VALUES(?,?,?);"); 
			pst.setString(1, this.login+" est amis avec "+u.getLogin());
			pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pst.setString(3,this.login);
			pst.executeUpdate();

			this.amis.put(u.getLogin(), new Timestamp(System.currentTimeMillis()));

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			con.close();
		}
	}

	public String afficheActualite(String contextPath){
		
		con = new Connexion();
		Statement stmt;
		Statement stmt1;
		ResultSet rs = null;
		ResultSet rs1 = null;
		HashMap<String,Timestamp> acutalites = new HashMap<>();
		boolean find = false;
		String temp;
		
		String res = "<ul>";
		
		try {

			stmt = con.getCon().createStatement();
			stmt1 = con.getCon().createStatement();
			String query = "SELECT contenu,ecrit_par,date_ecriture,2 as type,ano "
					+ "FROM actualite "
					+ "WHERE date_ecriture >= current_date-cast('7 day' as interval) AND ecrit_par in ("
						+ "SELECT cno2 "
						+ "FROM amis "
						+ "WHERE cno1='"+this.login+"' "
						+ "UNION "
						+ "SELECT cno1 "
						+ "FROM amis "
						+ "WHERE cno2='"+this.login+"') "
					+ "OR ecrit_par='"+this.login+"' "
					+ "UNION "
					+ "SELECT *,1 as type,-1 as ano "
					+ "FROM amis "
					+ "WHERE depuis >= current_date - cast('7 day' as interval) AND (cno1 in ("
						+ "SELECT cno2 "
						+ "FROM amis "
						+ "WHERE cno1='"+this.login+"' "
						+ "UNION "
						+ "SELECT cno1 "
						+ "FROM amis "
						+ "WHERE cno2='"+this.login+"') "
					+ "OR cno2 in("
						+ "SELECT cno2 "
						+ "FROM amis "
						+ "WHERE cno1='"+this.login+"'"
						+ "UNION "
						+ "SELECT cno1 "
						+ "FROM amis "
						+ "WHERE cno2='"+this.login+"')"
					+ ") ORDER BY date_ecriture DESC;";
				rs = stmt.executeQuery(query);

			while( rs.next() ){
				if( rs.getInt(4) == 1 ){
					res+="<li><table><tr class=\"entete_act\"><th><a href=profil.jsp?login_search="+rs.getString(2)+">"+rs.getString(2)+"</a></th></tr><tr class=\"corps_act\"><td><p><a href=profil.jsp?login_search="+rs.getString(2)+">"+rs.getString(2)+"</a> est amis avec <a href=profil.jsp?login_search="+rs.getString(1)+">"+rs.getString(1)+"</a></p><span>"+format.format(rs.getTimestamp(3))+"</span></td></tr></table></li>";
				}else{
					query = "SELECT concat('<a href=\""+contextPath+"/jsp/secured/profil.jsp?login_search=',liker_par,'\">',liker_par,'</a>'),liker_par FROM liked WHERE actualite="+rs.getInt(5)+";";
					rs1 = stmt1.executeQuery(query);
					temp = "";
					find = false;
					while(rs1.next()) {
						temp+=rs1.getString(1)+",";
						if( !find && rs1.getString(2).equals(this.getLogin()) ){
							find = true;
						}
					}
					//res+="<li><table><tr class=\"entete_act\"><th><a href=profil.jsp?login_search="+rs.getString(2)+">"+rs.getString(2)+"</a></th></tr><tr class=\"corps_act\"><td><p>"+rs.getString(1)+"</p><span>"+format.format(rs.getTimestamp(3))+"</span><a href=\""+contextPath+"/servlet/like_event?id_event="+rs.getInt(5)+"\">";
					res+="<li><table><tr class=\"entete_act\"><th><a href=profil.jsp?login_search="+rs.getString(2)+">"+rs.getString(2)+"</a></th></tr><tr class=\"corps_act\"><td><p>"+rs.getString(1)+"</p><span>"+format.format(rs.getTimestamp(3))+"</span><a onclick=\"send("+rs.getInt(5)+")\">";
					if(find) {
						res+="<i id=\"valide\" class=\"material-icons\">&#xE8DC;</i>";
					}else {
						res+="<i class=\"material-icons\">&#xE8DC;</i>";
					}
					res+="</a>";
					if(!temp.equals("")) {
						res+="<h1>"+temp.substring(0,temp.length()-1)+" a/ont aimé(es) cette publication</h1>";
					}
					res+="</td></tr></table></li>";
				}
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


		return res+"</ul>";
	}

}
