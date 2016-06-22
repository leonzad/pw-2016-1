package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*

create table aluno (
  matricula int,
  nome varchar(255)
)

*/
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final String URL = "jdbc:derby:db;create=true";

	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}

	private int toInt(HttpServletRequest req, String param, String padrao) {
		return Integer.parseInt(valor(req, param, padrao));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String msg = "";
			String op = valor(req, "operacao", "");
			String usuario = valor(req, "usuario", "");
			String senha = valor(req, "senha", "");
			// Abrir uma conexão com o banco de dados.
						Connection conn = DriverManager.getConnection(URL);
						//Query no BD procurando usuário e senha cadastrados
						PreparedStatement ps = conn.prepareStatement("select * from cadastro where usuario=? and senha=?");
						ps.setString(1, usuario);
						ps.setString(2, senha);
						ResultSet rs = ps.executeQuery();
						//Verificação	
						if (op.equals("entrar")) {
							if(rs.next()){
								//É de verdade.
								//Obter a sessão.
								HttpSession session = req.getSession();
								//Incluir variável na região de memória da sessão.
								session.setAttribute("usuario", usuario);				
								resp.sendRedirect("produto");
							
						} else {
							msg = "Usuário ou senha incorreta.";
						 }
						} else if (op.equals("")) {
							msg = "";
						} else {
							throw new IllegalArgumentException("Operação \"" + op + "\" não suportada.");
						}
						req.setAttribute("msg", msg);
						req.getRequestDispatcher("LoginView.jsp").forward(req, resp);
					} catch (Exception e) {
						e.printStackTrace(resp.getWriter());
					}
				}
			}