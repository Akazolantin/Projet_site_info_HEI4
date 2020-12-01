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


@WebServlet("/list")
	public class ListServlet extends GenericServlet {

		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			WebContext context = new WebContext(req, resp, req.getServletContext());
			List<Tea> listOfTea = TeaService.getInstance().listTea();
			context.setVariable("result",listOfTea);
			context.setVariable("currentAdmin", ListeIdentifiants.currentAdmin);
			if (PageAccueilServlet.getSession()==false ) {
		    	   resp.sendRedirect("Connexion");
		       }
			TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
			templateEngine.process("list", context, resp.getWriter());

	}
}



