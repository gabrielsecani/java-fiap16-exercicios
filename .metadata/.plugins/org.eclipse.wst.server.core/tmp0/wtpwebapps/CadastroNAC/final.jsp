<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Passo 4 - Final</title>
</head>
<body>
<span style="color: green;">A maior nota da sala foi de:</span>
<ul>
	<c:forEach items="${maximas}" var="n">
		<li>RM ${n.rm} => Nota: ${n.notaFinal}</li>
	</c:forEach>
</ul>
<hr/>
<span style="color: red;">A menor nota da sala foi de:</span>
<ul>
	<c:forEach items="${minimas}" var="n">
		<li>RM ${n.rm} => Nota: ${n.notaFinal}</li>
	</c:forEach>
</ul>
<hr/>
<span style="color: blue;">A média da sala foi de: ${media}</span>
<br/><br/>
<a href="entrada.html">Lançar próxima turma!</a>
</body>
</html>