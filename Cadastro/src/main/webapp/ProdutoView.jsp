<!DOCTYPE html>
<%@page import="database.Produto"%>
<%@page import="java.util.List"%>
<html>

<head>
<title>Produto</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Produto</title>
<!--[if lt IE 9]>
  <script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head>

<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Controle de Estoque</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span>  Usu�rio: ${usuario}</a></li>
      <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  
  <div class="container">
  <h2>Cadastro</h2>
  <form class="form-horizontal" role="form">
    <div class="form-group">
      <label class="control-label col-sm-1" for="qtd">Quantidade:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" name="qtd">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-1" for="nome">Nome:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" name="nome">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-1 col-sm-3">
        <button name="operacao" class="btn btn-default" value="incluir">Incluir</button>
   		<button name="operacao" class="btn btn-danger" value="excluir">Excluir</button>
   	    <button name="operacao" class="btn btn-warning" value="alterar">Alterar</button>
      </div>
    </div>
  </form>
</div> 
  <form>
  <div class="container">
  <h2>Produtos</h2>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Quantidade</th>
        <th>Nome</th>
        <b>${msg}</b>
      </tr>
    </thead>
    <tbody>
	  <%
      //Obt�m a lista de alunos criada pelo controlador.
  	List<Produto> produtos =
      (List<Produto>) request.getAttribute("produtos");

    if (produtos != null && !produtos.isEmpty()) {
      for (Produto a : produtos) {
    %>
    <tr>
      <td><%=a.getQtd()%></td>
      <td><%=a.getNome()%></td>
      <td><a href="produto?operacao=excluir&qtd=<%=a.getQtd()%>">Excluir</a></td>
    </tr>
    <%
      }
    }
    %>
 
    </tbody>
  </table>
</div>
</form>   
</body>

</html>