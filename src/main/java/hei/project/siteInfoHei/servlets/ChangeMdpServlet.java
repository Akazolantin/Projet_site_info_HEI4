package hei.project.siteInfoHei.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;



@WebServlet("/changeMdp")
public class ChangeMdpServlet extends GenericServlet{
	String res="";
	
			@Override
			public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				WebContext context = new WebContext(req, resp, req.getServletContext());
				context.setVariable("alerte", res);

		        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
		        
		        if (PageAccueilServlet.getSession()==false) {
			    	   resp.sendRedirect("accueil");
			       }
		        templateEngine.process("changeMdp", context, resp.getWriter());
				
			} 
			public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		        WebContext context = new WebContext(req, resp, req.getServletContext());
		    	String newMdp = req.getParameter("newMdp"); // On récupere le nouveau mdp
		    	String Mdp = req.getParameter("Mdp");
		    	if (Mdp.equals(ListeIdentifiants.currentMdp)) {
		    		ListeIdentifiants.changeMdp(newMdp);
			    	if (ListeIdentifiants.currentAdmin) {
			    		resp.sendRedirect("admin");
			    	}
			    	else {
			    		resp.sendRedirect("avancement");
			    	}
		    	}
		    	else {
		    		res="Votre mot de passe actuel est incorrect";
		    		doGet(req,resp);
		    	}
		    	
		       
			}
}