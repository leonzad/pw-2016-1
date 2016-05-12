<%@page import="imc.Imc.imc"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado IMC </title>

<%
String aux;
float altura = 0;
float peso = 0;
float imc = 0;

aux = request.getParameter("altura");

altura = Float.parseFloat(aux.replaceAll(",", "."));

aux = request.getParameter("peso");
peso = Float.parseFloat(aux.replaceAll(",", "."));

imc = peso/(altura*altura);
%>

</head>

<body>
Resultado
<br>
Seu IMC é <%=imc%>!
<br>

<%if(imc < 18.5){ %>
	Abaixo do peso!
	<%}else if(imc >= 18.5 && imc <= 24.9){%>
            IMC está normal!
            <%}else if(imc > 25 && imc < 29.9){ %>
                IMC indica sobrepeso!
                <%}else if(imc > 29.9){%>
                    IMC indica obesidade!
                    <%} %>          
	
	
	
	 

</body>
</html>