package hei.project.siteInfoHei.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;

@WebServlet("/SupprTea")
public class SupprTeaServlet extends GenericServlet{

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebContext context = new WebContext(req, resp, req.getServletContext());
		if (PageAccueilServlet.getSession()==false || !ListeIdentifiants.currentAdmin) {
	    	   resp.sendRedirect("Connexion");
	       }
		int id = Integer.parseInt(req.getParameter("id"));
	    TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
	    hei.project.siteInfoHei.dao.impl.EleveDao.delete(id);resp.sendRedirect("admin");
	}
}
