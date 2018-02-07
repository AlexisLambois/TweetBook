package forms;

import java.io.IOException;
import java.sql.*;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

/**
 * Servlet implementation class Inscription
 **/

@SuppressWarnings("serial")
@WebServlet("/servlet/inscrp_user")
public class Inscrp_user extends HttpServlet {

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
			
			pst =(PreparedStatement) con.prepareStatement("SELECT login FROM comptes WHERE login=?"); 
			pst.setString(1, req.getParameter("login"));
			rs = pst.executeQuery();
			
			if (rs.next()) {
				
				res.sendRedirect("../jsp/connec_inscrp.jsp?error=0");
				
			}else{
				
				if( req.getParameter("password").equals(req.getParameter("password2")) ){
					
					pst =(PreparedStatement) con.prepareStatement("INSERT INTO comptes(login,nom,prenom,email,password) VALUES(?,?,?,?,?)"); 
					pst.setString(1,req.getParameter("login"));  
					pst.setString(2,req.getParameter("name"));        
					pst.setString(3,req.getParameter("firstname"));
					pst.setString(4,req.getParameter("email"));
					pst.setString(5,req.getParameter("password"));
					
					pst.executeUpdate();
					
					res.sendRedirect("../jsp/connec_inscrp.jsp?error=2");
					
				}else{
					
					res.sendRedirect("../jsp/connec_inscrp.jsp?error=1");
					
				}
				
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
