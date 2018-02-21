package forms;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.Connexion;
import beans.User;

@SuppressWarnings("serial")
@WebServlet("/servlet/insert_event")
public class Insert_event extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User current_user = (User)session.getAttribute("user");
		
		PreparedStatement pst;
		Connexion con = new Connexion();
		
		try {

			pst =(PreparedStatement) con.getCon().prepareStatement("INSERT INTO actualite(contenu,date_ecriture,ecrit_par) VALUES(?,?,?);"); 
			pst.setString(1, req.getParameter("commentaire"));
			pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pst.setString(3, current_user.getLogin());
			pst.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			con.close();
		}
		
		res.sendRedirect(req.getContextPath()+"/jsp/secured/accueil.jsp");
	}

}
