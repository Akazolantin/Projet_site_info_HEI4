package hei.project.siteInfoHei.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;
import hei.project.siteInfoHei.entities.Tea;
import hei.project.siteInfoHei.managers.TeaService;


@WebServlet("/newtea")
public class AddTeaServlet  extends GenericServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			if (PageAccueilServlet.getSession()==false || !ListeIdentifiants.currentAdmin) {
		    	   resp.sendRedirect("Connexion");
		       }

			WebContext context = new WebContext(req, resp, req.getServletContext());
			context.setVariable("message", "");
			TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
			templateEngine.process("newtea", context, resp.getWriter());
			
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			WebContext context = new WebContext(req, resp, req.getServletContext());
			String title = req.getParameter("title");
			String duration=req.getParameter("duration");
			String nbrDispo = req.getParameter("nbrDispo");
			String releaseDateAsString = req.getParameter("releaseDate");
			
			if(title.equals("") || duration.equals("") ||nbrDispo.equals("")||releaseDateAsString.equals("") ) {
				context.setVariable("message", "La saisie n'est pas valide, veuillez remplir tous les champs.");}
			else {
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate releaseDate = LocalDate.parse(releaseDateAsString, dateFormat);
				Tea newTea = new Tea(null, title, releaseDate, Integer.parseInt(duration),false,Integer.parseInt(nbrDispo));
			
			Tea createdTea = TeaService.getInstance().addTea(newTea);
			// si creation ok on affiche le tea qui vient d'etre cree
			context.setVariable("message", "Le TEA a bien été créé et a pour id : "+createdTea.getId());}
			TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
			templateEngine.process("newtea", context, resp.getWriter());
			}
			
	
		}
	


