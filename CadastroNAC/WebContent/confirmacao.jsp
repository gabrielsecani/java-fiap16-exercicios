<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passo 3: Confirmação</title>
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
	<h1>Passo 3: Confirmação</h1>
	<form action="/digitacao">
		<table>
			<c:forEach var="aluno" varStatus="s" begin="1" end="60">
				<tr>
					<c:choose>
						<c:when test="${s.count == 1}">
							<th>RM</th>
							<%-- <c:forEach var="nac" items="${aluno.nacs}"> --%>
							<c:forEach var="nac" begin="1" end="3" varStatus="snac">
								<th>NAC ${snac.count}</th>
							</c:forEach>
							<th>AM</th>
							<th>PS</th>
						</c:when>
						<c:otherwise>
							<td>RM</td>
							<%-- <c:forEach var="nac" items="${aluno.nacs}"> --%>
							<c:forEach var="nac" begin="1" end="3" varStatus="snac">
								<td>NAC ${snac.count}</td>
							</c:forEach>
							<td>AM</td>
							<td>PS</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
