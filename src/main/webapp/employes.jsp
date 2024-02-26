<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Recherche des Produits</div>
			<div class="card-body">
				<form action="chercher.do" method="get">
					<label>Mot Clé</label> <input type="text" name="motCle"
						value="${model.motCle}" />
					<button type="submit" class="btn btn-primary">Chercher</button>
				</form>
				<table class="table table-striped">
					<tr>
						
						<th>Matricule</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Date Embauche</th>
						<th>Service</th>
						<th>Fonction</th>
						<th>Genre</th>
						<th>Salaire</th>
						<th>Suppression
						<th>Edition</th>
					</tr>
					<c:forEach items="${model.employes}" var="e">
						<tr>
							
							<td>${e.matricule }</td>
							<td>${e.nom }</td>
							<td>${e.prenom }</td>
							<td>${e.dateEmbauche }</td>
							<td>${e.service }</td>
							<td>${e.fonction }</td>
							<td>${e.sexe }</td>
							<td>${e.salaire }</td>
							<td><a onclick="return confirm('Etes-vous sûr ?')"
								href="supprimer.do?id=${e.id }">Supprimer</a></td>
							<td><a href="editer.do?id=${e.id }">Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>