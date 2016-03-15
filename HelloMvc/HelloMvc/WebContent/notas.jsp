<%@page import="br.hellomvc.model.NotaSemestral"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	th{
		color:green;
		width: 140px;
	}
	td{
	padding:2px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>RM</th>
			<th>Disciplina</th>
			<c:forEach var="nac" items="${notaSemestral.nacs}" varStatus="s">
			<th>NAC ${s.count}</th>
			</c:forEach>
			<th>AM</th>
			<th>PS</th>
			<th>Final</th>
		</tr>
		<tr>
			<td>${notaSemestral.rm}</td>
			<td>${notaSemestral.disciplina}</td>
			<c:forEach var="nac" items="${notaSemestral.nacs}">
			<td>${nac}</td>
			</c:forEach>
			<td>${notaSemestral.am}</td>
			<td>${notaSemestral.ps}</td>
			<td>${notaSemestral.notaFinal}</td>
		</tr>
	</table>
</body>
</html>