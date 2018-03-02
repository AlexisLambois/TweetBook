package forms;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.Connexion;
import beans.User;

@SuppressWarnings("serial")
@WebServlet("/servlet/like_event")
public class Like_event extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User current_user = (User)session.getAttribute("user");
		
		PreparedStatement pst = null;
		Connexion con = new Connexion();
		ResultSet rs = null;
		
		try {
			
			pst =(PreparedStatement) con.getCon().prepareStatement("SELECT * from liked WHERE actualite=? AND liker_par=?;");
			pst.setInt(1, Integer.parseInt(req.getParameter("id_event")));
			pst.setString(2, current_user.getLogin());
			rs = pst.executeQuery();
			
			if(!rs.next()) {
				pst =(PreparedStatement) con.getCon().prepareStatement("INSERT INTO liked VALUES(?,?,?);"); 
				pst.setString(1, current_user.getLogin());
				pst.setInt(2, Integer.parseInt(req.getParameter("id_event")));
				pst.setInt(3, 0);
				pst.executeUpdate();
			}else {
				pst =(PreparedStatement) con.getCon().prepareStatement("DELETE FROM liked WHERE actualite=? AND liker_par=?;"); 
				pst.setInt(1, Integer.parseInt(req.getParameter("id_event")));
				pst.setString(2, current_user.getLogin());
				pst.executeUpdate();
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			con.close();
			try {
				pst.close();
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
