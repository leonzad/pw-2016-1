<!DOCTYPE html>
<html>

<head>
<title>Login</title>
    
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    
  </head>
    
   <div class="container">
  <h2>Login</h2>
  <form class="form-horizontal" role="form">
    <div class="form-group">
      <label class="control-label col-sm-1" for="usuario">Usuário:</label>
      <div class="col-sm-4">
        <input type="text" name="usuario" class="form-control" placeholder="walison">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-1" for="senha">Senha:</label>
      <div class="col-sm-4">
        <input type="password" class="form-control" name="senha" placeholder="123">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-1 col-sm-4">
        <button name="operacao" value="entrar" class="btn btn-primary">Login</button>
        <button name="operacao" value="entrar" class="btn btn-default">Registrar</button>
        <br>
        <br>
        <b>${msg}</b>
      </div>
    </div>
 	</div>
	</form>   
  </body>
</html>