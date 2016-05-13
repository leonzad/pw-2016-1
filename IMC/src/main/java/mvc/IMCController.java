package mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class IMCController extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String valor(HttpServletRequest req, String param,	String padrao) {

		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}

	private double toDouble(HttpServletRequest req, String param, String padrao) {

		return Double.parseDouble(valor(req, param, padrao));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double oper1 = toDouble(req, "altura", "0");
		String op = valor(req, "operacao", "");
		double oper2 = toDouble(req, "peso", "0");

		String resultadoCalculo = IMCModel.calcula(oper2, op, oper1);
		
		//Passando parâmetro para o JSP.
		req.setAttribute(
				"resultado",
				resultadoCalculo);

		req.getRequestDispatcher("IMCView.jsp").forward(req, resp);
	}
}
