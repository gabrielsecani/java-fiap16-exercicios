<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passo 3: Confirmação</title>
<style>
th {
	color: green;
	width: 140px;
}

td {
	padding: 2px;
}
</style>
</head>
<body>
	<h1>Passo 3: Confirmação</h1>
	<form action="cadnac">
		<input type="hidden" name="action" value="confirmacao" />
		<table>
			<tr>
				<th>&nbsp;</th>
				<th>RM</th>
				<th>Md.NACs</th>
				<th>AM</th>
				<th>PS</th>
			</tr>
			<c:forEach items="${notas}" var="nota" varStatus="s">
				<tr>
					<td>${s.count-1}</td>
					<td>${nota.rm}</td>
					<td>${nota.mediaNacs}</td>
					<td>${nota.am}</td>
					<td>${nota.ps}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<input type="submit" value="Avançar" />
		</div>

	</form>
</body>
</html>
