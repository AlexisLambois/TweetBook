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
@WebServlet("/servlet/deconnection")
public class Deconnection extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		try{

			session.invalidate();
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
