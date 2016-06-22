package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO = Data Access Object.
 */
public class ProdutoDao {

	private static final String URL = "jdbc:derby:db;create=true";

	public static void inclui(int qtd, String nome) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "insert into produto (qtd, nome) values (?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, qtd);
		pstmt.setString(2, nome);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static void alterar(int qtd, String nome) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "update produto set nome = ? where qtd = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nome);
		pstmt.setInt(2, qtd);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static void excluir(int qtd) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "delete from produto where qtd = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, qtd);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static List<Produto> listar() throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "select qtd, nome from produto";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// Represneta o resultado da execução.
		ResultSet rs = pstmt.executeQuery();
		
		List<Produto> produtos = new ArrayList<>();
		while (rs.next()) {
			int qtd = rs.getInt("qtd");
			String nome = rs.getString("nome");
			Produto produto = new Produto(qtd, nome);
			produtos.add(produto);
		}
	
		// Fechar resultado.
		rs.close();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
		
		return produtos;
	}
}
