package hei.project.siteInfoHei.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;

@WebServlet("/addEleve")
public class addEleveServlet extends GenericServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (PageAccueilServlet.getSession()==false || !ListeIdentifiants.currentAdmin) {
	    	   resp.sendRedirect("accueil");
	       }
		WebContext context = new WebContext(req, resp, req.getServletContext());
		 TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
		 context.setVariable("message","");
	        
	        
	       templateEngine.process("addEleve", context, resp.getWriter());}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebContext context = new WebContext(req, resp, req.getServletContext());
		String dom=req.getParameter("domaine");
		String year=req.getParameter("year");
		String nom=req.getParameter("nom");
		String prenom=req.getParameter("prenom");
		if(nom.equals("") || prenom.equals("")) {context.setVariable("message", "La saisie n'est pas valide, veuillez remplir tous les champs.");}
		else {hei.project.siteInfoHei.dao.impl.EleveDao.addEleve(nom, prenom, year, dom);
			context.setVariable("message","L'élève a été créé avec succés.");
		}
		TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
		templateEngine.process("addEleve", context, resp.getWriter());
	}

}
