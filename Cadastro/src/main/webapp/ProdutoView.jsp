<!DOCTYPE html>
<%@page import="database.Produto"%>
<%@page import="java.util.List"%>
<html>

<head>
<title>Produtos</title>
</head>

<body>
  <h1>
    <a href="produto">Produto</a>
  </h1>
  <a href="logout">Logout</a>
  <br>
  <br>
  <form>
    <table>
      <tr>
        <td>Quantidade</td>
        <td><input name="qtd"></td>
      </tr>
      <tr>
        <td>Nome:</td>
        <td><input name="nome"></td>
      </tr>
    </table>
    <button name="operacao" value="incluir">Incluir</button>
    <button name="operacao" value="excluir">Excluir</button>
    <button name="operacao" value="alterar">Alterar</button>
  </form>
  <b>${msg}</b>
  <hr>
  Usuário: ${usuario}
  <hr>
  <table>
    <tr>
      <th>Quantidade</th>
      <th>Nome</th>
      <th>Ações</th>
    </tr>
    <%
      //Obtém a lista de produtos criada pelo controlador.
  	List<Produto> produtos =
      (List<Produto>) request.getAttribute("produtos");

    if (produtos != null && !produtos.isEmpty()) {
      for (Produto a : produtos) {
    %>
    <tr>
      <td><%=a.getQtd()%></td>
      <td><%=a.getNome()%></td>
      <td><a href="produto?operacao=excluir&preco=<%=a.getQtd()%>">Excluir</a></td>
    </tr>
    <%
      }
    }
    %>
  </table>
</body>

</html>