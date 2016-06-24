package database;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class SegurancaFilter implements Filter {
	
	 private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
		        Arrays.asList("/login", "/logout", "/registro", "/dbclient.jsp")));	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		//Obtém referências ao request e ao response.
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		//Obtém a sessão corrente. Caso não exista, retorna "null".
		HttpSession session = request.getSession(false);
		//Endereço de login.
		//String loginUri = request.getContextPath() + "/login";
		String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", ""); 

		
		boolean loggedIn = session != null && session.getAttribute("usuario") != null;
		boolean allowedPath = ALLOWED_PATHS.contains(path);
		//boolean loginRequest = request.getRequestURI().equals(loginUri);

		//Se estiver logado ou se for a página de login.
		//if (loggedIn || loginRequest) {
		if (loggedIn || allowedPath) {
			//Segue adiante.
			chain.doFilter(request, response);
		} else {
			//Redireciona para o login.
			//response.sendRedirect(loginUri);
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
