<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultado IMC</title>
</head>
<body>
Seu IMC é: <span style="color: ${imc.cor};">${imc.valorIMC}</span>
<hr/>
<a href="inicio.html">Tentar com novos valores!</a>
</body>
</html>