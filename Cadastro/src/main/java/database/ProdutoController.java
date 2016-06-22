package database;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*

create table aluno (
  matricula int,
  nome varchar(255)
)

*/
@WebServlet("/produto")
public class ProdutoController extends HttpServlet {

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
			String msg;
			String op = valor(req, "operacao", "");
			int qtd = toInt(req, "preco", "0");
			String nome = valor(req, "nome", "");
			if (op.equals("incluir")) {
				ProdutoDao.inclui(qtd, nome);
				msg = "Inclusão realizada com sucesso.";
			} else if (op.equals("alterar")) {
				ProdutoDao.alterar(qtd, nome);
				msg = "Alteração realizada com sucesso.";
			} else if (op.equals("excluir")) {
				ProdutoDao.excluir(qtd);
				resp.sendRedirect("aluno");
				msg = "Exclusão realizada com sucesso.";
			} else if (op.equals("")) {
				msg = "";
			} else {
				throw new IllegalArgumentException("Operação \"" + op + "\" não suportada.");
			}
			
			req.setAttribute("msg", msg);

			List<Produto> produtos = ProdutoDao.listar();
			req.setAttribute("produtos", produtos);
			
			req.getRequestDispatcher("ProdutoView.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}
