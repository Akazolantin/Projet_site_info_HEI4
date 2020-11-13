package hei.project.siteInfoHei.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

@WebServlet("/listetaches")
public class ListServlet extends GenericServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("listetaches", context, resp.getWriter());
	}
}
