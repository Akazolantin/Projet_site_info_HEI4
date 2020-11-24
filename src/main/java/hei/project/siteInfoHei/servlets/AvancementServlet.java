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

import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;
import hei.project.siteInfoHei.entities.B2;
import hei.project.siteInfoHei.entities.Responsabilité;
import hei.project.siteInfoHei.entities.Tea;
import hei.project.siteInfoHei.dao.impl.NNDao;

@WebServlet("/avancement")
public class AvancementServlet extends GenericServlet{
		
	

		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			WebContext context = new WebContext(req, resp, req.getServletContext());
			
			int eleve_id;
			
			if (ListeIdentifiants.currentAdmin) {
				String id = req.getParameter("id");
				eleve_id =Integer.parseInt(id);
			}
			else {
				eleve_id = ListeIdentifiants.IdUtil;
			}
			
			
			
			List<Tea> listetea = hei.project.siteInfoHei.dao.impl.NNDao.listNNTea(eleve_id);
			
			context.setVariable("tea", listetea);
	        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
	        
	       
	        int result = 0;
	        for (Tea tea : listetea) {
	        	if (tea.getValide()) {
	        		result += tea.getDuration();
	        }

	        }
	
	        

	        
	        List<Responsabilité> responsabilite = new ArrayList<Responsabilité>();
	        int result1 = 0;
	        for(Responsabilité responsab : responsabilite) {
	        	if(responsab.getValide()==true) {
	        		result1 = 20;
	        	}
	        }
	        
	        
	        List<B2> b2 = new ArrayList<B2>();
	        int result2 = 0;
	        for(B2 b2a : b2) {
	        	if(b2a.getValide()==true) {
	        		result2 = 20;
	        	}
	        }
	        
	        int resultfin = 0;
	        resultfin = result + result1 + result2;
	        context.setVariable("point", resultfin);
	        
	        if (PageAccueilServlet.getSession()==false) {
		    	   resp.sendRedirect("accueil");
		       }
	        templateEngine.process("avancement", context, resp.getWriter());
		}
		
}
