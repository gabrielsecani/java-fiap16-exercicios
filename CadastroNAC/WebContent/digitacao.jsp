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
	<form action="/digitacao">
		<div>
			Disciplina: <b>${txtDisciplina}</b>
			
		</div>
		<table>
			<c:forEach var="aluno" varStatus="s" begin="1" end="${txtQtdAlunos}">
				<tr>
					<c:choose>
						<c:when test="${s.count == 1}">
							<th>RM</th>
							<%-- <c:forEach var="nac" items="${aluno.nacs}"> --%>
							<c:forEach var="nac" begin="1" end="${txtQtdNacs}">
								<th>NAC ${nac}</th>
							</c:forEach>
							<th>AM</th>
							<th>PS</th>
						</c:when>
						<c:otherwise>
							<td><input type="input" name="rm" /></td>
							<%-- <c:forEach var="nac" items="${aluno.nacs}"> --%>
							<c:forEach var="nac" begin="1" end="${txtQtdNacs}">
								<td><input type="input" name="nac" /></td>
							</c:forEach>
							<td><input type="input" name="am" /></td>
							<td><input type="input" name="ps" /></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
		<div>
			<input type="hidden" name="action" value="digitacao"/>
			<input type="submit" value="Avançar" />
		</div>
	</form>
</body>
</html>
