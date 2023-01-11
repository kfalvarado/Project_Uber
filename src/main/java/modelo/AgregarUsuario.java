package modelo;

import java.io.IOException;
import java.io.PrintWriter;

import controlador.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarUsuario
 */
@WebServlet("/AgregarUsuario")
public class AgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int estatus = 0;
		int bloqueador= 0;
		Usuario u = new Usuario();
		PrintWriter imprime = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		String email = request.getParameter("email");
		int estado = Integer.parseInt(request.getParameter("estado"));
		
		u.setNombre(nombre);
		u.setContrasena(contrasena);
		u.setEmail(email);
		u.setEstatus(estado);
		
		estatus = UsuarioDAO.agregar(u);
		
		if (estatus>0) {
		    imprime.print("<head><style>body {\r\n"
		    		+ "  margin: 30px;\r\n"
		    		+ "  background-color: #E9E9E9;\r\n"
		    		+ "}div.polaroid {\r\n"
		    		+ "  width: 284px;\r\n"
		    		+ "  padding: 10px 20px 30px 10px;\r\n"
		    		+ "  border: 1px solid black;\r\n"
		    		+ "  background-color: #E4DC2A;\r\n"
		    		+ "  box-shadow: 10px 10px 5px #DA2B2B;\r\n"
		    		+ "}"
		    		+ "div.rotate_right {\r\n"
		    		+ "  float: left;\r\n"
		    		+ "  -ms-transform: rotate(7deg); /* IE 9 */\r\n"
		    		+ "  -webkit-transform: rotate(7deg); /* Safari */\r\n"
		    		+ "  transform: rotate(7deg);\r\n"
		    		+ "}\r\n"
		    		+ "div.rotate_left {\r\n"
		    		+ "  float: left;\r\n"
		    		+ "  -ms-transform: rotate(-8deg); /* IE 9 */\r\n"
		    		+ "  -webkit-transform: rotate(-8deg); /* Safari */\r\n"
		    		+ "  transform: rotate(-8deg);\r\n"
		    		+ "}</style>\r\n"
		    		+ "</head>\r\n"
		    		+ "<body>\r\n"
		    		+ "<div class=\"polaroid rotate_right\">\r\n"
		    		+ "  \r\n"
		    		+ "  <p class=\"caption\"><center><FONT FACE=\"impact\\\" SIZE=6 \\\\\\\"><b><u>Usuario aceptado</u></b></font></center></p>\r\n"
		    		+ "</div><div class=\"polaroid rotate_left\">\r\n"
		    		+ " \r\n"
		    		+ "  <p class=\"caption\"><center><FONT SIZE=4><b>Si desea crear otro usuario, ingrense los datos </b></font></center></p>"
		    		+ "</div></body>")	;
		    request.getRequestDispatcher("index2.html").include(request, response);
		    
		}else {
			imprime.println("No es posible agregar el registro");
			
		}
		imprime.close();
				
	}

}
