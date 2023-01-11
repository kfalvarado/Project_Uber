

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import controlador.Contador;
import controlador.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;


/**
 * Servlet implementation class Buscardata
 */
@WebServlet("/Buscardata")
public class Buscardata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Buscardata() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Connection con = UsuarioDAO.establecerCon();
		String username;
		String password;
		
		
		try {
			//PreparedStatement st = con.prepareStatement("SELECT * From miprueba.login WHERE User=?  ");
			//st.setInt(1, Integer.parseInt(request.getParameter("txtID")));
			username = request.getParameter("usuario");
			password = request.getParameter("contrasena");
		
		
		
		Usuario usuario = new Usuario();
		usuario.setNombre(username);
		usuario.setContrasena(password);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		int b=1;
		if(usuarioDAO.validarbloqueado(usuario)) {
			if(usuarioDAO.validardesactivado(usuario)) {
		if (usuarioDAO.validate(usuario))
			{
			response.sendRedirect("index3.html");
			}
		
		else
		{	
			Contador e1 = new Contador();
			
			//response.sendRedirect("index.html");
			PrintWriter salida = response.getWriter();
			
			
			if (e1.contador2(b)<3) {
				salida.println("<html><body><b>Intento fallido, Ingrese de Nuevo</b></body></html>");
				salida.println("<a href= 'index.html'>Regresar</a>");
				
			}
			
			else {
				
				salida.println("<html><body><b>ha sido bloqueado, llego a los:3 </b></body></html>");
				salida.println("<a href= 'index.html'>Regresar</a>");
				
				UsuarioDAO.bloqueo1(usuario);
				int idebloqueo = UsuarioDAO.ides;
				UsuarioDAO.bloqueo2(idebloqueo);
				int reinicio= -3;
				e1.contador2(reinicio);
				
			}
			
		}}else{
			PrintWriter salida = response.getWriter();
			salida.println("<p> el estado activo de su usuario esta desactivado</p>");
			salida.println("<a href= 'index.html'>Regresar</a>");
		}} else{
			PrintWriter salida = response.getWriter();
			salida.println("<p>Su Usuario tiene un estado  bloqueado</p>");
			salida.println("<a href= 'index.html'>Regresar</a>");
		}}

		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
		
	
	
}


