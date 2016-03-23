<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passo 2: Digitação</title>
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
	<h1>Passo 2: Digitação das notas</h1>
	<form action="cadnac">
	<input type="hidden" name="action" value="digitacao"/>
		<div>
			Disciplina: <b>${disciplina}</b>

		</div>
		<table>
			<tr>
				<th>&nbsp;</th>
				<th>RM</th>
				<%-- <c:forEach var="nac" items="${aluno.nacs}"> --%>
				<c:forEach var="nac" begin="1" end="${qtdNacs}">
					<th>NAC ${nac}</th>
				</c:forEach>
				<th>AM</th>
				<th>PS</th>
			</tr>

			<c:forEach var="aluno" varStatus="s" begin="1" end="${qtdAlunos}">
				<tr>
					<td>${s.count-1}</td>
					<td><input type="input" name="txtRM" /></td>
					<c:forEach var="nac" begin="1" end="${qtdNacs}">
						<td><input type="input" name="txtNAC" /></td>
					</c:forEach>
					<td><input type="input" name="txtAM" /></td>
					<td><input type="input" name="txtPS" /></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<input type="submit" value="Avançar" />
		</div>
	</form>
</body>
</html>
