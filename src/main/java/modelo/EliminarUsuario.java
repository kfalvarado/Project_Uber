package modelo;

import java.io.IOException;

import controlador.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/EliminarUsuario")
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public EliminarUsuario() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sIdUsuario = request.getParameter("id");
		int idUsuario = Integer.parseInt(sIdUsuario);
		/*UsuarioDAO.borrar(idUsuario);*/
		UsuarioDAO.Eliminar(idUsuario);
		
		
		UsuarioDAO.ConsultarTodosUsuario();
		response.sendRedirect("ConsultarUsuario");
		
	}

}
