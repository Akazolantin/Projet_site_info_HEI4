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

import entities.Tea;
import managers.TeaService;


@WebServlet("/newtea")
public class AddTeaServlet  extends GenericServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String errorMessage = (String) req.getSession().getAttribute("errorMessage");
			req.getSession().removeAttribute("errorMessage");

			WebContext context = new WebContext(req, resp, req.getServletContext());
			List<Tea> listOfTea = TeaService.getInstance().listTea();
			context.setVariable("TeaDao",listOfTea);
			context.setVariable("error", errorMessage);
			
			TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
			templateEngine.process("newtea", context, resp.getWriter());
			
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String title = req.getParameter("title");
			Integer duration = null;
			Boolean valide = null;
			try {
				duration = Integer.parseInt(req.getParameter("duration"));
			} catch (NumberFormatException nfe) {
			}

			String releaseDateAsString = req.getParameter("releaseDate");
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate releaseDate = null;
			try {
				releaseDate = LocalDate.parse(releaseDateAsString, dateFormat);
			} catch (DateTimeParseException dtpe) {
			}

			try {
				Tea newTea = new Tea(null, title, releaseDate, duration,valide);
				Tea createdTea = TeaService.getInstance().addTea(newTea);
				// si creation ok on affiche le tea qui vient d'etre cree
				resp.sendRedirect(String.format("tea?id=%d", createdTea.getId()));
			} catch(IllegalArgumentException iae) {
				// Si erreur on ajoute le message d'erreur dans la session et on redirige sur la page de creation
				req.getSession().setAttribute("errorMessage", iae.getMessage());
				resp.sendRedirect("newtea");
			}
		}
	

}
