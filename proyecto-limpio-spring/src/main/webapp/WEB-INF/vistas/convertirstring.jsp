<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Conversor</title>
  </head>
  <body>
  	<div class="container">
	    <h1>Conversor de string</h1>
	    
	    <form class="container" action="mostrarresultado" method="GET">
	    	<fieldset class="form-group">
				<div class="row">
			      <div class="col-sm-10">
			        <div class="form-check">
			          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
			          <label class="form-check-label" for="gridRadios1">
			            Convertir todo a mayuscula
			          </label>
			        </div>
			        <div class="form-check">
			          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
			          <label class="form-check-label" for="gridRadios2">
			            Convertir todo a minuscula
			          </label>
			        </div>
			        <div class="form-check">
			          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3">
			          <label class="form-check-label" for="gridRadios3">
			            Contar caracteres
			          </label>
			        </div>
			        <div class="form-check disabled">
			          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios4" value="option4">
			          <label class="form-check-label" for="gridRadios4">
			            Invertir el texto
			          </label>
			        </div>
			      </div>
				</div>
			</fieldset>
	    	
	    	<div class="form-group">
			 	<div class="form-group">
				    <textarea class="form-control" name="valor" id="exampleFormControlTextarea1" rows="3" placeholder="ingrese el texto"></textarea>
				</div>
				<button type="submit" class="btn btn-primary mb-2">Convertir</button>
			</div>
		</form>
	</div>
	
	
	
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>