package forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.User;

@SuppressWarnings("serial")
@WebServlet("/servlet/insert_amis")
public class Insert_amis extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		User a_ajouter = new User();
		a_ajouter.init(req.getParameter("hidden"));
		
		HttpSession session = req.getSession();
		User current_user = (User)session.getAttribute("user");
		
		current_user.ajouter_amis(a_ajouter);
		
		res.sendRedirect(req.getContextPath()+"/jsp/secured/profil.jsp?login_search="+a_ajouter.getLogin());
	}

}
