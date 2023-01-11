package modelo;

import java.io.IOException;
import java.io.PrintWriter;

import controlador.UsuarioDAO;
import modelo.Conductores;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificarUsuario2
 */
@WebServlet("/ModificarUsuario2")
public class ModificarUsuario2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ModificarUsuario2() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int estatus = 0;
		PrintWriter imprime = response.getWriter();
		Conductores c = new Conductores();
		int idUsuario = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		
		Usuario u = new Usuario();
	
		u.setId(idUsuario);
		c.setIduser(idUsuario);
		u.setNombre(nombre);
		u.setContrasena(contrasena);
		u.setEmail(email);
		u.setPais(pais);
		
		
		estatus = UsuarioDAO.actualizar(u);
		if (estatus >0 ) {
			response.sendRedirect("ConsultarUsuario");
			
		}
		else {
			imprime.println("Ha ocurrido un error!!");		
		}
		imprime.close();
	}

}
