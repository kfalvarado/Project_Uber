package modelo;

import java.io.IOException;
import java.io.PrintWriter;

import controlador.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModificarUsuario() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int estatus = 0;
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		salida.println("<h1>Modificar Usuario</h1>");
		int idUsuario = Integer.parseInt(request.getParameter("id"));
		Usuario u = UsuarioDAO.ConsultarEmpleadoPorCOdigo(idUsuario);
		salida.print("<body bgcolor=#DAF7A6>");
		salida.print("<form action='ModificarUsuario2' method='post'>");
		salida.print("<table>");
		salida.print("<tr><td></td><td><input type ='hidden' name='id' value='" +
				     u.getId() + "'/></td></tr>");
		salida.print("<tr><td>Nombre</td><td><input type='text' name='nombre' value = '" + 
				     u.getNombre() + "'/></td></tr>");
		salida.print("<tr><td>Contrasena</td><td><input type='password' name='contrasena' value='" +
				     u.getContrasena() + "'/></td></tr>");
		salida.print("<tr><td>Email</td><td><input type='text' name='email' value= '" + 
				     u.getEmail() + "'/></td></tr>");
		salida.print("<tr><td>Estado en:</td><td><input type=\"text\" name=\"estado\" value='"+ u.getEstatus() +"' readonly onmousedown=\"return false;\"/>");
		
		salida.print("</td></tr>");
		salida.print("<tr><td colspan='2'><input type='submit' value='Guardar' /></td></tr>");
		salida.print("</table>");
		salida.print("</form>");
		salida.close();
	}

}
