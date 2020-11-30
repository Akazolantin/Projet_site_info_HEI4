package hei.project.siteInfoHei.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;
import hei.project.siteInfoHei.entities.Identifiant;

@WebServlet("/Connexion")
public class PageAccueilServlet extends GenericServlet{
	String res="";
	static boolean connecte=false;
	String nomUtil;
	String Mdp;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("alerte", res);
		
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("Connexion", context, resp.getWriter());
        
        if (PageAccueilServlet.getSession()) {
        	PageAccueilServlet.connecte=false;
        }
        
        
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
        WebContext context = new WebContext(req, resp, req.getServletContext());
    	String nomUtil = req.getParameter("nomUtil");
        String Mdp = req.getParameter("Mdp");
        
        if(ListeIdentifiants.checkIdent(nomUtil,Mdp)) {
        	connecte=true;
        	if(ListeIdentifiants.currentAdmin) {
        	resp.sendRedirect("admin");
        }
        	else {
        		resp.sendRedirect("avancement");
        	}
        }else {
        	res="Votre identifiant ou mot de passe est incorrect";
        	doGet(req,resp);
        	res="";
        }
    }
    public static boolean getSession() {
    	return connecte;
    }
    
    
}
