package hei.project.siteInfoHei.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.project.siteInfoHei.Service.TeaService;
import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;
import hei.project.siteInfoHei.entities.Tea;

@WebServlet("/modiftea")
public class ModifTeaServlet extends GenericServlet {
	private Tea teaId;
	private int id;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WebContext context = new WebContext(req, resp, req.getServletContext());
        
        id = Integer.parseInt(req.getParameter("id"));
	    teaId= TeaService.getInstance().getTea(id);
        context.setVariable("tea", teaId);
        context.setVariable("currentAdmin", ListeIdentifiants.currentAdmin);
        
	  
	    if (PageAccueilServlet.getSession()==false || !ListeIdentifiants.currentAdmin) {
	    	   resp.sendRedirect("Connexion");
	       }
	    TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
	    templateEngine.process("modiftea", context, resp.getWriter());
	   
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebContext context = new WebContext(req, resp, req.getServletContext());
		String title=req.getParameter("title");
		String releaseDateAsString = req.getParameter("releaseDate");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate releaseDate = null;
		Integer duration = null;
		Boolean valide=null;
		
		try {
			duration = Integer.parseInt(req.getParameter("duration"));
		} catch (NumberFormatException nfe) {
		}
		
		try {
			valide = Boolean.parseBoolean(req.getParameter("valide"));
		} catch (NumberFormatException vpe) {
		}

		try {
			releaseDate = LocalDate.parse(releaseDateAsString, dateFormat);
		} catch (DateTimeParseException dtpe) {
		}
		
			if(title.equals("")) {title=teaId.getTitle();}
			if(duration.equals("")) {duration=teaId.getDuration();}
			if(valide.equals("")) {valide=teaId.getValide();}
			if(releaseDate.equals("")) {releaseDate=teaId.getReleaseDate();}else {}
			
		
		try {
			Tea modifTea = TeaService.getInstance().modifTea(id, title, releaseDate, duration,valide);
			// si creation ok on affiche le tea qui vient d'etre cree
			resp.sendRedirect("list");
		}
		catch(IllegalArgumentException iae) {
			// Si erreur on ajoute le message d'erreur dans la session et on redirige sur la page de creation
			req.getSession().setAttribute("errorMessage", iae.getMessage());
			resp.sendRedirect("modiftea");
		}
		
		
	}
	
}
