package hei.project.siteInfoHei.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.project.siteInfoHei.dao.impl.ListeIdentifiants;

@WebServlet("/supprmodif")
public class ModifSupprEleveServlet extends GenericServlet{
private int id;
private Eleve currentEleve;
@Override
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	WebContext context = new WebContext(req, resp, req.getServletContext());
	id = Integer.parseInt(req.getParameter("id"));
    TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
    currentEleve=hei.project.siteInfoHei.dao.impl.EleveDao.getEleveById(id);
    context.setVariable("eleve", currentEleve);
    if (PageAccueilServlet.getSession()==false || !ListeIdentifiants.currentAdmin) {
    	   resp.sendRedirect("accueil");
       }
   templateEngine.process("ModifSuppr", context, resp.getWriter());
   
}


public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	WebContext context = new WebContext(req, resp, req.getServletContext());
	String nom=req.getParameter("nom");
	String prenom=req.getParameter("prenom");
	String dom=req.getParameter("domaine");
	String year=req.getParameter("year");
	int annee;
	if(nom==""&&prenom==""&&dom==""&&year=="") {
		hei.project.siteInfoHei.dao.impl.EleveDao.delete(id);resp.sendRedirect("admin");	
		}else {
		if(nom=="") {nom=currentEleve.getNom();}
		if(prenom=="") {prenom=currentEleve.getPrenom();}
		if(dom=="") {dom=currentEleve.getDomaine();}
		if(year=="0") {annee=currentEleve.getYear();}else {annee=Integer.parseInt(year);}
		hei.project.siteInfoHei.dao.impl.EleveDao.modif(id, nom, prenom, annee, dom);
		resp.sendRedirect("admin");
	}
	
}
}
