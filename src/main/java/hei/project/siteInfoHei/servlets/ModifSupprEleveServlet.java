package hei.project.siteInfoHei.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;

@WebServlet("/supprmodif")
public class ModifSupprEleveServlet extends GenericServlet{

@Override
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	WebContext context = new WebContext(req, resp, req.getServletContext());
	int id = Integer.parseInt(req.getParameter("id"));
    TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
    
    context.setVariable("eleve", hei.project.siteInfoHei.dao.impl.EleveDao.getEleveById(id));
    if (PageAccueilServlet.getSession()==false || !ListeIdentifiants.currentAdmin) {
    	   resp.sendRedirect("accueil");
       }
   templateEngine.process("ModifSuppr", context, resp.getWriter());
   
}
}
