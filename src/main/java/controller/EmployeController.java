package controller;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.connector.Response;

import java.sql.Date; 

import dao.EmployeDaoImpl;
import dao.IEmployeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.Employe;
import web.EmployeModel;

@WebServlet(name = "cs", urlPatterns = { "/controlleur", "*.do" })
public class EmployeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEmployeDao metier;

	@Override
	public void init() throws ServletException {
		metier = new EmployeDaoImpl();
	}

	public EmployeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("employes.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			EmployeModel model = new EmployeModel();
			model.setMotCle(motCle);
			List<Employe> employes;

			try {
				employes = metier.EmployesParMC(motCle);
				model.setEmployes(employes);
				request.setAttribute("model", model);
				request.getRequestDispatcher("employes.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String matricule = request.getParameter("matricule");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Date dateEmbauche = Date.valueOf(request.getParameter("dateEmbauche"));
			String service = request.getParameter("service");
			String fonction = request.getParameter("fonction");
			String sexe = request.getParameter("sexe");
			Integer salaire = Integer.parseInt(request.getParameter("salaire"));

			Employe employe = new Employe(matricule, nom, prenom, dateEmbauche, service, fonction, sexe, salaire);

			try {
				Employe savedEmploye = metier.save(employe);
				request.setAttribute("employe", savedEmploye);
				request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (path.equals("/supprimer.do")) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				metier.deleteEmploye(id);
				response.sendRedirect("chercher.do?motCle=");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (path.equals("/editer.do")) {
			try {
				Long id= Long.parseLong(request.getParameter("id"));
      			Employe e = metier.getEmploye(id);
				request.setAttribute("employe", e);
				request.getRequestDispatcher("editerEmploye.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (path.equals("/update.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
		    String matricule = request.getParameter("matricule");
		    String nom = request.getParameter("nom");
		    String prenom = request.getParameter("prenom");
		    Date dateEmbauche = Date.valueOf(request.getParameter("dateEmbauche"));
		    String service = request.getParameter("service");
		    String fonction = request.getParameter("fonction");
		    String sexe = request.getParameter("sexe");
		    Integer salaire = Integer.parseInt(request.getParameter("salaire"));

		    Employe employe = new Employe(matricule, nom, prenom, dateEmbauche, service, fonction, sexe, salaire);
		    employe.setId(id); // Mettre à jour l'ID de l'employé

		    try {
		        Employe updatedEmploye = metier.updateEmploye(employe);
		        request.setAttribute("employe", updatedEmploye);
		        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
