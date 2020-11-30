package hei.project.siteInfoHei.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import hei.project.siteInfoHei.dao.impl.TeaDaoImpl;

import hei.project.siteInfoHei.entities.Tea;
import hei.project.siteInfoHei.managers.TeaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

	@WebServlet("/tea")
	public class DetailTeaServlet extends GenericServlet  {
		int teaId;
		
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        WebContext context = new WebContext(req, resp, req.getServletContext());

	        teaId = Integer.parseInt(req.getParameter("id"));
	        Tea tea = TeaService.getInstance().getTea(teaId);
	        context.setVariable("tea", tea);

	        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
	        templateEngine.process("tea", context, resp.getWriter());
	    }
	
	    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	TeaDaoImpl.valideTea(teaId);
	    	resp.sendRedirect("list");
			}

}
