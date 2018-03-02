package forms;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.Connexion;
import beans.User;

@SuppressWarnings("serial")
@WebServlet("/servlet/update_user")
public class Update_user extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		PreparedStatement pst = null;
		Connexion con = new Connexion();
		ResultSet rs = null;
		
		try {
			
			User current_user = (User)session.getAttribute("user");
			
			pst =(PreparedStatement) con.getCon().prepareStatement("SELECT * from comptes WHERE email=?;");
			pst.setString(1, req.getParameter("email"));
			rs = pst.executeQuery();
			
			if( !rs.next() ) {
				pst =(PreparedStatement) con.getCon().prepareStatement("UPDATE comptes SET email = ? WHERE login = ?;");
				pst.setString(1, req.getParameter("naissance"));
				pst.executeUpdate();
			}
			
			pst =(PreparedStatement) con.getCon().prepareStatement("UPDATE comptes SET naissance = TO_DATE(?, 'DD/MM/YYYY'), photo = ? WHERE login = ?;");
			pst.setString(1, req.getParameter("naissance"));
			pst.setString(2, req.getParameter("photo"));
			pst.setString(3, current_user.getLogin());
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				con.close();
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
