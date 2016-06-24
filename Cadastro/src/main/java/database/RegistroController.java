package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String URL = "jdbc:derby:db;create=true";

	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {		
			
			String op = valor(req, "operacao", "");
			String usuario = valor(req, "usuario", "");
			String senha = valor(req, "senha", "");
			
			if (op.equals("registro")) {
				RegistroDao.inclui(usuario, senha);
				resp.sendRedirect("login");
			}
			
			/*String msg = "";
			String op = valor(req, "operacao", "");
			String usuario = valor(req, "usuario", "");
			String senha = valor(req, "senha", "");
				// Abrir uma conexão com o banco de dados.
				Connection conn = DriverManager.getConnection(URL);
				//Query no BD procurando usuário e senha cadastrados
					String sql = "insert into cadastro (usuario, senha) values (?,?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, usuario);
					pstmt.setString(2, senha);
					pstmt.executeUpdate();
					// Fechar sentença.
					pstmt.close();
					// Fechar conexão.
					conn.close();*/
						
			
			
			
			
			
			req.getRequestDispatcher("RegistroView.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}
