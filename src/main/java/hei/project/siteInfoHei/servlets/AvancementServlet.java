package hei.project.siteInfoHei.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import dao.ListeIdentifiants;

import entities.Tea;

@WebServlet("/avancement")
public class AvancementServlet extends GenericServlet{
		
	

		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			WebContext context = new WebContext(req, resp, req.getServletContext());
			if (ListeIdentifiants.currentAdmin) {
				String eleve_id = req.getParameter("id");
				System.out.println(eleve_id);
			}
			String eleve_id = req.getParameter("id");
			System.out.println(eleve_id);
			
			
			List<Tea> listetea = new ArrayList<Tea>();
			
			context.setVariable("tea", listetea);
	        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
	        
	       
	        int result = 0;
	        for (Tea tea : listetea) {
	        	if (tea.getValide()) {
	        		result += tea.getDuration();
	        }
	        }
	        context.setVariable("point", result);
	        if (PageAccueilServlet.getSession()==false) {
		    	   resp.sendRedirect("accueil");
		       }
	        templateEngine.process("avancement", context, resp.getWriter());
		}
		public void deconnexion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
			if (ListeIdentifiants.currentAdmin) {
				String bouttton = req.getParameter("custId");
				System.out.println(bouttton);
			}
			
			 
		}
		}
		
