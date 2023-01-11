package modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import controlador.UsuarioDAO;
import modelo.Conductores;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarConductor
 */
@WebServlet("/AgregarConductor")
public class AgregarConductor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AgregarConductor() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Conductores c = new Conductores();
		
				
	
		
		int iden = Integer.parseInt(request.getParameter("id"));
		
		int iduser = UsuarioDAO.ides;
		
		
		 UsuarioDAO.agregarcond(iden,iduser);
		response.sendRedirect("index3.html");
		
	
		
	}
}
