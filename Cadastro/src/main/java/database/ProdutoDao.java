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

	public static void inclui(int preco, String nome) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "insert into produto (preco, nome) values (?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, preco);
		pstmt.setString(2, nome);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static void alterar(int preco, String nome) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "update produto set nome = ? where preco = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nome);
		pstmt.setInt(2, preco);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static void excluir(int preco) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "delete from produto where preco = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, preco);
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
		String sql = "select preco, nome from produto";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// Represneta o resultado da execução.
		ResultSet rs = pstmt.executeQuery();
		
		List<Produto> produtos = new ArrayList<>();
		while (rs.next()) {
			int preco = rs.getInt("preco");
			String nome = rs.getString("nome");
			Produto produto = new Produto(preco, nome);
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
