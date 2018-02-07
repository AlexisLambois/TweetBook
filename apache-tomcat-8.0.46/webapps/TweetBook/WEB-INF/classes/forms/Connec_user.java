package forms;

import java.io.IOException;
import java.sql.*;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

/**
 * Servlet implementation class Connection
 **/

@SuppressWarnings("serial")
@WebServlet("/servlet/connec_user")
public class Connec_user extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Context initCtx;
		Context envCtx;
		DataSource ds;
		Connection con = null;
		PreparedStatement pst;
		ResultSet rs;
		
		try{

			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("da2i");
			con = ds.getConnection();
			
			pst =(PreparedStatement) con.prepareStatement("SELECT login FROM comptes WHERE login=? AND password=?"); 
			pst.setString(1, req.getParameter("login"));
			pst.setString(2, req.getParameter("password"));
			rs = pst.executeQuery();
			
			if (rs.next()) {
				
				
	
			}else{
				
				res.sendRedirect("../jsp/accueil.jsp?error=3");
				
			}
			
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
