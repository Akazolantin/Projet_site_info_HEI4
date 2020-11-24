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

import entities.B2;
import entities.Responsabilité;
import entities.Tea;
import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;

@WebServlet("/avancement")
public class AvancementServlet extends GenericServlet{
	

		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			WebContext context = new WebContext(req, resp, req.getServletContext());
			
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
	        
	        List<Responsabilité> responsabilite = new ArrayList<Responsabilité>();
	        int result1 = 0;
	        for(Responsabilité responsab : responsabilite) {
	        	if(responsab.getValide()==true) {
	        		result1 = 20;
	        	}
	        }
	        context.setVariable("point1", result1);
	        
	        List<B2> b2 = new ArrayList<B2>();
	        int result2 = 0;
	        for(B2 b2a : b2) {
	        	if(b2a.getValide()==true) {
	        		result2 = 20;
	        	}
	        }
	        context.setVariable("point2", result2);
	        
	        if (PageAccueilServlet.getSession()==false) {
		    	   resp.sendRedirect("accueil");
		       }
	        templateEngine.process("avancement", context, resp.getWriter());
			
		}// si admin co essaye d'aller sur page eleve a partir de url + boutton //
		
		
			
}

