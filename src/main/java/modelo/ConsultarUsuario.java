package modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import controlador.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ConsultarUsuario")
public class ConsultarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String a="El usuario a sido desactivado de la base de datos";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter imprimir = response.getWriter();
		imprimir.println("");
		imprimir.println("<center><font face=\"Comic sans MS,Arial,verdana\"color=#00EC36 size=6><p>Lista de usuarios</p></font></center>");
		
		List<Usuario> lista = UsuarioDAO.ConsultarTodosUsuario();
		
		imprimir.print("<head><meta charset=\"utf-8\"><link rel=\"stylesheet\" href=\"style.css\"></head>  <body bgcolor=\"black\"><table class=\"content-table\" border='1' width='100%'>");
		imprimir.print("<thead><tr><th>Codigo</th><th>nombre</th><th>Contraseña</th><th>Email</th>" +
		                 "<th>Estado</th><th>Modificar</th><th>Eliminar</th></tr></thead>");
		for (Usuario u:lista) {
			imprimir.print("<tr><tr class=\"active-row\"><td>" + u.getId() + "</td><td>" + u.getNombre() + "</td><td>" + u.getContrasena() +
					"</td><td>" + u.getEmail() + "</td><td>" + u.getEstatus() +  "</td><td>"  +
					"<a href='ModificarUsuario?id=" + u.getId()	+ "'>modificar</a></td><td>" +
					"<a href='EliminarUsuario?id=" + u.getId() + "'>Eliminar</a> </td></tr>");
			
		}
		imprimir.print("</table>");
		imprimir.print(" <a href= 'index2.html'>\r\n"
				+ "        <input type=\"button\" value=\"Agregar Usuario\">\r\n"
				+ "    </a>  </body>");
		imprimir.close();
		
	}

}
