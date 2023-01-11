package controlador;

/*import java.sql.Connection;
import java.sql.DriverManager;
import modelo.Usuario;*/
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.exceptions.RSAException;

import modelo.Usuario;
import modelo.Conductores;


public class UsuarioDAO {
	public static Connection establecerCon() {
		Connection con= null;
		try {
			 String dbDriver = "com.mysql.jdbc.Driver";
			 String dbURL = "jdbc:mysql://localhost:3306/";
			 String dbName = "lenguaje3";
			 String dbUsername = "root";
			 String dbPassword = "Mot@gua12345";
			Class.forName(dbDriver);
			 con= DriverManager.getConnection(dbURL + dbName, dbUsername, 
														dbPassword);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			}
		return con;
	}
	
	public static int agregar(Usuario u) {
		int estatus = 0;
		
		try {
			Connection con = UsuarioDAO.establecerCon();
			PreparedStatement ps = con.prepareStatement("Insert into usuario (nombre, contrasena, email, estatus,activo)"+
					                                     "values (?, ?, ?, ?,1)");
			ps.setString(1, u.getNombre());
			ps.setString(2, u.getContrasena());
			ps.setString(3, u.getEmail());
			ps.setInt(4, u.getEstatus());
			
			estatus = ps.executeUpdate();
			con.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return estatus;
	}
	
	
public void loadDriver(String dbDriver) 
{
	try {
		Class.forName(dbDriver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public boolean validate(Usuario usuario) {
	//loadDriver(dbDriver);
	Connection con = establecerCon();
	boolean status = false;
	
	String sql= "select * from lenguaje3.usuario where nombre = ? and contrasena=?";
	
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, usuario.getNombre());
		ps.setString(2, usuario.getContrasena());
		/*ps.setString(3, usuario.getEstatus());*/
		List<Usuario> lista = UsuarioDAO.Todos(usuario);
		UsuarioDAO.ides = usuario.getId();
		
		 
		 
		
	ResultSet rs=  ps.executeQuery();
	status = rs.next();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}

public boolean validarbloqueado(Usuario usuario) {
	//loadDriver(dbDriver);
	Connection con = establecerCon();
	boolean status = false;
	
	String sql= "select * from lenguaje3.usuario where nombre = ? and estatus=1;";
	
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, usuario.getNombre());
		/*ps.setString(2, usuario.getContrasena());
		ps.setString(3, usuario.getEstatus());
		List<Usuario> lista = UsuarioDAO.Todos(usuario);
		UsuarioDAO.ides = usuario.getId();*/
		
	ResultSet rs=  ps.executeQuery();
	status = rs.next();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
public boolean validardesactivado(Usuario usuario) {
	//loadDriver(dbDriver);
	Connection con = establecerCon();
	boolean status = false;
	
	String sql= "select * from lenguaje3.usuario where nombre = ? and activo=1;";
	
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, usuario.getNombre());
		/*ps.setString(2, usuario.getContrasena());
		ps.setString(3, usuario.getEstatus());
		List<Usuario> lista = UsuarioDAO.Todos(usuario);
		UsuarioDAO.ides = usuario.getId();*/
		
	ResultSet rs=  ps.executeQuery();
	status = rs.next();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}



/*public boolean bloqueador(Usuario u) {
	//loadDriver(dbDriver);
	Connection con = establecerCon();
	boolean status = false;
	
	String sql= "update usuario set estatus=0 where id = ?";
	
	
	PreparedStatement ps;
	
	try {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		String 
		if (usuarioDAO.validate(usuario))
			{
			response.sendRedirect("index3.html");
			}
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, usuario.getId());
		/*ps.setString(2, usuario.getNombre());*/
		/*ps.setInt(2, usuario.getEstatus());*/
		/*ps.setString(3, usuario.getEstatus());
		
		
		
		
	ResultSet rs=  ps.executeQuery();
	status = rs.next();
	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return status;
}*/


private static Statement getInstance() {
	// TODO Auto-generated method stub
	return null;
}

public static List<Usuario> ConsultarTodosUsuario() {
	List<Usuario> lista = new ArrayList<Usuario>();
	try {
		Connection con = UsuarioDAO.establecerCon();
		PreparedStatement ps = con.prepareStatement("Select * from usuario");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Usuario u = new Usuario();
			u.setId(rs.getInt(1));
			u.setNombre(rs.getNString(2));
			u.setContrasena(rs.getString(3));
			u.setEmail(rs.getString(4));
			u.setEstatus(rs.getInt(5));
			u.setActivo(rs.getBoolean(6));
			lista.add(u);
		}
		con.close();			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lista;		
}
/*---------------------------------------------------------*/
public static List<Usuario> Todos(Usuario usuario) {
	List<Usuario> lista = new ArrayList<Usuario>();
	try {
		Connection con = UsuarioDAO.establecerCon();
		PreparedStatement ps = con.prepareStatement("select * from lenguaje3.usuario where nombre = ? and contrasena=?;");
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getContrasena());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			usuario.setId(rs.getInt(1));
			usuario.setNombre(rs.getNString(2));
			usuario.setContrasena(rs.getString(3));
			usuario.setEmail(rs.getString(4));
			usuario.setEstatus(rs.getInt(5));
			lista.add(usuario);
		}
		con.close();			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lista;		
}


public static Usuario ConsultarEmpleadoPorCOdigo(int id) {
	Usuario e = new Usuario();
	Conductores c = new Conductores();
	
	try {
		Connection con = UsuarioDAO.establecerCon();
		PreparedStatement ps = con.prepareStatement("Select * from usuario where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			e.setId(rs.getInt(1));
			c.setIduser(rs.getInt(1));
			UsuarioDAO.idresp(rs.getInt(1));
			e.setNombre(rs.getString(2));
			e.setContrasena(rs.getString(3));
			e.setEmail(rs.getString(4));
			/*e.setEstatus(rs.getString(5));*/
			
		}	} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
/*public static Usuario IIDES(int id) {
	
}*/

public static int actualizar(Usuario u) {
	int estatus = 0;
	try {
		Connection con = UsuarioDAO.establecerCon();
		PreparedStatement ps = con.prepareStatement("Update usuario set nombre=?, contrasena=?, " + 
				                                    "email =? where id=?;");
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getContrasena());
		ps.setString(3, u.getEmail());
		/*ps.setString(4, u.getEstatus());*/
		ps.setInt(4, u.getId());
		
		estatus = ps.executeUpdate();
		con.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return estatus;
}
public static int ides=0;
public static int idresp(int id) {
	ides=id;
	return ides;
}
public static int agregarcond(int id,int iduser) {
	int estatus = 0;
	
		try {
			Connection con = UsuarioDAO.establecerCon();
			PreparedStatement ps = con.prepareStatement("update usuario set conductor = ? where id = ?;"); 
					                                    
			ps.setInt(1, id);
			ps.setInt(2, iduser);
			
			
			estatus = ps.executeUpdate();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	
	return estatus;
}

public static List<Usuario> Todosbloque(Usuario usuario) {
	List<Usuario> lista = new ArrayList<Usuario>();
	try {
		Connection con = UsuarioDAO.establecerCon();
		PreparedStatement ps = con.prepareStatement("select * from lenguaje3.usuario where nombre = ? ;");
			ps.setString(1, usuario.getNombre());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			usuario.setId(rs.getInt(1));
			usuario.setNombre(rs.getNString(2));
			usuario.setContrasena(rs.getString(3));
			usuario.setEmail(rs.getString(4));
			usuario.setEstatus(rs.getInt(5));
			lista.add(usuario);
		}
		con.close();			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lista;		
}




public static boolean bloqueo1(Usuario u) {
	Connection con = establecerCon();
	boolean status=false;
	
	String sql= "select * from lenguaje3.usuario where nombre = ?;";
	
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		
		List<Usuario> lista = UsuarioDAO.Todosbloque(u);
		UsuarioDAO.ides = u.getId();
		ResultSet rs=  ps.executeQuery();
		status = rs.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}	 
		
public static int bloqueo2(int iduser) {
	int estatus = 0;
	
		try {
			Connection con = UsuarioDAO.establecerCon();
			PreparedStatement ps = con.prepareStatement("update usuario set estatus = 0 where id = ?;"); 
					                                    
			ps.setInt(1, iduser);
			
			
			estatus = ps.executeUpdate();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return estatus;
		}

public static int Eliminar(int u) {
	int estatus = 0;
	try {
		Connection con = UsuarioDAO.establecerCon();
		PreparedStatement ps = con.prepareStatement("Update usuario set activo=0 where id=?;");
	
		ps.setInt(1, u);
		
		estatus = ps.executeUpdate();
		con.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return estatus;
}
public static int borrar (int id) {
	int estatus = 0;
	try (Connection con  = UsuarioDAO.establecerCon();
	      PreparedStatement ps = con.prepareStatement("Delete from usuario where id=?")) {
		  ps.setInt(1, id);
		  estatus = ps.executeUpdate();
		  con.close();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return estatus;			
}	
}

