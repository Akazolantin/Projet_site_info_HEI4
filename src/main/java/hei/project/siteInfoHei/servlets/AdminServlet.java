package hei.project.siteInfoHei.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;

@WebServlet("/admin")
public class AdminServlet extends GenericServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (PageAccueilServlet.getSession()==false || !ListeIdentifiants.currentAdmin) {
	    	   resp.sendRedirect("Connexion");
	       }
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("eleves", hei.project.siteInfoHei.dao.impl.EleveDao.listEleves("nom","0","%",""));
		context.setVariable("currentAdmin", ListeIdentifiants.currentAdmin);
		context.setVariable("currentId", ListeIdentifiants.IdUtil);
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());

       templateEngine.process("adminhome", context, resp.getWriter());
       
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		String dom=req.getParameter("domaine");
		String year=req.getParameter("year");
		String tripar=req.getParameter("tripar");
		String rechNom=req.getParameter("rechNom");
		context.setVariable("eleves", hei.project.siteInfoHei.dao.impl.EleveDao.listEleves(tripar,year,dom,rechNom));
		context.setVariable("currentAdmin", ListeIdentifiants.currentAdmin);
		context.setVariable("currentId", ListeIdentifiants.IdUtil);
		TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("adminhome", context, resp.getWriter());
	
        
}}
